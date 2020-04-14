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
 * Servlet implementation class ServletJSPEnchereFini
 */
@WebServlet("/ModifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static EncheresManager manager = new EncheresManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletModifierProfil() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profilModifier.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur user = (Utilisateur) session.getAttribute("connectedUser");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/profilModifier.jsp");
		
		if(!request.getParameter("spseudo").equals("")) {
			if(!user.getPseudo().contentEquals(request.getParameter("spseudo"))) {
				user.setPseudo(request.getParameter("spseudo"));				
			}
		}
		else {
			request.setAttribute("erreur", "Le pseudo ne peut être nul.");
			rd.forward(request, response);
		}
		if(!request.getParameter("snom").equals("")) {
			if(!user.getNom().contentEquals(request.getParameter("snom"))) {
				user.setNom(request.getParameter("snom"));					
			}
		}
		else {
			request.setAttribute("erreur", "Le nom ne peut être nul.");
			rd.forward(request, response);
		}
		if(!request.getParameter("sprenom").equals("")) {
			if(!user.getPrenom().contentEquals(request.getParameter("sprenom"))) {
				user.setPrenom(request.getParameter("sprenom"));
			}
		}
		else {
			request.setAttribute("erreur", "Le prenom ne peut être nul.");
			rd.forward(request, response);
		}
		if(!request.getParameter("semail").equals("")) {
			if(!user.getEmail().contentEquals(request.getParameter("semail"))) {
				user.setEmail(request.getParameter("semail"));
			}
		}
		else {
			request.setAttribute("erreur", "L'email ne peut être nul.");
			rd.forward(request, response);
		}
		if(!request.getParameter("stelephone").equals("")) {
			if(!user.getTelephone().contentEquals(request.getParameter("stelephone"))) {
				user.setTelephone(request.getParameter("stelephone"));
			}
		}
		else {
			request.setAttribute("erreur", "Le numéro de téléphone ne peut être nul.");
			rd.forward(request, response);
		}	
		if(!request.getParameter("srue").equals("")) {	
			if(!user.getRue().contentEquals(request.getParameter("srue"))) {
				user.setRue(request.getParameter("srue"));
			}
		}
		else {
			request.setAttribute("erreur", "La rue ne peut être nulle.");
			rd.forward(request, response);
		}	
		if(!request.getParameter("scodePostal").equals("")) {	
			if(!user.getCodePostal().contentEquals(request.getParameter("scodePostal"))) {
				user.setCodePostal(request.getParameter("scodePostal"));
			}
		}
		else {
			request.setAttribute("erreur", "Le code postal ne peut être nul.");
			rd.forward(request, response);
		}
		if(!request.getParameter("sville").equals("")) {		
			if(!user.getVille().contentEquals(request.getParameter("sville"))) {
				user.setVille(request.getParameter("sville"));
			}
		}
		else {
			request.setAttribute("erreur", "Le ville ne peut être nulle.");
			rd.forward(request, response);
		}	
	
		String motDePasseActuel = (String) request.getParameter("smotDePasseActuel");
		String motDePasseNouveau = (String) request.getParameter("snouveauMotDePasse");
		
		if(!motDePasseActuel.equals("") && !motDePasseNouveau.equals("")) {
			if(user.getMotDePasse().equals(motDePasseActuel)) {
			user.setMotDePasse(motDePasseNouveau);		
			}
			else {
				request.setAttribute("erreur", "Le mot de passe est incorrect.");				
				rd.forward(request, response);
			}
		}
		
		
			
		
		
		try {
			manager.modifierUtilisateur(user);
			session.setAttribute("connectedUser", user);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		rd = request.getRequestDispatcher("/WEB-INF/jsp/monProfil.jsp");
		rd.forward(request, response);
		
	}

}

