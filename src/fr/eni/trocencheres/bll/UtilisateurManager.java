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
	
	
	private void validerUtilisateur(Utilisateur utilisateur) throws BllException {
		String checkAlphaNumeric = "[A-Za-z0-9]";
		String checkEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String checkTelephone = "^(0|\\+33|33|0033)[0-9]{8}$";
		String checkCodePostal = "[0-9]{5}";

		if (utilisateur.getPseudo().length() < 5 && utilisateur.getPseudo().length() > 20) {
			throw new BllException("Votre pseudonyme doit faire entre 5 et 20 caractères");
		}
		if (utilisateur.getPseudo().matches(checkAlphaNumeric)) {
			throw new BllException("Votre pseudonyme ne doit contenir que des caractères alphanumériques");
		}
		if (utilisateur.getNom().length() < 3 && utilisateur.getNom().length() > 30) {
			throw new BllException("Votre Nom doit faire entre 3 et 30 caractères");
		}
		if (utilisateur.getPrenom().length() < 2 && utilisateur.getPrenom().length() > 30) {
			throw new BllException("Votre Prénom doit faire entre 2 et 30 caractères");
		}
		if (!utilisateur.getEmail().matches(checkEmail)) {
			throw new BllException("Email invalide");
		}
		if (!utilisateur.getTelephone().matches(checkTelephone)) {
			throw new BllException("Numéro de téléphone invalide");
		}
		if (!utilisateur.getCodePostal().matches(checkCodePostal)) {
			throw new BllException("Code Postal invalide");
		}
	}
	

}
