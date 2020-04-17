package servlets;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

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
import bo.Utilisateur;

/**
 * Servlet implementation class ServletJSPEnchereFini
 */
@WebServlet("/AjoutEnchere")
public class ServletAjoutEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static EncheresManager manager = new EncheresManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutEnchere() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		try {
			categories = manager.getLesCategories();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("lesCategories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutEnchere.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("snom");
		String photo = "./assets/" + request.getParameter("photo");
		String description = request.getParameter("sdescription");
		int noCategorie = Integer.parseInt(request.getParameter("category"));
		String prix = request.getParameter("sprix");
		String dateDebut =  request.getParameter("sDebut");
		String dateFin =  request.getParameter("sFin");
		String rue = request.getParameter("sRue");
		String ville = request.getParameter("sVille");
		String cp = request.getParameter("sCodePostal");
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutEnchere.jsp");
		
		if(!nom.equals("")) {
		}
		else {
			request.setAttribute("erreur", "Le nom de l'article ne peut être nul.");
			rd.forward(request, response);
		}
		if(!photo.equals("")) {
		}
		else {
			request.setAttribute("erreur", "La photo de l'article ne peut être nulle.");
			rd.forward(request, response);
		}
		if(!description.equals("")) {
		}
		else {
			request.setAttribute("erreur", "Le nom de l'article ne peut être nul.");
			rd.forward(request, response);
		}
		if(prix!="" && Integer.parseInt(prix)>0) {
		}
		else {
			request.setAttribute("erreur", "Le prix de l'article ne peut être nul ou inférieur à zéro.");
			rd.forward(request, response);
		}
		
		Date d = new Date(Calendar.getInstance().getTime().getTime());

		if(dateFin.compareTo(dateDebut)<0)
		{
			request.setAttribute("erreur", "La date de fin doit être postérieure à la date de début.");
			rd.forward(request, response);
		}		
		else if(Date.valueOf(dateDebut).compareTo(d)<=0)
		{
			request.setAttribute("erreur", "La date de début ne peut être passée.");
			rd.forward(request, response);
		}
		else if(Date.valueOf(dateFin).compareTo(d)<=0)
		{
			request.setAttribute("erreur", "La date de fin ne peut être passée.");
			rd.forward(request, response);
		}
		
		if(!rue.equals("")) {
					
		}
		else {
			request.setAttribute("erreur", "La rue de l'adresse de retrait ne peut être nulle.");
			rd.forward(request, response);
		}
		if(!cp.equals("")) {
				
		}
		else {
			request.setAttribute("erreur", "Le code postal de l'adresse de retrait ne peut être nul.");
			rd.forward(request, response);
		}
		if(!ville.equals("")) {
					
		}
		else {
			request.setAttribute("erreur", "La ville de l'adresse de retrait ne peut être nulle.");
			rd.forward(request, response);
		}
		Categorie categorie = new Categorie();
		try {
			categorie = manager.getCategorie(noCategorie);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utilisateur user= (Utilisateur) request.getSession().getAttribute("connectedUser");
		try {
			manager.ajouterArticle(nom, description, categorie, Integer.parseInt(prix), Date.valueOf(dateDebut), Date.valueOf(dateFin), rue, cp, ville, user, photo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Categorie> listCategories = new ArrayList<Categorie>();
		ArrayList<Article> listArticles = new ArrayList<Article>();
		try {
			listCategories = manager.getLesCategories();
			listArticles = manager.getLesArticles();
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setAttribute("lesCategories", listCategories);
		request.setAttribute("lesArticles", listArticles);
		rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		rd.forward(request, response);	
	}

}
