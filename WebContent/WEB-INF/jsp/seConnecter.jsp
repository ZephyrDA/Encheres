<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container-fluid text-center col-md-12 offset-2 mt-5">
	<div class="blocProfil col-lg-6 col-lg-offset-3 col-xs-12">
		<%String erreur = (String) request.getAttribute("erreur");
		if (erreur != null) {
		%>
			<p class="red"><%=erreur%></p>
		<%
		}
		%>
		<form action="<%=request.getContextPath()%>/Connexion" method="post">
			<p>
				<strong>identifiant :</strong>
			</p>
			<input type="text" id="identifiant" name="identifiant" size="80" value=""><br> <br>
			<p>
				<strong>Mot de passe :</strong>
			</p>
			<input type="password" id="mdp" name="mdp" size="80"	value=""><br> <br>
			<button type="submit" class=" col-lg-4 btn btn-default">
				<p>Connexion</p>
			</button>			
		</form>
		<!--  <form action="LireCookie" method="post">
			<label for="souvenir">Se souvenir de moi</label>
        	<input type="checkbox" id="souvenir" name="souvenir" />
		</form>		-->		
		<a href="motDePasseOublie">Mot de passe oublié</a>
		<br>
		<br>
		<button type="submit" class="col-lg-11 btn btn-default">
			<p>Créer un compte</p>
		</button>		
	</div>
</div>
</body>
</html>
