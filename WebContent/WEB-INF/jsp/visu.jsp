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

<% out.print(request.getContextPath());%>
</body>
</html>