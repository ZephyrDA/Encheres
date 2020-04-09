package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BusinessException;
import bll.EncheresManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletInscription
 */
@WebServlet("/GestionInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static EncheresManager manager = new EncheresManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String pseudo = (String) request.getAttribute("pseudoInscription");
		String nom = (String) request.getAttribute("nomInscription");
		String prenom = (String) request.getAttribute("prenomInscription");
		String email = (String) request.getAttribute("emailInscription");
		String telephone = (String) request.getAttribute("telephoneInscription");
		String rue = (String) request.getAttribute("rueInscription");
		String codePostal = (String) request.getAttribute("codePostalInscription");
		String ville = (String) request.getAttribute("villeInscription");
		String motDePasse = (String) request.getAttribute("motDePasseInscription");
		String motDePasse2 = (String) request.getAttribute("confirmationInscription");
		boolean administrateur = false;
		
		try {
			Utilisateur user = manager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, motDePasse2, administrateur);
			session.setAttribute("connectedUser", user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		rd.forward(request, response);
	}

}
