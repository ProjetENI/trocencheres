package fr.eni.trocencheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
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
import fr.eni.trocencheres.bll.ArticleVenduManager;
import fr.eni.trocencheres.bll.EnchereManager;
import fr.eni.trocencheres.bll.UtilisateurManager;
import fr.eni.trocencheres.bo.ArticleVendu;
import fr.eni.trocencheres.bo.Enchere;
import fr.eni.trocencheres.bo.Utilisateur;

/**
 * Servlet implementation class EncherirServlet
 */
@WebServlet("/EncherirServlet")
public class EncherirServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DETAILS_ARTICLE = "/WEB-INF/jsp/detailsArticle.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		forward(request, response, DETAILS_ARTICLE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean validModif = false;
		HttpSession session = request.getSession();
		Utilisateur userConnecter = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager um = new UtilisateurManager();
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		ArticleVendu articleRecherche = null;
		int noArticleRecherche = verifierArticle(request, listeCodesErreur);
		ArticleVenduManager avm = new ArticleVenduManager();

		int montantEnchere = verifierMontantEnchere(request, listeCodesErreur, "montantEnchere");
		ArticleVendu noArticle = new ArticleVendu(Integer.parseInt(request.getParameter("noArticle")));

//		Utilisateur myUser = new Utilisateur(userConnecter.getNoUtilisateur());
//		Enchere enchere = new Enchere(LocalDate.now(), montantEnchere, noArticle, myUser);

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            try {
				articleRecherche = avm.informationArticleVendu(noArticleRecherche);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("article", articleRecherche);
			forward(request, response, DETAILS_ARTICLE);
		} else {
//			try {
//				um.modifierUtilisateur(myUser);
//				validModif = true;
//	
//			} catch (BusinessException e) {
//				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
//			}
			
			try {
    			articleRecherche = avm.informationArticleVendu(noArticleRecherche);
    			request.setAttribute("article", articleRecherche);
    			forward(request, response, DETAILS_ARTICLE);
    		} catch (BusinessException e) {
    			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
    			forward(request, response, DETAILS_ARTICLE);
    		}
			
//			if (validModif) {
//				session.setAttribute("utilisateur", myUser);
//			}
		
			forward(request, response, DETAILS_ARTICLE);
		}

	}
	
	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext
		.getRequestDispatcher(redirection);
		requestDispatcher.forward(request, response);
	}
	
	private int verifierMontantEnchere(HttpServletRequest request, List<Integer> listeCodesErreur, String nomParametre) {
		int montantEnchere = 0;
		if(request.getParameter(nomParametre)==null || request.getParameter(nomParametre).trim().equals("")) {
			listeCodesErreur.add(CodesResultatServlets.CHAMPS_MONTANT_ENCHERE_VIDE_ERREUR);
		} else {
			try {
				montantEnchere = Integer.parseInt(request.getParameter(nomParametre));
			} catch (NumberFormatException e) {
				listeCodesErreur.add(CodesResultatServlets.CHAMPS_MONTANT_ENCHERE_ENTIER_ERREUR);
			}	
		}
		return montantEnchere;
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
