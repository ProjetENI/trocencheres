<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>


	<!-- Remplit � titre d'exemple pour le moment-->
	<div class="container">
	
		<!-- 	CONTENU DE LA PAGE INDEX -->
		<div class="row">
	    	<div class="col h200 d-flex align-items-center justify-content-center">Informatique</div>
	    	<div class="col h200 d-flex align-items-center justify-content-center">Ameublement</div>
		    <div class="w-100"></div>
		    <div class="col h200 d-flex align-items-center justify-content-center">V�tement</div>
		    <div class="col h200 d-flex align-items-center justify-content-center">Sport et Loisirs</div>
	  	</div>
	</div>


<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>