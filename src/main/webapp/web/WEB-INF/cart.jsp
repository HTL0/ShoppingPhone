<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "/web/css/bootstrapCss.jsp" %>
<link href="${pageContext.request.contextPath}/web/css/style.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<header>
	<%-- <jsp:directive.include file = "header.jsp" /> --%>
	<jsp:include page="header.jsp"></jsp:include>
</header>
<section class="h-100 h-custom">
  <div class="container h-100 py-5">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card shopping-cart" style="border-radius: 15px;">
          <div class="card-body text-black">

            <div class="row">
            <c:if test="${completed != 1 }">
              <div class="col-lg-6 px-5 py-4">

                <h3 class="mb-5 pt-2 text-center fw-bold text-uppercase">Products in card: </h3>
                <c:if test="${cart.items.size() == 0 || cart.items == null}">
                	<div class="text-center">
                		<h3 class="text-danger">Your cart is empty!</h3>
                		<p class="text-dark">Your have no items in your shopping cart.<br>Let't go buy something!</p>
                		<a href="${pageContext.request.contextPath}/PagingController"><button class="btn btn-primary text-uppercase text-white mr-2 px-4">Shop now</button></a>
                	</div>
                </c:if>
				
                  <c:forEach items = "${cart.items}" var="o">
                	<h5><a class="text-muted" href="${pageContext.request.contextPath}/AddToCartController?action=delete&id=${o.id}">x</a></h5>
                	<div class="d-flex align-items-center mb-5">
	                <div class="flex-shrink-0">
	                  <a href="${pageContext.request.contextPath}/InformationProductController?id=${o.id}"><img src="${o.src }" class="img-fluid" style="width: 150px;"></a>
	                </div>
	                <div class="flex-grow-1 ms-3">
                    <h5 class="text-primary"><a href="${pageContext.request.contextPath}/InformationProductController?id=${o.id}">${o.name}</a></h5>
                    <h6 style="color: #9e9e9e;">ID:${o.id}</h6>
                    <div class="d-flex align-items-center">
                      <p class="fw-bold mb-0 me-5 pe-3 text-danger">$${Math.round((o.number * o.price) * 100.0)/100.0}</p>
                      <div class="def-number-input number-input safari_only ">
                      <form name="quantityForm" id="quantityform" action = "${pageContext.request.contextPath}/AddToCartController?action=quantity&id=${o.id}" method = "POST">
                        <input type="submit" style="visibility: hidden;" />
                        <button type="submit" onclick="this.parentNode.querySelector('input[type=number]').stepDown(); document.location.reload(true)"
                          class="btn btn-primary ml-2 px-2">-</button>
                        <input class="quantity fw-bold text-black w-25 " min="1" name="quantity" value="${o.number }"
                          type="number">
                        <button type="submit" onclick="this.parentNode.querySelector('input[type=number]').stepUp(); document.location.reload(true)"
                          class="btn btn-primary ml-1 px-2">+</button>
                      </form>
                      </div>
                    </div>              
                  </div>
                  </div>
                  </c:forEach>                
				<c:if test="${cart.items.size() != 0 && cart.items != null}">
                <hr class="mb-4" style="height: 2px; background-color: #1266f1; opacity: 1;">
                <div class="d-flex justify-content-between px-x">
                  <p class="fw-bold">Discount:</p>
                  <p class="fw-bold">$</p>
                </div>
                <div class="d-flex justify-content-between p-2 mb-2" style="background-color: #e1f5fe;">
                  <h5 class="fw-bold mb-0">Total:</h5>
                  <h5 class="fw-bold mb-0">$${cart.amount }</h5>
                </div>
				</c:if>
              </div>
              
              <!--Pay information-->
              <div class="col-lg-6 px-5 py-4">
              <jsp:include page="pay.jsp"></jsp:include>
              </div>
              <!--End Pay information-->
              </c:if>
              
            </div>
            
            <c:if test="${completed == 1 }">
            <!-- Payment completed -->
            <div class="row">
              <div class="col-lg-3"></div>
              <div class="col-lg-6 px-5 py-4 text-center">
	              <img src="${pageContext.request.contextPath}/web/media/payment_completed.png" alt="payment">
	              <h1>Payment Successful</h1>
	              <p>Thank you for your billing</p>
	              <a href="${pageContext.request.contextPath}/PagingController">
	              <button class="btn btn-success" ><i class="fa fa-long-arrow-left"></i>Back to	shopping</button></a>
              </div>
              <div class="col-lg-3"></div>
            </div>
			<!-- End payment completed -->
			</c:if>
			
          </div>
        </div>
      </div>
    </div>
  </div>
</section>


<footer>
	<%-- <%@ include file = "footer.jsp" %> --%>
	<jsp:include page="footer.jsp"></jsp:include>
</footer>

</body>
</html>