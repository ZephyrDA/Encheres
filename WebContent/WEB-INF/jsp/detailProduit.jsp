<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>   
<%@ include file="../header/header.jspf"%>
<%@page import="bo.Article"%>
<%@page import="bo.Enchere"%>
<%@page import="java.util.ArrayList"%>


<div class="row" style="margin-top:15%;">
	<div class="col-lg-6 offset-lg-3 col-xs-12  border border-primary p-2" >
		<form action="<%= request.getContextPath()%>/ModifierArticle" method="post" style="margin-left: 35%;">
		<% 
			Article article = (Article) request.getAttribute("article");
			ArrayList<Enchere> encheres = article.getEncheres();
		%>
			<span style="margin-left: auto;margin-right: auto;" id="usernameVendeur">Nom du vendeur : <br>
			<input type="text" value=<%=article.getVendeur().getPseudo() %>>
			</span>
			<span style="margin-left: auto;margin-right: auto;">Catégorie du produit : <br>		
				<%= article.getCategorie().getLibelle() %>
			</span>
			<br>
			<span>  Nom de l'article : <br>
	
			<c:choose>
			    <c:when test="${empty sessionScope.connectedUser}">
			        <input type="text" name="snom" value="<%=article.getNom_article() %>" readonly> 
			    </c:when>    
			    <c:when test="${!empty sessionScope.connectedUser}">
			       <c:if test="${user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()}">
			       		<input type="text" name="snom" value="<%=article.getNom_article() %>" readonly>
			       </c:if>
			       <c:if test="${user.getNoUtilisateur()==article.getVendeur().getNoUtilisateur()}">
			       		<input type="text" name="snom" value="<%=article.getNom_article() %>">
			       </c:if>
			    </c:when>
			</c:choose>
				
			</span>
			<br>
			<span > Prix du produit : <br>
			<c:choose>
			    <c:when test="${empty sessionScope.connectedUser}">
			       <input type="text" name="sprix" value="<%=article.getPrix_initial() %>" readonly>
			    </c:when>    
			    <c:when test="${!empty sessionScope.connectedUser}">
			       <c:if test="${user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()}">
						<input type="text" name="sprix" value="<%=article.getPrix_initial() %>" readonly>
			       </c:if>
			       <c:if test="${user.getNoUtilisateur()==article.getVendeur().getNoUtilisateur()}">
						<input type="text" name="sprix" value="<%=article.getPrix_initial() %>">
			       </c:if>
			    </c:when>
			</c:choose>
			</span>
			<br>
			<span> Descriptif : 
			<br>
			<c:choose>
			    <c:when test="${empty sessionScope.connectedUser}">
			       <textarea name="sdescription" style="resize: none" id="desc" rows="4" cols="50" readonly>
							<%=article.getDescription() %>
						</textarea>
			    </c:when>    
			    <c:when test="${!empty sessionScope.connectedUser}">
			       <c:if test="${user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()}">
						<textarea name="sdescription" style="resize: none" id="desc" rows="4" cols="50" readonly>
							<%=article.getDescription() %>
						</textarea>
			       </c:if>
			       <c:if test="${user.getNoUtilisateur()==article.getVendeur().getNoUtilisateur()}">
						<textarea name="sdescription" style="resize: none" id="desc" rows="4" cols="50" >
							<%=article.getDescription() %>
						</textarea>
			       </c:if>
			    </c:when>
			</c:choose>			
			</span>
			<br>
			<span> Début de l'enchère : <br>
			<c:choose>
			    <c:when test="${empty sessionScope.connectedUser}">
			       <textarea name="sdescription" style="resize: none" id="desc" rows="4" cols="50" readonly>
							<%=article.getDescription() %>
						</textarea>
			    </c:when>    
			    <c:when test="${!empty sessionScope.connectedUser}">
			       <c:if test="${user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()}">
						<textarea name="sdescription" style="resize: none" id="desc" rows="4" cols="50" readonly>
							<%=article.getDescription() %>
						</textarea>
			       </c:if>
			       <c:if test="${user.getNoUtilisateur()==article.getVendeur().getNoUtilisateur()}">
						<textarea name="sdescription" style="resize: none" id="desc" rows="4" cols="50" >
							<%=article.getDescription() %>
						</textarea>
			       </c:if>
			    </c:when>
			</c:choose>
				<input name="sDebut" type="date" value="<%=article.getDate_debut_encheres() %>" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
			</span>
			<br>
			<span> Fin de l'enchère : <br>
				<input name="sFin" type="date" value="<%=article.getDate_fin_encheres() %>" <%if(user.getNoUtilisateur()!=article.getVendeur().getNoUtilisateur()){%>readonly<%}%>>
			</span>
			<br>
			<c:if test="${!empty sessionScope.connectedUser}"> 
				<c:if test="${sessionScope.connectedUser.getNoUtilisateur().equals(article.getVendeur().getNoUtilisateur())}">
		      		<button type="submit" class="btn btn-primary mt-2" style="margin-left:20%" value="Valider"> Modifier </button>
		      	</c:if>			      	
  			</c:if>		
		</form>
		
		<div class="container-fluid text-center col-md-10 offset-2">	
			<div class="col-md-5">
			<% for(Enchere enchere : encheres){ %>
				<div class="col-md-3">
					<label>Date :</label>
					<label>Utilisateur :</label>
					<label>Offre :</label>
				</div>
				<div class="col-md-2">
					<label> <%=enchere.getDateEnchere() %></label>
					<label><%=enchere.getUtilisateur() %></label>
					<label><%=enchere.getMontantEnchere() %> credits</label>
				</div>
			<% } %>
			</div>
		</div>
	</div>
</div>

