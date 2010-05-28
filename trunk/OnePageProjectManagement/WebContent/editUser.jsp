<%@ include file="/include/header.jspfrag" %>

<h2>Edit User</h2>

<%-- either add or edit based on id --%>
<c:choose>
  <c:when test="${not empty userForm.id}">
     <h2>Edit User:</h2>
  </c:when>
  <c:otherwise>
     <h2>Add a User:</h2>
  </c:otherwise>
</c:choose>


<html:form action="/EditUserSaver">

<html:hidden property="id"/>

<table border='0'>

<tr>
<td>Username : </td>
<td><html:text property="userName"/><html:errors property="userName"/>
</td>
</tr>

<tr>
<td>Password : </td>
<td>
<html:text property="password"/><html:errors property="password"/>
</td>
</tr>

<tr>
<td>Name Surname : </td>
<td>
<html:text property="nameSurname"/><html:errors property="nameSurname"/>
</td>
</tr>

<tr>
<td>Role : </td>
<td>
<html:select property="role">
<html:option value="manager">Manager</html:option>
<html:option value="project manager">Project Manager</html:option>
<html:option value="project member">Project Member</html:option>
</html:select>
</td>
</tr>

<tr>
<td>&nbsp;</td>
<td>
<html:submit>Save</html:submit>

<c:if test="${not empty userForm.id}">
	
<a href="javascript:Popup()"  alt="" width="8" height="10" border="0" />
	    Delete User</a>
	    </c:if>

</td>
</tr>
</table>

</html:form>

<script language="javascript">
function Popup(){
	sure = confirm("Are you sure?");
	if(sure){
		window.location="DeleteUser.do?id=" + ${userForm.id};
	}
}
</script>

<%@ include file="/include/footer.jspfrag" %>
