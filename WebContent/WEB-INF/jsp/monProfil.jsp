<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="container blocProfil mt-5">
	<h3 class=" formulaire text-center mb-5">Mon Profil</h3>	
		<% Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("connectedUser"); %>
		<form class="" action="<%= request.getContextPath()%>/MonProfil" method="post">
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
			<br> <br>
			 <a class="btn btn-primary ml-5" href="ModifierProfil">Modifier</a>
			  
		</form>
	</div>
</body>
</html>