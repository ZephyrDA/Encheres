<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="container-fluid text-center col-md-10 offset-2 mt-5">	
	<div class="col-lg-offset-3 col-lg-6 col-xs-12 blocProfil">
		<h3>Profil Utilisateur</h3>
		<br><br>
		<div class="col-lg-6 col-xs-6">
			<p><strong>Pseudo : </strong></p>
			<p><strong>Nom : </strong></p>
			<p><strong>Prénom : </strong></p>
			<p><strong>Email : </strong></p>
			<p><strong>Téléphone : </strong></p>
			<p><strong>Rue : </strong></p>
			<p><strong>Code postal :</strong></p>
			<p><strong>Ville :</strong></p>
		</div>
		<div class="col-lg-6 col-xs-6 text-center">
			<% Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>
			<p><strong><%=utilisateur.getPseudo()%></strong></p>
			<p><%=utilisateur.getNom()%></p>
			<p><%=utilisateur.getPrenom()%></p>
			<p><%=utilisateur.getEmail()%></p>
			<p><%=utilisateur.getTelephone()%></p>
			<p><%=utilisateur.getRue()%></p>
			<p><%=utilisateur.getCodePostal()%></p>
			<p><%=utilisateur.getVille()%></p>
		</div>	 		
		<form action="<%=request.getContextPath()%>/GestionModificationProfil" method="get" >
			<input type="submit" class="bouton btn btn-default" value="Modifier" name="Modifier"> 
		</form>
		<c:if test="${!empty sessionScope.connectedUser}">
        	<c:if test="${sessionScope.connectedUser.getAdministrateur() == true}">
				<form action="<%=request.getContextPath()%>/GestionSupprimerProfil" method="get" >
					<input type="submit" class="bouton btn btn-default" value="Supprimer" name="Supprimer"> 
				</form>
			</c:if>
		</c:if> 
	</div>
</div>
</body>
</html>