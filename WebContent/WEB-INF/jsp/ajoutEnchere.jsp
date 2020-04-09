<%@page import="bo.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<%@ include file="../header/header.jspf"%>
<div class="row">
	<div class="col-lg-6 offset-lg-3 col-xs-12">
		<% Article newProduit = (Article).getEncheres.add().getAttribute("addProduct"); %>
		<form action="<%= request.getContextPath()%>/NouvelleEnchere" method="post">
	<label style="margin-left: auto;margin-right: auto;">Catégories : 
		<select name="category" class="dropdown btn btn-secondary" >
		    <option name="catInfo" value="${fn:escapeXml(catInformatique)}">Informatique</option>
		    <option name="catAmeublement" value="${fn:escapeXml(catAmeublement)}">Ameublement</option>
		    <option name="catVetement" value="${fn:escapeXml(catVetement)}">Vêtements</option>
		    <option name="cartSportLoisir" value="${fn:escapeXml(catSportLoisir)}">Sport et Loisirs</option>
		</select>
	</label>
	<input type="number">

			<button type="submit" class=" col-lg-4 btn btn-default">
				<p>Modifier</p>
			</button>
		</form>
	</div>
</div>
</body>
</html>