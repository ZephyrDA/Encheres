<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="messages.LecteurMessage"%>
<%@page import="java.util.*"%>
<%@page import="bo.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

		ArrayList<Categorie> lesCategories = (ArrayList<Categorie>)request.getAttribute("lesCategories");
		ArrayList<Utilisateur> lesUtilisateurs = (ArrayList<Utilisateur>)request.getAttribute("lesUtilisateurs");
		ArrayList<Article> lesArticles = (ArrayList<Article>)request.getAttribute("lesArticles");	
		ArrayList<Retrait> lesRetraits = (ArrayList<Retrait>)request.getAttribute("lesRetraits");	
		ArrayList<Enchere> lesEncheres = (ArrayList<Enchere>)request.getAttribute("lesEncheres");	
	%>
	
	
HISTORIQUE

<table>
	<thead>
		<tr>
			<th>id</th>
			<th>libelle</th>	
		</tr>
	</thead>
	<tbody>
		<%for(Categorie cat : lesCategories){
			out.print("<tr>");
			out.print("<td>");
			out.print(cat.getNo_categorie());
			out.print("</td>");
			out.print("<td>");
			out.print(cat.getLibelle());
			out.print("</td>");
			out.print("</tr>");

		}
			%>
	</tbody>
</table>
     
<table>
	<thead>
		<tr>
			<th>idUtil</th>
			<th>pseudo</th>
			<th>nom</th>
			<th>prenom</th>
			<th>email</th>
			<th>telephone</th>
			<th>rue</th>
			<th>code postal</th>
			<th>ville</th>
			<th>mdp</th>
			<th>credit</th>
			<th>admin</th>	
		</tr>
	</thead>
	<tbody>
		<%for(Utilisateur util : lesUtilisateurs){
			out.print("<tr>");
			out.print("<td>");
			out.print(util.getNoUtilisateur());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getPseudo());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getNom());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getPrenom());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getEmail());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getTelephone());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getRue());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getCodePostal());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getVille());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getMotDePasse());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getCredit());
			out.print("</td>");
			out.print("<td>");
			out.print(util.getAdministrateur());
			out.print("</td>");
			out.print("</tr>");

		}
			%>
	</tbody>
</table>

<table>
	<thead>
		<tr>
			<th>idArticle</th>
			<th>nom</th>
			<th>description</th>
			<th>date debut encheres</th>
			<th>date fin encheres</th>
			<th>prix initial</th>
			<th>prix vente</th>
			<th>Vendeur</th>
			<th>Categorie</th>
			<th>Les Encheres</th>		
		</tr>
	</thead>
	<tbody>
		<%for(Article art : lesArticles){
			out.print("<tr>");
			out.print("<td>");
			out.print(art.getNo_article());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getNom_article());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getDescription());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getDate_debut_encheres());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getDate_fin_encheres());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getPrix_initial());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getPrix_vente());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getVendeur().getPseudo());
			out.print("</td>");
			out.print("<td>");
			out.print(art.getCategorie().getLibelle());
			out.print("</td>");
			out.print("<td>");
			%>
			<table>
				<thead>
					<tr>
						<th>Acheteur</th>
						<th>Date</th>
						<th>Prix</th>	
					</tr>
				</thead>
				<tbody>
					<%for(Enchere ench : art.getEncheres()){
						out.print("<tr>");
						out.print("<td>");
						out.print(ench.getUtilisateur().getPseudo());
						out.print("</td>");
						out.print("<td>");
						out.print(ench.getDateEnchere());
						out.print("</td>");
						out.print("<td>");
						out.print(ench.getMontantEnchere());
						out.print("</td>");
						out.print("</tr>");
					}
						%>
				</tbody>
			</table>
			<%
			out.print("</td>");
			out.print("</tr>");

		}
			%>
	</tbody>
</table>

<table>
	<thead>
		<tr>
			<th>idArticle</th>
			<th>rue</th>
			<th>code_postal</th>
			<th>Ville</th>	
		</tr>
	</thead>
	<tbody>
		<%for(Retrait ret : lesRetraits){
			out.print("<tr>");
			out.print("<td>");
			out.print(ret.getArticle().getNom_article());
			out.print("</td>");
			out.print("<td>");
			out.print(ret.getRue());
			out.print("</td>");
			out.print("<td>");
			out.print(ret.getCode_postal());
			out.print("</td>");
			out.print("<td>");
			out.print(ret.getVille());
			out.print("</td>");
			out.print("</tr>");

		}
			%>
	</tbody>
</table>



<% out.print(request.getContextPath());%>
</body>
</html>