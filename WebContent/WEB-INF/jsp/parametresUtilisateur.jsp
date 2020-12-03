<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Remplit à titre d'exemple pour le moment-->

	<div class="container">
	<section class="mb-5">
		<h2>Modifier les paramètres utilisateur</h2>
		<form action="ModifierParametreServlet" method="POST">
			<div class="row">
				<div class="form-group col-6">
					<label for="prenom">Prénom</label>
					<input type="text" class="form-control" id="prenom" name="prenom" value="${utilisateur.prenom}">
				</div>
				<div class="form-group col-6">
					<label for="nom">Nom</label>
					<input type="text" class="form-control" id="nom" name="nom" value="${utilisateur.nom}">
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<label for="pseudo">Pseudo</label>
					<input type="text" class="form-control" id="pseudo" name="pseudo" value="${utilisateur.pseudo}">
				</div>
				<div class="form-group col-6">
					<label for="telephone">Numéro de téléphone</label>
					<input type="text" class="form-control" id="telephone" name="telephone" value="${utilisateur.telephone}">
				</div>
			</div>
			<div class="form-group">
				<label for="rue">N° et nom de rue</label>
				<input type="text" class="form-control" id="rue" name="rue" value="${utilisateur.rue}">
			</div>
			<div class="row">
				<div class="form-group col-6">
					<label for="codePostal">Code Postal</label>
				<input type="text" class="form-control" id="codePostal" name="codePostal" value="${utilisateur.codePostal}">
				</div>
				<div class="form-group col-6">
					<label for="ville">Ville</label>
					<input type="text" class="form-control" id="ville" name="ville" value="${utilisateur.ville}">
				</div>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<input type="text" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${utilisateur.email}">
				<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</section>
	
	
	
</div>
