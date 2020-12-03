package fr.eni.trocencheres.bll;

import java.util.List;

import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.dal.DaoFactory;
import fr.eni.trocencheres.dal.UtilisateurDao;
import fr.eni.trocencheres.exceptions.BllException;

public class UtilisateurManager {

	private UtilisateurDao utilisateurDao;


	public UtilisateurManager() {
		this.utilisateurDao = DaoFactory.getUtilisaseurDao();
	}


	public List<Utilisateur> listerUtilisateurs() {
		return this.utilisateurDao.listerUtilisateurs();
	}


	public Utilisateur listerUtilisateurInformation(String identifiant) {
		return this.utilisateurDao.listerUtilisateurInformation(identifiant);
	}


	public void supprimerUtilisateur(Utilisateur utilisateur) {
		this.utilisateurDao.supprimerUtilisateur(utilisateur);
	}


	public void ajouterUtilisateur(Utilisateur utilisateur) throws BllException {
		validerUtilisateur(utilisateur);
	}


	public void modifierUtilisateur(Utilisateur utilisateur) throws BllException {
		validerUtilisateur(utilisateur);
	}


	public void modifierMotDePasse(Utilisateur identifiant) throws BllException {
		validerPseudo(identifiant);
	}


	public boolean verifierIdentification(String identifiant, String mdp) {
		return this.utilisateurDao.verifierIdentification(identifiant, mdp);
	}


	/*******************************************************************************
	 *
	 *	ENSEMBLE DES MÉTHODES INDÉPENDANTES DE VERIFICATION DE CHAMPS
	 *
	 *******************************************************************************/
	private void validerUtilisateur(Utilisateur utilisateur) throws BllException {
		validerPseudo(utilisateur);
		validerEmail(utilisateur);
		validerNom(utilisateur);
		validerPrenom(utilisateur);
		validerTelephone(utilisateur);
		validerCodePotal(utilisateur);
	}

	private void validerPseudo(Utilisateur utilisateur) throws BllException {
		String checkAlphaNumeric = "[\\w]";

		if (utilisateur.getPseudo().length() < 5 && utilisateur.getPseudo().length() > 20) {
			throw new BllException("Votre pseudonyme doit faire entre 5 et 20 caractères");
		}
		if (utilisateur.getPseudo().matches(checkAlphaNumeric)) {
			throw new BllException("Votre pseudonyme ne doit contenir que des caractères alphanumériques");
		}
	}

	private void validerEmail(Utilisateur utilisateur) throws BllException {
		String checkEmail = "^[\\w-]+@[\\w-]+\\.[a-zA-Z]{2,6}$";

		if (!utilisateur.getEmail().matches(checkEmail)) {
			throw new BllException("Email invalide");
		}
	}

	private void validerNom(Utilisateur utilisateur) throws BllException {
		if (utilisateur.getNom().length() < 3 && utilisateur.getNom().length() > 30) {
			throw new BllException("Votre Nom doit faire entre 3 et 30 caractères");
		}
	}

	private void validerPrenom(Utilisateur utilisateur) throws BllException {
		if (utilisateur.getPrenom().length() < 2 && utilisateur.getPrenom().length() > 30) {
			throw new BllException("Votre Prénom doit faire entre 2 et 30 caractères");
		}
	}

	private void validerTelephone(Utilisateur utilisateur) throws BllException {
		String checkTelephone = "^(0|\\+33|33|0033){1|2|3|4|5|6|7|9}[0-9]{8}$";
		
		if (!utilisateur.getTelephone().matches(checkTelephone)) {
			throw new BllException("Numéro de téléphone invalide");
		}
	}

	private void validerCodePotal(Utilisateur utilisateur) throws BllException {
		String checkCodePostal = "[\\d]{5}";

		if (!utilisateur.getCodePostal().matches(checkCodePostal)) {
			throw new BllException("Code Postal invalide");
		}
	}


}
