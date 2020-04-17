package servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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

    private String dateFormat;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletHome() {
        super();
        this.dateFormat = ("yyyy-MM-dd");
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");

		EncheresManager EM = new EncheresManager();
		try {
			ArrayList<Article> listArticles = EM.getLesArticles();
			Date d = new Date(Calendar.getInstance().getTime().getTime());
			boolean dateFinOk= false;

			for(Article unArticle : listArticles) {
				//Si la date de fin est passée
				if(unArticle.getDate_fin_encheres().compareTo(d)<0)
				{
					dateFinOk=true;
				}
				if(unArticle.getPrix_vente()==-1 && dateFinOk==true) {
					ArrayList<Enchere> encheres = EM.getEncheresByArticle(unArticle.getNo_article());
					if(encheres.size()>0) {
					unArticle.setPrix_vente(encheres.get(0).getMontantEnchere());
					EM.modifierArticle(unArticle);					
					Utilisateur user = EM.getLesEncheres().get(0).getUtilisateur();
					user.setCredit(user.getCredit()-(encheres.get(0).getMontantEnchere()));
					EM.modifierUtilisateur(user);
					}
				}
			}
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
		// Set standard HTTP/1.1 no-cache headers.
		response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

		// Set standard HTTP/1.0 no-cache header.
		response.setHeader("Pragma", "no-cache");
		int idCategorie = Integer.parseInt(request.getParameter("category"));
		try {
			EncheresManager encheresManager = new EncheresManager();
			ArrayList<Article> lesArticlesFiltre = (idCategorie != 0) ? encheresManager.getLesArticlesByCategorie(idCategorie) : encheresManager.getLesArticles();
			Date d = new Date(Calendar.getInstance().getTime().getTime());
			boolean dateFinOk= false;

			for(Article unArticle : lesArticlesFiltre) {
				//Si la date de fin est passée
				if(unArticle.getDate_fin_encheres().compareTo(d)<0)
				{
					dateFinOk=true;
				}
				if(unArticle.getPrix_vente()==-1 && dateFinOk==true) {
					ArrayList<Enchere> encheres = encheresManager.getEncheresByArticle(unArticle.getNo_article());
					if(encheres.size()>0) {
					unArticle.setPrix_vente(encheres.get(0).getMontantEnchere());
					encheresManager.modifierArticle(unArticle);					
					Utilisateur user = encheresManager.getLesEncheres().get(0).getUtilisateur();
					user.setCredit(user.getCredit()-(encheres.get(0).getMontantEnchere()));
					encheresManager.modifierUtilisateur(user);
					}
				}
			}
			ArrayList<Categorie> listCategories = encheresManager.getLesCategories();
			String filtres = ((String)request.getParameter("filtres") == null) ? "" : (String)request.getParameter("filtres") ;

			ArrayList<Article> lesArticles = new ArrayList<Article>();
			if(filtres.trim() != "") {
				String[] lesMotsCles = filtres.split(" ");
				for(Article a : lesArticlesFiltre) {
					Boolean addArticle = false;
					for(String mot : lesMotsCles) {
						if(isValid(mot)) {
							String[] dateStr = mot.split("-");
							int y = Integer.parseInt(dateStr[0]);
							int m = Integer.parseInt(dateStr[1]);
							int d = Integer.parseInt(dateStr[2]);
							if(CompareDate(a.getDate_debut_encheres(), y , m, d) || CompareDate(a.getDate_fin_encheres(),y,m,d)) {
								addArticle = true;
							}
						}else if(mot.equals(a.getCategorie().getLibelle()) || mot.equals(a.getVendeur().getPseudo())){
							addArticle = true;
						}else{
							String[] description = a.getDescription().split(" ");
							String[] nomArticle = a.getNom_article().split(" ");
							for(String motDesc : description) {
								if(motDesc.length() > 2 && motDesc.equals(mot)) {
									addArticle = true;
								}
							}
							for(String motNom : nomArticle) {
								if(mot.equals(motNom)) {
									addArticle = true;
								}
							}
						}
					}
					if(addArticle == true) {
						if(!lesArticles.contains(a)) {
							lesArticles.add(a);
						}
					}
				}
			}else {
				lesArticles = lesArticlesFiltre;
			}

			request.setAttribute("lesCategories", listCategories);
			request.setAttribute("lesArticles", lesArticles);
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
	}


    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private boolean CompareDate(Date date, int y, int m, int d) {
    	boolean ret = false;
    	String dateStr = date.toString();
    	int y1 = Integer.parseInt(dateStr.split("-")[0]);
    	int m1 = Integer.parseInt(dateStr.split("-")[1]);
    	int d1 = Integer.parseInt(dateStr.split("-")[2]);
    	if(y == y1 && m == m1 && d == d1) {
    		ret = true;
    	}
    	return ret;

    }


}
