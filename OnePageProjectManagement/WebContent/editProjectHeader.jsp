<%@ include file="/include/header.jspfrag"%>
<%@ include file="/include/menu.jsp"%>
<center>
<h2>Project Operations</h2>

<html:form action="/EditProjectHeaderSaver">

	<html:hidden property="id" />

	<table border='0'>

		<tr>
			<td>Project Name&nbsp;:</td>
			<td><html:text property="name" /><html:errors property="name" />
			</td>
		</tr>

		<tr>
			<td>Project Leader&nbsp;:</td>
			<td><html:text property="leader" disabled="true" /></td>
		</tr>

		<tr>
			<td>Objective&nbsp;:</td>
			<td><html:text property="objective" /></td>
		</tr>
		<tr>
			<td colspan="2">Months will be divided by this amount</td>
		</tr>
		<tr>
			<td>Slice Amount&nbsp;:</td>
			<td><html:text property="sliceAmount" /></td>
			<html:errors property="sliceAmount" />
		</tr>

		<tr>
			<td>Start Date&nbsp;:</td>
			<td><html:select property="startDateDay">
				<%
					for (int i = 1; i < 31; i++) {
				%>
				<html:option value="<%= String.valueOf(i) %>"><%=String.valueOf(i)%>
				</html:option>
				<%
					}
				%>
			</html:select> <html:select property="startDateMonth">
				<%
					for (int i = 1; i < 13; i++) {
				%>
				<html:option value="<%= String.valueOf(i) %>"><%=String.valueOf(i)%>
				</html:option>
				<%
					}
				%>
			</html:select> <html:select property="startDateYear">
				<%
					for (int i = 2010; i < 2015; i++) {
				%>
				<html:option value="<%= String.valueOf(i) %>"><%=String.valueOf(i)%>
				</html:option>
				<%
					}
				%>
			</html:select></td>
			<tr>

				<td>Finish Date&nbsp;:</td>
				<td><html:select property="finishDateDay">
					<%
						for (int i = 1; i < 31; i++) {
					%>
					<html:option value="<%= String.valueOf(i) %>"><%=String.valueOf(i)%>
					</html:option>
					<%
						}
					%>
				</html:select> <html:select property="finishDateMonth">
					<%
						for (int i = 1; i < 13; i++) {
					%>
					<html:option value="<%= String.valueOf(i) %>"><%=String.valueOf(i)%>
					</html:option>
					<%
						}
					%>
				</html:select> <html:select property="finishDateYear">
					<%
						for (int i = 2010; i < 2015; i++) {
					%>
					<html:option value="<%= String.valueOf(i) %>"><%=String.valueOf(i)%>
					</html:option>
					<%
						}
					%>
				</html:select></td>
			</tr>
		</tr>
		<tr>
			<html:errors property="date" />
		</tr>

		<tr>
			<td>&nbsp;</td>
			<td><html:submit>Save</html:submit> <c:if
				test="${not empty projectHeaderForm.id}">

				<a href="javascript:Popup()" alt="" width="8" height="10" border="0" />
				Delete Project</a>
			</c:if></td>
		</tr>
	</table>

</html:form></center>
<script language="javascript">
	function Popup() {
		sure = confirm("Are you sure?");
		if (sure) {
			window.location = "DeleteProject.do?id=" + ${projectHeaderForm.id};
		}
	}
</script>

<%@ include file="/include/footer.jspfrag"%>
