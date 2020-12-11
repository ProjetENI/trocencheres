<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@page import="fr.eni.trocencheres.bo.Utilisateur" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Remplit à titre d'exemple pour le moment-->

	<div class="container">
	<section class="mb-5">
		<h2>Modifier les paramètres utilisateur</h2>
		<form action="ModifierParametreServlet" method="POST">
			<div class="row">
				<div class="form-group col-6">
					<label for="prenom">Prénom</label>
					<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30012 || code eq 20004 }'>error-field</c:if></c:forEach></c:if>" id="prenom" name="prenom" value="${utilisateur.prenom}">
					<c:if test="${!empty listeCodesErreur}">           	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30012 || code eq 20004 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                		</div>
                	 	</c:if>
                    </c:forEach>           		
                </c:if>
				</div>
				<div class="form-group col-6">
					<label for="nom">Nom</label>
					<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30011 || code eq 20003 }'>error-field</c:if></c:forEach></c:if>" id="nom" name="nom" value="${utilisateur.nom}">
					<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30011 || code eq 20003 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                    </c:forEach>           		
                </c:if>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-6">
					<label for="pseudo">Pseudo</label>
					<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30010 || code eq 20000 || code eq 20001 }'>error-field</c:if></c:forEach></c:if>" id="pseudo" name="pseudo" value="${utilisateur.pseudo}">
					<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30010 || code eq 20000 || code eq 20001 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                    </c:forEach>           		
                </c:if>
				</div>
				<div class="form-group col-6">
					<label for="telephone">Numéro de téléphone</label>
					<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30014 || code eq 20005 }'>error-field</c:if></c:forEach></c:if>" id="telephone" name="telephone" value="${utilisateur.telephone}">
					<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30014 || code eq 20005 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                    </c:forEach>           		
                </c:if>
				</div>
			</div>
			<div class="form-group">
				<label for="rue">N° et nom de rue</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30015 }'>error-field</c:if></c:forEach></c:if>" id="rue" name="rue" value="${utilisateur.rue}">
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
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30016 || code eq 20006 }'>error-field</c:if></c:forEach></c:if>" id="codePostal" name="codePostal" value="${utilisateur.codePostal}">
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
					<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30017 }'>error-field</c:if></c:forEach></c:if>" id="ville" name="ville" value="${utilisateur.ville}">
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
			<div class="form-group">
				<label for="email">Email</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test='${ code eq 30013 }'>error-field</c:if></c:forEach></c:if>" id="email" name="email" aria-describedby="emailHelp" value="${utilisateur.email}">
				<c:if test="${!empty listeCodesErreur}">               	 
              	<c:forEach var="code" items="${listeCodesErreur}">
             		<c:if test="${ code eq 30013 }">
             		<div class="alert alert-danger" role="alert">
             			${LecteurMessage.getMessageErreur(code)}
             			</div>
             	 	</c:if>                	 	
                 </c:forEach>           		
				</c:if>
				<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
			</div>
			<button type="submit" class="btn btn-primary">Modifier</button>
				
		</form>
	</section>			
</div>
