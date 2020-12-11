<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div class="container">
	<section class="mb-5">
		<h2>Changer de mot de passe</h2>
		<form action="ModifierMotDePasseServlet" method="POST">
			<div class="row">
				<div class="form-group col-4">
					<label for="ancienMotDePasse">Ancien Mot de Passe</label>
					<input type="password" class="form-control" id="ancienMotDePasse" name="ancienMotDePasse">
					<!-- Affichage d'une erreur si le champs mots de passe est vide -->
					<c:if test="${!empty listeCodesErreur}">
	                 	<c:forEach var="code" items="${listeCodesErreur}">
	                		<c:if test="${ code eq 30018 }">
	                		<div class="invalid-feedback" role="alert">
	                			${LecteurMessage.getMessageErreur(code)}
	                			</div>
	                	 	</c:if>
	                    </c:forEach> 
	                </c:if>
				</div>
				<div class="form-group col-4">
					<label for="nouveauMotDePasse1">Nouveau Mot de Passe</label>
					<input type="password" class="form-control" id="nouveauMotDePasse1" name="nouveauMotDePasse1">
					<!-- Affichage d'une erreur si le champs mots de passe est vide -->
					<c:if test="${!empty listeCodesErreur}">
	                 	<c:forEach var="code" items="${listeCodesErreur}">
	                		<c:if test="${ code eq 30018 }">
	                		<div class="invalid-feedback" role="alert">
	                			${LecteurMessage.getMessageErreur(code)}
	                			</div>
	                	 	</c:if>
	                    </c:forEach> 
	                </c:if>
				</div>
				<div class="form-group col-4">
					<label for="nouveauMotDePasse2">Confirmer mot de passe</label>
					<input type="password" class="form-control" id="nouveauMotDePasse2" name="nouveauMotDePasse2">
					<!-- Affichage d'une erreur si le champs mots de passe est vide -->
					<c:if test="${!empty listeCodesErreur}">
	                 	<c:forEach var="code" items="${listeCodesErreur}">
	                		<c:if test="${ code eq 30018 }">
	                		<div class="invalid-feedback" role="alert">
	                			${LecteurMessage.getMessageErreur(code)}
	                			</div>
	                	 	</c:if>
	                    </c:forEach> 
	                </c:if>
				</div>
				<!-- Affichage d'une erreur si les nouveaux mots de passe ne correspondent pas -->
				<c:if test="${!empty listeCodesErreur}">
	                 	<c:forEach var="code" items="${listeCodesErreur}">
	                		<c:if test="${ code eq 30005 }">
	                		<div class="invalid-feedback" role="alert">
	                			${LecteurMessage.getMessageErreur(code)}
	                			</div>
	                	 	</c:if>
	                    </c:forEach> 
	                </c:if>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
		</form>
	</section>
	
</div>