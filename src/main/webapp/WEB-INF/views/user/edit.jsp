<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 3/9/16
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><s:message code="user.edit.title"/></title>
</head>
<body>
<s:message code="user.edit.lable"/>
<form action="edit" method="post">
    <input type="hidden" name="id" value="${user.id}"/>
    <s:message code="user.edit.address"/> <input type="text" name="address" value="${user.address}">
    <s:message code="user.edit.name"/> <input type="text" name="name" value="${user.name}">
    <s:message code="user.edit.phone"/> <input type="text" name="phone" value="${user.phone}">
</select>
    <input type="submit" name="Ok">
</body>
</html>
