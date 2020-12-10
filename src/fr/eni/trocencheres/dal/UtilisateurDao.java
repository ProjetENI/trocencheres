package fr.eni.trocencheres.dal;

import java.util.List;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bo.Utilisateur;

public interface UtilisateurDao {

	/**
	 * Fonction qui permet lister tous les utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 * @throws BusinessException 
	 */
	List<Utilisateur> listerUtilisateurs() throws BusinessException;

	/**
	 * Fonction prenant en paramètre un utilisateur pour l'ajouter en base de données
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException;

	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier ses données en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	void modifierUtilisateur(Utilisateur utilisateur) throws BusinessException;

	/**
	 * Fonction prenant en paramètre un utilisateur pour supprimer ses données en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	void supprimerUtilisateur(Utilisateur utilisateur) throws BusinessException;

	/**
	 * Fonction prenant en paramètre un utilisateur pour modifier son mot de passe en base
	 * @param Utilisateur
	 * @throws BusinessException 
	 */
	void modifierMotDePasse(Utilisateur utilisateur,String nouveauMotDePasse) throws BusinessException;

	/**
	 * Fonction qui permet lister toutes les informations d'un utilisateurs présents en base de données
	 * @return une liste d'Utilisateur
	 * @throws BusinessException 
	 */
	Utilisateur listerUtilisateurInformation(String identifiant, String mdp) throws BusinessException;


}