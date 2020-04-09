<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="row">
	<div class="col-lg-6 offset-lg-3 col-xs-12">
		<% Utilisateur utilisateur = (Utilisateur)request.getSession().getAttribute("utilisateurConnecte"); %>
		<form action="<%= request.getContextPath()%>/GestionUtilisateurs" method="post">
			<p>
				<strong>Pseudo : <%=utilisateur.getPseudo() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Nom : <%=utilisateur.getNom() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Prénom : <%=utilisateur.getPrenom() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Email : <%=utilisateur.getEmail() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Téléphone : <%=utilisateur.getTelephone() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Rue : <%=utilisateur.getRue() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Code postal : <%=utilisateur.getCodePostal() %></strong>
			</p>
			<br> <br>
			<p>
				<strong>Ville : <%=utilisateur.getVille() %></strong>
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