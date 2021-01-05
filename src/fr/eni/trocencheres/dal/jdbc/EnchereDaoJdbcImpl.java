package fr.eni.trocencheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Enchere;
import fr.eni.trocencheres.dal.CodesResultatDAL;
import fr.eni.trocencheres.dal.ConnectionProvider;
import fr.eni.trocencheres.dal.EnchereDao;

public class EnchereDaoJdbcImpl implements EnchereDao {
	
	private final String SELECT_DERNIERE_ENCHERE_ARTICLE = "SELECT * FROM ENCHERE WHERE no_Article=? AND date_enchere=MAX(date_enchere);";
	
	private final String INSERT_ENCHERE = "INSERT INTO ENCHERES"
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere) "
			+ "VALUES (?,?,?,?);";
	
	private final String UPDATE_UTILISATEUR_CREDIT = "UPDATE UTILISATEURS SET "
			+ "credit=? WHERE no_utilisateur=?;";
	
	
	/**
	 * Fonction prenant en paramètre un article pour l'ajouter en base de données
	 * @param article vendu
	 * @throws BusinessException 
	 */
	@Override
	public void ajouterEnchere(Enchere enchere) throws BusinessException {

		try (Connection conn = ConnectionProvider.getConnection()) {

			conn.setAutoCommit(false);
        	try (	PreparedStatement pstt_enchere = conn.prepareStatement(INSERT_ENCHERE);
        			PreparedStatement pstt_liste_enchere = conn.prepareStatement(SELECT_DERNIERE_ENCHERE_ARTICLE);
        			PreparedStatement pstt_credit = conn.prepareStatement(UPDATE_UTILISATEUR_CREDIT)) {

        		if(enchere.getMontant_enchere()<=enchere.getUtilisateur().getCredit())
        		{
        	   		
            		pstt_enchere.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
            		pstt_enchere.setInt(2, enchere.getArticlevendu().getNoArticle());
            		pstt_enchere.setDate(3, java.sql.Date.valueOf(enchere.getDateEncheres()));
            		pstt_enchere.setInt(4, enchere.getMontant_enchere());
            		pstt_enchere.executeUpdate();
            		
            		//Debit du nouveau encherisseur
            		
            		
            		
            		//Credit de l'ancien encherisseur
            		if (!enchere.getArticlevendu().gethistoriqueEnchereArticle().isEmpty()) {
            			
            			int indiceDerniereEnchere = enchere.getArticlevendu().gethistoriqueEnchereArticle().size() - 1;
            			int noDernierEncherisseur = enchere.getArticlevendu().gethistoriqueEnchereArticle().get(indiceDerniereEnchere).getUtilisateur().getNoUtilisateur();
            			int soldeDernierEncherisseur = enchere.getArticlevendu().gethistoriqueEnchereArticle().get(indiceDerniereEnchere).getUtilisateur().getCredit();
            			int montantEnchere = enchere.getArticlevendu().gethistoriqueEnchereArticle().get(indiceDerniereEnchere).getMontant_enchere();
            			
            			pstt_credit.setInt(1, soldeDernierEncherisseur + montantEnchere);
            			pstt_credit.setInt(2, noDernierEncherisseur);
            			pstt_credit.executeUpdate();
    				}
            	

    				conn.commit();
        		}
     

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

}
