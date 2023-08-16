<div class="col-lg-2 col-md-3 col-sm-3 px-0 "
	style="background-color: #293847;">
	<div class="nav  flex-column px-3 pt-2 min-vh-100">
		<h3>
			<a href="web/admin/index.jsp" class="nav-link text-center text-warning">Dash board</a>
		</h3>
		<hr>
		<a class="nav-link btn btn-info ${listS != null ? 'active' : '' }"
			href="${pageContext.request.contextPath}/AccountController">Staff
			List</a> 
		<a class="nav-link btn btn-info ${listP != null ? 'active' : '' }"
			href="${pageContext.request.contextPath}/ListController">Product
			list</a>
	</div>
</div>