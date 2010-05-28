<%@ include file="/include/header.jspfrag" %>
<%@ include file="/include/menu.jsp" %>



<p>
<c:if test="${user.role=='manager'}">
<html:link forward="editUser">Add New User</html:link>
</c:if>
</p>


<p>
<c:if test="${user.role=='project manager'}">
<html:link forward="editProject">Add New Project</html:link>
</c:if>
</p>

<c:forEach items='${projects}' var='project'>
	<c:set var="even" value="${!even}"/>
	<tr class="${even?'bglo':'bghi'}">
	<td><c:out value="${project.name}"/></td>
	<td>    Leader : <c:out value="${user.nameSurname}"/>, </td>
	<td>    Date Interval : <c:out value="${project.startDate}"/> - <c:out value="${project.finishDate}"/></td>
    
    <c:if test="${user.role=='project manager'}">
      <td><html:link action="/EditProjectHeader" paramId="id" paramName="project" paramProperty="id">
	    EDIT</html:link>
      </td>
    </c:if>
	</br>
	<td>Objective : <c:out value="${project.objective}"/> </td>
	</br>
	</br>
	</tr>
</c:forEach>

<c:if test="${empty projects}">
<td>No Project exists.</td>
</c:if>

<%@ include file="/include/footer.jspfrag" %>

