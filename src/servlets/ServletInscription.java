package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BusinessException;
import bll.EncheresManager;
import bo.Article;
import bo.Categorie;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/GestionInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String pseudo = (String) request.getParameter("pseudoInscription");
		String nom = (String) request.getParameter("nomInscription");
		String prenom = (String) request.getParameter("prenomInscription");
		String email = (String) request.getParameter("emailInscription");
		String telephone = (String) request.getParameter("telephoneInscription");
		String rue = (String) request.getParameter("rueInscription");
		String codePostal = (String) request.getParameter("codePostalInscription");
		String ville = (String) request.getParameter("villeInscription");
		String motDePasse = (String) request.getParameter("motDePasseInscription");
		String motDePasse2 = (String) request.getParameter("confirmationInscription");
		boolean administrateur = false;
		
		if(pseudo.equals(null)||nom.equals(null)||prenom.equals(null)||email.equals(null)||telephone.equals(null)||rue.equals(null)||codePostal.equals(null)
				||ville.equals(null)||motDePasse.equals(null)||motDePasse2.equals(null)) {
			request.setAttribute("erreur", "Veuillez remplir tous les champs");
		}
		else {
			try {
				Utilisateur user = manager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, motDePasse2, administrateur);
				ArrayList<Article> listArticles = new ArrayList<Article>();
				try {
					listArticles = manager.getLesArticles();
				} catch (BusinessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<Categorie> listCategories = new ArrayList<Categorie>();
				try {
					listCategories = manager.getLesCategories();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("lesCategories", listCategories);
				request.setAttribute("lesArticles", listArticles);
				session.setAttribute("connectedUser", user);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		rd.forward(request, response);
	}

}
