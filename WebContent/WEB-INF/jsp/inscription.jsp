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
	<form action="InscriptionServlet" method="POST">
		<div class="row">
			<div class="form-group col-6">
				<label for="prenom">Prénom</label>
				<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Votre prénom">
			</div>
			<div class="form-group col-6">
				<label for="nom">Nom</label>
				<input type="text" class="form-control" id="nom" name="nom" placeholder="Votre nom">
			</div>
		</div>
		
		<div class="row">
			<div class="form-group col-6">
				<label for="pseudo">Pseudo</label>
				<input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Votre pseudo">
			</div>
			<div class="form-group col-6">
				<label for="telephone">Téléphone</label>
				<input type="text" class="form-control" id="telephone" name="telephone" placeholder="Votre numéro de tééphone">
			</div>
		</div>
		<div class="form-group">
			<label for="rue">N° et nom de rue</label>
			<input type="text" class="form-control" id="rue" name="rue" placeholder="Votre adresse">
		</div>
		<div class="row">
			<div class="form-group col-6">
				<label for="codePostal">Code Postal</label>
			<input type="text" class="form-control" id="codePostal" name="codepostal" placeholder="CP">
			</div>
			<div class="form-group col-6">
				<label for="ville">Ville</label>
				<input type="text" class="form-control" id="ville" name="ville" placeholder="Ville">
			</div>
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
			<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
		</div>
		<div class="form-group">
			<label for="password">Mot de Passe</label>
			<input type="password" class="form-control" id="password" name="password">
		</div>
		<button type="submit" class="btn btn-primary">S'inscrire</button>
	</form>
	
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>