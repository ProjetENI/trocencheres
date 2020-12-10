package fr.eni.trocencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.ArticleVendu;
import fr.eni.trocencheres.bo.Categorie;
import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.dal.ArticleVenduDao;
import fr.eni.trocencheres.dal.CodesResultatDAL;
import fr.eni.trocencheres.dal.ConnectionProvider;


	public class ArticleVenduDaoJdbcImpl implements ArticleVenduDao {
	
	
	private final String SELECT_ALL_INDEX = "SELECT * FROM ARTICLES_VENDUS as A INNER JOIN CATEGORIES as C ON A.no_categorie=C.no_categorie "
			+ "INNER JOIN UTILISATEURS as U ON A.no_utilisateur=U.no_utilisateur WHERE etat_vente='EC';";
	
	private final String INSERT_ARTICLE_VENDU = "INSERT INTO ARTICLES_VENDUS"
			+ "(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image) "
			+ "VALUES (?,?,?,?,?,?,?,?,?);";
	
	private final String UPDATE_ARTICLE_VENDU_INFO = "UPDATE ARTICLES_VENDUS SET "
			+"nom_article=?, description=?, prix_initial=? " 
			+ "WHERE no_articlevendu=?;";
	
	private final String DELETE_ARTICLE_VENDU = "DELETE FROM ARTICLES_VENDUS WHERE no_articlevendu=?; ";
			


	/**
	 * Fonction qui permet lister tous les articles présents en base de données
	 * @return une liste d'article vendu
	 * @throws BusinessException 
	 */
	@Override
	public List<ArticleVendu> listerArticleVendu() throws BusinessException{
			
		List<ArticleVendu> listeArticleVendu = new ArrayList <>();
		try (	Connection conn = ConnectionProvider.getConnection();
				Statement stt = conn.createStatement()) {
			
			ResultSet rs = stt.executeQuery(SELECT_ALL_INDEX);

			while (rs.next()) {
				String nomArticle = rs.getString("nom_article");
		    	String description = rs.getString("description");
		    	String image = rs.getString("image");
		    	LocalDate dateDebutEncheres = rs.getDate("date_debut_enchere").toLocalDate();
		    	LocalDate dateFinEncheres = rs.getDate("date_fin_enchere").toLocalDate();
		    	int miseAPrix = rs.getInt("prix_initial");
		    	//Construction de l'objet Catégorie
		    	int categorieNo = rs.getInt("no_categorie");
		    	String categorieLibelle = rs.getString("libelle");
		    	Categorie categorie = new Categorie(categorieNo, categorieLibelle);
		    	//Construction de l'objet Utilisateur
		    	String pseudo = rs.getString("pseudo");
            	String nom = rs.getString("nom");
            	String prenom = rs.getString("prenom");
            	String email = rs.getString("email");
            	String telephone = rs.getString("telephone");
            	String rue = rs.getString("rue");
            	String code_postal = rs.getString("code_postal");
            	String ville = rs.getString("ville");
		    	Utilisateur vendeur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville);
		    	
		    	ArticleVendu articleVendu = new ArticleVendu(nomArticle, description, image, dateDebutEncheres, dateFinEncheres, miseAPrix, categorie, vendeur);
		    	listeArticleVendu.add(articleVendu);
			
			}
		}catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_LISTES_ECHEC);
			throw businessException;
		}
		return listeArticleVendu;
	}
	
	
	
	/**
	 * Fonction prenant en paramètre un article pour l'ajouter en base de données
	 * @param article vendu
	 * @throws BusinessException 
	 */
	@Override
	public void ajouterArticleVendu(ArticleVendu articlevendu) throws BusinessException {
//		"INSERT INTO ARTICLE_VENDU"
//				+ "(no_article, nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, no_utilisateur, no_categorie, etat_vente, image) "
//				+ "VALUES (?,?,?,?,?,?,?,?,?,?);"
		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_articlevendu = conn.prepareStatement(INSERT_ARTICLE_VENDU, PreparedStatement.RETURN_GENERATED_KEYS)) {

				pstt_articlevendu.setString(1, articlevendu.getNomArticle());
				pstt_articlevendu.setString(2, articlevendu.getDescription());
				pstt_articlevendu.setDate(3, java.sql.Date.valueOf(articlevendu.getDateDebutEncheres()));
				pstt_articlevendu.setDate(4, java.sql.Date.valueOf(articlevendu.getDateFinEncheres()));
				pstt_articlevendu.setInt(5, articlevendu.getPrixInitial());
				pstt_articlevendu.setInt(6, articlevendu.getUtilisateur().getNoUtilisateur());
				pstt_articlevendu.setInt(7, articlevendu.getCategorieArticle().getNoCategorie());
				pstt_articlevendu.setString(8, "CR");
				pstt_articlevendu.setString(9, articlevendu.getImageURL());
				pstt_articlevendu.executeUpdate();

				ResultSet rs = pstt_articlevendu.getGeneratedKeys();
        		
        		if (rs.next()) {
        			int noArticle = rs.getInt(1);
        			articlevendu.setNoArticle(noArticle);
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
			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ARTICLE_ECHEC);
			throw businessException;
		}
	}
		
	
	/**
	 * Fonction prenant en paramètre une modification d'un article 
	 * @param article vendu
	 * @throws BusinessException 
	 */
	@Override
	public void modifierArticleVendu(ArticleVendu articlevendu) throws BusinessException {
	
			try (Connection conn = ConnectionProvider.getConnection()) {
	
				conn.setAutoCommit(false);
		        	try (PreparedStatement pstt_articlevendu = conn.prepareStatement(UPDATE_ARTICLE_VENDU_INFO)) {
		
		        		pstt_articlevendu.setString(1, articlevendu.getNomArticle());
		        		pstt_articlevendu.setString(2, articlevendu.getDescription());
		        		pstt_articlevendu.setInt(3, articlevendu.getPrixInitial());
						pstt_articlevendu.executeUpdate();
						
						conn.commit();
						
		        	} catch (Exception e) {
		    			e.printStackTrace();
		    			BusinessException businessException = new BusinessException();
		    			businessException.ajouterErreur(CodesResultatDAL.MODIF_ARTICLE_ERREUR);
		    			throw businessException;
		    		}
			
	
					} catch (Exception e) {
		    			e.printStackTrace();
		    			BusinessException businessException = new BusinessException();
		    			businessException.ajouterErreur(CodesResultatDAL.LECTURE_ARTICLE_ECHEC);
		    			throw businessException;
		    		}
		}
	/**
	 * Fonction prenant en paramètre un utilisateur pour supprimer un article en base
	 * @param article vendu
	 * @throws BusinessException 
	 */
	@Override
	public void supprimerArticleVendu(ArticleVendu articlevendu) throws BusinessException {
		
    	try (	Connection conn = ConnectionProvider.getConnection();
    			PreparedStatement pstt_articlevendu = conn.prepareStatement(DELETE_ARTICLE_VENDU)) {

			pstt_articlevendu.setInt(1, articlevendu.getNoArticle());

			pstt_articlevendu.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_UTILISATEUR_ERREUR);
			throw businessException;
        }
		}
	}

