package fr.eni.trocencheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/ModifierParametreServlet")
public class ModifierParametreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";
	private static final String MODIFIER_PARAMETRE = "ModifierParametre";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, MODIFIER_PARAMETRE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, INDEX);

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
}