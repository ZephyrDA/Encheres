<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<div class="row">
	<form action="<%=request.getContextPath()%>/GestionInscription"
		method="post">
		<div class="row formulaire">
			<h3 class="col-md-12 text-center">Création de mon Profil</h3>
			<br>
		</div>
		<div class="row">
			<div class="col-md-offset-2 col-md-8 col-xs-12 blocProfil">
				<div class="col-md-2 ">
					<p>Pseudo :</p>
					<p>Prenom :</p>
					<p>Telephone :</p>
					<p>Code postal :</p>
					<p>Mot de passe :</p>
				</div>
				<div class="col-md-3 formulaire">
					<input type="text" name="spseudo" value="${fn:escapeXml(spseudo)}"><br>
					<input type="text" name="sprenom" value="${fn:escapeXml(sprenom)}"><br>
					<input type="text" name="stelephone" value="${fn:escapeXml(stelephone)}"><br>
					<input type="text" name="scodePostal" value="${fn:escapeXml(scodePostal)}"><br>
					<input type="password" name="smotDePasse" value="${fn:escapeXml(smotDePasse)}">
				</div>
				<div class="col-md-2">
					<p>Nom :</p>
					<p>Email :</p>
					<p>Rue :</p>
					<p>Ville :</p>
					<p>Confirmation :</p>
				</div>
				<div class="col-md-3 formulaire">
					<input type="text" name="snom" value="${fn:escapeXml(snom)}"><br>
					<input type="text" name="semail" value="${fn:escapeXml(semail)}"><br>
					<input type="text" name="srue" value="${fn:escapeXml(srue)}"><br>
					<input type="text" name="sville" value="${fn:escapeXml(sville)}"><br>
					<input type="password" name="sconfirmation">
				</div>
				<%
					String erreur = (String) request.getAttribute("erreur");
					if (erreur != null) {
				%>
					<p class="red"><%=erreur%></p>
				<%
					}
				%>
				<div class="row"></div>
					<button type="submit" class=" col-md-4 btn btn-default">
						<p>Creer</p>
					</button>
			</div>
		</div>
	</form>
	<form action="<%=request.getContextPath()%>/encheres" method="get">
		<button type="submit" class=" col-md-4 btn btn-default">
			<p>Annuler</p>
		</button>
	</form>
</div>
</body>
</html>