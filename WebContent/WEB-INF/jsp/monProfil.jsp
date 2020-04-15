<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<% Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("connectedUser"); %>
<div class="container-fluid text-center col-md-10 offset-2">			
 	<div class="formulaire">  		
 			<div class=" row col-md-offset-2 col-md-9 col-xs-12 blocProfil mt-5"> 
 				<h3 class="col-md-12">Mon Profil</h3><br>	
 				<div class="col-md-2 text-right "> 
 					<p>Pseudo :</p> 
					<p>Prenom :</p> 
					<p>Telephone :</p> 
					<p>Code postal :</p>  
 				</div> 
 				<div class="col-md-3 formulaire"> 
					<p><% out.print(utilisateur.getPseudo()); %></p> 
					<p><% out.print(utilisateur.getPrenom()); %></p> 
					<p><% out.print(utilisateur.getTelephone()); %></p> 
					<p><% out.print(utilisateur.getCodePostal()); %></p> 
 				</div> 
 				<div class="col-md-2 text-right"> 
 					<p>Nom :</p> 
 					<p>Email :</p> 
 					<p>Rue :</p> 
 					<p>Ville :</p> 
 				</div> 
 				<div class="col-md-3 formulaire">
 					<p><% out.print(utilisateur.getNom()); %></p> 
					<p><% out.print(utilisateur.getEmail()); %></p> 
					<p><% out.print(utilisateur.getRue()); %></p> 
					<p><% out.print(utilisateur.getVille()); %></p> 
 				</div> 
 				<%
 					String erreur = (String) request.getAttribute("erreur");
 					if (erreur != null) { 
 				%> 
 						<p class="erreur"><%=erreur%></p> 
 				<% 
 					}
 				%> 
 			</div>  			 			
			  	
 		<div style="margin-right: 25%;"> 
	 		<a class="nav-link" href="<%=request.getContextPath()%>/ModifierProfil"><button class="bouton col-md-3 btn btn-default"> Modifier</button><span class="sr-only">(current)</span></a>			
		</div>
 	</div> 						
</div>
</body>
</html>