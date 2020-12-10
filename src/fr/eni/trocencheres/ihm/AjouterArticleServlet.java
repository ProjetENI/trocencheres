package fr.eni.trocencheres.ihm;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

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

		// String imageURL = request.getParameter("photoArticle");
		String imageURL = uploadImage(request, listeCodesErreur, "photoArticle");
		System.out.println(imageURL);
		LocalDate dateDebutEncheres = verifierDate(request, listeCodesErreur, "dateDebutEnchere");
		LocalDate dateFinEncheres = verifierDate(request, listeCodesErreur, "dateFinEnchere");
		int prixInitial = verifierPrixInitial(request, listeCodesErreur, "prixInitial");
		Categorie categorie = new Categorie(verifierCategorie(request, listeCodesErreur, "categories"));
		Utilisateur utilisateurVendeur = userSession;

		String rue = verifierRue(request, listeCodesErreur);
		String codepostal = verifierCodePostal(request, listeCodesErreur);
		String ville = verifierVille(request, listeCodesErreur);
		
		ArticleVendu articlevendu;
		
		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, AJOUTER_ARTICLE);
        }
		

		// Si l'utilisateur a gardé l'adresse de retrait par défaut instancie un ArticleVendu sans les paramètres adresse
		if ( utilisateurVendeur.getRue().equals(rue) && 
			 utilisateurVendeur.getCodePostal().equals(codepostal) &&	
			 utilisateurVendeur.getVille().equals(ville) ) {

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
	
	private int verifierPrixInitial(HttpServletRequest request, List<Integer> listeCodesErreur, String nomParametre) {
		int prixInitial = 0;
		try {
			prixInitial = Integer.parseInt(request.getParameter(nomParametre));
		} catch (NumberFormatException e) {
			 listeCodesErreur.add(CodesResultatServlets.CHAMPS_PRIX_INITIAL_ARTICLE_PARSE_ERREUR);
		}
		return prixInitial;
	}
	
	private int verifierCategorie(HttpServletRequest request, List<Integer> listeCodesErreur, String nomParametre) {
		int categorie = 0;
		try {
			categorie = Integer.parseInt(request.getParameter(nomParametre));
		} catch (NumberFormatException e) {
			 listeCodesErreur.add(CodesResultatServlets.CHAMPS_CATEGORIE_ARTICLE_PARSE_ERREUR);
		}
		return categorie;
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
        codepostal = request.getParameter("codePostal");
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
	
	private String uploadImage(HttpServletRequest request, List<Integer> listeCodesErreur, String nomParametre) throws IOException, ServletException {
		String fileName = null;
		//récupérer l’image provenant de la JSP	
		Part filePart = request.getPart(nomParametre);

		//si l’utilisateur a saisi une image
		if(filePart != null && filePart.getSize() > 0) {	 
			//récupérer le nom de l’image
			fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

			//séparer le nom et l’extension
			String[] fn = fileName.split("(\\.)");

			//stocker l’extension
			String ext = fn[(fn.length-1)];
			if(!ext.isEmpty()) {
				//mettre en place un mécanisme ici, pour générer un nom de fichier unique afin d’éviter les écrasements de fichier
				Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("yymmddhhmmss");
				String strDate = dateFormat.format(date);

				//recréer le nom complet
				fileName = "photo_enchere_" + strDate.toLowerCase() + "." + ext;
				
				InputStream fileContent = filePart.getInputStream();
				
				//Version Production
				//String sContext = //this.getServletContext().getRealPath("/");
					     
				//TODO : A supprimer pour la production
				//Version eclipse (indiquer en dur le répertoire de stockage des images sur le serveur
				// WINDOWS 10
				String sContext = "D:\\JAVA EE\\WorkSpaceProject_2020"+ request.getContextPath() + "/WebContent";
				// MAC OS X
				//String sContext = "/Users/damienpuaud/eclipse-workspace/git/"+ request.getContextPath() + "/WebContent";

				File f = new File(sContext + "/uploads/images/" + fileName);

				FileOutputStream fos= null;
	            try {
	                fos = new FileOutputStream(f);
	                byte[] buffer = new byte[32 * 1024];
	                int len;
	                while ((len = fileContent.read(buffer)) > -1) {
	                    fos.write(buffer, 0, len);
	                }
	            } catch (IOException e) {
	                f.delete();
	            }finally {
	                 if (fos != null) {
	                     try { fos.close(); } catch (IOException ignored) {};
	                 }
	                if(fileContent!= null) {
	                    try {fileContent.close(); } catch (IOException ignored) {};
	                }
	            }

			}
			
		}
		return fileName;
	}
	

}
