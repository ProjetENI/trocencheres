<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="#">Troc Ench�res</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<li class="nav-item active">
				<c:choose>
					<c:when test="${utilisateur.pseudo eq null}">
						<a class="nav-link" href="ConnectionServlet">Se connecter<span class="sr-only">(current)</span></a>
					</c:when>
					<c:otherwise>
						<a class="nav-link" href="DeconnexionServlet">Se d�connecter<span class="sr-only">(current)</span></a>
					</c:otherwise>
				</c:choose>
			</li>
			<li class="nav-item active">
			<a class="nav-link" href="MonProfilServlet">Mon Profil<span class="sr-only">(current)</span></a>
			</li>
		</ul>


	</div>

<!-- 	<form class="form-inline"> -->
<!-- 		<input class="form-control mr-sm-2" type="search" placeholder="Le nom de l'article contient" aria-label="Search"> -->
<!-- 		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
<!-- 	</form> -->
</nav>