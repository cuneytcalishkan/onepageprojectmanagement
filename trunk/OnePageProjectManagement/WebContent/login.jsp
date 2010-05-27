<%@ include file="/include/header.jspfrag" %>

<h2>login:</h2> <html:errors/>

<html:form action="/Login.do">

<tr>
<td>username:</td>
<td><html:text property="username"/>
</tr>
<br></br>
<tr>
<td>password:</td>
<td><html:password property="password"/>
</tr>
<br></br>
<tr>
<td>&nbsp;</td>
<td><html:submit>login</html:submit></td>
</tr>


</html:form>

<%@ include file="/include/footer.jspfrag" %>
