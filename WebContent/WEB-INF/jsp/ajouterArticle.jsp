<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Nouvelle enchere"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Nouvelle enchere"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Nouvelle enchere"/>
</jsp:include>

<div class="container">

	<form action="AjouterArticleServlet" method="POST" enctype="multipart/form-data">
		
		<div class="form-group">
			<label for="nomArticle">Article</label>
			<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30020 || code eq 20040 || code eq 20041 }">error-field</c:if></c:forEach></c:if>" id="nomArticle" name="nomArticle" placeholder="Titre de l'article" value="${param.nomArticle}">
			<c:if test="${!empty listeCodesErreur}">               	 
              	<c:forEach var="code" items="${listeCodesErreur}">
             		<c:if test="${ code eq 30020 || code eq 20040 || code eq 20041 }">
             		<div class="invalid-feedback" role="alert">
             			${LecteurMessage.getMessageErreur(code)}
             			</div>
             	 	</c:if>
                 </c:forEach> 
			</c:if>
		</div>
		<div class="form-group">
			<label for="description">Description</label>
			<textarea rows="" cols="" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30021 || code eq 20042 || code eq 20043 }">error-field</c:if></c:forEach></c:if>" id="description" name="description">${param.description}</textarea>
			<c:if test="${!empty listeCodesErreur}">               	 
              	<c:forEach var="code" items="${listeCodesErreur}">
             		<c:if test="${ code eq 30021 || code eq 20042 || code eq 20043 }">
             		<div class="invalid-feedback" role="alert">
             			${LecteurMessage.getMessageErreur(code)}
             			</div>
             	 	</c:if>
                 </c:forEach> 
			</c:if>
		</div>
		
		<div class="row">
			<div class="form-group col-4">
				<label for="categories">Catégorie</label>
				<select class="form-control" id="categories" name="categories" value="${param.categories}">
					<option value="1">Informatique</option>
					<option value="2">Ameublement</option>
					<option value="3">Vêtement</option>
					<option value="4">Sport & Loisirs</option>
				</select>
			</div>
			
			<div class="range-slider col-4">
				<label for="prixInitial">Mise à prix</label>
	  			<input class="range-slider__range" type="range" value="${param.prixInitial}" min="0" max="1500" step="10" id="prixInitial" name="prixInitial">
	  			<span class="range-slider__value">0</span>
			</div>
			
			<div class="form-group col-4">
				<label for="photoArticle">Photo de l'article</label>
				<input type="file" class="form-control-file" id="photoArticle" name="photoArticle" accept="image/png, image/jpeg" value="${param.photoArticle}">
	 		</div>
		</div>


		<div class="row">
			<div class="form-group date col-6" data-provide="datepicker">
				<label for="dateDebutEnchere">Début de l'enchère</label>
				<input type="date" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30022 || code eq 20044}">error-field</c:if></c:forEach></c:if>" name="dateDebutEnchere" id="dateDebutEnchere" value="${param.dateDebutEnchere}">
				<c:if test="${!empty listeCodesErreur}">               	 
	              	<c:forEach var="code" items="${listeCodesErreur}">
	             		<c:if test="${ code eq 30022 || code eq 20044}">
	             		<div class="invalid-feedback" role="alert">
	             			${LecteurMessage.getMessageErreur(code)}
	             			</div>
	             	 	</c:if>
	                 </c:forEach> 
				</c:if>
			</div>
			
			<div class="form-group date col-6" data-provide="datepicker">
				<label for="dateFinEnchere">Fin de l'enchère</label>
				<input type="date" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30029 || code eq 20047}">error-field</c:if></c:forEach></c:if>" name="dateFinEnchere" id="dateFinEnchere" value="${param.dateFinEnchere}">
				<c:forEach var="code" items="${listeCodesErreur}">
	         		<c:if test="${ code eq 30029 || code eq 20047}">
	         		<div class="invalid-feedback" role="alert">
	         			${LecteurMessage.getMessageErreur(code)}
	         			</div>
	         	 	</c:if>
	             </c:forEach> 
			</div>
		</div>


		<div class="form-group">
			<label for="rue">N° et nom de rue</label>
			<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30015 }">error-field</c:if></c:forEach></c:if>" id="rue" name="rue" value="${utilisateur.rue}">
			<c:if test="${!empty listeCodesErreur}">
				<c:forEach var="code" items="${listeCodesErreur}">
				<c:if test="${ code eq 30015 }">
					<div class="invalid-feedback" role="alert">
						${LecteurMessage.getMessageErreur(code)}
					</div>
				</c:if>
				</c:forEach>
			</c:if>		
		</div>
		<div class="row">
			<div class="form-group col-6">
				<label for="codePostal">Code Postal</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30016 || code eq 20006 }">error-field</c:if></c:forEach></c:if>" id="codePostal" name="codePostal" value="${utilisateur.codePostal}">
				<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30016 || code eq 20006 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>
			</div>
			<div class="form-group col-6">
				<label for="ville">Ville</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30017 }">error-field</c:if></c:forEach></c:if>" id="ville" name="ville" value="${utilisateur.ville}">
				<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30017 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>	
			</div>
		</div>
		<button type="submit" class="btn btn-primary">Enregistrer</button>
		<button type="reset" class="btn btn-outline-danger">Annuler</button>
	</form>

</div>


<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>