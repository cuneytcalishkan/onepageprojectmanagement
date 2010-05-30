
<tr>
	<td><c:choose>
		<c:when test="${user==null}">
			<% response.sendRedirect(response.encodeRedirectURL("login.jsp")); %>
		</c:when>
		<c:otherwise>
    Hello, <html:link action="/EditUser" paramId="id" paramName="user"
				paramProperty="id">[&nbsp;
				<c:out value="${user.nameSurname}" />&nbsp;]
			</html:link>
			<br />
			<html:link style = "text-decoration:none" forward="logout">[ Logout ]</html:link>
		</c:otherwise>
	</c:choose></td>

	<!--  <td class="${category == 'products'?'menuactive':'menupassive'}"><a href="${controllerUrl}ListProducts">Products</a></td>
  <td class="${category == 'basket'?'menuactive':'menupassive'}"><a href="http://www.google.fi">Shopping cart</a></td> -->
</tr>
