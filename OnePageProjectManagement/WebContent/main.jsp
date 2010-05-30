<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>

<%@page import="controller.Utilizer"%>
<html:messages id="message" message="true">
	<h3><font color=#FF0000><bean:write name="message" /></font></h3>
</html:messages>
<table align="center">
	<tr>
		<c:if test="${user.role=='manager'}">
			<td align="center" valign="top">
			<p><b>LIST OF THE USERS</b></p>
			<table border="1" bordercolor="#ECECEC" cellspacing="0"
				cellpadding="2">
				<th>Name Surname</th>
				<th>Role</th>
				<c:forEach items='${users}' var='user'>
					<tr>
						<td><html:link style="text-decoration:none"
							action="/EditUser" paramId="id" paramName="user"
							paramProperty="id">[&nbsp;
							<c:out value="${user.nameSurname}" />&nbsp;]
						</html:link></td>
						<td><c:out value="${user.role}" /></td>
					</tr>
				</c:forEach>
			</table>
			<p><html:link style="text-decoration:none" forward="editUser">[ Add New User ]</html:link></p>

			</td>
		</c:if>

		<td align="center" valign="top">
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
					<td><html:link style="text-decoration:none"
						action="/OnePageProject" paramId="id" paramName="project"
						paramProperty="id">[&nbsp;
						<c:out value="${project.name}" />&nbsp;]
					</html:link></td>
					<td><c:out value="${project.leader.nameSurname}" /></td>
					<td><c:out value="${project.startDateAsString}" />&nbsp;&nbsp;-&nbsp;&nbsp;<c:out
						value="${project.finishDateAsString}" /></td>
					<c:if test="${user.role=='project manager'}">
						<td><html:link style="text-decoration:none"
							action="/EditProjectHeader" paramId="id" paramName="project"
							paramProperty="id">
	    [ EDIT ]</html:link></td>
					</c:if>
					<td><c:out value="${project.objective}" /></td>
				</tr>
			</c:forEach>
		</table>
		<c:if test="${user.role=='project manager'}">
			<p><html:link style="text-decoration:none" forward="editProject">[ Add New Project ]</html:link></p>
		</c:if></td>
	</tr>
	<tr align="center">
		<c:if test="${empty projects}">
			<td><b>No Project exists.</b></td>
		</c:if>
	</tr>
</table>
<%@ include file="/include/footer.jspfrag"%>