package fr.eni.trocencheres.ihm;

/**
 * Les codes disponibles sont entre 30000 et 39999
 */
public abstract class CodesResultatServlets {
	
	/**
	 * Erreur lancée par la Servlet lors de la connexion de l'utilisateur
	 */
	public static final int CONNECTION_SERVLET_ERREUR=30000;
	/**
	 * Erreur lancée par la Servlet lors de l'inscription de l'utilisateur
	 */
	public static final Integer INSCRIPTION_SERVLET_ERREUR = 30001;
	/**
	 * Erreur lanceé par la Servlet lors de l'inscription de l'utilisateur
	 */
	public static final Integer MODIFIER_PARAMETRES_SERVLET_ERREUR = 30002;
	/**
	 * Erreur lanceé par la Servlet lors de la suppression d'un compte utilisateur
	 */
	public static final Integer SUPPRIMER_COMPTE_SERVLET_ERREUR = 30003;
	
	
	
}