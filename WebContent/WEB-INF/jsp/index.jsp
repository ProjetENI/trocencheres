<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="fr.eni.trocencheres.bo.ArticleVendu" %>
<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@page import="fr.eni.trocencheres.bo.Categorie" %>
<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Liste des encheres"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Liste des encheres"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Liste des encheres"/>
</jsp:include>

	<div class="container">
		<section>
			<form action="IndexServlet" method="POST">
				<div class="row">
					<div class="col-12 col-md-4">
						<div class="form-group">
							<label for="nomArticle">Article</label>
							<input type="text" class="form-control" id="nomArticle" name="nomArticle" placeholder="Rechercher un article">
						</div>
					</div>
					<div class="col-12 col-md-4">
						<div class="form-group">
							<label for="categories">Catégorie</label>
							<select class="form-control" id="categories" name="categories">
								<option value="0">Choix de la catégorie</option>
								<option value="1">Informatique</option>
								<option value="2">Ameublement</option>
								<option value="3">Vêtement</option>
								<option value="4">Sport et Loisirs</option>
							</select>
						</div>
					</div>
					<div class="col-12 col-md-4 mx-auto text-center">
						<button type="submit" class="btn btn-outline-primary mt-4 w-full" style="height:40px">Rechercher</button>
					</div>
				</div>
			</form>
		</section>
		
		<section>
			<div class="row text-center mt-5">
				<h2 class="mx-auto">LISTE DES ENCHERES EN COURS</h2>
			</div>
			
			<div class="row">
				<c:if test="${!empty listeArticles}">
					<c:forEach items="${listeArticles}" var="article" >
					<div class="col-12 col-md-6 col-lg-3">
						<div class="card mb-3">
							<c:choose>
								<c:when test="${!empty article.imageURL}">
							  		<img src="${pageContext.request.contextPath}/uploads/images/${article.imageURL}" class="card-img-top" alt="...">
							  	</c:when>
							  	<c:otherwise>
							  		<img src="${pageContext.request.contextPath}/img/categorie_${article.categorieArticle.noCategorie}.jpg" class="card-img-top" alt="...">
							  	</c:otherwise>
							</c:choose>
							<div class="card-body">
								<h5 class="card-title">
									${fn:substring(article.nomArticle, 0, 20)}<br/>
									<span class="categorie">Catégorie : ${article.categorieArticle.libelle}</span>
								</h5>
								<p class="card-text">
									<span class="seller-title">Vendu par : </span><span class="seller-name">${article.utilisateur.pseudo}</span><br/>
									<span class="price-title">Enchère en cours : </span><span class="price-tag">${article.prixInitial} <i class="fa fa-gavel"></i></span>
								</p>
								<c:if test="${!empty utilisateur}">
								<form action="DetailArticleServlet" method="POST">
									<input type="hidden" class="hide" id="noArticle" name="noArticle" value="${article.noArticle}">
									<input type="submit" class="btn btn-primary" value="Détails">
								</form>
								</c:if>
							</div>
						</div>
					</div>
					</c:forEach>
				</c:if>
			</div>
		</section>
	</div><!--  END .container -->
	
<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>