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
import bo.Utilisateur;

/**
 * Servlet implementation class ServletAjoutCredit
 */
@WebServlet("/crediter")
public class ServletAjoutCredit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjoutCredit() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutCredit.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=null;
		String erreur=null;
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/ajoutCredit.jsp");
		
		if (request.getParameter("pseudoUtilisateur").trim().isEmpty()) {
			erreur = "Erreur - Veuillez renseigner un pseudo utilisateur.";
			request.setAttribute("erreur", erreur);
			rd.forward(request, response);
		}
		if (request.getParameter("credit").trim().isEmpty()) {
			erreur = "Erreur - Veuillez renseigner un crédit.";
			request.setAttribute("erreur", erreur);
			rd.forward(request, response);
		}		 
		String pseudo = request.getParameter("pseudoUtilisateur").trim();			
		int credit = Integer.parseInt(request.getParameter("credit").trim());
		int compteur = 0;
		try {
			ArrayList<Utilisateur> listUtilisateur = manager.getLesUtilisateurs();
			for ( Utilisateur unUtilisateur : listUtilisateur) {
				if (unUtilisateur.getPseudo().equals(pseudo)) {					
					unUtilisateur.setCredit(unUtilisateur.getCredit()+credit);
					manager.modifierUtilisateur(unUtilisateur);
					compteur = compteur + 1;					
				}
			}			
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (compteur == 1) {
			message = "L'utilisateur " + pseudo + " à bien été créditer de " + credit + " crédits.";
			request.setAttribute("message", message);
		} else {
			erreur = "L'utilisateur " + pseudo + " n'existe pas dans la base.";
			request.setAttribute("erreur", erreur);
		}		
		rd.forward(request, response);
	}
}
