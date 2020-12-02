package fr.eni.trocencheres.dal;

import fr.eni.trocencheres.dal.jdbc.UtilisateurDaoJdbcImpl;

public abstract class DaoFactory {
	
	public static UtilisateurDao getUtilisaseurDao() {
		return new UtilisateurDaoJdbcImpl();
	}

}
