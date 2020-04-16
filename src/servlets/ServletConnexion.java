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
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String id = (String) request.getParameter("identifiant");
		String mdp = (String) request.getParameter("mdp");
		
		Utilisateur user = new Utilisateur ();
		try {
			user = manager.getUtilisateurByPseudo(id);
			if(user.getNom()==null) {
				user = manager.getUtilisateurByEmail(id);
			}
			if(user.getNom()!=null && mdp.contentEquals(user.getMotDePasse())) {				
				session.setAttribute("connectedUser", user);
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
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("erreur", "L'identifiant ou le mot de passe est incorrect.");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/seConnecter.jsp");
				rd.forward(request, response);
			}
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
