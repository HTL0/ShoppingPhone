<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${listS != null}">
		<div class="col-lg-0 col-md-0 mb-md-0">
			<div class="bg-warning">
				<h2>Members of the team</h2>
			</div>
			<table class="table text-white" style="background-color: #293847;">
				<thead>
					<tr>
						<th>EMAIL</th>
						<th>NAME</th>
						<th>ADDRESS</th>
						<th>PHONE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listS }" var="s">
						<tr>
							<td>${s.usr }</td>
							<td>${s.name }</td>
							<td>${s.address}</td>
							<td>${s.phone}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:if>