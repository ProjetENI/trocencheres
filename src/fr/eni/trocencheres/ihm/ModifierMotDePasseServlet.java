package fr.eni.trocencheres.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bll.UtilisateurManager;
import fr.eni.trocencheres.bo.Utilisateur;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/ModifierMotDePasseServlet")
public class ModifierMotDePasseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String MODIFIER_MOT_DE_PASSE = "ModifierMotDePasse";
	private static final String PARAMETRE_UTILISATEUR = "MonProfil";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, MODIFIER_MOT_DE_PASSE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean validModif = false;
		
		HttpSession session = request.getSession();
		BusinessException be = new BusinessException();
		Utilisateur userConnecter = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager um = new UtilisateurManager();
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		String passwordAncien = verifierAncienPassword(request, listeCodesErreur);
		
		String passwordNouveau = verifierNouveauPassword(request, listeCodesErreur);
		String passwordNouveau2 = verifierNouveauPassword2(request, listeCodesErreur);
		
		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, PARAMETRE_UTILISATEUR);
        } else {
			if (passwordNouveau.equals(passwordNouveau2)) {
				Utilisateur myUser = new Utilisateur(userConnecter.getNoUtilisateur(),userConnecter.getPseudo(),userConnecter.getNom(),userConnecter.getPrenom(),
						userConnecter.getEmail(),userConnecter.getTelephone(),userConnecter.getRue(),userConnecter.getCodePostal(),userConnecter.getVille(),passwordAncien);
				
				try {
					um.modifierMotDePasse(myUser,passwordNouveau);
					validModif = true;
	
				} catch (BusinessException e) {
					request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				}
				
				if (validModif) {
					myUser.setMotDePasse(passwordNouveau);
					session.setAttribute("utilisateur", myUser);
				}
				
			} else {
				be.ajouterErreur(CodesResultatServlets.CORRESPONDACE_MDP);
				request.setAttribute("listeCodesErreur", be.getListeCodesErreur());
			}
        }

		forward(request, response, PARAMETRE_UTILISATEUR);

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
	
	private String verifierAncienPassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String password;
        password = request.getParameter("ancienMotDePasse");
        if(password==null || password.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PASSWORD_VIDE_ERREUR);
        }
        return password;
    }
	
	private String verifierNouveauPassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String password;
        password = request.getParameter("nouveauMotDePasse1");
        if(password==null || password.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PASSWORD_VIDE_ERREUR);
        }
        return password;
    }
	
	private String verifierNouveauPassword2(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String password;
        password = request.getParameter("nouveauMotDePasse2");
        if(password==null || password.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PASSWORD_VIDE_ERREUR);
        }
        return password;
    }
}

