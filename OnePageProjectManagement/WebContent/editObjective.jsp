<%@ include file="/include/header.jspfrag"%>


<center>
<h2>Objective Operations</h2>
<html:form action="/EditObjectiveSaver">
	<html:hidden property="id"/>
	<tr>
		<td>Objective Name&nbsp;:</td>
		<td><html:text property="name"></html:text><html:errors
			property="name"></html:errors></td>
	</tr>
	<html:hidden property="projectId"/>
	<tr>
		<td>&nbsp;</td>
		<td><html:submit>Save</html:submit> <c:if
			test="${(not empty objectiveForm.id)}">
			<a href="javascript:Popup()" /> Delete Objective</a>
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