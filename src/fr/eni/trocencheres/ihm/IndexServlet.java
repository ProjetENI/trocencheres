package fr.eni.trocencheres.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bll.ArticleVenduManager;
import fr.eni.trocencheres.bll.UtilisateurManager;
import fr.eni.trocencheres.bo.ArticleVendu;



@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Integer> listeCodesErreur = new ArrayList<>();
		List<ArticleVendu> listeArticlesVendus = new ArrayList<>();
		
		ArticleVenduManager avm = new ArticleVenduManager();

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, INDEX);
        } else {
        	UtilisateurManager um = new UtilisateurManager();
    		try {
    			listeArticlesVendus = avm.listerArticleVendu();
    			request.setAttribute("listeArticles", listeArticlesVendus);
    			forward(request, response, INDEX);
    		} catch (BusinessException e) {
    			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
    			forward(request, response, INDEX);
    		}
        }

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> listeCodesErreur = new ArrayList<>();
		List<ArticleVendu> listeArticlesVendus = new ArrayList<>();

		ArticleVenduManager avm = new ArticleVenduManager();

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, INDEX);
        } else {
        	UtilisateurManager um = new UtilisateurManager();
    		try {
    			listeArticlesVendus = avm.listerArticleVendu();
    			request.setAttribute("listeArticles", listeArticlesVendus);
    			forward(request, response, INDEX);
    		} catch (BusinessException e) {
    			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
    			forward(request, response, INDEX);
    		}
        }

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}
	
}
