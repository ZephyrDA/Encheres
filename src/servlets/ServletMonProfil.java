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
import bo.Enchere;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletMonProfil
 */
@WebServlet("/MonProfil")
public class ServletMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMonProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		try {
			ArrayList<Article> lesArticles = manager.getLesArticles();
			ArrayList<Enchere> lesEncheres = manager.getLesEncheres();
			request.setAttribute("lesEncheres", lesEncheres);
			request.setAttribute("lesArticles", lesArticles);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
