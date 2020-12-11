<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Inscription"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Inscription"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Inscription"/>
</jsp:include>


<!-- Remplit à titre d'exemple pour le moment-->
<div class="container">
<form action="InscriptionServlet" method="POST">
		
		<div class="row">
			<div class="form-group col-6">
				<label for="prenom">Prénom</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30012 || code eq 20004 }">error-field</c:if></c:forEach></c:if>" id="prenom" name="prenom" placeholder="Votre prénom">
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
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30011 || code eq 20003 }">error-field</c:if></c:forEach></c:if>" id="nom" name="nom" placeholder="Votre Nom">
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

			<div class="form-group col-6">
				<label for="pseudo">Pseudo</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30010 || code eq 20000 || code eq 20001 }">error-field</c:if></c:forEach></c:if>" id="pseudo" name="pseudo" placeholder="Votre pseudo">
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
				<label for="telephone">N° de téléphone</label>
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30014 || code eq 20005 }">error-field</c:if></c:forEach></c:if>" id="telephone" name="telephone" placeholder="Votre N° de téléphone">
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
			<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30015 }">error-field</c:if></c:forEach></c:if>" id="rue" name="rue" placeholder="Votre adresse">
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
			<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30016 || code eq 20006 }">error-field</c:if></c:forEach></c:if>" id="codePostal" name="codePostal" placeholder="CP">
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
				<input type="text" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30017 }">error-field</c:if></c:forEach></c:if>" id="ville" name="ville" placeholder="Ville">
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
			<input type="email" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30013 || code eq 20002 }">error-field</c:if></c:forEach></c:if>" id="email" name="email" aria-describedby="emailHelp">
			<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
			<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30013 || code eq 20002 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>				
		</div>
		<div class="form-group">
			<label for="password">Mot de Passe</label>
			<input type="password" class="form-control <c:if test='${!empty listeCodesErreur}'><c:forEach var="code" items="${listeCodesErreur}"><c:if test="${ code eq 30018 || code eq 20007 }">error-field</c:if></c:forEach></c:if>" id="password" name="password">
			<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30018 || code eq 20007 }">
                		<div class="invalid-feedback" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>				
		</div>
		<button type="submit" class="btn btn-primary">S'inscrire</button>
	</form>
	
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>



