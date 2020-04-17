<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<%@ include file="../header/header.jspf"%>

<div class="row" style="margin-top:15%;">
	<div class="col-lg-6 offset-lg-3 col-xs-12  border border-primary p-2" >
		<form action="<%= request.getContextPath()%>/categories" method="post" style="margin-left: 35%;">
<div class="d-flex mt-4 align-items-center font-weight-bold">

	<label style="margin-left: auto;margin-right: auto;">Catégories : 
		<select name="category" class="dropdown btn btn-secondary" >
		<option value="0">toutes</option>

		</select>
	</label>
	<input type="submit" class="btn btn-primary "  style="margin-left: auto;margin-right: auto;" value="Rechercher">
</div>
	<br>
	<span> Prix : <br>
		<input type="number" value="prix">
	</span>
	<br>
	<span > Nom de l'article : <br>
		<input type="number" value="prix">
	</span>
	<br>
	<span> Descriptif : 
	<br>
		<textarea style="resize: none" id="desc" rows="4" cols="50"></textarea>
	</span>
	<br>
	<span> Fin de l'enchère : <br>
		<input type="date" value="date">
	</span>
	<br>
	<input type="submit" class="btn btn-primary mt-2" style="margin-left:20%" value="Valider">
	</form>
		</div>
	</div>

