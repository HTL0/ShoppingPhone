<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "/web/css/bootstrapCss.jsp" %>
<link href="${pageContext.request.contextPath}/web/css/style.css" rel="stylesheet" type="text/css">
<title>Home</title>
</head>
<body>
<header>
	<%-- <jsp:directive.include file = "header.jsp" /> --%>
	<jsp:include page="header.jsp"></jsp:include>
</header>
<!-- body -->
<div class="row">

<!-- Product list -->
<c:if test="${listP != null}">
	<jsp:include page="view.jsp"></jsp:include>
</c:if>
<!-- End product list -->
<!-- Search list -->
<c:if test="${products != null}">
	<jsp:include page="search.jsp"></jsp:include>
</c:if>
<!-- End search list -->
<!-- Product detail -->
<c:if test="${product != null}">
	<jsp:include page="infoProduct.jsp"></jsp:include>
</c:if>
<!-- End Product detail -->

</div>
<!-- End body -->
<footer>
	<%-- <%@ include file = "footer.jsp" %> --%>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>