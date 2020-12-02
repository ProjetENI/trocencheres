package fr.eni.trocencheres.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeconnexionServlet")
public class DeconnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		forward(request, response, INDEX);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		forward(request, response, INDEX);
	}
	protected void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
}
