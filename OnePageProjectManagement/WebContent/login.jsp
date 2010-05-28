<%@ include file="/include/header.jspfrag"%>
<html:errors />
<center><html:form action="/Login.do">
	<table width=150 height=120 background="images/login.png"
		style="background-repeat: no-repeat">
		<tr>

			<td><font color=#000000>USERNAME&nbsp;:</font></td>

			<td><html:text property="username" />
		</tr>
		<tr>

			<td><font color=#FFFFFF>PASSWORD&nbsp;:</font></td>

			<td><html:password property="password" />
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td><html:submit>LOGIN</html:submit></td>
		</tr>

	</table>
</html:form></center>
<%@ include file="/include/footer.jspfrag"%>
