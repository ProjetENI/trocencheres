<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Nouvelle enchère"/>
</jsp:include>

<div class="container">

	<form action="AjouterArticleServlet" method="POST" enctype="multipart/form-data">
		<span class="text-danger">
			${error}
			<c:if test="${!empty listeCodesErreur}">
				<div class="alert alert-danger" role="alert">
					<strong>Erreur!</strong>
					<ul>
					<c:forEach var="code" items="${listeCodesErreur}">
						<li>${LecteurMessage.getMessageErreur(code)}</li>
					</c:forEach>
					</ul>
				</div>
			</c:if>
		</span>
		
		<div class="form-group">
			<label for="nomArticle">Article</label>
			<input type="text" class="form-control" id="nomArticle" name="nomArticle" placeholder="Titre de l'article">
		</div>
		<div class="form-group">
			<label for="description">Description</label>
			<textarea rows="" cols="" class="form-control" id="description" name="description"></textarea>
		</div>
		
		<div class="form-group">
			<label for="categories">Catégorie</label>
			<select class="form-control" id="categories" name="categories">
				<option value="1">Informatique</option>
				<option value="2">Ameublement</option>
				<option value="3">Vêtement</option>
				<option value="4">Sport & Loisirs</option>
			</select>
		</div>
		
		<div class="form-group">
			<label for="photoArticle">Photo de l'article</label>
			<input type="file" class="form-control-file" id="photoArticle" name="photoArticle" accept="image/png, image/jpeg">
 		</div>
 		
		<div class="range-slider">
			<label for="prixInitial">Mise à prix</label>
  			<input class="range-slider__range" type="range" value="150" min="0" max="1500" step="10" id="prixInitial" name="prixInitial">
  			<span class="range-slider__value">0</span>
		</div>
		
		<div class="form-group date" data-provide="datepicker">
			<label for="dateDebutEnchere">Début de l'enchère</label>
			<input type="date" class="form-control" name="dateDebutEnchere" id="dateDebutEnchere">
		</div>
		
		<div class="form-group date" data-provide="datepicker">
			<label for="dateFinEnchere">Fin de l'enchère</label>
			<input type="date" class="form-control" name="dateFinEnchere" id="dateFinEnchere">
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
		<button type="submit" class="btn btn-primary">Enregistrer</button>
		<button type="reset" class="btn btn-outline-danger">Annuler</button>
	</form>

</div>


<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>