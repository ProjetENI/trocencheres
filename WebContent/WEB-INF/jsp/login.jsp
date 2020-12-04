<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<!-- Remplit à titre d'exemple pour le moment-->
<div class="bgBlue d-flex justify-content-center align-items-center">
	<div class="formOuter">
		<div class="row m-0 h100">
			<div class="col-4 m-0 d-flex justify-content-center align-items-center">
				<img src="${pageContext.request.contextPath}/img/auction-2.png" class="img-full d-block mx-auto" alt="green auction" title="green auction"/>
		   	</div>
		   	<div class="col-8 curvedBg m-0 d-flex justify-content-end align-items-center">
		   		<div id="loginForm">
					<form method="post" action="ConnectionServlet">	
						<label for="identifiant">Identifiant</label><br/>
						<input type="text" id="identifiant" name="identifiant"/>
					
						
						<br /> 
						<label for="motdepasse">Mot de passe</label><br/>
						<input type="password" id="motdepasse" name="motdepasse"/>
						
						<br /> 
							
						<input type="submit" value="Connexion" class="button mx-auto" /> 

						<div class="register">
							Vous n'avez pas de compte ?<br/>
							<a href="InscriptionServlet">S'inscrire </a>
						</div>
					</form>
					
						
					<br />
					<%--  <% if(request.getAttribute("error") != null) {%>
		   			<div class="error"><%request.getAttribute("error");%></div>
		   			<%}%>--%>
		   			<div class="error">
		   				${vide}
		   				${error}
		   			</div>
		   		</div>
		   	</div>
		</div>
	</div>
</div>

     <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="js/script.js"></script>
    
</body>
</html>