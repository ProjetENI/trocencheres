<%@page import="fr.eni.trocencheres.exceptions.LecteurMessage" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Inscription"/>
</jsp:include>


<!-- Remplit à titre d'exemple pour le moment-->
<div class="container">
<form action="InscriptionServlet" method="POST">
		
		<div class="row">
			<div class="form-group col-4">
				<label for="prenom">Prénom</label>
				<input type="text" class="form-control" id="prenom" name="prenom" placeholder="Votre prénom">
				<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30012 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                    </c:forEach> 
				</c:if>
			</div>

			<div class="form-group col-4">
				<label for="nom">Nom</label>
				<input type="text" class="form-control" id="nom" name="nom" placeholder="Votre Nom">
				<c:if test="${!empty listeCodesErreur}">
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30011 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                    </c:forEach> 
                </c:if>
	       </div>	 

			<div class="form-group col-4">
				<label for="pseudo">Pseudo</label>
				<input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Votre pseudo">
				<c:if test="${!empty listeCodesErreur}">
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30010 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                    </c:forEach> 
                </c:if>
			</div>
		</div>

		<div class="form-group">
			<label for="rue">N° et nom de rue</label>
			<input type="text" class="form-control" id="rue" name="rue" placeholder="Votre adresse">
			<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30015 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>				
		</div>
		<div class="row">
			<div class="form-group col-6">
				<label for="codePostal">Code Postal</label>
			<input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="CP">
			<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30016 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>				
			</div>
			<div class="form-group col-6">
				<label for="ville">Ville</label>
				<input type="text" class="form-control" id="ville" name="ville" placeholder="Ville">
				<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30017 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>				
			</div>
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
			<small id="emailHelp" class="form-text text-muted">Aucune crainte, nous ne pratiquons pas le SPAM.</small>
			<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30013 }">
                		<div class="alert alert-danger" role="alert">
                			${LecteurMessage.getMessageErreur(code)}
                			</div>
                	 	</c:if>
                	 	
                    </c:forEach> 
          		
                </c:if>				
		</div>
		<div class="form-group">
			<label for="password">Mot de Passe</label>
			<input type="password" class="form-control" id="password" name="password">
			<c:if test="${!empty listeCodesErreur}">               	 
                 	<c:forEach var="code" items="${listeCodesErreur}">
                		<c:if test="${ code eq 30018 }">
                		<div class="alert alert-danger" role="alert">
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



