package fr.eni.trocencheres.dal;

import fr.eni.trocencheres.dal.jdbc.UtilisateurDaoJdbcImpl;

public abstract class DaoFactory {
	
	private static UtilisateurDao getUtilisaseurDao() {
		return new UtilisateurDaoJdbcImpl();
	}

}
