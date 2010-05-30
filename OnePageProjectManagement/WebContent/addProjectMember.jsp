<%@ include file="/include/header.jspfrag"%>

<center>
<h2>Add Project Member</h2>
<html:form action="/AddProjectMemberSaver">

	<table border='0'>
		<table border="1" cellpadding="0" cellspacing="2">
		<tr>
			<td><html:select property="projectMember">
			<c:forEach items='${members}' var='member'>
			<c:if test='${fn:contains(alreadyMembers,member)}'> 
			<html:option value='${member.id }'>
			<c:out value='${member.username }'/></html:option>
			</c:if>
			</c:forEach>
			</html:select></td>
		</tr>
	</table>
			<td>&nbsp;</td>
			<td><html:submit>Add Project Member</html:submit> 
	</table>
	

</html:form></center>


<%@ include file="/include/footer.jspfrag"%>