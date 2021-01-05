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
	public static final int CHAMPS_PASSWORD1_VIDE_ERREUR=30030;
	public static final int CHAMPS_PASSWORD2_VIDE_ERREUR=30031;
	/**
	 * Erreur lanceé par la Servlet lors de la suppression d'un compte utilisateur
	 */
	public static final int CHAMPS_IDENTIFIANT_VIDE_ERREUR = 30019;
	
	
	/**
	 * Erreur lanceé par la Servlet lors de la création d'une vente
	 */
	public static final int CHAMPS_NOM_ARTICLE_VIDE_ERREUR = 30020;
	public static final int CHAMPS_DESCRIPTION_ARTICLE_VIDE_ERREUR = 30021;
	public static final int CHAMPS_DATE_DEBUT_ARTICLE_VIDE_ERREUR = 30022;
	public static final int CHAMPS_DATE_ARTICLE_FORMAT_ERREUR = 30023;
	public static final int CHAMPS_RUE_RETRAIT_ARTICLE_VIDE_ERREUR = 30024;
	public static final int CHAMPS_CODEPOSTAL_RETRAIT_ARTICLE_VIDE_ERREUR = 30025;
	public static final int CHAMPS_VILLE_RETRAIT_VIDE_ERREUR = 30026;
	public static final int CHAMPS_PRIX_INITIAL_ARTICLE_PARSE_ERREUR = 30027;
	public static final int CHAMPS_CATEGORIE_ARTICLE_PARSE_ERREUR = 30028;
	public static final int CHAMPS_DATE_FIN_ARTICLE_VIDE_ERREUR = 30029;
	
	/**
	 * Erreur lanceé par la Servlet lors d'une enchère sur un article
	 */
	public static final int CHAMPS_MONTANT_ENCHERE_VIDE_ERREUR = 30040;
}