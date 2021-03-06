package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.EncheresManager;
import bo.Article;
import bo.Categorie;
import bo.Enchere;
import bo.Retrait;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletListeDonnees
 */
@WebServlet("/ListeDonnees")
public class ServletListeDonnees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeDonnees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			EncheresManager encheresManager = new EncheresManager();
			ArrayList<Categorie> lesCategories = encheresManager.getLesCategories();
			ArrayList<Utilisateur> lesUtilisateurs = encheresManager.getLesUtilisateurs();
			ArrayList<Article> lesArticles = encheresManager.getLesArticles();
			ArrayList<Enchere> lesEncheres = encheresManager.getLesEncheres();
			ArrayList<Retrait> lesRetraits = encheresManager.getLesRetraits();
			request.setAttribute("lesCategories", lesCategories);
			request.setAttribute("lesUtilisateurs", lesUtilisateurs);
			request.setAttribute("lesArticles", lesArticles);
			request.setAttribute("lesEncheres", lesEncheres);
			request.setAttribute("lesRetraits", lesRetraits);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/visu.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
	}

}
