<%@ include file="/include/header.jspfrag"%>
<center>
<html:errors />
<html:form action="/Login.do">
	<table height=125 background="images/login.png"
		style="background-repeat: no-repeat">
		<tr>

			<td>USERNAME&nbsp;:</td>

			<td><html:text property="username" />
		</tr>
		<tr>

			<td>PASSWORD&nbsp;:</td>

			<td><html:password property="password" />
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td><html:submit>LOGIN</html:submit></td>
		</tr>

	</table>
</html:form></center>
<%@ include file="/include/footer.jspfrag"%>
