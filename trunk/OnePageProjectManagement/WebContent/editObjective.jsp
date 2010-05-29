<%@ include file="/include/header.jspfrag"%>


<center>
<h2>Edit Operations</h2>

<%-- either add or edit based on id --%> <c:choose>
	<c:when test="${not empty userForm.id}">
		<h2>Edit Objective</h2>
	</c:when>
	<c:otherwise>
		<h2>Add an Objective</h2>
	</c:otherwise>
</c:choose> <html:form action="/EditObjectiveSaver">
	<tr>
		<td>Objective Name&nbsp;:</td>
		<td><html:text property="name"></html:text><html:errors
			property="name"></html:errors></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td><html:submit>Save</html:submit> <c:if
			test="${(not empty objectiveForm.id) && (user.role == 'project manager')}">
			<a href="javascript:Popup()"/>
			Delete Objective</a>
		</c:if></td>
	</tr>
</html:form></center>
<script language="javascript">
	function Popup() {
		sure = confirm("Are you sure?");
		if (sure) {
			window.location = "DeleteObjective.do?id=" + $
			{
				objectiveForm.id
			}
			;
		}
	}
</script>
<%@ include file="/include/footer.jspfrag"%>