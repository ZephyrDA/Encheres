<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<meta charset="UTF-8">
<title>Enchères</title>
</head>
<body>




<div class="font-weight-bold display-5" style="text-align-last: center;font-size: xx-large;">Liste des enchères</div>

<h5 class="font-weight-bold mt-5 ml-2">Filtres : </h5>

<form class="form-inline d-flex justify-content-left w-25  md-form form-sm mt-3 ml-4">
  <i class="fas fa-search" aria-hidden="true"></i>
  <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search"
    aria-label="Search">
</form>

<div class="d-flex mt-4 align-items-center font-weight-bold">
	<label style="margin-left: auto;margin-right: auto;">Catégories : 
		<select name="category" class="dropdown btn btn-secondary" >
		    <option value="category_id">Informatique</option>
		    <option value="category_id">Ameublement</option>
		    <option value="category_id">Vêtements</option>
		    <option value="category_id">Sport et Loisirs</option>
		</select>
	</label>
	<input type="button" class="btn btn-primary "  style="margin-left: auto;margin-right: auto;" value="Rechercher">
</div>
<div class="d-flex mt-5" >
<div class="p-2 bg-primary ml-2 text-white" style="width: 35%;height: 100%">
	<img src="../jsp/assets/pc.jpg" class="height: 100%">
	<div class="float-right">
	<div >Titre produit</div>
	<div>Prix : 100 points</div>
	<div>Fin de l'enchère : date</div>
	<div>Vendeur : Nom Vendeur</div>
	</div>
</div>
<div class="p-2 bg-dark text-white float-right mr-2" style="width: 35%;height: 100%;margin-left: auto;">
	<div class="height: 100%">Image</div>
	<div class="float-right">
	<div >Titre produit</div>
	<div>Prix : 100 points</div>
	<div>Fin de l'enchère : date</div>
	<div>Vendeur : Nom Vendeur</div>
	</div>
</div></div>
</body>
</html>