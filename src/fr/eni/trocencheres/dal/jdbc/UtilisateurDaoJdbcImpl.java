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
	private final String SELECT_ALL = "SELECT * FROM UTILISATEURS;";
	private final String SELECT_MDP = "SELECT mot_de_passe FROM UTILISATEURS WHERE pseudo=? OR email=?;";
	// private final String SELECT_MDP_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=? OR email=? AND mot_de_passe=?;";
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?,?,?,?,?,?,?,?,?,?,?);";


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
            	String mot_de_passe = rs.getString("mot_de_passe");
            	int credit = rs.getInt("credit");
            	boolean administrateur = rs.getBoolean("administrateur");

            	Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur);
            	listeUtilisateurs.add(utilisateur);
            }

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listeUtilisateurs;
	}


	/**
	 * Fonction prenant en paramètre un utilisateur pour l'ajouter en base de données
	 * @param Utilisateur
	 */
	@Override
	public void ajouterUtilisateur(Utilisateur utilisateur) {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (Statement stt = conn.createStatement();
                 PreparedStatement pstt_utilisateur = conn.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS)) {

        		ResultSet rs = pstt_utilisateur.getGeneratedKeys();
        		
        		if (rs.next()) {
        			int noUtilisateur = rs.getInt(1);
        			utilisateur.setNoUtilisateur(noUtilisateur);
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
				pstt_utilisateur.setInt(10, utilisateur.getCredit());
				pstt_utilisateur.setBoolean(11, utilisateur.isAdministrateur());

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


//	public boolean verifierMotDePasse(String identifiant, String mdp) {
//
//		boolean isCorrect = false;
//
//		try (Connection conn = ConnectionProvider.getConnection();
//		     PreparedStatement pstt = conn.prepareStatement(SELECT_MDP_PSEUDO)) {
//
//			pstt.setString(1, identifiant);
//			pstt.setString(2, identifiant);
//			pstt.setString(3, mdp);
//
//			ResultSet rs = pstt.executeQuery();
//			while (rs.next()) {
//				isCorrect = true;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return isCorrect;
//	}


}
