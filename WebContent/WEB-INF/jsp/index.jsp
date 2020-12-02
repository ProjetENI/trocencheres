<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>


	<!-- Remplit à titre d'exemple pour le moment-->
	<div class="container">
	
		<!-- 	CONTENU DE LA PAGE INDEX -->
		<div class="row text-center">
	    <div class="col">Informatique</div>
	    <div class="col">Ameublement</div>
	    <div class="w-100"></div>
	    <div class="col">Vêtement</div>
	    <div class="col">Sport et Loisirs</div>
	  </div>
	</div>


<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>