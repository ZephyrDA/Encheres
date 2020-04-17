<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="col-md-10 formulaire">
	<h3 class="text-center mb-5 mt-5">Récupération du mot de passe</h3>
	<form action="<%=request.getContextPath()%>/motDePasseOublie" method="post">
		<div class="blocProfil mt-5">			
			<div class="col-lg-12 offset-4">
				<p class="col-lg-2">Votre Pseudo :</p>
				<input type="text" name="pseudoUtilisateur" placeholder="Saisir votre pseudo" class="col-lg-3"><br>
			</div>
			<div class="col-lg-12 offset-4">
				<p class="col-lg-2">Votre Email :</p>
				<input type="text" name="mailUtilisateur" placeholder="Saisir votre email" class="col-lg-3"><br>
			</div>
			<div class="col-lg-12 offset-4">		
				<button type="submit" class="bouton btn btn-default">
					Valider
				</button>
			</div>
		</div>		
	</form>	
	<%
		String erreur = (String)request.getAttribute("erreur");
		if (erreur != null) {
	%>
			<p class="erreur text-center"><strong><%=erreur%></strong></p>
	<%
		}
	%>
	<%
		String message = (String)request.getAttribute("message");
		if (message != null) {
	%>
			<p class="text-center"><Strong><%= message %></Strong></p>
	<%
		}
	%>
</div>
</body>
</html>