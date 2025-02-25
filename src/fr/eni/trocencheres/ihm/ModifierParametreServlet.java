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
import javax.servlet.http.HttpSession;

import fr.eni.trocencheres.BusinessException;
import fr.eni.trocencheres.bll.UtilisateurManager;
import fr.eni.trocencheres.bo.Utilisateur;

/**
 * Servlet implementation class MonProfilServlet
 */
@WebServlet("/ModifierParametreServlet")
public class ModifierParametreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PARAMETRE_UTILISATEUR = "MonProfil";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		forward(request, response, PARAMETRE_UTILISATEUR);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean validModif = false;
		HttpSession session = request.getSession();
		Utilisateur userConnecter = (Utilisateur) session.getAttribute("utilisateur");
		UtilisateurManager um = new UtilisateurManager();
		List<Integer> listeCodesErreur = new ArrayList<>();
		
		String pseudo = verifierPseudo(request, listeCodesErreur);
		String nom = verifierNom(request, listeCodesErreur);
		String prenom = verifierPrenom(request, listeCodesErreur);
		String email = verifierEmail(request, listeCodesErreur);
		String telephone = verifierTelephone(request, listeCodesErreur);
		String rue = verifierRue(request, listeCodesErreur);
		String codepostal = verifierCodePostal(request, listeCodesErreur);
		String ville = verifierVille(request, listeCodesErreur);
		
		
		Utilisateur myUser = new Utilisateur(userConnecter.getNoUtilisateur(),pseudo,nom,prenom,email,telephone,rue,codepostal,ville);

		if(listeCodesErreur.size()>0) {
            request.setAttribute("listeCodesErreur",listeCodesErreur);
			forward(request, response, PARAMETRE_UTILISATEUR);
		} else {
			try {
				um.modifierUtilisateur(myUser);
				validModif = true;
	
			} catch (BusinessException e) {
				request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			}
			
			if (validModif) {
				session.setAttribute("utilisateur", myUser);
			}
		
			forward(request, response, PARAMETRE_UTILISATEUR);
		}

	}

	private void forward(HttpServletRequest request, HttpServletResponse response, String redirection) throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher(redirection);
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
        if(prenom.equals(null) || prenom.trim().equals("")) {
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
	
}