<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@taglib prefix="div" uri="http://java.sun.com/jsp/jstl/core"%>


<%@page import="bo.*"%>
<%@page import="java.util.ArrayList"%>

<div class="font-weight-bold display-5" style="text-align-last: center;font-size: xx-large;">Liste des enchères</div>

<h5 class="font-weight-bold mt-5 ml-2">Filtres : </h5>

<form action="<%=request.getContextPath()%>/categories" method="post" class="form-inline d-flex justify-content-left w-25  md-form form-sm mt-3 ml-4">
  <i class="fas fa-search" aria-hidden="true"></i>
  <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search" name="filtres" value="${fn:escapeXml(filtres)}"
    aria-label="Search">
</form>

<div class="d-flex mt-4 align-items-center font-weight-bold">
<form action="" method="post">
	<label style="margin-left: auto;margin-right: auto;">Catégories : 
		<select name="category" class="dropdown btn btn-secondary" >
		<option value="0">toutes</option>
		<%	
			ArrayList<Categorie> lesCat = (ArrayList<Categorie>) request.getAttribute("lesCategories");
			for(Categorie cat : lesCat){
		%>		<option value="<% out.print(cat.getNo_categorie()); %>"><%out.print(cat.getLibelle());%></option>	
		<%	}%>	  

		</select>
	</label>
	<input type="submit" class="btn btn-primary "  style="margin-left: auto;margin-right: auto;" value="Rechercher">
</form>	
</div>

<div class="d-flex mt-5" >
		<%	
			ArrayList<Article> lesArts = (ArrayList<Article>) request.getAttribute("lesArticles");
			for(Article art : lesArts){
				%>
	
		<div class="p-2 bg-primary ml-2 text-white" style="width: 30%;height: 100%" >
			<form method="post"  action="<%=request.getContextPath()%>/ServletDetailProduit">
				<img src="./assets/pc.jpg"  alt="pc">
				<div class="float-right">
					<input type="hidden" id="idArticle" name="idArticle"  value="<%= art.getNo_article()%>">
					<a class="text-white"><%out.print(art.getNom_article());%></a>
					<div><%out.print(art.getPrix_initial());%> credits</div>
					<div><%out.print("du " + art.getDate_debut_encheres()+" au "+art.getDate_fin_encheres());%></div>
					<div>Vendeur : <%out.print(art.getVendeur().getPseudo());%></div>
					<input type="submit" class="btn btn-primary "  style="margin-left: auto;margin-right: auto;" value="Afficher">
				</div>
			</form>
		</div>
	
			<%		
			}
			%>
</div>
</body>
</html>