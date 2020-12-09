package fr.eni.trocencheres.ihm;

/**
 * Les codes disponibles sont entre 30000 et 39999
 */
public abstract class CodesResultatServlets {
	
	/**
	 * Erreur lancée par la Servlet lors de la connexion de l'utilisateur
	 */
	public static final int CONNECTION_SERVLET_CHAMPS_VIDES_ERREUR=30000;
	public static final int CONNECTION_SERVLET_ID_MDP_ERREUR=30001;
	/**
	 * Erreur lancée par la Servlet lors de l'inscription de l'utilisateur
	 */
	public static final Integer INSCRIPTION_SERVLET_ERREUR = 30002;
	/**
	 * Erreur lanceé par la Servlet lors de l'inscription de l'utilisateur
	 */
	public static final Integer MODIFIER_PARAMETRES_SERVLET_ERREUR = 30003;
	/**
	 * Erreur lanceé par la Servlet lors de la suppression d'un compte utilisateur
	 */
	public static final Integer SUPPRIMER_COMPTE_SERVLET_ERREUR = 30004;
	/**
	 * Erreur lanceé par la Servlet lors de la suppression d'un compte utilisateur
	 */
	public static final Integer CORRESPONDACE_MDP = 30005;
	
	/*
	 * Erreurs lancées lors de l'inscription si un champs est vide 
	 */
	public static final int CHAMPS_PSEUDO_VIDE_ERREUR=30010;
	public static final int CHAMPS_NOM_VIDE_ERREUR=30011;
	public static final int CHAMPS_PRENOM_VIDE_ERREUR=30012;
	public static final int CHAMPS_EMAIL_VIDE_ERREUR=30013;
	public static final int CHAMPS_TELEPHONE_VIDE_ERREUR=30014;
	public static final int CHAMPS_RUE_VIDE_ERREUR=30015;
	public static final int CHAMPS_CODEPOSTAL_VIDE_ERREUR=30016;
	public static final int CHAMPS_VILLE_VIDE_ERREUR=30017;
	public static final int CHAMPS_PASSWORD_VIDE_ERREUR=30018;
	/**
	 * Erreur lanceé par la Servlet lors de la suppression d'un compte utilisateur
	 */
	public static final int CHAMPS_IDENTIFIANT_VIDE_ERREUR = 30019;
	
	
}