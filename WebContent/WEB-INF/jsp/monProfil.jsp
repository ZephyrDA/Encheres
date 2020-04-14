<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="container blocProfil mt-5">
	<h3 class="formulaire text-center mb-5">Mon Profil</h3>	
	<div class="col-lg-6 offset-lg-3 col-xs-12">
		<% Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("connectedUser"); %>
		<form class="col-md-12 offset-3"action="<%= request.getContextPath()%>/MonProfil" method="post">
			<p>
				<strong>Pseudo : <% out.print(utilisateur.getPseudo()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Nom :<% out.print(utilisateur.getNom()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Prénom : <% out.print(utilisateur.getPrenom()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Email : <% out.print(utilisateur.getEmail()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Téléphone : <% out.print(utilisateur.getTelephone()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Rue : <% out.print(utilisateur.getRue()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Code postal : <% out.print(utilisateur.getCodePostal()); %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Ville : <% out.print(utilisateur.getVille()); %></strong>
			</p>
			<br> <br>
			  <a class="btn btn-primary ml-5" href="ModifierProfil">Modifier</a>
		</form>
	</div>
</div>
</body>
</html>