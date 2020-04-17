package servlets;

import java.io.IOException;

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
 * Servlet implementation class ServletJSPEnchereFini
 */
@WebServlet("/Encherir")
public class ServletEncherir extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEncherir() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		Utilisateur user = (Utilisateur) request.getSession().getAttribute("connectedUser");
		 int idArticle = Integer.parseInt(request.getParameter("sIdArticle"));
		 
		int montant = Integer.parseInt(request.getParameter("sMontantOffre"));
		int montantmini = Integer.parseInt(request.getParameter("sMontantMinimum"));
		try {
			
			if(montant>=montantmini && montant<user.getCredit()) {
			Enchere enchere = manager.ajouterEnchere(montant, user, idArticle);
			Article article = manager.getArticle(idArticle);
			article.getEncheres().add(enchere);
			manager.modifierArticle(article);
			request.setAttribute("idArticle", article.getNo_article());			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailProduit.jsp");
			rd.forward(request, response);
			}
			
			else {
				request.setAttribute("erreur", "Votre offre doit être supérieure la dernière offre, et inférieur à votre montant de crédits");	
				Article article = manager.getArticle(idArticle);
				request.setAttribute("article", article);			
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailProduit.jsp");
				rd.forward(request, response);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
