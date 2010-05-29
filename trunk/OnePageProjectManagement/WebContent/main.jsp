<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>

<%@page import="controller.Utilizer"%>

<table align="center">
	<tr>
		<c:if test="${user.role=='manager'}">
			<td align="center">
			<p><html:link forward="editUser">Add New User</html:link></p>
			<table border="1" bordercolor="#ECECEC" cellspacing="0"
				cellpadding="2">
				<th>Name Surname</th>
				<th>Role</th>
				<c:forEach items='${users}' var='user'>
					<tr>
						<td><html:link action="/EditUser" paramId="id"
							paramName="user" paramProperty="id">
							<c:out value="${user.nameSurname}" />
						</html:link></td>
						<td><c:out value="${user.role}" /></td>
					</tr>
				</c:forEach>


			</table>

			</td>
		</c:if>

		<td align="center"><c:if test="${user.role=='project manager'}">
		<p><html:link forward="editMajorTask">Add New MajorTask</html:link></p>
			<p><html:link forward="editProject">Add New Project</html:link></p>
		</c:if>
		<p><b>LIST OF THE PROJECTS</b></p>
		<table border="1" bordercolor="#ECECEC" cellspacing="0"
			cellpadding="2">
			<th>Project Name</th>
			<th>Project Leader</th>
			<th>Date Interval</th>
			<c:if test="${user.role=='project manager'}">
				<th>Edit</th>
			</c:if>
			<th>Objective</th>
			<c:forEach items='${projects}' var='project'>
				<c:set var="even" value="${!even}" />
				<tr align="center" class="${even?'bglo':'bghi'}">
					<td><html:link action="/OnePageProject" paramId="id"
						paramName="project" paramProperty="id">
						<c:out value="${project.name}" />
					</html:link></td>
					<td><c:out value="${project.leader.nameSurname}" /></td>
					<td><c:out value="${project.startDateAsString}" />&nbsp;&nbsp;-&nbsp;&nbsp;<c:out
						value="${project.finishDateAsString}" /></td>
					<c:if test="${user.role=='project manager'}">
						<td><html:link action="/EditProjectHeader" paramId="id"
							paramName="project" paramProperty="id">
	    EDIT</html:link></td>
					</c:if>
					<td><c:out value="${project.objective}" /></td>
				</tr>
			</c:forEach>
		</table>
		</td>
	</tr>
</table>
<c:if test="${empty projects}">
	<td>No Project exists.</td>
</c:if>

<%@ include file="/include/footer.jspfrag"%>

