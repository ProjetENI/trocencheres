package fr.eni.trocencheres.dal;

import java.util.List;

import fr.eni.trocencheres.bo.Utilisateur;

public interface UtilisateurDao {

	/**
	 * Fonction qui permet lister tous les utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 */
	List<Utilisateur> listerUtilisateurs();

	/**
	 * Fonction prenant en paramètre un utilisateur pour l'ajouter en base de données
	 * @param Utilisateur
	 */
	void ajouterUtilisateur(Utilisateur utilisateur);

	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier ses données en base
	 * @param Utilisateur
	 */
	void modifierUtilisateur(Utilisateur utilisateur);

	/**
	 * Fonction prenant en paramètre un utilisateur pour supprimer ses données en base
	 * @param Utilisateur
	 */
	void supprimerUtilisateur(Utilisateur utilisateur);

	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier son mot de passe en base
	 * @param Utilisateur
	 */
	void modifierMotDePasse(Utilisateur utilisateur);

	/**
	 * Fonction qui permet lister toutes les informations d'un utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 */
	Utilisateur listerUtilisateurInformation(String identifiant, String mdp);

}