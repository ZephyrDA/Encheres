<%@page import="bo.Enchere"%>
<%@page import="bo.Article"%>
<%@page import="bo.Utilisateur"%>
<%@page import="bo.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dal.dao.CategorieDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<%
	Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateurConnecte");
	Article article = (Article) request.getSession().getAttribute("utilisateurConnecte");
	Enchere e = (Enchere) request.getSession().getAttribute("utilisateurConnecte");
%>
<div class="container blocProfil mt-5">
	<header class="row">
		<div class="col-lg-12">
			<h4 class="text-center">Détail vente</h4>
			<br>
		</div>
	</header>
	<div class="row offset-3">
		<nav class="col-lg-2"><img src="" alt="" height="300px" width="300px"/></nav>
		<section class="col-lg-10">
			<form class="form-horizontal"action="<%=request.getContextPath()%>/encherir" method="post">
				<fieldset>
					<div class="form-group">
						<label class="col-md-4 control-label" for="sarticle">Article :</label>
						<div class="col-md-4">
							<input id="sarticle" name="sarticle" type="text" placeholder=""	class="form-control input-md">
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="sdescription">Description :</label>
						<div class="col-md-4">
							<textarea class="form-control" id="sdescription" name="sdescription"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="scategorie">Catégorie :</label>
						<div class="col-md-4">
							<select id="scategorie" name="scategorie" class="form-control">
							<%
								@SuppressWarnings("unchecked")
								ArrayList<Categorie> listeCategorie = (ArrayList<Categorie>)request.getAttribute("listeCategorie");
								for (Categorie c : listeCategorie) {
							%>
									<option value="<%= c.getNo_categorie() %>"><%=c.getLibelle()%></option>
							<%
								}
							%>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="smiseAPrix">Meilleur offre :</label>
						<%=e.getMontantEnchere() %>
						<div class="col-md-2">
							<select id="smiseAPrix" name="smiseAPrix" class="form-control">
								<option value="">150</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="smiseAPrix">Mise	à prix :</label>
						<%=article.getPrix_initial() %>
						<div class="col-md-2">
							<select id="smiseAPrix" name="smiseAPrix" class="form-control">
								<option value="">150</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="sfinEnchere">Fin	de l'enchère :</label>					
						<%=article.getDate_fin_encheres() %>					
						<div class='col-md-4'>
							<div class='input-group date' id='datetimepicker1'>
								<input type='text' class="form-control" /> 
								<span class="input-group-addon"> 
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="sfinEnchere">Retrait</label>
						<div class='col-md-4'>
							<div class='input-group date' id='datetimepicker1'>
								<%=utilisateur.getRue() %><br><%=utilisateur.getCodePostal() %>
								<%=utilisateur.getVille() %>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="sfinEnchere">Vendeur</label>
						<div class='col-md-4'>
							<div class='input-group date' id='datetimepicker1'>
								<%=utilisateur.getPrenom() %>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="sfinEnchere">Ma proposition</label>
						<div class='col-md-4'>
							<div class='input-group date' id='datetimepicker1'>
								<div class="col-md-2">
									<select id="smiseAPrix" name="smiseAPrix" class="form-control">
										<option value="">500</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-4 control-label" for="button1id"></label>
						<div class="col-md-4">
							<button id="button1id" name="button1id" class="btn btn-default">Encherir</button>
						</div>
					</div>
				</fieldset>
			</form>
		</section>
	</div>	
</div>
</body>
</html>