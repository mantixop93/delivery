<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 2/16/16
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
    <jsp:attribute name="title">
        <s:message code="user.users"/>
    </jsp:attribute>
    <jsp:attribute name="header">
     <s:message code="user.users"/>
    </jsp:attribute>
    <jsp:body>
        <table cellspacing="15" border="1">
            <tr>
                <td>
                    Name
                </td>
                <td>
                    Address
                </td>
                <td>
                    Phone
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
                        <c:out value="${user.address}"/>
                    </td>
                    <td>
                        <c:out value="${user.phone}"/>
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
    </jsp:body>
</t:genericpage>
