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

@WebServlet("/ConnectionServlet")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";
	private static final String LOGIN = "Login";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward(request, response, LOGIN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BusinessException businessException = new BusinessException();
		String identifiant = request.getParameter("identifiant");
		String motdepasse = request.getParameter("motdepasse");
		Utilisateur myUser = null;

		UtilisateurManager um = new UtilisateurManager();

		if(motdepasse.equals("") || identifiant.equals("")) {
			businessException.ajouterErreur(CodesResultatServlets.CONNECTION_SERVLET_CHAMPS_VIDES_ERREUR);
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
			forward(request, response, LOGIN);
		} else {
			try {
				myUser =  um.listerUtilisateurInformation(identifiant,motdepasse);
			} catch (BusinessException e) {
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
				e.printStackTrace();
			}
		}

		if (myUser == null) {
			businessException.ajouterErreur(CodesResultatServlets.CONNECTION_SERVLET_ID_MDP_ERREUR);
			request.setAttribute("listeCodesErreur", businessException.getListeCodesErreur());
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
