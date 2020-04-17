package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BusinessException;
import bll.EncheresManager;
import bo.Article;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletDetailProduit
 */
@WebServlet("/ServletDetailProduit")
public class ServletDetailProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetailProduit() {
        super();
        // TODO Auto-generated constructor stub
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("idArticle", request.getParameter("idArticle"));
		doPost( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		int idArticle = (int) Integer.parseInt(request.getParameter("idArticle"));
		try {
			Article article = manager.getArticle(idArticle);
			request.setAttribute("article", article);			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailProduit.jsp");
			rd.forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
