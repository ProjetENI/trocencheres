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

@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";
	private static final String LOGIN = "ConnectionServlet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward(request, response, LOGIN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");
		Utilisateur myUser = new Utilisateur();

		UtilisateurManager um = new UtilisateurManager();
		
		if(motdepasse.equals("") || identifiant.equals("")) {
			request.setAttribute("vide", "Veuillez remplir les champs obligatoires*");
			forward(request, response, LOGIN);
		} else {
			myUser =  um.listerUtilisateurInformation(identifiant,motdepasse);

		}
				
		if (myUser == null) {
			request.setAttribute("error", "Connexion échouée, mauvaise combinaison identifiant/mot de passe !");
			forward(request, response, LOGIN);
		} else {
			HttpSession session = request.getSession();

			// 8001 _ Sécurité - Session utilisateur de 5min
			session.setMaxInactiveInterval(300);

			session.setAttribute("utilisateur", myUser);
			forward(request, response, INDEX);
		}
		
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection)
			throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
}
