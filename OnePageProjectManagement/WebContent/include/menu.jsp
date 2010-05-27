
<tr>
  <%-- show menu. If category is frontpage, show it as active etc. --%>
  <%-- condition?a:b below means that if "condition" is true, then a else b --%>
  <td>
  <c:choose>
    <c:when test="${not isAdminUser}">
      <html:link forward="login">login</html:link>
    </c:when>
    <c:otherwise>
      <html:link forward="logout">logout</html:link>
    </c:otherwise>
  </c:choose>
  </td>
  
 <!--  <td class="${category == 'products'?'menuactive':'menupassive'}"><a href="${controllerUrl}ListProducts">Products</a></td>
  <td class="${category == 'basket'?'menuactive':'menupassive'}"><a href="http://www.google.fi">Shopping cart</a></td> -->
</tr>
