<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Banner_Value"/>
</jsp:include>


<!-- Remplit à titre d'exemple pour le moment-->
<div class="container">
	<section class="mb-5">
		<h2>Changer de mot de passe</h2>
		<form action="changerMotDePasseServlet" method="POST">
			<div class="row">
				<div class="form-group col-4">
					<label for="ancienMotDePasse">Ancien Mot de Passe</label>
					<input type="text" class="form-control" id="ancienMotDePasse">
				</div>
				<div class="form-group col-4">
					<label for="nouveauMotDePasse1">Nouveau Mot de Passe</label>
					<input type="text" class="form-control" id="nouveauMotDePasse1">
				</div>
				<div class="form-group col-4">
					<label for="nouveauMotDePasse2">Confirmer mot de passe</label>
					<input type="text" class="form-control" id="nouveauMotDePasse2">
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</section>
	
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
	
	<section class="mb-5">
		<h2>Supprimer mon compte</h2>
		<p>Vous pouvez supprimer votre compte en cliquant sur "Supprimer le compte".<br/>
		Attention: Toutes vos données seront perdue.</p>
		<button type="button" class="btn btn-outline-danger">Supprimer le compte</button>	
	</section>
	
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>