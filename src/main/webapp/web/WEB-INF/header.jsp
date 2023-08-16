<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Grid container -->
	<div class="header container-fluid">
		<div class="row mb-4 ">
		<!-- Logo -->
			<div class="col-lg-2 col-md-4 mb-md-0 text-white mt-4">
			<a class="text-white text-uppercase font-weight-bold" href="${pageContext.request.contextPath}/PagingController">
				<img src="${pageContext.request.contextPath}/web/media/MY_Logo.png"alt="Logo" width="50px">My Website<br/></a>
					<span class="text-while text-capitalize font-italic">Welcome to my website</span>
			</div>
		<!-- Logo End -->
		<!-- Search gird -->
		<div class="col-lg-10 col-md-8 mt-5 mb-md-0">
			<form name="searchForm" id="searchform" action = "${pageContext.request.contextPath}/SearchController2?index=1" method = "post">
			<div class = "form-row">
			 <div class="col-lg-2 col-md-3 mb-md-0 input-group">
				<select class = "form-control">
					<option value="all">categories</option>
					<option value="cellphone">Cell Phone</option>
					<option value="earphone">Ear Phone</option>
					<option value="speaker">Speaker</option>
					<option value="case">Case</option>
				</select>
			</div>
			<div class="col-lg-8 col-md-7 mb-md-0"> 
			<input class = "form-control" type="text" name="search" placeholder = "${searchKey == null ? 'What are you looking for?' : searchKey}"/>
			</div>
			<div class="col-lg-1 col-md-2 mb-md-0" >
			<button class = "btn bg-warning fa fa-search py-2" type="submit" name ="btnSearch"></button>
			</div>
			</div>
			</form>
		</div>
		<!-- Search gird End -->
		<!-- nav -->
	</div>
    <div class="topnav row text-white">
    <div class="col-lg-1 col-md-0 mb-md-0"></div>
    <div class="col-lg-7 col-md-8 mb-md-0">
    	<ul class="nav">
  		<li class="nav-item">
        	<a class="nav-link" href="${pageContext.request.contextPath}/PagingController">Home</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="${pageContext.request.contextPath}/PagingController">Products</a>
        </li>
        <li class="nav-item"> 
        	<a class="nav-link" href="#">About us</a>
        </li>
		</ul>
    </div>
    <div class = "col-lg-4 col-md-4 mb-md-0 float-right">
        <!-- <a type="button" data-toggle="modal" data-target="#loginModal">Login</a> -->
        <ul class="nav">
        	<li class="nav-item">
        	<a class="nav-link" href="${pageContext.request.contextPath}/AddToCartController">Cart</a>
        	</li>
        <c:if test="${login == true }">
        	<li class="nav-item">      	
        		<a class="nav-link font-italic text-warning" href="#">Welcome ${name}</a>
        	</li>
        	<li class="nav-item">
        		<a class="nav-link" href="${pageContext.request.contextPath}/logout?action=logout">Logout</a>
        	</li>
        </c:if>
        <c:if test="${login == false || login == null }">
        	<li class="nav-item">
        		<a class="nav-link" href="${pageContext.request.contextPath}/login?action=login">Login</a>
        	</li>
        	<li class="nav-item">
        		<a class="nav-link" href="${pageContext.request.contextPath}/RegisterController?action=register">Register</a>
        	</li>
        </c:if>
        </ul>
    </div>
    <!-- nav end-->
	</div>
	</div>
	<!-- Grid container -->
	<!-- login -->
	<%-- <div>
	    <jsp:directive.include file = "login.jsp" />
	</div> --%>
	<!-- End login -->
	
	

</body>
</html>