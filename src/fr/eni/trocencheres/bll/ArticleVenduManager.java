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
	
	public ArticleVendu informationArticleVendu(int pNoArticle) throws BusinessException {
		return this.articleVenduDao.informationArticleVendu(pNoArticle);
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
		validerDateDebut(articlevendu.getDateDebutEncheres(), businessException);
		validerDateFin(articlevendu.getDateFinEncheres(), businessException);
		validerPrix(articlevendu.getPrixInitial(), businessException);
		validerPrix(articlevendu.getPrixVente(), businessException);
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

	private void validerDateDebut(LocalDate date, BusinessException businessException) {
		if(date==null || 
		   date.isBefore(LocalDate.now()) ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_DEBUT_ERREUR);
		}
	}
	
	private void validerDateFin(LocalDate date, BusinessException businessException) {
		if(date==null || 
		   date.isBefore(LocalDate.now()) ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_DATE_FIN_ERREUR);
		}
	}

	private void validerPrix(int prix, BusinessException businessException) {
		if( prix < 0 || prix != (int)prix ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_PRIX_ERREUR);
		}
	}

	private void validerEtatVente(String etatvente, BusinessException businessException) {
		if (etatvente != "RT" && etatvente != "VD" && etatvente != "EC" && etatvente != "CR") {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_ETAT_ERREUR);
		}
	}

}
