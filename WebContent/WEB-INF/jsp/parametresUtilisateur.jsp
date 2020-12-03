<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Remplit � titre d'exemple pour le moment-->

	<div class="container">
	<section class="mb-5">
		<h2>Modifier les param�tres utilisateur</h2>
		<form action="ParametresUtilisateurServlet" method="POST">
			<div class="row">
				<div class="form-group col-6">
					<label for="prenom">Pr�nom</label>
					<input type="text" class="form-control" id="prenom" placeholder="${utilisateur.prenom}">
				</div>
				<div class="form-group col-6">
					<label for="nom">Nom</label>
					<input type="text" class="form-control" id="nom" placeholder="${utilisateur.nom}">
				</div>
			</div>
			<div class="form-group">
				<label for="pseudo">Pseudo</label>
				<input type="text" class="form-control" id="pseudo" placeholder="${utilisateur.pseudo}">
			</div>
			<div class="form-group">
				<label for="rue">N� et nom de rue</label>
				<input type="text" class="form-control" id="rue" placeholder="${utilisateur.rue}">
			</div>
			<div class="row">
				<div class="form-group col-6">
					<label for="codePostal">Code Postal</label>
				<input type="text" class="form-control" id="codePostal" placeholder="${utilisateur.codePostal}">
				</div>
				<div class="form-group col-6">
					<label for="ville">Ville</label>
					<input type="text" class="form-control" id="ville" placeholder="${utilisateur.ville}">
				</div>
			</div>
			<div class="form-group">
				<label for="InputEmail">Email</label>
				<input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp" placeholder="${utilisateur.email}">
				<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</section>
	
	
	
</div>
