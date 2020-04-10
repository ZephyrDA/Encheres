<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="../header/header.jspf"%>
<div class="col-md-10 formulaire">
	<h3 class="text-center mb-5">Crediter un Utilisateur</h3>
	<form action="<%=request.getContextPath()%>/crediter" method="post">
		<div class="blocProfil mt-5">
			<div class="col-lg-12 offset-4">
				<p class="col-lg-2">Pseudo utilisateur :</p>
				<input type="text" name="pseudoUtilisateur" value="" class="col-lg-3"><br>
			</div>
			<div class="col-lg-12 offset-4">
				<p class="col-lg-2">Montant à créditer :</p>
				<input type="text" name="credit" value="" class="col-lg-3"><br>
			</div>
			<div class="col-lg-12 offset-4">		
				<button type="submit" class="bouton btn btn-default">
					Créditer l'utilisateur
				</button>
			</div>
		</div>		
	</form>
</div>
</body>
</html>