package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bll.EncheresManager;
import bo.Article;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;


/**
 * Servlet implementation class ServletVisu
 */
@WebServlet("")
public class ServletHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EncheresManager EM = new EncheresManager();
		try {
			ArrayList<Article> listArticles = EM.getLesArticles();
			ArrayList<Categorie> listCategories = EM.getLesCategories();
			request.setAttribute("lesCategories", listCategories);
			request.setAttribute("lesArticles", listArticles);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choixUt = request.getParameter("choixUtilisateur");
		String idProduit = request.getParameter("idProduit");
		
		
		
		System.out.println(choixUt);
		System.out.println(idProduit);
		//Get IdArticle from BDD
		try {
			EncheresManager encheresManager = new EncheresManager();
			ArrayList<Article> lesArticles = encheresManager.getLesArticles();
			request.setAttribute("lesArticles", lesArticles);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		if(choixUt==null) {
			doGet(request, response);
		}
		else {
			if(choixUt.equals("Saisie")) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Ajout.jsp").forward(request, response);
			}
			else if(choixUt.equals("Historique")) {
				
			}
			else {
				doGet(request, response);
				System.out.println("else"); 
			}
		}

	}
}
