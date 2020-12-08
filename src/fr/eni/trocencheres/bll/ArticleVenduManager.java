package fr.eni.trocencheres.bll;

import java.time.LocalDate;
import java.util.List;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.ArticleVendu;
import fr.eni.trocencheres.dal.ArticleVenduDao;
import fr.eni.trocencheres.dal.DaoFactory;

public class ArticleVenduManager {
	
	private ArticleVenduDao articleVenduDao;
	
	public ArticleVenduManager() {
		this.articleVenduDao = DaoFactory.getArticleVenduDao();
	}
	
	public List<ArticleVendu> listerArticleVendu() throws BusinessException {
		return this.articleVenduDao.listerArticleVendu();
	}
	
	public void ajouterArticleVendu(ArticleVendu articlevendu) throws BusinessException {
		BusinessException businessException = new BusinessException();
		validerArticleVendu(articlevendu, businessException);
	
		if(!businessException.hasErreurs()) {
			articleVenduDao.ajouterArticleVendu(articlevendu);
		} else {
			throw businessException;
		}
	}
	
	public void modifierArticleVendu(ArticleVendu articlevendu) throws BusinessException {
		BusinessException businessException = new BusinessException();
		validerArticleVendu(articlevendu, businessException);
		
		if(!businessException.hasErreurs()) {
			articleVenduDao.modifierArticleVendu(articlevendu);
		} else {
			throw businessException;
		}
	}
	
	/*******************************************************************************
	 *
	 *	ENSEMBLE DES MÉTHODES INDÉPENDANTES DE VERIFICATION DE CHAMPS
	 *
	 *******************************************************************************/
	private void validerArticleVendu(ArticleVendu articlevendu, BusinessException businessException) {
		validerNomArticle(articlevendu, businessException);
		validerDescription(articlevendu, businessException);
		validerDate(articlevendu.getDateDebutEncheres(), businessException);
		validerDate(articlevendu.getDateFinEcheres(), businessException);
		validerPrix(articlevendu.getMiseAPrix(), businessException);
		validerPrix(articlevendu.getPrixVente(), businessException);
		validerEtatVente(articlevendu.getEtatVente(), businessException);
	}
	
	private void validerNomArticle(ArticleVendu articlevendu, BusinessException businessException) {
		String checkAlphaNumeric = "[\\w]";

		if (articlevendu.getNomArticle().length() < 5 && articlevendu.getNomArticle().length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_TAILLE_NOM_ERREUR);
		}
		if (articlevendu.getNomArticle().matches(checkAlphaNumeric)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_CARACTERES_NOM_ERREUR);
		}
	}

	private void validerDescription(ArticleVendu articlevendu, BusinessException businessException) {
		String checkAlphaNumeric = "[\\w]";

		if (articlevendu.getDescription().length() < 20 && articlevendu.getDescription().length() > 300) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_TAILLE_DESCIPTION_ERREUR);
		}
		if (articlevendu.getDescription().matches(checkAlphaNumeric)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_CARACTERES_DESCRIPTION_ERREUR);
		}
	}

	private void validerDate(LocalDate date, BusinessException businessException) {
		if(date==null || 
		   date.isAfter(LocalDate.now()) ||
		   date.isEqual(LocalDate.now()) ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_ERREUR);
		}
	}

	private void validerPrix(int prix, BusinessException businessException) {
		if( prix < 0 || prix != (int)prix ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_PRIX_ERREUR);
		}
	}

	private void validerEtatVente(int etatvente, BusinessException businessException) {
		if (etatvente < 0 || etatvente != (int)etatvente) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_ETAT_ERREUR);
		}
	}

}
