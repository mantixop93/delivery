<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 2/16/16
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:genericpage>
    <jsp:attribute name="title">
         Add new pizza:
    </jsp:attribute>
    <jsp:attribute name="header">
       Add new pizza:
    </jsp:attribute>
  <jsp:body>
    <form action="edit" method="post">
    <input type="hidden" name="id" value="${pizza.id}"/>
    Name:<input type="text" name="name" value="${pizza.name}">
    Price:<input type="number" name="price" value="${pizza.price}">
    Type:<select type="text" name="pizzaType" value="${pizza.pizzaType}">
    <c:forEach items="${types}" var="type">
      <option>${type}</option>
    </c:forEach>
    </select>
    <input type="submit" name="Ok">
  </jsp:body>
</t:genericpage>