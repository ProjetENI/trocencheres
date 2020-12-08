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
		
	private final String SELECT_ALL = "SELECT noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente "
			+ "FROM ARTICLEVENDU;";
	
	private final String INSERT_ARTICLE_VENDU = "INSERT INTO ARTICLE_VENDU"
			+ "(noArticle, nomArticle, description, dateDebutencheres, dateFinEnchere, miseAPrix, prixVente, etatVente) "
			+ "VALUES (?,?,?,?,?,?,?,?);";
	
	private final String UPDATE_ARTICLE_VENDU_INFO = "UPDATE ARTICLE_VENDU SET "
			+ "description=? "
			+ "WHERE no_articlevendu=?;";


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
				String nom_article = rs.getString("nom_article");
		    	String description = rs.getString("description");
		    	LocalDate date_debut_encheres = rs.getDate("date_debut_encheres").toLocalDate();
		    	LocalDate date_fin_encheres = rs.getDate("date_fin_encheres").toLocalDate();
		    	int mise_a_prix = rs.getInt("mise_a_prix");
		    	int prix_vente  = rs.getInt("prix_vente");
		    	int etat_vente = rs.getInt("etat_vente");
		    
		    	ArticleVendu articlevendu = new ArticleVendu(noArticle, nom_article, description, date_debut_encheres, date_fin_encheres, mise_a_prix, prix_vente, etat_vente);
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
				pstt_articlevendu.setInt(6, articlevendu.getMiseAPrix());
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
		
	
	
	
	
	
	
	
	@Override
	public void modifierArticleVendu(ArticleVendu articlevendu) {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (PreparedStatement pstt_articlevendu = conn.prepareStatement(UPDATE_ARTICLE_VENDU_INFO)) {

        		pstt_articlevendu.setString(1, articlevendu.getDescription());
        		
				pstt_articlevendu.executeUpdate();
				
				conn.commit();
				
	        } catch (Exception e) {
	        	conn.rollback();
	            e.printStackTrace();
	        }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

		}

