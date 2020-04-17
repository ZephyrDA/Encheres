package servlets;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class ServletModifierArticle
 */
@WebServlet("/ServletModifierArticle")
public class ServletModifierArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		EncheresManager EM = new EncheresManager();
//		try {
//			ArrayList<Article> listArticles = EM.getLesArticles();
//			ArrayList<Categorie> listCategories = EM.getLesCategories();
//			
//			request.setAttribute("lesCategories", listCategories);
//			request.setAttribute("lesArticles", listArticles);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		
//		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/ajoutEnchere.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//		HttpSession session = request.getSession();
//		Article art = (Article) session.getAttribute("connectedUser");
//		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profilModifier.jsp");
//
//		if(!request.getParameter("snom").equals("")) {
//			if(!art.getNom_article().contentEquals(request.getParameter("snom"))) {
//				art.setNom_article(request.getParameter("snom"));					
//			}
//		}
//		else {
//			request.setAttribute("erreur", "Echec modification du nom");
//			rd.forward(request, response);
//		}
//		if(!request.getParameter("sdescription").equals("")) {
//			if(!art.getDescription().contentEquals(request.getParameter("sdescription"))) {
//				art.setDescription(request.getParameter("sdescription"));
//			}
//		}
//		else {
//			request.setAttribute("erreur", "Echec modification description");
//			rd.forward(request, response);
//		}
//		if(!request.getParameter("sDebut").equals("")) {
//			String[] dateStr = ((String)request.getParameter("sFin")).split("-");
//			int y = Integer.parseInt(dateStr[0]);
//			int m = Integer.parseInt(dateStr[1]);
//			int day = Integer.parseInt(dateStr[2]);
//			java.util.Date date = new java.util.Date(y,m,day,0,0, 0);
//			java.sql.Date dateSql = new java.sql.Date(date.getTime());
//			if(art.getDate_debut_encheres().compareTo(request.getParameter("sDebut"))!=0) {
//				art.setDate_debut_encheres(request.getParameter("sDebut"));
//			}
//		}
//		else {
//			request.setAttribute("erreur", "Echec modif date debut enchere");
//			rd.forward(request, response);
//		}	
//		if(!request.getParameter("sFin").equals("")) {	
//			if(!art.getDate_fin_encheres().compareTo(request.getParameter("sFin"))) {
//				art.setDate_fin_encheres(request.getParameter("sFin"));
//			}
//		}
//		else {
//			request.setAttribute("erreur", "Echec modif date fin enchere");
//			rd.forward(request, response);
//		}	
//		if(!request.getParameter("sprix").equals("")) {	
//			if(!art.getPrix_initial().contentEquals(request.getParameter("sprix"))) {
//				art.setPrix_initial(request.getParameter("sprix"));
//			}
//		}
//		else {
//			request.setAttribute("erreur", "Echec modif prix enchere");
//			rd.forward(request, response);
//		}
//	
//		
//		
//			
//		
//		
//		try {
//			manager.modifierArticle(art);
//			session.setAttribute("connectedUser", art);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		rd = request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp");
//		rd.forward(request, response);
//		

	//		String[] dateStr = ((String)request.getParameter("sFin")).split("-");
	//		int y = Integer.parseInt(dateStr[0]);
	//		int m = Integer.parseInt(dateStr[1]);
	//		int day = Integer.parseInt(dateStr[2]);
	//		java.util.Date date = new java.util.Date(y,m,day,0,0, 0);
	//		java.sql.Date dateSql = new java.sql.Date(date.getTime());
	//		if(art.getDate_debut_encheres().compareTo(request.getParameter("sDebut"))!=0) {
	//			art.setDate_debut_encheres(request.getParameter("sDebut"));
	//		}

	//		if(!art.getDate_fin_encheres().compareTo(request.getParameter("sFin"))) {
	//			art.setDate_fin_encheres(request.getParameter("sFin"));
	//		}

	//		if(!art.getPrix_initial().contentEquals(request.getParameter("sprix"))) {
	//			art.setPrix_initial(request.getParameter("sprix"));
	//		}
	}


}
