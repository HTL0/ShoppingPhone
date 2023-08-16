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
			<div class="col-lg-10 col-md-9 px-0 min-vh-100 "
				style="background-color: #222F3C;">
				<jsp:include page="navLink.jsp"></jsp:include>
	<c:if test="${listP != null }">
	<div class = "mb-2">
	<form name="searchForm" id="searchform"
		action="${pageContext.request.contextPath}/SearchController"
		method="post">
		<div class="form-row">
			<div class="col-lg-2 col-md-3 mb-md-0 input-group">
				<select class="form-control">
					<option value="all">categories</option>
					<option value="cellphone">Cell Phone</option>
					<option value="earphone">Ear Phone</option>
					<option value="speaker">Speaker</option>
					<option value="case">Case</option>
				</select>
			</div>
			<div class="col-lg-8 col-md-7 mb-md-0">
				<input class="form-control" type="text" name="search"
					placeholder="${searchKey == null ? 'What are you looking for?' : searchKey}" />
			</div>
			<div class="col-lg-1 col-md-2 mb-md-0">
				<button class="btn bg-warning fa fa-search py-2" type="submit"
					name="btnSearch"></button>
			</div>
		</div>
	</form>
	</div>
	<div class="col-lg-0 col-md-0 mb-md-0">
	<div class="bg-warning">
				<h2>PRODUCT LIST</h2>
			</div>
			<a href="#" class="btn bg-warning my-1">Add new product</a>
			<table class="table text-white" style="background-color: #293847;">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Src</th>
						<th>Description</th>
						<th>Price</th>
						<th>Type</th>
						<th>Brand</th>
						<th>Setting</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listP }" var="p">
						<tr>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td><img class="img-fluid" style="width: 100px" src="${p.src}"></td>
							<td>${p.description}</td>
							<td>$${p.price}</td>
							<td>${p.type}</td>
							<td>${p.brand}</td>
							<td>
								<a href="#" class="btn bg-warning my-1">Update</a>
								<a href="#" class="btn bg-warning my-1">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</div>
</c:if>
</div>
</div>
</div>

</body>
</html>