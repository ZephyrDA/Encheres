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
			erreur = "Erreur - Veuillez renseigner votre pseudo.";
			request.setAttribute("erreur", erreur);
			rd.forward(request, response);
		}	
		if (request.getParameter("mailUtilisateur").trim().isEmpty()) {
			erreur = "Erreur - Veuillez renseigner votre email.";
			request.setAttribute("erreur", erreur);
			rd.forward(request, response);
		}
		String pseudo = request.getParameter("pseudoUtilisateur").trim();
		String mail = request.getParameter("mailUtilisateur").trim();
		int compteur = 0;
		String mdp = null;
		try {
			ArrayList<Utilisateur> listUtilisateur = manager.getLesUtilisateurs();
			for ( Utilisateur unUtilisateur : listUtilisateur) {
				if (unUtilisateur.getPseudo().equals(pseudo) && unUtilisateur.getEmail().equals(mail)) {	
					mdp = unUtilisateur.getMotDePasse();
					compteur = compteur + 1;					
				}
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if (compteur == 1) {
			message = "Votre mot de passe est : " + mdp ;
			request.setAttribute("message", message);
		} else {
			erreur = "L'utilisateur " + pseudo + " ou le mail " + mail + " n'existe pas dans la base.";	
			request.setAttribute("erreur", erreur);
		}
		
		rd.forward(request, response);
	}
}
