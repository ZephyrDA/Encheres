<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="row">
	<div class="col-lg-6 offset-lg-3 col-xs-12">
		<% Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("connectedUser"); %>
		<form action="<%= request.getContextPath()%>/MonProfil" method="post">
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
			<button type="submit" class=" col-lg-4 btn btn-default">
				<p>Modifier</p>
			</button>
		</form>
	</div>
</div>
</body>
</html>