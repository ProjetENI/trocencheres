package fr.eni.trocencheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	//ERREURS GENERALES
	/**
	 * Echec général quand tentative d'ajouter un objet null
	 */
	public static final int INSERT_OBJET_NULL=10000; //ok
	
	/**
	 * Echec général quand erreur non gérée à l'insertion 
	 */
	public static final int ERREUR_NON_GEREE=10001; //ok

	
	//ERREURS 
	/**
	 * Echec de la lecture des listes d'utilisateur
	 */
	public static final int LECTURE_LISTES_ECHEC = 10002; //ok
	
	/**
	 * Echec à l'insertion d'un utilisateur
	 */
	public static final int INSERT_OBJET_ECHEC=10003; //ok
	
	
	
	/**
	 * Echec de la lecture d'une liste de course
	 */
	public static final int LECTURE_LISTE_ECHEC = 10004;
	
	
	/**
	 * Liste de course inexistante
	 */
	public static final int LECTURE_LISTE_INEXISTANTE = 10005;
	
	
	/**
	 * Erreur à la suppression d'un article
	 */
	public static final int SUPPRESSION_ARTICLE_ERREUR = 10006;
	
	
	/**
	 * Erreur à la suppression d'une liste
	 */
	public static final int SUPPRESSION_LISTE_ERREUR = 10006;
	/**
	 * Erreur au cochage d'un article
	 */
	public static final int COCHE_ARTICLE_ERREUR = 10007;
	/**
	 * Erreur au décochage d'un article
	 */
	public static final int DECOCHE_ARTICLE_ERREUR = 10008;
	/**
	 * Erreur au décochage de tous les articles d'une liste
	 */
	public static final int DECOCHE_ARTICLES_ERREUR = 10009;
}












