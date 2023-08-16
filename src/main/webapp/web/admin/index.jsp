<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/web/css/bootstrapCss.jsp"%>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}web/css/index.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid ">
		<div class="row flex-nowrap">
			<jsp:include page="header.jsp"></jsp:include>
			<div class="col-lg-10 col-md-9 col-sm-9 px-0 min-vh-100"
				style="background-color: #222F3C;">
				<jsp:include page="navLink.jsp"></jsp:include>
				<div>
				<jsp:include page="poster.jsp"></jsp:include>
				</div>
				<jsp:include page="staffList.jsp"></jsp:include>
			</div>
		</div>
	</div>
</body>
</html>