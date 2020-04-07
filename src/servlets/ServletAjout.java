package fr.eni.suivirepas.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.suivirepas.BusinessException;
import fr.eni.suivirepas.bll.RepasManager;
import fr.eni.suivirepas.bo.Aliments;
import fr.eni.suivirepas.bo.Repas;

/**
 * Servlet implementation class ServletRepas
 */
@WebServlet("/ajout")
public class ServletAjout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAjout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String action = request.getParameter("Action");		
		if(action.equals("Retour")) {
			response.sendRedirect("/TPSuiviDesRepas");
			//this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}else {
			String pdate=request.getParameter("txtDate");
			java.util.Date udate=null;
			try {
				udate = new SimpleDateFormat("dd/MM/yyyy").parse(pdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date date = new java.sql.Date(udate.getTime()); 			
			String pheure=request.getParameter("txtHeure");
			if(pheure.split(":").length < 3) {
				pheure+=":00";			
			}
			java.sql.Time heure = java.sql.Time.valueOf(pheure);		
	
			String paliments=request.getParameter("txtAliments");
			
			EncheresManager repasManager = new EncheresManager();
			Categorie repas=null;
			try {
				 repas=repasManager.ajouterRepas(date, heure);
			}
			catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String[] taliments=paliments.split(",");
			for(int i=0;i<taliments.length;i++) {
				try {
					repasManager.ajouterAliment(taliments[i], repas.getIdentifiant());
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			//Recuperation Repas MAJ
			try {
				ArrayList<Categorie> lesRepas = repasManager.getLesRepas();
				request.setAttribute("lesRepas", lesRepas);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			this.getServletContext().getRequestDispatcher("/WEB-INF/Visu.jsp").forward(request, response);
		}
		
	}

}

