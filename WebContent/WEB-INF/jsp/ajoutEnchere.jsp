<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="bo.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Calendar"%>
<% 
		

		%>
<div class="container-fluid text-center col-md-12 justify-content-center">			
 	<div class="formulaire">  		
 		<form action="<%=request.getContextPath()%>/AjoutEnchere" style="text-align: -webkit-center;"	method="post">  			
 			<div class=" row  col-md-9 col-xs-10 blocProfil mt-5"> 
 				<h3 class="col-md-12">Détail de l'article</h3><br>	 				
 				<!--  <div class="p-2 bg-primary ml-2 text-white" style="width: 30%;height: 100%;margin-left:50px;margin-right:auto;" >
 					<img src="./assets/pc.jpg"  alt="pc">
 				</div>-->
 				<div class="col-md-2 text-right "> 
 					<p>Nom de l'article :</p> 
 					<P>Photo : </P> 
 					<p>Descriptif :</p> 
 					
 				</div> 
 				<div class="col-md-4 formulaire">				
				    
					<input type="text" name="snom" value=""> 
					<br>						
					<input type="file" id="photo" name="photo"  accept="image/png, image/jpeg">	
					<br>
					<textarea name="sdescription" style="resize: none" id="desc" rows="3" cols="22.9"></textarea>
					<br>				 
 				</div> 
 				<div class="col-md-2 text-right"> 
 					<p>Catégorie du produit :</p> 
 					<p>Prix initial :</p> 
 					<p>Début de l'enchère :</p> 
 					<p>Fin de l'enchère :</p> 
 				</div> 
 				<div class="col-md-4 formulaire">
 					<select name="category" class="dropdown col-md-4" >
					<%	
						ArrayList<Categorie> lesCat = (ArrayList<Categorie>) request.getAttribute("lesCategories");
						for(Categorie cat : lesCat){
					%>		<option value="<% out.print(cat.getNo_categorie()); %>"><%out.print(cat.getLibelle());%></option>	
					<%	}%>	  
			
					</select>
					 <br>
					 <br>
 					<input type="text" name="sprix" value="">
					<br> 
					<input name="sDebut" type="date" value="" >
					<br>
					<input name="sFin" type="date" value="">				    
 					
 				</div> 
 				
 			 
 			<br>			 			
		      	
  			</div> 	
  			<div class=" row  col-md-9 col-xs-10 blocProfil mt-5"> 
 				<h3 class="col-md-12">Détail du retrait</h3><br>	 				
 				<!--  <div class="p-2 bg-primary ml-2 text-white" style="width: 30%;height: 100%;margin-left:50px;margin-right:auto;" >
 					<img src="./assets/pc.jpg"  alt="pc">
 				</div>-->
 				<div class="col-md-2 text-right "> 
 					<p>Rue :</p> 
 					<p>Ville :</p> 
 				</div> 
 				<div class="col-md-4 formulaire">				
				    
					<input type="text" name="sRue" value="<%=user.getRue()%>"> 
					<br>					
					<input type="text" name="sVille" value="<%=user.getVille()%>"> 								 
 				</div> 
 				<div class="col-md-2 text-right"> 
 					<p>Code Postal :</p>  					
 				</div> 
 				<div class="col-md-4 formulaire"> 					
 					<input type="text" name="sCodePostal" value="<%=user.getCodePostal()%>">							    
 					
 				</div> 
 				
  			</div> 	
  			<br>	
  			<button type="submit" class="btn btn-primary mt-2" style="margin-left:0%" value="Ajouter"> Ajouter  </button>	
 		</form>
	</div>
</div>