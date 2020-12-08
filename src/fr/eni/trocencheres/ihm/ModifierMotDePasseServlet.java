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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, MODIFIER_MOT_DE_PASSE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean validModif = false;
		
		HttpSession session = request.getSession();
		Utilisateur userConnecter = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager um = new UtilisateurManager();
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		String password = verifierPassword(request, listeCodesErreur);
		
		Utilisateur myUserMdpModif = new Utilisateur(userConnecter.getNoUtilisateur(),password);
		Utilisateur myUser = new Utilisateur(userConnecter.getNoUtilisateur(),userConnecter.getPseudo(),userConnecter.getNom(),userConnecter.getPrenom(),
				userConnecter.getEmail(),userConnecter.getTelephone(),userConnecter.getRue(),userConnecter.getCodePostal(),userConnecter.getVille());
		
		try {
			um.modifierMotDePasse(myUserMdpModif);
			validModif = true;

		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			e.printStackTrace();
		}
		
		if (validModif) {
			session.setAttribute("utilisateur", myUser);
		}

		forward(request, response, MODIFIER_MOT_DE_PASSE);

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
	
	private String verifierPassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String password;
        password = request.getParameter("codepostal");
        if(password==null || password.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PASSWORD_VIDE_ERREUR);
        }
        return password;
    }
}

