package fr.eni.trocencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.dal.ConnectionProvider;
import fr.eni.trocencheres.dal.UtilisateurDao;

public class UtilisateurDaoJdbcImpl implements UtilisateurDao {
	
	private final String SELECT_ALL = "SELECT (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur) "
			+ "FROM UTILISATEURS;";
	
	private final String SELECT_ALL_UTILISATEUR_INFORMATIONS = "SELECT "
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur) "
			+ "FROM UTILISATEURS WHERE pseudo=? OR email=?;";
	
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	
	private final String UPDATE_UTILISATEUR_INFO = "UPDATE UTILISATEURS SET "
			+ "pseudo = '?',nom = '?',prenom = '?',email = '?',telephone = '?',rue = '?',"
			+ "code_postal = '?',ville = '?',administrateur = '?'"
			+ "WHERE no_utilisateur=?; ";
	
	private final String UPDATE_UTILISATEUR_MDP = "UPDATE UTILISATEURS SET mot_de_passe = '?'"
			+ "WHERE no_utilisateur=?; ";
	
	private final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?; ";

	private final String SELECT_MDP_PSEUDO = "SELECT pseudo FROM UTILISATEURS WHERE (pseudo=? OR email=?) AND mot_de_passe=?;";

	/**
	 * Fonction qui permet lister tous les utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 */
	@Override
	public List<Utilisateur> listerUtilisateurs() {

		List<Utilisateur> listeUtilisateurs = new ArrayList<>();

		try (Connection conn = ConnectionProvider.getConnection();
			 Statement stt = conn.createStatement()) {

			ResultSet rs = stt.executeQuery(SELECT_ALL);

            while (rs.next()) {
            	int noUtilisateur = rs.getInt("no_utilisateur");
            	String pseudo = rs.getString("pseudo");
            	String nom = rs.getString("nom");
            	String prenom = rs.getString("prenom");
            	String email = rs.getString("email");
            	String telephone = rs.getString("telephone");
            	String rue = rs.getString("rue");
            	String code_postal = rs.getString("code_postal");
            	String ville = rs.getString("ville");
            	int credit = rs.getInt("credit");
            	boolean administrateur = rs.getBoolean("administrateur");

            	Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur);
            	listeUtilisateurs.add(utilisateur);
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
	}
	
	/**
	 * Fonction qui permet lister toutes les informations d'un utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 */
	@Override
	public Utilisateur listerUtilisateurInformation(String identifiant) {

		Utilisateur infoUtilisateur = new Utilisateur();

		try (	Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstt_utilisateur = conn.prepareStatement(SELECT_ALL_UTILISATEUR_INFORMATIONS)) {

			pstt_utilisateur.setString(1, identifiant);
			pstt_utilisateur.setString(2, identifiant);

			ResultSet rs = pstt_utilisateur.executeQuery();
			

            if (rs.next()) {
            	int noUtilisateur = rs.getInt("no_utilisateur");
            	String pseudo = rs.getString("pseudo");
            	String nom = rs.getString("nom");
            	String prenom = rs.getString("prenom");
            	String email = rs.getString("email");
            	String telephone = rs.getString("telephone");
            	String rue = rs.getString("rue");
            	String code_postal = rs.getString("code_postal");
            	String ville = rs.getString("ville");
            	int credit = rs.getInt("credit");
            	boolean administrateur = rs.getBoolean("administrateur");

            	infoUtilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur);
            	
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return infoUtilisateur;
	}


	/**
	 * Fonction prenant en paramètre un utilisateur pour l'ajouter en base de données
	 * @param Utilisateur
	 */
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_utilisateur = conn.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS)) {
        		
				pstt_utilisateur.setString(1, utilisateur.getPseudo());
				pstt_utilisateur.setString(2, utilisateur.getNom());
				pstt_utilisateur.setString(3, utilisateur.getPrenom());
				pstt_utilisateur.setString(4, utilisateur.getEmail());
				pstt_utilisateur.setString(5, utilisateur.getTelephone());
				pstt_utilisateur.setString(6, utilisateur.getRue());
				pstt_utilisateur.setString(7, utilisateur.getCodePostal());
				pstt_utilisateur.setString(8, utilisateur.getVille());
				pstt_utilisateur.setString(9, utilisateur.getMotDePasse());
				pstt_utilisateur.setInt(10, 100);
				pstt_utilisateur.setBoolean(11, false);

				pstt_utilisateur.executeUpdate();
				
				ResultSet rs = pstt_utilisateur.getGeneratedKeys();
        		
        		if (rs.next()) {
        			int noUtilisateur = rs.getInt(1);
        			utilisateur.setNoUtilisateur(noUtilisateur);
        		}
				
				conn.commit();

	        } catch (Exception e) {
	        	conn.rollback();
	            e.printStackTrace();
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier ses données en base
	 * @param Utilisateur
	 */
	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_utilisateur = conn.prepareStatement(UPDATE_UTILISATEUR_INFO)) {

        		pstt_utilisateur.setInt(10, utilisateur.getNoUtilisateur());
        		
				pstt_utilisateur.setString(1, utilisateur.getPseudo());
				pstt_utilisateur.setString(2, utilisateur.getNom());
				pstt_utilisateur.setString(3, utilisateur.getPrenom());
				pstt_utilisateur.setString(4, utilisateur.getEmail());
				pstt_utilisateur.setString(5, utilisateur.getTelephone());
				pstt_utilisateur.setString(6, utilisateur.getRue());
				pstt_utilisateur.setString(7, utilisateur.getCodePostal());
				pstt_utilisateur.setString(8, utilisateur.getVille());
				pstt_utilisateur.setBoolean(9, utilisateur.isAdministrateur());

				pstt_utilisateur.executeUpdate();
				conn.commit();

	        } catch (Exception e) {
	        	conn.rollback();
	            e.printStackTrace();
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier son mot de passe en base
	 * @param Utilisateur
	 */
	@Override
	public void modifierMotDePasse(Utilisateur utilisateur) {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (Statement stt = conn.createStatement();
                 PreparedStatement pstt_mdp = conn.prepareStatement(UPDATE_UTILISATEUR_MDP)) {

        		pstt_mdp.setInt(2, utilisateur.getNoUtilisateur());
        		
        		pstt_mdp.setString(1, utilisateur.getMotDePasse());

        		pstt_mdp.executeUpdate();
				conn.commit();

	        } catch (Exception e) {
	        	conn.rollback();
	            e.printStackTrace();
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Fonction prenant en paramètre un utilisateur pour supprimer ses données en base
	 * @param Utilisateur
	 */
	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		
	try (Connection conn = ConnectionProvider.getConnection()) {

		conn.setAutoCommit(false);
		
    	try (PreparedStatement pstt_utilisateur = conn.prepareStatement(DELETE_UTILISATEUR)) {

    		pstt_utilisateur.setInt(1, utilisateur.getNoUtilisateur());

			pstt_utilisateur.executeUpdate();
			conn.commit();

        } catch (Exception e) {
        	conn.rollback();
            e.printStackTrace();
        }

	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	/**
	 * Fonction prenant en paramètre l'identifiant et le mot de passe d'un utilisateur pour vérifier leur concordance
	 * @param Utilisateur
	 */
	@Override
	public boolean verifierIdentification(String identifiant, String mdp) {

		boolean isCorrect = false;

		try (Connection conn = ConnectionProvider.getConnection();
		     PreparedStatement pstt = conn.prepareStatement(SELECT_MDP_PSEUDO)) {

			pstt.setString(1, identifiant);
			pstt.setString(2, identifiant);
			pstt.setString(3, mdp);

			ResultSet rs = pstt.executeQuery();
			if (rs.next()) {
				isCorrect = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCorrect;
	}


}
