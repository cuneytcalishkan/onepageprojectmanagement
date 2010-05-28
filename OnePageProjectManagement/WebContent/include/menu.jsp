
<tr>
  <%-- show menu. If category is frontpage, show it as active etc. --%>
  <%-- condition?a:b below means that if "condition" is true, then a else b --%>
  <td>
  <c:choose>
    <c:when test="${not user}">
      <html:link forward="login">Login</html:link>
    </c:when>
    <c:otherwise>
      <c:out value="${user.nameSurname}"/> <br/>
      <html:link forward="logout">Logout</html:link>
    </c:otherwise>
  </c:choose>
  </td>
  
 <!--  <td class="${category == 'products'?'menuactive':'menupassive'}"><a href="${controllerUrl}ListProducts">Products</a></td>
  <td class="${category == 'basket'?'menuactive':'menupassive'}"><a href="http://www.google.fi">Shopping cart</a></td> -->
</tr>
