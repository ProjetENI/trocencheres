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

	<form action="InscriptionServlet" method="POST">
		
		<div class="form-group">
			<label for="article">Article</label>
			<input type="text" class="form-control" id="article" name="article" placeholder="Titre de l'article">
		</div>
		<div class="form-group">
			<label for="description">Description</label>
			<textarea rows="" cols="" class="form-control" id="description" name="description"></textarea>
		</div>
		
		<div class="form-group">
			<label for="categories">Catégorie</label>
			<select class="form-control" id="categories">
				<option>Catégorie 1</option>
				<option>Catégorie 2</option>
				<option>Catégorie 3</option>
				<option>Catégorie 4</option>
				<option>Catégorie 5</option>
			</select>
		</div>
		
		<div class="form-group">
			<label for="photoArticle">Photo de l'article</label>
			<input type="file" class="form-control-file" id="photoArticle" name="photoArticle" >
 		</div>
 		
		<div class="range-slider">
			<label for="miseAPrix">Mise à prix</label>
  			<input class="range-slider__range" type="range" value="150" min="0" max="1500" id="miseAPrix" name="miseAPrix">
  			<span class="range-slider__value">0</span>
		</div>
		
		<div class="form-group date" data-provide="datepicker">
			<label for="dateDebutEnchere">Début de l'enchère</label>
			<input type="date" class="form-control" name="dateDebutEnchere" id="dateDebutEnchere">
		</div>
		
		<div class="form-group date" data-provide="datepicker">
			<label for="dateFinEnchere">Début de l'enchère</label>
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