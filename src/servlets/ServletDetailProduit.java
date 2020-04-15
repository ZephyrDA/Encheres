package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BusinessException;
import bo.Article;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletDetailProduit
 */
@WebServlet("/ServletDetailProduit")
public class ServletDetailProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Article utilisateur = new Article();
       
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String pseudo = (String) request.getAttribute("usernameVendeur");
		boolean administrateur = false;


		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailProduit.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}