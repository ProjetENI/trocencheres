package fr.eni.trocencheres.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bll.ArticleVenduManager;
import fr.eni.trocencheres.bll.RetraitManager;
import fr.eni.trocencheres.bo.ArticleVendu;
import fr.eni.trocencheres.bo.Categorie;
import fr.eni.trocencheres.bo.Retrait;
import fr.eni.trocencheres.bo.Utilisateur;

/**
 * Servlet implementation class AjouterArticle
 */
@WebServlet("/AjouterArticleServlet")
@MultipartConfig
public class AjouterArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String INDEX = "Index";
	private static final String AJOUTER_ARTICLE = "AjouterArticle";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forward(request, response, AJOUTER_ARTICLE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération de l'utilisateur de la session en cours
		HttpSession session = request.getSession();
		Utilisateur userSession = (Utilisateur) session.getAttribute("utilisateur");
		
		// Déclaration de la liste listeCodesErreur et instanciation vide pour y insérer les erreurs potentielles
		List<Integer> listeCodesErreur = new ArrayList<>();

		// Récupération de tous les paramètres envoyés par la JSP
		String nomArticle = verifierNomArticle(request, listeCodesErreur);
		String description = verifierDescription(request, listeCodesErreur);
		String imageURL = request.getParameter("photoArticle");
		LocalDate dateDebutEncheres = verifierDate(request, listeCodesErreur, "dateDebutEnchere");
		LocalDate dateFinEncheres = verifierDate(request, listeCodesErreur, "dateFinEnchere");
		int prixInitial = Integer.parseInt(request.getParameter("prixIntial"));
		Categorie categorie = new Categorie(Integer.parseInt(request.getParameter("categorie")));
		Utilisateur utilisateurVendeur = userSession;
		
		String rue = verifierRue(request, listeCodesErreur);
		String codepostal = verifierCodePostal(request, listeCodesErreur);
		String ville = verifierVille(request, listeCodesErreur);
		
		ArticleVendu articlevendu;
		
		// Si l'utilisateur a gardé l'adresse de retrait par défaut instancie un ArticleVendu sans les paramètres adresse
		if ( userSession.getRue().equals(rue) && 
			 userSession.getCodePostal().equals(codepostal) &&	
			 userSession.getVille().equals(ville) ) {

			articlevendu = new ArticleVendu(nomArticle, description, imageURL, dateDebutEncheres, 
														 dateFinEncheres, prixInitial, categorie, utilisateurVendeur);			
		} else {
			// Sinon instancie un Retrait avec la nouvelle adresse et l'envoie en paramètres pour instancier un ArticleVendu
			
			RetraitManager rm = new RetraitManager();
			Retrait retrait = new Retrait(rue, codepostal, ville);
			try {
				rm.validerRetrait(retrait);
			} catch (BusinessException e) {
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			}

			articlevendu = new ArticleVendu(nomArticle, description, imageURL, dateDebutEncheres, 
														 dateFinEncheres, prixInitial, categorie, utilisateurVendeur, 
														 retrait);
		}

		// Gestion des erreurs
		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, AJOUTER_ARTICLE);
        } else {
        	ArticleVenduManager avm = new ArticleVenduManager();
    		try {
    			avm.ajouterArticleVendu(articlevendu);
    			forward(request, response, INDEX);
    		} catch (BusinessException e) {
    			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
    			forward(request, response, AJOUTER_ARTICLE);
    		}
        }

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection)
			throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
		rd.forward(request, response);
	}


	// TOUTES LES MÉTHODES DE VÉRIFICATION IHM
	private String verifierNomArticle(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String nomArticle;
        nomArticle = request.getParameter("nomArticle");
        if(nomArticle==null || nomArticle.trim().equals("")) {

            listeCodesErreur.add(CodesResultatServlets.CHAMPS_NOM_ARTICLE_VIDE_ERREUR);
        }
        return nomArticle;
    }
	
	private String verifierDescription(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String description;
        description = request.getParameter("description");
        if(description==null || description.trim().equals("")) {

            listeCodesErreur.add(CodesResultatServlets.CHAMPS_DESCRIPTION_ARTICLE_VIDE_ERREUR);
        }
        return description;
    }
	
	private LocalDate verifierDate(HttpServletRequest request, List<Integer> listeCodesErreur, String nomParametre) {

        String stringDate = request.getParameter(nomParametre);
        LocalDate date = null;
        
        if(stringDate==null || stringDate.trim().equals("")) {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_DATE_ARTICLE_VIDE_ERREUR);
        } else {
        	try {
            	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            	date = LocalDate.parse(stringDate, dtf);
    		} catch (DateTimeParseException e) {
    			listeCodesErreur.add(CodesResultatServlets.CHAMPS_DATE_ARTICLE_FORMAT_ERREUR);
    		}
        }
        return date;
    }

	private String verifierRue(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String rue;
        rue = request.getParameter("rue");
        if(rue==null || rue.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_RUE_RETRAIT_ARTICLE_VIDE_ERREUR);
        }
        return rue;
    }
	
	private String verifierCodePostal(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String codepostal;
        codepostal = request.getParameter("codepostal");
        if(codepostal==null || codepostal.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_CODEPOSTAL_RETRAIT_ARTICLE_VIDE_ERREUR);
        }
        return codepostal;
    }
	
	private String verifierVille(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String ville;
        ville = request.getParameter("ville");
        if(ville==null || ville.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_VILLE_RETRAIT_VIDE_ERREUR);
        }
        return ville;
    }
}
