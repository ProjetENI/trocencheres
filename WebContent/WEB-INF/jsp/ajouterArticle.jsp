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

<div class="container">




</div>


<jsp:include page="/WEB-INF/fragment/footer.jsp">
    <jsp:param name="button" value="Footer_Value"/>
</jsp:include>