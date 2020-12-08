package fr.eni.trocencheres.bll;

/**
 * Les codes disponibles sont entre 20000 et 29999
 */
public abstract class CodesResultatBLL {
	
	/**
	 * Echec la taille du pseudo de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_PSEUDO_TAILLE_NOM_ERREUR=20000;
	/**
	 * Echec le pseudo de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_PSEUDO_CARACTERES_NOM_ERREUR=20001;
	/**
	 * Echec l'email de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_EMAIL_NOM_ERREUR=20002;
	/**
	 * Echec le nom de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_NOM_UTILISATEUR_NOM_ERREUR=20003;
	/**
	 * Echec le prénom de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_PRENOM_UTILISATEUR_NOM_ERREUR=20004;
	/**
	 * Echec le numéro de téléphone de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_TELEPHONE_NOM_ERREUR=20005;
	/**
	 * Echec le code postal de l'utilisateur ne respecte pas les règles définies
	 */
	public static final int REGLE_CODEPOSTAL_NOM_ERREUR=20006;



	/**
	 * Echec la taille du nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_TAILLE_NOM_ERREUR=20007;
	/**
	 * Echec le nom de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_CARACTERES_NOM_ERREUR=20008;
	/**
	 * Echec la taille de la description de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_TAILLE_DESCIPTION_ERREUR=20009;
	/**
	 * Echec la description de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_CARACTERES_DESCRIPTION_ERREUR=20010;
	/**
	 * Echec la date de vente de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_DATE_ERREUR=20011;
	/**
	 * Echec le prix de vente de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_PRIX_ERREUR=20012;
	/**
	 * Echec l'état de vente de l'article ne respecte pas les règles définies
	 */
	public static final int REGLE_ARTICLE_ETAT_ERREUR=20013;
}
