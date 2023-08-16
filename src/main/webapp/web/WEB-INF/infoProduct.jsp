<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file = "/web/css/bootstrapCss.jsp" %>
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
<div class="row d-flex justify-content-center">
<div class="col-md-10">
<h1>${product.name}</h1>
<hr>
</div>
</div>
    <div class="row d-flex justify-content-center">
        <div class="col-lg-10 col-md-10 mb-md-0">
            <div class="card">
                <div class="row">
                    <div class="col-lg-6 col-md-6 mb-md-0">
                        <div class="images p-3">
                            <div class="text-center p-4"> <img class="img-fluid" src="${product.src}"/> </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 mb-md-0">
                        <div class="product p-4">
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="d-flex align-items-center">
                                	<button class="btn btn-primary text-white" type="button" name="back" onclick="history.back()"><i class="fa fa-long-arrow-left"></i> <span class="ml-1">Back</span></button>
                                </div> 
                                <i class="fa fa-shopping-cart text-muted"></i>
                            </div>
                                
                            <div class="mt-4 mb-3">
                            <h1 class="text-uppercase text-danger">$${product.price}</h1>
                            <h5 class="text-uppercase ">Product Description:</h5>
                            </div>
                            <p>${product.description}</p>
                            <div class="cart mt-4 align-items-center"> 
                            	<a href="${pageContext.request.contextPath}/AddToCartController?action=add&id=${product.id}"><button class="btn btn-warning text-uppercase text-white mr-2 px-4">Add to cart</button></a>
                            	<i class="fa fa-heart text-muted"></i> 
                            	<i class="fa fa-share-alt text-muted"></i> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>