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
	void ajouterUtilisateur(Utilisateur u);

}