<%@ include file="/include/header.jspfrag"%>


<center>
<h2>Summary Operations</h2>

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
		<td><html:submit>Save</html:submit><c:if
				test="${not empty summaryForm.id}">

				<a href="javascript:Popup()"/>
				Delete Summary</a>
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