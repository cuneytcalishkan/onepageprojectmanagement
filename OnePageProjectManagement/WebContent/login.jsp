<%@ include file="/include/header.jspfrag" %>

<h2>login:</h2>

<html:form action="/Login.do">

<tr>
<td>username:</td>
<td><html:text property="username"/><html:errors property="username"/></td>
</tr>
<tr> </tr>
<tr>
<td>password:</td>
<td><html:password property="password"/><html:errors property="password"/></td>
</tr>

<tr>
<td>&nbsp;</td>
<td><html:submit>login</html:submit></td>
</tr>


</html:form>

<%@ include file="/include/footer.jspfrag" %>
