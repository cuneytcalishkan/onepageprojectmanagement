<%@ include file="/include/header.jspfrag"%>
<table border="1">
	<tr>
		<th colspan="3">ONE PAGE</th>
		<th colspan="18">Project Leader : <c:out
			value="${project.leader.nameSurname}" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Project : <c:out
			value="${project.name}" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Date: <%=new java.util.Date()%> /> <br>
		Project Objective: <c:out value="${project.objective}" /></th>
	</tr>
	<tr>
		<td colspan="3" align="center">Objectives</td>
		<td colspan="2" align="center">Major Tasks</td>
		<td colspan="12" align="center">Project Completed By: <c:out
			value="${project.finishDate}" /></td>
		<td colspan="4" align="center">Owner/ Priority</td>
	</tr>
	<tr>
		<td>*</td>
		<td>&nbsp;</td>
		<td>*</td>
		<td>1</td>
		<td>Award Contracts</td>
		<td>*</td>
		<td>*</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>A</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td>*</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>2</td>
		<td>Site Dempoltion</td>
		<td>*</td>
		<td>*</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>A</td>
		<td>B</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>*</td>
		<td>&nbsp;</td>
		<td>*</td>
		<td>3</td>
		<td>System Software Design</td>
		<td>*</td>
		<td>*</td>
		<td>*</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>A</td>
		<td>&nbsp;</td>
		<td>C</td>
		<td>B</td>
	</tr>


	<tr bordercolordark="#000000">
		<td>&nbsp;</td>
		<td>*</td>
		<td>&nbsp;</td>
		<td>A</td>
		<td>Internal Software Operational</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td>&nbsp;</td>
		<td>A</td>
		<td>A</td>
		<td>A</td>
		<td>A</td>
	</tr>


	<tr>
		<td>&nbsp;</td>
		<td>*</td>
		<td>&nbsp;</td>
		<td>B</td>
		<td>External Software Operational</td>
		<td>&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#00FF00">&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td bgcolor="#FFFF00">&nbsp;</td>
		<td>A</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>B</td>
	</tr>


	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="2">Major Task</td>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td rowspan="2">Objectives</td>
		<td>Target Dates</td>
		<td height="70">&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>


	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td height="70">Costs</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td colspan="2">Summary and Forecasts</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>

	</tr>
</table>
<%@ include file="/include/footer.jspfrag"%>

