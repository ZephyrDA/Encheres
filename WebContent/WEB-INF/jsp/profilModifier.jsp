<%@page import="bo.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container-fluid text-center col-md-10 offset-2">			
 	<div class="formulaire">  		
 		<form action="<%=request.getContextPath()%>/ModifierProfil"	method="post">  			
 			<div class=" row col-md-offset-2 col-md-9 col-xs-12 blocProfil mt-5"> 
 				<h3 class="col-md-12">Modifier de mon Profil</h3><br>	
 				<div class="col-md-2 text-right "> 
 					<p>Pseudo :</p> 
 					<p>Prenom :</p> 
 					<p>Telephone :</p> 
 					<p>Code postal :</p> 
 					<p>Mot de passe actuel :</p> 
 				</div> 
 				<div class="col-md-3 formulaire"> 
					<input type="text" name="spseudo" value="<%=user.getPseudo() %>"  class="form-control input-md"><br> 
 					<input type="text" name="sprenom" value="<%=user.getPrenom()%>"  class="form-control input-md"><br> 
					<input type="text" name="stelephone" value="<%=user.getTelephone()%>"  class="form-control input-md"><br>  
 					<input type="text" name="scodePostal" value="<%=user.getCodePostal()%>"  class="form-control input-md"><br> 
 					<input type="password" name="smotDePasseActuel"  placeholder="Mot de passe actuel" class="form-control input-md">
 				</div> 
 				<div class="col-md-2 text-right"> 
 					<p>Nom :</p> 
 					<p>Email :</p> 
 					<p>Rue :</p> 
 					<p>Ville :</p> 
 					<p>Nouveau mot de passe :</p> 
 				</div> 
 				<div class="col-md-3 formulaire">
 					<input type="text" name="snom" value="<%=user.getNom()%>" class="form-control input-md"><br> 
 					<input type="text" name="semail" value="<%=user.getEmail()%>"  class="form-control input-md"><br> 
 					<input type="text" name="srue" value="<%=user.getRue()%>" class="form-control input-md"><br> 
 					<input type="text" name="sville" value="<%=user.getVille()%>" class="form-control input-md"><br> 
 					<input type="password" name="snouveauMotDePasse"  placeholder="Nouveau mot de passe" class="form-control input-md">
 				</div> 
 				<%
 					String erreur = (String) request.getAttribute("erreur");
 					if (erreur != null) { 
 				%> 
 						<p class="erreur"><%=erreur%></p> 
 				<% 
 					}
 				%> 
 			</div>  			 			
			<div class="row" style="margin-left: 25%"> 
 				<button type="submit" class="bouton col-md-3 btn btn-default">Sauvegarder</button>  				
 				
 			</div>  	
 		</form>
 		
 	</div> 						
</div>
</body>
</html>