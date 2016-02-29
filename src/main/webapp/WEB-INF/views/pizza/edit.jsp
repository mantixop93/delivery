<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 2/16/16
  Time: 2:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  Add new pizza:
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
</body>
</html>
