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
@WebServlet("/motDePasseOublie")
public class ServletMotDePasseOublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletMotDePasseOublie() {
        super();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/motDePasseOublie.jsp");
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message=null;
		String erreur=null;
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/motDePasseOublie.jsp");
		
		if (request.getParameter("pseudoUtilisateur").trim().isEmpty()) {
			erreur = "Erreur - Veuillez renseigner un pseudo uilisateur.";
			request.setAttribute("erreur", erreur);
			rd.forward(request, response);
		}				 
		String pseudo = request.getParameter("pseudoUtilisateur").trim();			
		int compteur = 0;
		String mdp = null;
		try {
			ArrayList<Utilisateur> listUtilisateur = manager.getLesUtilisateurs();
			for ( Utilisateur unUtilisateur : listUtilisateur) {
				if (unUtilisateur.getPseudo().equals(pseudo)) {	
					mdp = unUtilisateur.getMotDePasse();
					compteur = compteur + 1;					
				}
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (compteur == 1) {
			message = "Votre mot de passe est : " + mdp ;			
		} else {
			message = "L'utilisateur " + pseudo + " n'existe pas dans la base.";			
		}
		request.setAttribute("message", message);
		rd.forward(request, response);
	}
}
