<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>



<p><c:if test="${user.role=='manager'}">
	<html:link forward="editUser">Add New User</html:link>
</c:if></p>


<p><c:if test="${user.role=='project manager'}">
	<html:link forward="editProject">Add New Project</html:link>
</c:if></p>
<table border="1" bordercolor="#CCCCCC">
	<tr>
		<td>Project Name</td>
		<td>Project Leader</td>
		<td>Date Interval</td>
		<c:if test="${user.role=='project manager'}"><td>Edit</td></c:if>
		<td>Objective</td>
	</tr>
	<c:forEach items='${projects}' var='project'>
		<c:set var="even" value="${!even}" />
		<tr class="${even?'bglo':'bghi'}">
			<td><c:out value="${project.name}" /></td>
			<td><c:out value="${user.nameSurname}" /></td>
			<td><c:out value="${project.startDate}" /> - <c:out
				value="${project.finishDate}" /></td>
			<c:if test="${user.role=='project manager'}">
				<td><html:link action="/EditProjectHeader" paramId="id"
					paramName="project" paramProperty="id">
	    EDIT</html:link></td>
			</c:if>
			<td><c:out value="${project.objective}" /></td>
		</tr>
	</c:forEach>
</table>
<c:if test="${empty projects}">
	<td>No Project exists.</td>
</c:if>

<%@ include file="/include/footer.jspfrag"%>

