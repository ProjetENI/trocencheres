package fr.eni.trocencheres.dal;

import fr.eni.trocencheres.dal.jdbc.ArticleVenduDaoJdbcImpl;
import fr.eni.trocencheres.dal.jdbc.UtilisateurDaoJdbcImpl;
import fr.eni.trocencheres.dal.jdbc.EnchereDaoJdbcImpl;

public abstract class DaoFactory {
	
	public static UtilisateurDao getUtilisaseurDao() {
		return new UtilisateurDaoJdbcImpl();
	}
	
	public static ArticleVenduDao getArticleVenduDao() {
		return new ArticleVenduDaoJdbcImpl();
	}
	
	public static EnchereDao getEnchereDao() {
		return new EnchereDaoJdbcImpl();
	}
}
