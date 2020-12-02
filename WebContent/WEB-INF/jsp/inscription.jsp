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
	<form action="inscriptionServlet" method="POST">
		<div class="form-group">
			<label for="prenom">Prénom</label>
			<input type="text" class="form-control" id="prenom" placeholder="Votre prénom">
			<label for="nom">Nom</label>
			<input type="text" class="form-control" id="nom" placeholder="Votre nom">
		</div>
		<div class="form-group">
			<label for="pseudo">Pseudo</label>
			<input type="text" class="form-control" id="pseudo" placeholder="Votre pseudo">
		</div>
		<p>Adresse</p>
		<div class="form-group">
			<label for="rue">N° et nom de rue</label>
			<input type="text" class="form-control" id="rue" placeholder="Votre adresse">
		</div>
		<div class="form-group">
			<label for="codePostal">Code Postal</label>
			<input type="text" class="form-control" id="codePostal" placeholder="CP">
			<label for="ville">Ville</label>
			<input type="text" class="form-control" id="ville" placeholder="Ville">
		</div>
		<div class="form-group">
			<label for="InputEmail">Email</label>
			<input type="email" class="form-control" id="InputEmail" aria-describedby="emailHelp">
			<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
		</div>
		<div class="form-group">
			<label for="InputPassword">Mot de Passe</label>
			<input type="password" class="form-control" id="InputPassword">
		</div>
		<button type="submit" class="btn btn-primary">S'inscrire</button>
	</form>
	
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>