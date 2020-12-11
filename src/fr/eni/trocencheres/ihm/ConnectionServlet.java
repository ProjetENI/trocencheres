package fr.eni.trocencheres.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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

	private static final String INDEX = "/IndexServlet";
	private static final String LOGIN = "/WEB-INF/jsp/login.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward(request, response, LOGIN);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Integer> listeCodesErreur = new ArrayList<>();
		String identifiant = verifierIdentifiant(request, listeCodesErreur);
		String motdepasse = verifierPassword(request, listeCodesErreur);
		
		Utilisateur myUser = null;

		UtilisateurManager um = new UtilisateurManager();

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
			forward(request, response, LOGIN);
		} else {
			try {
				myUser =  um.listerUtilisateurInformation(identifiant,motdepasse);
			} catch (BusinessException e) {
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			}
		}

		if (myUser == null) {
			listeCodesErreur.add(CodesResultatServlets.CONNECTION_SERVLET_ID_MDP_ERREUR);
			request.setAttribute("listeCodesErreur", listeCodesErreur);
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

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext
		.getRequestDispatcher(redirection);
		rd.forward(request, response);
	}
	
	private String verifierIdentifiant(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String ville;
        ville = request.getParameter("identifiant");
        if(ville==null || ville.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_IDENTIFIANT_VIDE_ERREUR);
        }
        return ville;
    }
	
	private String verifierPassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String password;
        password = request.getParameter("motdepasse");
        if(password==null || password.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PASSWORD_VIDE_ERREUR);
        }
        return password;
    }
	
}
