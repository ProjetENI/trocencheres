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
	private final String SELECT_ALL = "select * from UTILISATEURS;";
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values (?,?,?,?,?,?,?,?,?,?,?);";


	/**
	 * Fonction qui permet lister tous les utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 */
	@Override
	public List<Utilisateur> listerUtilisateurs() {
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();

		try (Connection conn = ConnectionProvider.getConnection()) {

        	conn.setAutoCommit(false);
        	 try (Statement stt = conn.createStatement()) {

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
	public void ajouterUtilisateur(Utilisateur u) {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (Statement stt = conn.createStatement();
                 PreparedStatement pstt_utilisateur = conn.prepareStatement(INSERT_UTILISATEUR)) {

        		ResultSet rs = stt.executeQuery(SELECT_ALL);
                while (rs.next()) {
					pstt_utilisateur.setString(1, u.getPseudo());
					pstt_utilisateur.setString(2, u.getNom());
					pstt_utilisateur.setString(3, u.getPrenom());
					pstt_utilisateur.setString(4, u.getEmail());
					pstt_utilisateur.setString(5, u.getTelephone());
					pstt_utilisateur.setString(6, u.getRue());
					pstt_utilisateur.setString(7, u.getCodePostal());
					pstt_utilisateur.setString(8, u.getVille());
					pstt_utilisateur.setString(9, u.getMotDePasse());
					pstt_utilisateur.setInt(10, u.getCredit());
					pstt_utilisateur.setBoolean(11, u.isAdministrateur());
					pstt_utilisateur.executeUpdate();
                }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
