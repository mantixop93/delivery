<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 2/16/16
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<body>
<div>
    <h2><s:message code="user.users"/></h2>
    <table cellspacing="15" border="1">
        <tr>
            <td>
                Name
            </td>
            <td>
                Email
            </td>
            <td>
                Role
            </td>
            <td>
        </tr>
        </td>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <c:out value="${user.name}"/>
                </td>
                <td>
                    <c:out value="${user.email}"/>
                </td>
                <td>
                    <c:forEach items="${user.roles}" var="role">
                        <c:out value="${role.name}"/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
