<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="font-weight-bold display-5" style="text-align-last: center;font-size: xx-large;">Liste des enchères</div>

<h5 class="font-weight-bold mt-5 ml-2">Filtres : </h5>

<form action="<%=request.getContextPath()%>/categories" method="post" class="form-inline d-flex justify-content-left w-25  md-form form-sm mt-3 ml-4">
  <i class="fas fa-search" aria-hidden="true"></i>
  <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search" name="filtres" value="${fn:escapeXml(filtres)}"
    aria-label="Search">
</form>

<div class="d-flex mt-4 align-items-center font-weight-bold">
<form action="<%=request.getContextPath()%>/categories" method="post">
	<label style="margin-left: auto;margin-right: auto;">Catégories : 
		<select name="category" class="dropdown btn btn-secondary" >
		    <option name="catInfo" value="${fn:escapeXml(catInformatique)}">Informatique</option>
		    <option name="catAmeublement" value="${fn:escapeXml(catAmeublement)}">Ameublement</option>
		    <option name="catVetement" value="${fn:escapeXml(catVetement)}">Vêtements</option>
		    <option name="cartSportLoisir" value="${fn:escapeXml(catSportLoisir)}">Sport et Loisirs</option>
		</select>
	</label>
	</form>
	<input type="button" class="btn btn-primary "  style="margin-left: auto;margin-right: auto;" value="Rechercher">
</div>
<div class="d-flex mt-5" >
<div class="p-2 bg-primary ml-2 text-white" style="width: 30%;height: 100%">
	<img src="./assets/pc.jpg"  alt="pc">
	<div class="float-right">
	<div >Titre produit</div>
	<div>Prix : 100 points</div>
	<div>Fin de l'enchère : date</div>
	<div>Vendeur : Nom Vendeur</div>
	</div>
</div>
<div class="p-2 bg-dark text-white float-right mr-2" style="width: 30%;height: 100%;margin-left: auto;">
	<div class="height: 100%">Image</div>
	<div class="float-right">
	<div>Titre produit</div>
	<div>Prix : 100 points</div>
	<div>Fin de l'enchère : date</div>
	<div>Vendeur : Nom Vendeur</div>
	</div>
</div></div>

<form method="post" class="d-flex mt-4 align-items-center font-weight-bold">
	<input class="btn btn-primary" value="Saisie" name="choixUtilisateur" type="submit"/>					
	<input class="btn btn-primary"  value="Historique" name="choixUtilisateur" type="submit"/>
</form><
</body>
</html>