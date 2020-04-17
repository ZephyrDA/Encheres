package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.BusinessException;
import bll.EncheresManager;
import bo.Article;
import bo.Categorie;

/**
 * Servlet implementation class ServletSupprimerArticle
 */
@WebServlet("/ServletSupprimerArticle")
public class ServletSupprimerArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSupprimerArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		ArrayList<Categorie> listCategories = new ArrayList<Categorie>();
		ArrayList<Article> listArticles = new ArrayList<Article>();
		try {
			listCategories = manager.getLesCategories();
			listArticles = manager.getLesArticles();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			manager.supprimerArticle(idArticle);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lesCategories", listCategories);
		request.setAttribute("lesArticles", listArticles);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		rd.forward(request, response);	
	}

}
