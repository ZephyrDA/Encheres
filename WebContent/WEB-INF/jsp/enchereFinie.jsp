<%@page import="bo.Article"%>
<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="container blocProfil mt-5">
	<h3 class="formulaire text-center mb-5">Détail Vente</h3>	
	<div class="col-lg-8 col-xs-12">		
		<div class="col-lg-6 col-xs-6 offset-6">
			<p><strong>Article : </strong></p>
			<p><strong>Description : </strong></p>
			<p><strong>Meilleure offre : </strong></p>
			<p><strong>Mise à prix : </strong></p>
			<p><strong>Fin de l'enchère : </strong></p>
			<p><strong>Retrait :</strong></p>
			<p><strong>Vendeur :</strong></p>
		</div>
		<div class="col-lg-6 col-xs-6">
			<%
			Article article = (Article) request.getAttribute("articleVendu");				
			%>
			<p><strong><%=Acheteur.getPseudo() %> a remporté l'enchère</strong></p>
			<p><strong><%=article.getNom_article() %></strong></p>
			<p><%=article.getDescription()%></p>
			<p><%=article.getPrix_vente()%> pts par <%= article.getAcheteur().getPseudo() %></p>
			<p><%=article.getPrix_initial() %></p>
			<p><%=article.getDate_fin_encheres() %></p>
			<p><%=Retrait.getRetrait(article.getNo_Article()).getRue() %></p>
			<p><%=article.getVendeur().getPseudo() %></p>
		</div>
		<div class="col-md-12 offset-7">	
			<form action="<%=request.getContextPath()%>/#" method="get">
				<button type="submit" class="col-lg-4 btn btn-default"><p>Retrait effectué</p></button>
			</form>				
		</div>
	</div>
</div>
</body>
</html>