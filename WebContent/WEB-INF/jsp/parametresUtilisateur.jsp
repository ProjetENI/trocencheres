<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>




<!-- Remplit à titre d'exemple pour le moment-->

	<div class="container">
	<section class="mb-5">
		<h2>Modifier les paramètres utilisateur</h2>
		<form action="ParametresUtilisateurServlet" method="POST">
			<div class="row">
				<div class="form-group col-6">
					<label for="prenom">Prénom</label>
					<input type="text" class="form-control" id="prenom" placeholder="Votre prénom">
				</div>
				<div class="form-group col-6">
					<label for="nom">Nom</label>
					<input type="text" class="form-control" id="nom" placeholder="Votre nom">
				</div>
			</div>
			<div class="form-group">
				<label for="pseudo">Pseudo</label>
				<input type="text" class="form-control" id="pseudo" placeholder="Votre pseudo">
			</div>
			<div class="form-group">
				<label for="rue">N° et nom de rue</label>
				<input type="text" class="form-control" id="rue" placeholder="Votre adresse">
			</div>
			<div class="row">
				<div class="form-group col-6">
					<label for="codePostal">Code Postal</label>
				<input type="text" class="form-control" id="codePostal" placeholder="CP">
				</div>
				<div class="form-group col-6">
					<label for="ville">Ville</label>
					<input type="text" class="form-control" id="ville" placeholder="Ville">
				</div>
			</div>
			<div class="form-group">
				<label for="InputEmail">Email</label>
				<input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp">
				<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</section>
	
	
	
</div>
