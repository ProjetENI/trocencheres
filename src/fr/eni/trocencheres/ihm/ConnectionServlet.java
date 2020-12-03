package fr.eni.trocencheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocencheres.dal.jdbc.UtilisateurDaoJdbcImpl;

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
		String erreur = request.getParameter("erreur");

		UtilisateurDaoJdbcImpl toto = new UtilisateurDaoJdbcImpl();
		boolean resulatIdentification = toto.verifierIdentification(email, motdepasse);
		if (resulatIdentification) {
			forward(request, response, INDEX);
		} else {
			request.setAttribute("error", "");
			forward(request, response, INDEX);
		}
	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection)
			throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("ConnectionServlet");
		rd.forward(request, response);
	}
}
