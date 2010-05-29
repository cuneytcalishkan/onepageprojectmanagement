<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>


<center>
<p><c:if test="${user.role=='manager'}">
	<html:link forward="editUser">Add New User</html:link>
</c:if></p>


<p><c:if test="${user.role=='project manager'}">
	<html:link forward="editProject">Add New Project</html:link>
</c:if></p>
<table border="1" bordercolor="#CCCCCC" cellspacing="0" cellpadding="2">
	<tr align="center">
		<td><b>Project Name</b></td>
		<td><b>Project Leader</b></td>
		<td><b>Date Interval</b></td>
		<c:if test="${user.role=='project manager'}">
			<td><b>Edit</b></td>
		</c:if>
		<td><b>Objective</b></td>
	</tr>
	<c:forEach items='${projects}' var='project'>
		<c:set var="even" value="${!even}" />
		<tr align="center" class="${even?'bglo':'bghi'}">
			<td><html:link action="/OnePageProject" paramId="id"
					paramName="project" paramProperty="id">
			<c:out value="${project.name}" />
			</html:link></td>
			<td><c:out value="${project.leader.nameSurname}" /></td>
			<td><c:out value="${project.startDate}" />&nbsp;&nbsp;-&nbsp;&nbsp;<c:out
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
</c:if></center>

<%@ include file="/include/footer.jspfrag"%>

