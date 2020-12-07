package fr.eni.trocencheres.ihm;

import java.io.IOException;

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
@WebServlet("/SupprimerCompteServlet")
public class SupprimerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur userASupprimer = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager um = new UtilisateurManager();

		try {
			um.supprimerUtilisateur(userASupprimer);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Utilisateur emptyUser = new Utilisateur();
		session.setAttribute("utilisateur", emptyUser);
		
		forward(request, response, INDEX);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward(request, response, INDEX);

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
}

