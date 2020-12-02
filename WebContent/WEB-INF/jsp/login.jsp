<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/fragment/header.jsp">
    <jsp:param name="onglet" value="Header_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/navbar.jsp">
    <jsp:param name="title" value="Navbar_Value"/>
</jsp:include>

<jsp:include page="/WEB-INF/fragment/banner.jsp">
    <jsp:param name="title" value="Banner_Value"/>
</jsp:include>


<!-- Remplit à titre d'exemple pour le moment-->
<div class="container">
<%--     <c:if test="${!empty listeUtilisateur}">
	    <div class="row d-flex justify-content-center align-items-center full-height">
	        <ul class="list-group col-12">
		        <c:forEach items="${listeUtilisateur}" var="lu">
		            <li class="list-group-item d-flex justify-content-between align-items-center">
		                ${lu.id} : ${lu.name}
		                <div class="list-buttons">
		                    <i class="fa fa-shopping-cart"></i>
		                    <i class="fa fa-trash"></i>
		                </div>
		            </li>
		        </c:forEach>
	        </ul>
	    </div>
    </c:if> --%>
</div>

<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>