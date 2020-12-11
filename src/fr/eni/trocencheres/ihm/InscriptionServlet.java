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

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bll.UtilisateurManager;
import fr.eni.trocencheres.bo.Utilisateur;



@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String INDEX = "/IndexServlet";
	private static final String INSCRIPTION = "/WEB-INF/jsp/inscription.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		forward(request, response, INSCRIPTION);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Integer> listeCodesErreur = new ArrayList<>();

		String pseudo = verifierPseudo(request, listeCodesErreur);
		String nom = verifierNom(request, listeCodesErreur);
		String prenom = verifierPrenom(request, listeCodesErreur);
		String email = verifierEmail(request, listeCodesErreur);
		String telephone = verifierTelephone(request, listeCodesErreur);
		String rue = verifierRue(request, listeCodesErreur);
		String codepostal = verifierCodePostal(request, listeCodesErreur);
		String ville = verifierVille(request, listeCodesErreur);
		String password = verifierPassword(request, listeCodesErreur);

		Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codepostal, ville, password);

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
            forward(request, response, INSCRIPTION);
        } else {
        	UtilisateurManager um = new UtilisateurManager();
    		try {
    			um.ajouterUtilisateur(utilisateur);
    			forward(request, response, INDEX);
    		} catch (BusinessException e) {
    			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
    			System.out.println(e.getListeCodesErreur().toString());
    			forward(request, response, INSCRIPTION);
    		}
        }

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		ServletContext servletContext = getServletContext();
		RequestDispatcher rd = servletContext
		.getRequestDispatcher(redirection);
		rd.forward(request, response);
	}
	

	
	private String verifierPseudo(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String pseudo;
        pseudo = request.getParameter("pseudo");
        if(pseudo==null || pseudo.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PSEUDO_VIDE_ERREUR);
        }
        return pseudo;
    }

	private String verifierNom(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String nom;
        nom = request.getParameter("nom");
        if(nom==null || nom.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_NOM_VIDE_ERREUR);
        }
        return nom;
    }
	
	private String verifierPrenom(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String prenom;
        prenom = request.getParameter("prenom");
        if(prenom==null || prenom.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PRENOM_VIDE_ERREUR);
        }
        return prenom;
    }
	
	private String verifierEmail(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String email;
        email = request.getParameter("email");
        if(email==null || email.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_EMAIL_VIDE_ERREUR);
        }
        return email;
    }
	
	private String verifierTelephone(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String telephone;
        telephone = request.getParameter("telephone");
        if(telephone==null || telephone.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_TELEPHONE_VIDE_ERREUR);
        }
        return telephone;
    }
	
	private String verifierRue(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String rue;
        rue = request.getParameter("rue");
        if(rue==null || rue.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_RUE_VIDE_ERREUR);
        }
        return rue;
    }
	
	private String verifierCodePostal(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String codepostal;
        codepostal = request.getParameter("codePostal");
        if(codepostal==null || codepostal.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_CODEPOSTAL_VIDE_ERREUR);
        }
        return codepostal;
    }
	
	private String verifierVille(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String ville;
        ville = request.getParameter("ville");
        if(ville==null || ville.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_VILLE_VIDE_ERREUR);
        }
        return ville;
    }
	
	private String verifierPassword(HttpServletRequest request, List<Integer> listeCodesErreur) {
        String password;
        password = request.getParameter("password");
        if(password==null || password.trim().equals(""))
        {
            listeCodesErreur.add(CodesResultatServlets.CHAMPS_PASSWORD_VIDE_ERREUR);
        }
        return password;
    }

}
