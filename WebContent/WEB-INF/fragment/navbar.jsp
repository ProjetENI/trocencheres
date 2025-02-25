<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container mr-auto">
		<a class="navbar-brand" href="${pageContext.request.contextPath}"><img src="${pageContext.request.contextPath}/img/logo_ecoauction.png" width="121" height="40" alt="green auction" title="green auction"/></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<c:choose>
					<c:when test="${empty utilisateur}">
						<li class="nav-item">
							<a class="nav-link" href="ConnectionServlet">Se connecter<span class="sr-only">(current)</span></a>
						</li>
					</c:when>
					<c:otherwise>
<!-- 						<li class="nav-item"> -->
<!-- 							<a class="nav-link" href="ListerArticles">Ench�res<span class="sr-only">(current)</span></a> -->
<!-- 						</li> -->
						
						<li class="nav-item">
							<a class="nav-link" href="AjouterArticleServlet">Vendre un article<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="MonProfilServlet">Mon Profil<span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="DeconnectionServlet">Se d�connecter<span class="sr-only">(current)</span></a>
						</li>
						<p class="card-text ml-3">
							<span class="price-title">Cr�dits </span><span class="price-tag">${utilisateur.credit} <i class="fa fa-gavel"></i></span>
						</p>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	
	<!-- 	<form class="form-inline"> -->
	<!-- 		<input class="form-control mr-sm-2" type="search" placeholder="Le nom de l'article contient" aria-label="Search"> -->
	<!-- 		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button> -->
	<!-- 	</form> -->
	</div>
	</nav>
