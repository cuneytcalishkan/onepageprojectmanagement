<%@ include file="/include/header.jspfrag"%>
<center>
<h2>Cost Operations</h2>

<html:form action="/EditCostSaver">

	<html:hidden property="id" />

	<table border='0'>

		<tr>
			<td>Budget&nbsp;:</td>
			<td><html:text property="budget" /><html:errors
				property="budget" /></td>
		</tr>

		<tr>
			<td>Expense&nbsp;:</td>
			<td><html:text property="expense" /><html:errors
				property="expense" /></td>
		</tr>

		<tr>
			<td>Color&nbsp;:</td>
			<td><html:text property="color" /><html:errors
				property="color" /></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td><html:submit>Save</html:submit> 
			<c:if test="${(not empty costForm.id) && (user.role=='project manager' )}">

				<a href="javascript:Popup()" />
				Delete Cost</a>
			</c:if></td>
		</tr>
	</table>

</html:form></center>
<script language="javascript">
	function Popup() {
		sure = confirm("Are you sure?");
		if (sure) {
			window.location = "DeleteCost.do?id=" + $
			{
				costForm.id
			}
			;
		}
	}
</script>

<%@ include file="/include/footer.jspfrag"%>
