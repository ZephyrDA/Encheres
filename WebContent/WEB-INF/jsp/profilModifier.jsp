<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container-fluid text-center col-md-8 offset-2 blocProfil mt-5">
	<h3 class="mb-5"><strong>Mon Profil</strong></h3>
	<form action="<%=request.getContextPath()%>/GestionModificationProfil" method="post">
		<div class="col-md-6 offset-3">
			Pseudo :<input type="text" name="spseudo" value="<%=user.getPseudo() %>"  class="form-control input-md">
			<br> 
			Prenom :<input type="text" name="sprenom" value="<%=user.getPrenom()%>"  class="form-control input-md">
			<br>
			Telephone :<input type="text" name="stelephone" value="<%=user.getTelephone()%>"  class="form-control input-md">
			<br> 
			Code postal :<input type="text" name="scodePostal" value="<%=user.getCodePostal()%>"  class="form-control input-md">
			<br>
			Mot de passe actuel :<input type="password" name="smotDePasseActuel" value="${fn:escapeXml(smotDePasseActuel)}" placeholder="Mot de passe actuel" class="form-control input-md">
			<br> 
			Nouveau mot de passe :<input type="password" name="snouveauMotDePasse" value="${fn:escapeXml(snouveauMotDePasse)}" placeholder="Nouveau mot de passe" class="form-control input-md">
			<br>
		</div>
		<div class="col-md-6 offset-3">
			Nom :<input type="text" name="snom" value="<%=user.getNom()%>" class="form-control input-md">
			<br>
			Email :<input type="text" name="semail" value="<%=user.getEmail()%>"  class="form-control input-md">
			<br> 
			Rue :<input type="text" name="srue" value="<%=user.getRue()%>" class="form-control input-md">
			<br>
			Ville :<input type="text" name="sville" value="<%=user.getVille()%>" class="form-control input-md">
			<br> 			
			Credit : <p>  </p>
			<br>
		</div>				
		<div class = "row">
			<div class ="col-md-12">
				<% String erreur = (String) request.getAttribute("erreur");
				   if (erreur != null) {
				%>
				<%=	 erreur %>
				<%
					}
				%>
			</div>
		</div>	
		<button type="submit" class=" col-lg-6 btn btn-default">
			<p>Enregistrer</p>
		</button>
	</form>	
	<form action="<%=request.getContextPath()%>/SuppressionUtilisateur" method="post">
		<button type="submit" class=" col-lg-6 btn btn-default mt-2">
			<p>Supprimer mon compte</p>
		</button>
	</form>	
</div>
<br>
</body>
</html>