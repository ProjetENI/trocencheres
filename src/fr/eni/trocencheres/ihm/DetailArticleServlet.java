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

/**
 * Servlet implementation class DetailArticleServlet
 */
@WebServlet("/DetailArticleServlet")
public class DetailArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "Index";
	private static final String DETAILS_ARTICLE = "DetailsArticle";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, INDEX);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Integer> listeCodesErreur = new ArrayList<>();
		ArticleVendu articleRecherche = null;
		
		int noArticleRecherche = verifierArticle(request, listeCodesErreur);
		
		ArticleVenduManager avm = new ArticleVenduManager();

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, INDEX);
        } else {
        	UtilisateurManager um = new UtilisateurManager();
    		try {
    			articleRecherche = avm.informationArticleVendu(noArticleRecherche);
    			request.setAttribute("article", articleRecherche);
    			forward(request, response, DETAILS_ARTICLE);
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
	
	private int verifierArticle(HttpServletRequest request, List<Integer> listeCodesErreur) {
		int noArticle = 0;
		try {
			noArticle = Integer.parseInt(request.getParameter("noArticle"));
		} catch (NumberFormatException e) {
			 listeCodesErreur.add(CodesResultatServlets.CHAMPS_CATEGORIE_ARTICLE_PARSE_ERREUR);
		}
		return noArticle;
	}

}
