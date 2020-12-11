package fr.eni.trocencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.dal.CodesResultatDAL;
import fr.eni.trocencheres.dal.ConnectionProvider;
import fr.eni.trocencheres.dal.UtilisateurDao;

public class UtilisateurDaoJdbcImpl implements UtilisateurDao {
	
	private final String SELECT_ALL = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur "
			+ "FROM UTILISATEURS;";
	
	private final String SELECT_ALL_UTILISATEUR_INFORMATIONS = "SELECT "
			+ "no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, administrateur "
			+ "FROM UTILISATEURS WHERE (pseudo=? OR email=?) AND mot_de_passe=?;";
	
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS"
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
	
	private final String UPDATE_UTILISATEUR_INFO = "UPDATE UTILISATEURS SET "
			+ "pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, "
			+ "code_postal=?, ville=? "
			+ "WHERE no_utilisateur=?;";
	
	private final String UPDATE_UTILISATEUR_MDP = "UPDATE UTILISATEURS SET mot_de_passe =? "
			+ "WHERE no_utilisateur=? AND mot_de_passe =?; ";
	
	private final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?; ";

	/**
	 * Fonction qui permet lister tous les utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 * @throws BusinessException 
	 */
	@Override
	public List<Utilisateur> listerUtilisateurs() throws BusinessException {

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
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return listeUtilisateurs;
	}
	
	/**
	 * Fonction qui permet lister toutes les informations d'un utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 * @throws BusinessException 
	 */
	@Override
	public Utilisateur listerUtilisateurInformation(String identifiant, String mdp) throws BusinessException {

		Utilisateur infoUtilisateur = null;
		boolean userFound = false;
		try (	Connection conn = ConnectionProvider.getConnection();
				PreparedStatement pstt_utilisateur = conn.prepareStatement(SELECT_ALL_UTILISATEUR_INFORMATIONS)) {

			pstt_utilisateur.setString(1, identifiant);
			pstt_utilisateur.setString(2, identifiant);
			pstt_utilisateur.setString(3, mdp);

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
            	userFound = true;
            }
   

		} catch (Exception e) {
			System.out.println(1);
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_ECHEC);
			throw businessException;
		}
		
        if (!userFound) {
        	BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTE_INEXISTANTE);
			throw businessException;
        }
		
		
		return infoUtilisateur;
	}

	
	/**
	 * Fonction prenant en paramètre un utilisateur pour l'ajouter en base de données
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_utilisateur = conn.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS)) {
        		
        		if(utilisateur == null)
        		{
        			BusinessException businessException = new BusinessException();
        			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_NULL);
        			throw businessException;
        		}
        		
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
				rs.close();
				conn.commit();
				
	        } catch (Exception e) {
	        	conn.rollback();
	            e.printStackTrace();
	            throw e;
	        }

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_OBJET_ECHEC);
			throw businessException;
		}
	}

	
	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier ses données en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_utilisateur = conn.prepareStatement(UPDATE_UTILISATEUR_INFO)) {

        		pstt_utilisateur.setInt(9, utilisateur.getNoUtilisateur());
        		
				pstt_utilisateur.setString(1, utilisateur.getPseudo());
				pstt_utilisateur.setString(2, utilisateur.getNom());
				pstt_utilisateur.setString(3, utilisateur.getPrenom());
				pstt_utilisateur.setString(4, utilisateur.getEmail());
				pstt_utilisateur.setString(5, utilisateur.getTelephone());
				pstt_utilisateur.setString(6, utilisateur.getRue());
				pstt_utilisateur.setString(7, utilisateur.getCodePostal());
				pstt_utilisateur.setString(8, utilisateur.getVille());

				pstt_utilisateur.executeUpdate();
				
				conn.commit();
				
	        } catch (Exception e) {
	        	conn.rollback();
	            e.printStackTrace();
	        }

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.MODIF_UTILISATEUR_ERREUR);
			throw businessException;
		}
	}

	
	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier son mot de passe en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	@Override
	public void modifierMotDePasse(Utilisateur utilisateur,String nouveauMotDePasse) throws BusinessException {

        	try (	Connection conn = ConnectionProvider.getConnection();
        			Statement stt = conn.createStatement();
        			PreparedStatement pstt_mdp = conn.prepareStatement(UPDATE_UTILISATEUR_MDP)) {

        		
        		pstt_mdp.setString(1, nouveauMotDePasse);
        		pstt_mdp.setInt(2, utilisateur.getNoUtilisateur());
        		pstt_mdp.setString(3, utilisateur.getMotDePasse());
        		

        		pstt_mdp.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.MODIFIER_MDP_ERREUR);
				throw businessException;
	        }
	}
	
	
	/**
	 * Fonction prenant en paramètre un utilisateur pour supprimer ses données en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	@Override
	public void supprimerUtilisateur(Utilisateur utilisateur) throws BusinessException {
		
    	try (	Connection conn = ConnectionProvider.getConnection();
    			PreparedStatement pstt_utilisateur = conn.prepareStatement(DELETE_UTILISATEUR)) {

    		pstt_utilisateur.setInt(1, utilisateur.getNoUtilisateur());

			pstt_utilisateur.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_ARTICLE_ERREUR);
			throw businessException;
        }

	}



}
