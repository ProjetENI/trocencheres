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
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Liste des encheres"/>
</jsp:include>

	<div class="container">

		<section>
			<div class="row text-center mt-5">
				<h2 class="mx-auto">DÉTAIL DE L'ARTICLE</h2>
			</div>
			
			<div class="row">
				<div class="col-12 col-md-4 col-lg-4">
					<div class="card mb-3">
						<c:choose>
							<c:when test="${!empty article.imageURL}">
						  		<img src="${pageContext.request.contextPath}/uploads/images/${article.imageURL}" class="card-img-top" alt="...">
						  	</c:when>
						  	<c:otherwise>
						  		<img src="${pageContext.request.contextPath}/img/categorie_${article.categorieArticle.noCategorie}.jpg" class="card-img-top" alt="...">
						  	</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-12 col-md-8 col-lg-8">
					<h5>
						${fn:substring(article.nomArticle, 0, 20)}<br/>
						<span class="categorie">Catégorie : ${article.categorieArticle.libelle}</span>
					</h5>
					<p>
						<span class="seller-title">Vendu par : </span><span class="seller-name">${article.utilisateur.pseudo}</span><br/>
						<span class="price-title">Prix en cours : </span><span class="price-tag">${article.prixInitial} <i class="fa fa-gavel"></i></span>
					</p>
					
					
					<p class="description">
						${article.description}
					</p>
					
					<form class="validate-form w-60 validate-form-check" method="post" action="EncherirServlet">
					
						<input type="hidden" class="hide" id="noArticle" name="noArticle" value="${article.noArticle}">

						<div class="wrap-input100 validate-input validate-input-check" data-validate = "Indiquez une enchère">
							<input class="input100 input-check" type="text" id="enchere" name="enchere">
							<span class="focus-input100"></span>
							<span class="label-input100">Votre enchère</span>
						</div>
						
						<input type="submit" class="btn btn-primary" value="Encherir">
					</form>
					
				</div>
			</div>
		</section>
	</div><!--  END .container -->
	
<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>