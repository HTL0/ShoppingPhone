<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "/web/css/bootstrapCss.jsp" %>
<link href="${pageContext.request.contextPath}/web/css/style.css" rel="stylesheet" type="text/css">
<script>
    function validate(){
        if(username.value == '' || password.value == ''){
            alert('Please enter a username and password');
            return false;
        }
    }
</script>
<title>Insert title here</title>
</head>
<body>
<header>
	<%-- <jsp:directive.include file = "header.jsp" /> --%>
	<jsp:include page="header.jsp"></jsp:include>
</header>
<!-- modal -->
<!-- <div class="modal fade" id ="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModal" aria-hidden="true">
<div class="modal-dialog modal-dialog-centered modal-lg ">
<div class="modal-content rounded-3 modalLogin">
<div class="modal-body"> -->
<!-- Grid container -->
  <div class="container">
  <!-- Card group -->
	<div class="row card-group py-5">
	<!-- Card 1 -->
	    <div class="card py-5">
	        <form class="card-body px-3" name="loginForm" id="loginform" onsubmit = "return validate()" action = "${pageContext.request.contextPath}/login" method = "POST">
	            <input type="hidden" name="action" value="dologin" />
                <div class="card-title text-center mt-4">
                    <h2 class="font-weight-bold">Sign in</h2>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control bg-light" id="username"  placeholder="Username"
                    name="username" value="<%= session.getAttribute("username") != null ? session.getAttribute("username") : "" %>" />
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control bg-light" id="password"  placeholder="Password"
                    name="password" value="<%= session.getAttribute("password") != null ? session.getAttribute("password") : "" %>" />
                </div>
                <div class="form-check">
                	<input type="checkbox" class="form-check-input " id="remember" name="remember" value="1" 
                	<%= "1".equals(session.getAttribute("remember")) ? "checked = 'checked'" : "" %> />Remember me 
                </div>
                <div class = "my-3 text-center">
                    <a class = "font-weight-bold text-secondary" href="#" >Forgot your Password?</a>
                </div>
                <div class="text-center pb-3 ">
                <button type="submit" class="btn btn-danger rounded-pill font-weight-bold px-5" 
                id="LoginBtn">Login</button>
                </div>
                <div class="text-center pt-3">
                <h6> <%= session.getAttribute("error") != null ? session.getAttribute("error"): "" %></h6>
                </div>
            </form>
	    </div>
	<!-- End Card 1 -->
	    
	<!-- Card 2 -->
	    <div class="card py-5 px-2 colorCustom "  style= "background-color: #222F3C">
	      <div class="card-body text-white ">
	        <h2 class="card-text text-center font-weight-bold pt-5 mt-3">Welcome Back!</h2>
	        <p class="text-center">to keep connected with us please login with your personal info</p>
	      </div>
	    </div>
	<!-- End card 2 -->
	</div>
	<!-- End card group -->
  </div>
<!-- End Grid container -->

<!-- </div>
</div>
</div>
</div> -->
<!-- end modal -->
<footer>
	<%-- <%@ include file = "footer.jsp" %> --%>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>
</body>
</html>