<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="container">			
 	<div class="formulaire text-center">  		
 		<form action="<%=request.getContextPath()%>/GestionInscription"	method="post">  			
 			<div class=" row col-md-offset-2 col-md-9 col-xs-12 blocProfil mt-5"> 
 				<h3 class="col-md-12">Création de mon Profil</h3><br>	
 				<div class="col-md-3 "> 
 					<p>Pseudo :</p> 
 					<p>Prenom :</p> 
 					<p>Telephone :</p> 
 					<p>Code postal :</p> 
 					<p>Mot de passe :</p> 
 				</div> 
 				<div class="col-md-3 formulaire"> 
					<input type="text" name="pseudoInscription" value="${fn:escapeXml(pseudoInscription)}"><br> 
 					<input type="text" name="prenomInscription" value="${fn:escapeXml(prenomInscription)}"><br> 
					<input type="text" name="telephoneInscription" value="${fn:escapeXml(telephoneInscription)}"><br>  
 					<input type="text" name="codePostalInscription" value="${fn:escapeXml(codePostalInscription)}"><br> 
 					<input type="password" name="motDePasseInscription" value="${fn:escapeXml(motDePasseInscription)}"> 
 				</div> 
 				<div class="col-md-3"> 
 					<p>Nom :</p> 
 					<p>Email :</p> 
 					<p>Rue :</p> 
 					<p>Ville :</p> 
 					<p>Confirmation :</p> 
 				</div> 
 				<div class="col-md-3 formulaire">
 					<input type="text" name="nomInscription" value="${fn:escapeXml(nomInscription)}"><br> 
 					<input type="text" name="emailInscription" value="${fn:escapeXml(emailInscription)}"><br> 
 					<input type="text" name="rueInscription" value="${fn:escapeXml(rueInscription)}"><br> 
 					<input type="text" name="villeInscription" value="${fn:escapeXml(villeInscription)}"><br> 
 					<input type="password" name="confirmationInscription"> 
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
			<div class="row"> 
 				<button type="submit" class="bouton col-md-4 btn btn-default">Creer</button>
 			</div>  	
 		</form>
 		<form action="<%=request.getContextPath()%>/home" method="get"> 						  		
 				<button type="submit" class="bouton col-md-4 btn btn-default">Annuler</button>
 		</form> 
 	</div> 						
</div>
</body>
</html>