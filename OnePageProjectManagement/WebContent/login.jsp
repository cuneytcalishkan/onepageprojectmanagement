<%@ include file="/include/header.jspfrag"%>
<center>
<html:messages id="message" message="true">
  <h2><bean:write name="message"/></h2>
</html:messages>
<html:form action="/Login.do">
	<table height=125 background="images/login.png"
		style="background-repeat: no-repeat">
		<tr>

			<td>USERNAME&nbsp;:</td>

			<td><html:text property="username" value="natan"/>
		</tr>
		<tr>

			<td>PASSWORD&nbsp;:</td>

			<td><html:password property="password" value="1234"/>
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td><html:submit>LOGIN</html:submit></td>
		</tr>

	</table>
</html:form></center>
<%@ include file="/include/footer.jspfrag"%>
