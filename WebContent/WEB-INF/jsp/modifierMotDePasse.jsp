<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="container">
	<section class="mb-5">
		<h2>Changer de mot de passe</h2>
		<form action="ModifierMotDePasseServlet" method="POST">
			<div class="row">
				<div class="form-group col-4">
					<label for="ancienMotDePasse">Ancien Mot de Passe</label>
					<input type="password" class="form-control" id="ancienMotDePasse">
				</div>
				<div class="form-group col-4">
					<label for="nouveauMotDePasse1">Nouveau Mot de Passe</label>
					<input type="password" class="form-control" id="nouveauMotDePasse1">
				</div>
				<div class="form-group col-4">
					<label for="nouveauMotDePasse2">Confirmer mot de passe</label>
					<input type="password" class="form-control" id="nouveauMotDePasse2">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</section>
	
</div>
