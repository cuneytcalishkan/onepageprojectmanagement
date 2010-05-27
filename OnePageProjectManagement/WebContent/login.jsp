<%@ include file="/include/header.jspfrag" %>

<h2>login:</h2>

<p>username: <b>admin</b></p>
<p>password: <b>secret</b></p>

<html:errors/>

<html:form action="/Login.do">

<tr>
<td>username:</td>
<td><html:text property="username"/></td>
</tr>

<tr>
<td>password:</td>
<td><html:password property="password"/></td>
</tr>

<tr>
<td>&nbsp;</td>
<td><html:submit>login</html:submit></td>
</tr>


</html:form>

<%@ include file="/include/footer.jspfrag" %>
