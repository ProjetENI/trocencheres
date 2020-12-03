package fr.eni.trocencheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocencheres.bll.UtilisateurManager;

@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";
	private static final String LOGIN = "login";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, LOGIN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String motdepasse = request.getParameter("motdepasse");

		UtilisateurManager toto = new UtilisateurManager();
		boolean resulatIdentification = toto.verifierIdentification(email, motdepasse);
		
		if(motdepasse.equals("") || email.equals("")) {
			request.setAttribute("vide", "Veuillez remplir les champs obligatoires*");
			forward(request, response, LOGIN);
		} else if (!resulatIdentification) {
			request.setAttribute("error", "Connexion échouée, mauvaise combinaison identifiant/mot de passe !");
			forward(request, response, LOGIN);
		} else {
			forward(request, response, INDEX);
		}
		
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection)
			throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("ConnectionServlet");
		rd.forward(request, response);
	}
}
