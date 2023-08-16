<div class="nav justify-content-end text-white my-2 "
	style="background-color: #222F3C;">
	<span class="nav-link">Welcome <%=session.getAttribute("username")%></span>
	<a class="nav-link btn bg-info text-white"
		href="${pageContext.request.contextPath}/logout?action=logout">Logout</a>
</div>
