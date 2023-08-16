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
		if(userMail.value == '' || name.value == '' || password.value == '' || rePassword.value == '' || address.value == ''){
			alert('Please enter UserName/Email, Password, RePassword and Address !');
			return false;
		}else if(!(password.value === rePassword.value)){
			alert('RePassword not incorrect !');
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
<!-- Grid container -->
  <div class="container">
	<!-- Card  -->
	    <div class="card col-lg-0 py-5">
	        <form class="card-body px-3" name="regisForm" id="regisForm" onsubmit = "return validate()" action = "${pageContext.request.contextPath}/RegisterController" method = "POST">
	            <input type="hidden" name="action" value="doReg" />
                <div class="card-title text-center mt-4">
                    <h2 class="font-weight-bold">Create Account</h2>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control bg-light" id="userMail"  
                    name="userMail" value="${userMail != null ? userMail : ''}" />
                    <label class="form-label" for="typeText">UserName/Email</label><label class="text-danger">*</label>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control bg-light" id="name"  
                    name="name" value="${name != null ? name : ''}" />
                    <label class="form-label" for="typeText">Name</label><label class="text-danger">*</label>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control bg-light" id="password"  
                    name="password" value="" />
                    <label class="form-label" for="typeText">Password</label><label class="text-danger">*</label>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control bg-light" id="rePassword"  
                    name="rePassword" value="" />
                    <label class="form-label" for="typeText">RePassword</label><label class="text-danger">*</label>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control bg-light" id="address" 
                    name="address" value="${address != null ? address : ''}" />
                    <label class="form-label" for="typeText">Address</label><label class="text-danger">*</label>
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control bg-light" id="phone"
                    name="phone" value="${phone != null ? phone : ''}"/>
                    <label class="form-label" for="typeText">Phone Number</label>
                </div>
                <div class = "my-3 text-center">
                    <a class = "font-weight-bold text-secondary" href="${pageContext.request.contextPath}/login?action=login" >Have already an account?</a>
                </div>
                <div class="text-center pb-3 ">
                <button type="submit" class="btn btn-danger rounded-pill font-weight-bold px-5" 
                id="regBtn">Register</button>
                </div>
                <div class="text-center text-danger font-weight-bold pt-3">
                <h6> ${error != null ? error : ''}</h6>
                </div>
            </form>
	    </div>
	<!-- End Card  -->
	</div>


<footer>
	<%-- <%@ include file = "footer.jsp" %> --%>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>

</body>
</html>