package fr.eni.trocencheres.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/connectionServlet")
public class connectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String REDIRECTIONLOGIN = "login.jsp";
	private static String REDIRECTIONINDEX = "index.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(REDIRECTIONLOGIN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.sendRedirect(REDIRECTIONINDEX);
	}

}
