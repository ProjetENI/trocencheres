<%@page import="fr.eni.trocencheres.bo.ArticleVendu" %>
<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Liste des enchères"/>
</jsp:include>

	<div class="container">
			<form action="IndexServlet" method="POST">
				<div class="row">
					<div class="col-6">
						<div class="form-group">
							<label for="nomArticle">Article</label>
							<input type="text" class="form-control" id="nomArticle" name="nomArticle" placeholder="Le nom de l'article contient">
						</div>
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
					<div class="col-6 center p-b-50 p-t-50">
						<button type="submit" class="btn btn-primary w-60">Rechercher</button>
					</div>
				</div>
			</form>
				<div class="row">
					<div class="col-6">
					LISTE DES ENCHERES EN COURS
					</div>
				</div>
				
			
				<c:if test="${!empty listeArticles}"> 
					<c:forEach items="${listeArticles}" var="article" >
						<form action="DetailsArticleServlet" method="POST" class="col-6">
							<div class="form-group">
								<div class="box">
									${article.imageURL}
									${article.nomArticle}
								</div>
							</div>
						</form>
					</c:forEach>
				</c:if>

	</div>
	
<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>