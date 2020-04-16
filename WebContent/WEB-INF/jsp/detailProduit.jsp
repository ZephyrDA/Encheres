<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="bo.Article"%>
<%@page import="bo.Enchere"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.Calendar"%>
<% 
			Article article = (Article) request.getAttribute("article");
			ArrayList<Enchere> encheres = article.getEncheres();
			Date d = new Date(Calendar.getInstance().getTime().getTime());
			boolean dateFinOk= true;
			boolean dateDebutOk= true;
			//Si la date de fin est passée
			if(article.getDate_fin_encheres().compareTo(d)<=0)
			{
				dateFinOk=false;
			}
			if(article.getDate_debut_encheres().compareTo(d)<=0)
			{
				dateDebutOk=false;
			}
			System.out.println("Date debut ok :" +dateDebutOk);
			System.out.println("Date fin ok :" +dateFinOk);

		%>
<div class="container-fluid text-center col-md-12 justify-content-center">			
 	<div class="formulaire">  		
 		<form action="<%=request.getContextPath()%>/ModifierArticle" style="text-align: -webkit-center;"	method="post">  			
 			<div class=" row  col-md-9 col-xs-10 blocProfil mt-5"> 
 				<h3 class="col-md-12">Détail de l'article</h3><br>	 				
 				<!--  <div class="p-2 bg-primary ml-2 text-white" style="width: 30%;height: 100%;margin-left:50px;margin-right:auto;" >
 					<img src="./assets/pc.jpg"  alt="pc">
 				</div>-->
 				<div class="col-md-2 text-right "> 
 					<p>Nom du vendeur :</p> 
 					<p>Nom de l'article :</p> 
 					<p>Descriptif :</p> 
 					 
 				</div> 
 				<div class="col-md-4 formulaire"> 
					<c:choose>
					    <c:when test="${empty sessionScope.connectedUser}">
					        <input type="text" value=<%=article.getVendeur().getPseudo() %> readonly> 
					        <%System.out.print("non connecté /"); %>
					    </c:when>    
					    <c:when test="${!empty sessionScope.connectedUser}">
					      <%if(user.getNoUtilisateur()!=(article.getVendeur().getNoUtilisateur()) || dateDebutOk==false)  {%>
					       		<input type="text" value=<%=article.getVendeur().getPseudo() %> readonly> 
					       		<%System.out.print(" pas vendeur /"); %>
					       		<%System.out.print(" user id : " + user.getNoUtilisateur()); %>
					       		<%System.out.print(" vendeur id : " + article.getVendeur().getNoUtilisateur()); %>					       		
					       <%}
					      else{%>
					       		<input type="text" value=<%=article.getVendeur().getPseudo() %> >
					       		<%System.out.print(" vendeur /"); %> 
					       		<%System.out.print(" user id : " + user.getNoUtilisateur()); %>
					       		<%System.out.print(" vendeur id : " + article.getVendeur().getNoUtilisateur()); %>	
					    	  <%}%>
					    </c:when>
					</c:choose>  <br>
					<c:choose>
					    <c:when test="${empty sessionScope.connectedUser}">
					        <input type="text" name="snom" value="<%=article.getNom_article() %>" readonly> 
					    </c:when>    
					    <c:when test="${!empty sessionScope.connectedUser}">
					       <%if(user.getNoUtilisateur()!=(article.getVendeur().getNoUtilisateur()) || dateDebutOk==false)  {%>
					       		<input type="text" name="snom" value="<%=article.getNom_article() %>" readonly>
					       <%}
					      else{%>
					       		<input type="text" name="snom" value="<%=article.getNom_article() %>">
					      <%}%>
					    </c:when>
					</c:choose>  <br>
					<c:choose>
					    <c:when test="${empty sessionScope.connectedUser}">
					       <textarea name="sdescription" style="resize: none" id="desc" rows="3" cols="22.9" readonly>
									<%=article.getDescription() %>
								</textarea>
					    </c:when>    
					    <c:when test="${!empty sessionScope.connectedUser}">
					       <%if(user.getNoUtilisateur()!=(article.getVendeur().getNoUtilisateur()) || dateDebutOk==false)  {%>
								<textarea name="sdescription" style="resize: none" id="desc" rows="3" cols="22.9" readonly>
									<%=article.getDescription() %>
								</textarea>
					       <%}
					      else{%>
								<textarea name="sdescription" style="resize: none" id="desc" rows="3" cols="22.9" >
									<%=article.getDescription() %>
								</textarea>
					       <%}%>
					    </c:when>
					</c:choose>	<br>
					 
 				</div> 
 				<div class="col-md-2 text-right"> 
 					<p>Catégorie du produit :</p> 
 					<p>Prix initial :</p> 
 					<p>Début de l'enchère :</p> 
 					<p>Fin de l'enchère :</p> 
 				</div> 
 				<div class="col-md-4 formulaire">
 					<label style="margin-left: auto;margin-right: auto;"><%= article.getCategorie().getLibelle() %></label> <br>
 					<c:choose>
					    <c:when test="${empty sessionScope.connectedUser}">
					       <input type="text" name="sprix" value="<%=article.getPrix_initial() %>" readonly>
					    </c:when>    
					    <c:when test="${!empty sessionScope.connectedUser}">
					       <%if(user.getNoUtilisateur()!=(article.getVendeur().getNoUtilisateur()) || dateDebutOk==false)  {%>
								<input type="text" name="sprix" value="<%=article.getPrix_initial() %>" readonly>
					       <%}
					      else{%>
								<input type="text" name="sprix" value="<%=article.getPrix_initial() %>">
					        <%}%>
					    </c:when>
					</c:choose><br> 
					<c:choose>
					    <c:when test="${empty sessionScope.connectedUser}">
					       <input name="sDebut" type="date" value="<%=article.getDate_debut_encheres() %>" readonly>
					    </c:when>    
					    <c:when test="${!empty sessionScope.connectedUser}">
					      <%if(user.getNoUtilisateur()!=(article.getVendeur().getNoUtilisateur()) || dateDebutOk==false)  {%>
								<input name="sDebut" type="date" value="<%=article.getDate_debut_encheres() %>" readonly>
					       <%}
					      else{%>
								<input name="sDebut" type="date" value="<%=article.getDate_debut_encheres() %>">
					        <%}%>
					    </c:when>
					</c:choose><br>
					<c:choose>
					    <c:when test="${empty sessionScope.connectedUser}">
					       <input name="sFin" type="date" value="<%=article.getDate_fin_encheres() %>" readonly>
					    </c:when>    
					    <c:when test="${!empty sessionScope.connectedUser}">
					       <%if(user.getNoUtilisateur()!=(article.getVendeur().getNoUtilisateur()) || dateDebutOk==false)  {%>
								<input name="sFin" type="date" value="<%=article.getDate_fin_encheres() %>" readonly>
					       <%}
					      else{%>
								<input name="sFin" type="date" value="<%=article.getDate_fin_encheres() %>">
					       <%}%>
					    </c:when>
					</c:choose>
 					
 				</div> 
 				
 			 
 			<br>			 			
			<c:if test="${!empty sessionScope.connectedUser}"> 
				<%if(user.getNoUtilisateur()==article.getVendeur().getNoUtilisateur() && dateDebutOk==true)  {%>
					<input type="hidden" value="sidArticle" name="<%=article.getNo_article()%>">
		      		<button type="submit" class="btn btn-primary mt-2" style="margin-left:45%" value="Valider"> Modifier </button>
		      	<%}%>		      	
  			</c:if>	
  			</div> 	
 		</form>
		
 		<div class="container-fluid text-center col-md-11 ">			
 		<div class="formulaire" style="text-align: -webkit-center;">  		
 			<div class=" row  col-md-10 col-xs-12 blocProfil mt-5"> 
 				<h3 class="col-md-12">Enchères</h3><br>	
 				<%
 				int i=0;
 				for(Enchere enchere : encheres){ 
 				if(i==0){
 					%>
 				
 				<div class="row  col-md-12 col-xs-12 blocProfil mt-5 mr-1 ml-1">
 				<form action="<%=request.getContextPath()%>/Encherir" style="display: contents;"	method="post">
 					<h5 class="col-md-12">Dernière enchère</h5><br>
	 				<div class="col-md-4 text-right"> 
	 					<p>Date :</p> 
	 					<p>Pseudo :</p> 
	 					<p>Montant :</p>  				 
	 				</div> 
	 				<div class="col-md-4 formulaire " > 
						<p> <%=enchere.getDateEnchere() %></p> 
	 					<p><%=enchere.getUtilisateur().getPseudo() %></p> 
	 					<p><%=enchere.getMontantEnchere() %> credits</p> 
	 				</div> 
	 				<input type="hidden" value="<%=article.getNo_article() %>" name="noArt">
	 				
			 				<%
			 				if((user!=null)){
			 				if( user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur() && dateDebutOk==false){ %>
				 				<!--&& DateDebutOK==true && DateFinOK==true -->
				 					<div class="col-md-4 p-3"> 	 					
					 					<%
					 						
						 					String erreur = (String) request.getAttribute("erreur");
						 					if (erreur != null) { 
						 				%> 
						 						<p class="erreur"><%=erreur%></p> 
						 				<% 
						 					}
						 				%> 
						 				<input type="hidden" name="sMontantMinimum" value="<%=enchere.getMontantEnchere()+1%>">
						 				<input type="hidden" name="sIdArticle" value="<%=article.getNo_article()%>">
					 					<input type="text" name="sMontantOffre" value="" ><br>
					 					<button type="submit" class="btn btn-primary mt-2" value="Valider"> Enchérir </button>
			 						</div>
			 				<%}} %>
	 					
	 				
 				</form>
 				</div>
	 			<%
	 			i++;
	 			}
 				else{ %>
 					<div class="row  col-md-5 col-xs-12 blocProfil mt-5 mr-1 ml-1">
	 				<div class="col-md-6 text-right"> 
	 					<p>Date :</p> 
	 					<p>Pseudo :</p> 
	 					<p>Montant :</p>  				 
	 				</div> 
	 				<div class="col-md-6 formulaire " > 
						<p> <%=enchere.getDateEnchere() %></p> 
	 					<p><%=enchere.getUtilisateur().getPseudo() %></p> 
	 					<p><%=enchere.getMontantEnchere() %> credits</p> 
	 				</div> 
 				</div>	
 				<%}
 				} %>
 				
			</div>  			 			
			  		
 	</div> 						
</div>
 	</div> 						
</div>
</body>
</html>
