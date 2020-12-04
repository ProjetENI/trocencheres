package fr.eni.trocencheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocencheres.bll.UtilisateurManager;
import fr.eni.trocencheres.bo.Utilisateur;
import fr.eni.trocencheres.exceptions.BllException;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/ModifierParametreServlet")
public class ModifierParametreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PARAMETRE_UTILISATEUR = "MonProfil";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward(request, response, PARAMETRE_UTILISATEUR);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean validModif = false;
		HttpSession session = request.getSession();
		Utilisateur userAModifieer = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager um = new UtilisateurManager();
		
		Utilisateur myUser = new Utilisateur(userAModifieer.getNoUtilisateur(),request.getParameter("pseudo"),request.getParameter("nom"),
				request.getParameter("prenom"),request.getParameter("email"),request.getParameter("telephone"),request.getParameter("rue"),
				request.getParameter("codePostal"),request.getParameter("ville"));
	
		try {
			um.modifierUtilisateur(myUser);
			validModif = true;

		} catch (BllException e) {
			e.printStackTrace();
		}
		
		if (validModif) {
			session.setAttribute("utilisateur", myUser);
		}
		
		forward(request, response, PARAMETRE_UTILISATEUR);

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
}