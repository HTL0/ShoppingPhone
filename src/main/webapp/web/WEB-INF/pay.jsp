<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/web/css/bootstrapCss.jsp"%>
<script>
    function validate(){
        if(email.value == '' || address.value == ''){
            alert('Please enter a Email and address');
            return false;
        }
        
    }
</script>
<title>Insert title here</title>
</head>
<body>


	<h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Payment</h3>
	<form class="mb-5" name="payForm" onsubmit = "return validate()" action="${pageContext.request.contextPath}/PayController" method = "POST">
		
		<div class="form-outline mb-5">
			<input type="text" id="email" name="email" class="form-control form-control-lg"
				value="${name != null ? name : '' }" /> <label class="form-label" for="typeText">Customer
				Name</label><label class="text-danger">*</label>
		</div>

		<div class="form-outline mb-5">
			<input type="text" id="address" name="address" class="form-control form-control-lg"
				value="${address != null ? address : '' }" /> <label class="form-label" for="typeName">Customer
				address</label><label class="text-danger">*</label>
		</div>

		<div class="form-outline mb-5">
			<input type="text" name="discount" class="form-control form-control-lg"
				value="" /> <label class="form-label" for="typeName">Discount
				code(if any)</label>
		</div>

		<button type="submit" class="btn btn-primary btn-block btn-lg">Buy
			now</button>

		<h5 class="fw-bold mt-5" style="position: absolute;">
			<a href="${pageContext.request.contextPath}/PagingController"><i class="fa fa-long-arrow-left"></i>Back to
				shopping</a>
		</h5>

	</form>

</body>
</html>