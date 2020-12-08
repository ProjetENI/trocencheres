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
import fr.eni.trocencheres.dal.ArticleVenduDao;
import fr.eni.trocencheres.dal.CodesResultatDAL;
import fr.eni.trocencheres.dal.ConnectionProvider;


	public class ArticleVenduDaoJdbcImpl implements ArticleVenduDao {
		
	private final String SELECT_ALL = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente "
			+ "FROM ARTICLEVENDU;";
	
	private final String INSERT_ARTICLE_VENDU = "INSERT INTO ARTICLE_VENDU"
			+ "(no_article, nom_article, description, date_debut_encheres, date_finenchere, prix_initial, prix_vente, etat_vente) "
			+ "VALUES (?,?,?,?,?,?,?,?);";
	
	private final String UPDATE_ARTICLE_VENDU_INFO = "UPDATE ARTICLE_VENDU SET "
			+"nom_article=?, description=?, prix_initial=? " 
			+ "WHERE no_articlevendu=?;";
	
	private final String DELETE_ARTICLE_VENDU = "DELETE FROM ARTICLE_VENDU WHERE no_articlevendu=?; ";
			


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
			ResultSet rs = stt.executeQuery(SELECT_ALL);

			while (rs.next()) {
				int noArticle = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
		    	String description = rs.getString("description");
		    	LocalDate dateDebutEncheres = rs.getDate("date_debut_encheres").toLocalDate();
		    	LocalDate dateFinEncheres = rs.getDate("date_fin_encheres").toLocalDate();
		    	int miseAPrix = rs.getInt("prix_initial");
		    	int prixVente  = rs.getInt("prix_vente");
		    	int etatVente = rs.getInt("etat_vente");
		    
		    	ArticleVendu articleVendu = new ArticleVendu(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente);
		    	listeArticleVendu.add(articlevendu);
			
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

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_articlevendu = conn.prepareStatement(INSERT_ARTICLE_VENDU, PreparedStatement.RETURN_GENERATED_KEYS)) {
        		
				pstt_articlevendu.setInt(1, articlevendu.getNoArticle());
				pstt_articlevendu.setString(2, articlevendu.getNomArticle());
				pstt_articlevendu.setString(3, articlevendu.getDescription());
				pstt_articlevendu.setDate(4, java.sql.Date.valueOf(articlevendu.getDateDebutEncheres()));
				pstt_articlevendu.setDate(5, java.sql.Date.valueOf(articlevendu.getDateFinEcheres()));
				pstt_articlevendu.setInt(6, articlevendu.getPrixInitial());
				pstt_articlevendu.setInt(7, articlevendu.getPrixVente());
				pstt_articlevendu.setInt(8, articlevendu.getEtatVente());
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
			pstt_articlevendu.setString(2, articlevendu.getNomArticle());
			pstt_articlevendu.setString(3, articlevendu.getDescription());
			pstt_articlevendu.setDate(4, java.sql.Date.valueOf(articlevendu.getDateDebutEncheres()));
			pstt_articlevendu.setDate(5, java.sql.Date.valueOf(articlevendu.getDateFinEcheres()));
			pstt_articlevendu.setInt(6, articlevendu.getPrixInitial());
			pstt_articlevendu.setInt(7, articlevendu.getPrixVente());
			pstt_articlevendu.setInt(8, articlevendu.getEtatVente());

			pstt_articlevendu.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_UTILISATEUR_ERREUR);
			throw businessException;
        }
		}
	}

