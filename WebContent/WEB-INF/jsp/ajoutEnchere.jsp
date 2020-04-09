<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    
<%@ include file="../header/header.jspf"%>
<div class="row" style="margin-top:20%;">
	<div class="col-lg-6 offset-lg-3 col-xs-12  border border-primary p-2" >
		<form action="<%= request.getContextPath()%>/NouvelleEnchere" method="post" style="margin-left: 25%;">
	<label >Catégories : 
		<select name="category" class="dropdown btn btn-secondary" >
		    <option name="catInfo" value="${fn:escapeXml(catInformatique)}">Informatique</option>
		    <option name="catAmeublement" value="${fn:escapeXml(catAmeublement)}">Ameublement</option>
		    <option name="catVetement" value="${fn:escapeXml(catVetement)}">Vêtements</option>
		    <option name="cartSportLoisir" value="${fn:escapeXml(catSportLoisir)}">Sport et Loisirs</option>
		</select>
	</label>
	<br>
	<label> Prix : 
		<input type="number" value="prix">
	</label>
	<br>
	<label for="desc"> Nom de l'article : 
		<input type="number" value="prix">
	</label>
	<br>
	<label> Descriptif : </label>
	<br>
		<textarea style="resize: none" id="desc" rows="4" cols="50"></textarea>
	
	<br>
	<label> Fin de l'enchère : 
		<input type="date" value="date">
	</label>
	<br>
	<input type="submit" class="btn btn-primary" style="margin-left:20%" value="Valider">
		</form>
	</div>
</div>
</body>
</html>