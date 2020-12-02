<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<ul>
<li>Mes enchères en cours</li>
<li>Mes articles suivis</li>
<li class="nav-item active">
			<a class="nav-link" href="ModifierParametreServlet">Modifier mes paramètres<span class="sr-only">(current)</span></a>
			</li>
<li class="nav-item active">
			<a class="nav-link" href="ModifierMotDePasseServlet">Modifier mon mot de passe<span class="sr-only">(current)</span></a>
			</li>
<li class="nav-item active">
			<a class="nav-link" href="SupprimerCompte.jsp">Supprimer mon compte<span class="sr-only">(current)</span></a>
			</li>			
</ul>


<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>