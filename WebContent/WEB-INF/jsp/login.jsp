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
		<form method="post" action="ConnectionServlet">	
			<label for="email">Adresse email<span class="requis">*</span></label> 
			<input type="email" id="email" name="email" size="20" maxlength="60" required/>
		
			
			<br /> 
			<label for="motdepasse">Mot de passe<span class="requis">*</span></label>
			<input type="password" id="motdepasse" name="motdepasse" size="20" maxlength="60" required/>
			
			<br /> 
				
			<input type="submit" value="Connexion" class="button" /> 
			<a class="button" href="InscriptionServlet">S'inscrire </a>
		</form>
		
			
			<br />
			<%--  <% if(request.getAttribute("error") != null) {%>
   			<div class="error"><%request.getAttribute("error");%></div>
   			<%}%>--%>
   			<div class="error">
   				${vide}
   				${error}
   			</div>
   				</fieldset>
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>