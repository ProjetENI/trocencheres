<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Connection"/>
</jsp:include>


<!-- Remplit à titre d'exemple pour le moment-->
<div class="container">
	
	<fieldset>
	
		<legend>Connexion</legend>
		<p>Formulaire de connexion</p>
		<form method="post" action="connexion">	
			<label for="nom">Adresse email<span class="requis">*</span></label> 
			<input type="email" id="email" name="email"
				value="<c:out value="${utilisateur.email}"/>" size="20"
				maxlength="60" />
			<span class="erreur">${form.erreurs['email']}</span>
			
			<br /> 
			<label for="motdepasse">Mot de passe<span class="requis">*</span></label>
			<input type="password" id="motdepassse"
				name="motdepasse" size="20" maxlength="20" />
			<span class="erreur">${form.erreurs['motdepasse']}</span> 
				<br /> 
				
			<input type="submit" value="Connexion" class="sansLabel" /> 
		</form>
			
			<br />

		<p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	</fieldset>
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>