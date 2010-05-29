<%@ include file="/include/header.jspfrag"%>


<center>
<h2>Edit Operations</h2>

<%-- either add or edit based on id --%> <c:choose>
	<c:when test="${not empty summaryForm.id}">
		<h2>Edit Summary</h2>
	</c:when>
	<c:otherwise>
		<h2>Add Summary</h2>
	</c:otherwise>
</c:choose> 

<html:form action="/EditSummarySaver">
	<html:hidden property="id"/>
	<tr>
		<td>Summary Description&nbsp;:</td>
		<td><html:text property="description"></html:text><html:errors
			property="description"></html:errors></td>
	</tr>
	<html:hidden property="projectId"/>
	<tr>
		<td>&nbsp;</td>
		<td><html:submit>Save</html:submit> <c:if
			test="${(not empty summaryForm.id) && (user.role == 'project manager')}">
			<a href="javascript:Popup()" /> Delete Summary</a>
		</c:if></td>
	</tr>
</html:form></center>
<script language="javascript">
	function Popup() {
		sure = confirm("Are you sure?");
		if (sure) {
			window.location = "DeleteSummary.do?id=" + $
			{
				summaryForm.id
			}
			;
		}
	}
</script>
<%@ include file="/include/footer.jspfrag"%>