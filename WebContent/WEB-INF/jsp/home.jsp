<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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


<h2>ENI-Encheres <a style="cursor:pointer; font-size: large;" class="float-right text-primary pointeur">Se connecter/S'inscrire</a></h2> 

<div class="font-weight-bold display-5" style="text-align-last: center;font-size: xx-large;">Liste des enchères</div>

<h5 class="font-weight-bold mt-5 ml-2">Filtres : </h5>

<form class="form-inline d-flex justify-content-left w-25  md-form form-sm mt-3 ml-4">
  <i class="fas fa-search" aria-hidden="true"></i>
  <input class="form-control form-control-sm ml-3 w-75" type="text" placeholder="Search"
    aria-label="Search">
</form>


<div class="btn-group">
  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Action
  </button>
  <div class="dropdown-menu">
    <a class="dropdown-item" href="#">Toutes</a>
  </div>
</div>
</body>
</html>