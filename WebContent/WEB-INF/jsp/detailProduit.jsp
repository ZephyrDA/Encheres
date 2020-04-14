<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<%@ include file="../header/header.jspf"%>
<%@page import="bo.Article"%>
<%@page import="bo.Enchere"%>
<%@page import="java.util.ArrayList"%>


<div class="row" style="margin-top:15%;">
	<div class="col-lg-6 offset-lg-3 col-xs-12  border border-primary p-2" >
		<form action="<%= request.getContextPath()%>/ModifierArticle" method="post" style="margin-left: 35%;">
		<% 
			Article article = (Article) request.getAttribute("article");
			ArrayList<Enchere> encheres = article.getEncheres();
		%>
			<span style="margin-left: auto;margin-right: auto;" id="usernameVendeur">Nom du vendeur : <br>
			<input type="text" value=<%=user.getPseudo() %>>
			</span>
			<span style="margin-left: auto;margin-right: auto;">Catégorie du produit : <br>		
				<%= article.getCategorie().getLibelle() %>
			</span>
			<br>
			<span>  Nom de l'article : <br>
				<input type="text" value="<%=article.getNom_article() %>" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
			</span>
			<br>
			<span > Prix du produit : <br>
				<input type="text" value="<%=article.getPrix_initial() %>" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
			</span>
			<br>
			<span> Descriptif : 
			<br>
				<textarea style="resize: none" id="desc" rows="4" cols="50" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
					<%=article.getDescription() %>
				</textarea>
			</span>
			<br>
			<span> Début de l'enchère : <br>
				<input type="date" value="<%=article.getDate_debut_encheres() %>" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
			</span>
			<br>
			<span> Fin de l'enchère : <br>
				<input type="date" value="<%=article.getDate_fin_encheres() %>" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
			</span>
			<br>
			<c:if test="${!empty sessionScope.connectedUser && sessionScope.connectedUser.getNoUtilisateur().equals(article.getVendeur().getNoUtilisateur())}">
		      	<button type="submit" class="btn btn-primary mt-2" style="margin-left:20%" value="Valider"> Modifier </button>
  			</c:if>
			
		</form>
	</div>
</div>

