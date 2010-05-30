<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>
<center>
<h2>User Operations</h2>

<html:form action="/EditUserSaver">

	<html:hidden property="id" />

	<table border='0'>

		<tr>
			<td>Username&nbsp;:</td>
			<td><html:text property="userName" /><html:errors
				property="userName" /></td>
		</tr>

		<tr>
			<td>Password&nbsp;:</td>
			<td><html:text property="password" /><html:errors
				property="password" /></td>
		</tr>

		<tr>
			<td>Name Surname&nbsp;:</td>
			<td><html:text property="nameSurname" /><html:errors
				property="nameSurname" /></td>
		</tr>

		<tr>
			<td>Role&nbsp;:</td>
			<td><html:select property="role" disabled="${user.role=='project manager' }">
				<html:option value="manager">Manager</html:option>
				<html:option value="project manager">Project Manager</html:option>
				<html:option value="project member">Project Member</html:option>
			</html:select></td>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td><html:submit>Save</html:submit> 
			<c:if test="${(not empty userForm.id) && (user.role=='manager' )}">

				<a href="javascript:Popup()" alt="" width="8" height="10" border="0" />
				Delete User</a>
			</c:if></td>
		</tr>
	</table>

</html:form></center>
<script language="javascript">
	function Popup() {
		sure = confirm("Are you sure?");
		if (sure) {
			window.location = "DeleteUser.do?id=" + $
			{
				userForm.id
			}
			;
		}
	}
</script>

<%@ include file="/include/footer.jspfrag"%>
