<%@ include file="/include/header.jspfrag"%>
<%
	Project project = (Project) request.getAttribute("project");
%>

<%@page import="model.Project"%>
<%@page import="controller.Utilizer"%>
<%@page import="java.util.GregorianCalendar"%><table border="1"
	align="center">
	<tr>
		<th colspan="3">ONE PAGE</th>
		<th colspan="18">Project Leader : <c:out
			value="${project.leader.nameSurname}" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Project : <c:out
			value="${project.name}" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Date: <%=Utilizer.getDateAsString(new java.util.Date())%> <br>
		Project Objective: <c:out value="${project.objective}" /></th>
	</tr>
	<tr>
		<td colspan="3" align="center">Objectives</td>
		<td colspan="2" align="center">Major Tasks</td>
		<td colspan="12" align="center">Project Completed By: <c:out
			value="${project.finishDateAsString}" /></td>
		<td colspan="4" align="center">Owner/ Priority</td>
	</tr>
	<tr>
		<td align="center"><html:link action="/EditMajorTask"
			paramId="projectId" paramName="project" paramProperty="id">
							Add Major Task
						</html:link></td>
	</tr>
	<c:forEach items='${mTasks}' var='mTask'>
		<tr>

			<td>&nbsp;</td>
			<c:forEach items='${project.objectives}' var='objective'>
				<td><c:choose>
					<c:when test='${fn:contains(objective.majorTasks,mTask)}'> * </c:when>
					<c:otherwise> &nbsp;</c:otherwise>
				</c:choose></td>
			</c:forEach>
			<td><c:out value="${mTask.id}" /></td>
			<td><c:out value="${mTask.name}" /></td>
			<%
				for (int i = 1; i <= project.getSliceQuantity(); i++) {
			%>
			<td><%=String.valueOf(i)%></td>
			<%
				}
			%>
			<td>A</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</c:forEach>

	<tr>
		<td align="center"><html:link action="/EditSubjectiveTask"
			paramId="projectId" paramName="project" paramProperty="id">
							Add Subjective Task
						</html:link></td>
	</tr>
	<c:forEach items='${sTasks}' var='sTask'>
		<tr>

			<td>&nbsp;</td>
			<c:forEach items='${project.objectives}' var='objective'>
				<td><c:choose>
					<c:when test='${fn:contains(objective.subjectiveTasks,sTask)}'> * </c:when>
					<c:otherwise> &nbsp;</c:otherwise>
				</c:choose></td>
			</c:forEach>
			<td><c:out value="${sTask.id}" /></td>
			<td><c:out value="${sTask.name}" /></td>
			<%
				for (int i = 1; i <= project.getSliceQuantity(); i++) {
			%>
			<td><%=String.valueOf(i)%></td>
			<%
				}
			%>
			<td>A</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</c:forEach>


	<tr>
		<td>&nbsp;</td>
		<td colspan="2">Major Task</td>
	</tr>

	<tr>
		<td rowspan="3" align="center"><html:link action="/EditObjective"
			paramId="projectId" paramName="project" paramProperty="id">
							Add Objective
						</html:link></td>
		<c:forEach items='${project.objectives}' var='objective'>
			<td rowspan="3"><c:out value="${objective.name }" /></td>
		</c:forEach>
		<td rowspan="2">Objectives</td>
		<td>Target Dates</td>
		<%
			GregorianCalendar sCal = new GregorianCalendar();
			sCal.setTime(project.getStartDate());
			int sYear = sCal.get(java.util.Calendar.YEAR);
			int sMonth = sCal.get(java.util.Calendar.MONTH);
			sCal.setTime(project.getFinishDate());
			int fYear = sCal.get(java.util.Calendar.YEAR);
			int fMonth = sCal.get(java.util.Calendar.MONTH);
			while (sYear != fYear || sMonth != fMonth + 1) {
		%>
		<td height="50"><%=String.valueOf(sMonth + 1) + "/"
						+ String.valueOf(sYear)%></td>
		<%
			sMonth++;
				if (sMonth > 11) {
					sMonth = 0;
					sYear++;
				}
			}
		%>
		<c:forEach items='${project.users}' var='user'>
			<td><c:out value="${user.nameSurname }" /></td>
		</c:forEach>
		<td><html:link action="/AddProjectMember" paramId="projectId"
			paramName="project" paramProperty="id">
							Add Project Member
						</html:link></td>
	</tr>


	<tr>
		<td height="70">Costs</td>
		<td><html:link action="/EditCost" paramId="projectId"
			paramName="project" paramProperty="id">
							Add Cost
						</html:link></td>
		<td>
		<table border="1" cellspacing="0" cellpadding="1">
			<th colspan="2">Expense/Budget</th>
			<c:forEach items='${project.costs}' var='cost'>
				<tr align="center">
					<td align="center" bgcolor="${cost.color}"><c:out
						value="${cost.expense}" />/<c:out value="${cost.budget}" /></td>
						<td bordercolor="${cost.color}"><c:out
						value="${cost.name}" /></td>
				</tr>
			</c:forEach>
		</table>
		</td>
		<tr>
			<td colspan="2">Summary and Forecasts</td>
			<td><html:link action="/EditSummary" paramId="projectId"
				paramName="project" paramProperty="id">
							Add Summary
		</html:link></td>
			<td><c:forEach items='${project.summaries}' var='summary'>
				<c:out value="${summary.description}" />
				<hr color="#CCCCCC"></hr>
			</c:forEach></td>
		</tr>
	</tr>
</table>
<%@ include file="/include/footer.jspfrag"%>