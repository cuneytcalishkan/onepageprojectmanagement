<%@ include file="/include/header.jspfrag" %>

<h2>Edit Project</h2>

<%-- either add or edit based on id --%>
<c:choose>
  <c:when test="${not empty projectForm.id}">
     <h2>Edit Project:</h2>
  </c:when>
  <c:otherwise>
     <h2>Add a Project:</h2>
  </c:otherwise>
</c:choose>


<html:form action="/EditProjectSaver">

<html:hidden property="id"/>

<table border='0'>

<tr>
<td>Project Name : </td>
<td><html:text property="name"/><html:errors property="name"/>
</td>
</tr>

<tr>
<td>Project Leader : </td>
<td>
<html:text property="leader" disabled="true"/>
</td>
</tr>

<tr>
<td>Objective : </td>
<td>
<html:text property="objective"/>
</td>
</tr>

<tr>
<td>Start Date : </td>
<td>
<html:text property="startDate"/> 
</td>
<td>&nbsp;</td>

<td>Start Date : </td>
<td>
<html:text property="finishDate"/> 
</td>
</tr>
<tr>
Format : DD-MM-YYYY
<html:errors property="date"/>
</tr>

<tr>
<td>&nbsp;</td>
<td>
<html:submit>Save</html:submit>

<c:if test="${not empty projectForm.id}">
	
<a href="javascript:Popup()"  alt="" width="8" height="10" border="0" />
	    Delete observation</a>
	    </c:if>

</td>
</tr>
</table>

</html:form>

<script language="javascript">
function Popup(){
	sure = confirm("Are you sure?");
	if(sure){
		window.location="DeleteProject.do?id=" + ${projectForm.id};
	}
}
</script>

<%@ include file="/include/footer.jspfrag" %>
