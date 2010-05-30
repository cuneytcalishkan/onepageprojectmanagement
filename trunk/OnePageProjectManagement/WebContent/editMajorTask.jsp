<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>

<center>
<h2>Major Task Operations</h2>
<html:form action="/EditMajorTaskSaver">

	<table border='0'>
		<tr>
			<td>Major Task Name&nbsp;:</td>
			<td><html:text property="name" /><html:errors property="name" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><html:submit>Save</html:submit> 
			<c:if test="${(not empty costForm.id) && (costForm.id !=0)}">
				<a href="javascript:Popup()" /> Delete Task</a>
			</c:if></td>
		</tr>
	</table>
	<table border="1" cellpadding="0" cellspacing="2">
		<th>Select Objective(s) from the List</th>
		<tr>
			<td><html:select property="objectivesList" multiple="true">
			<c:forEach items='${objectives}' var='objective'>
			<html:option value='${objective.id }'>
			<c:out value='${objective.name }'/></html:option>
			</c:forEach>
			</html:select></td>
		</tr>
	</table>

</html:form></center>

<script language="javascript">
	function Popup() {
		sure = confirm("Are you sure?");
		if (sure) {
			window.location = "DeleteMajorTask.do?id=" + $
			{
				costForm.id
			}
			;
		}
	}
</script>

<%@ include file="/include/footer.jspfrag"%>