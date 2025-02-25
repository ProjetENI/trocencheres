package fr.eni.trocencheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocencheres.bo.Utilisateur;

@WebServlet("/DeconnectionServlet")
public class DeconnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "/IndexServlet";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur emptyUser = null;
		
		HttpSession session = request.getSession();
		session.setAttribute("utilisateur", emptyUser);
		forward(request, response, INDEX);
	}

	protected void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext
		.getRequestDispatcher(redirection);
		requestDispatcher.forward(request, response);
	}
}
