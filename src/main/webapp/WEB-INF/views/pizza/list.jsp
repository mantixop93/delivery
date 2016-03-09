<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 2/16/16
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>

<t:genericpage>
    <jsp:attribute name="title">
        <s:message code="user.edit.title"/>
    </jsp:attribute>
    <jsp:attribute name="header">
       <s:message code="pizza.pizzas"/>
    </jsp:attribute>
    <jsp:body>
        <table cellspacing="15" border="1">
            <tr>
                <td>
                    Name
                </td>
                <td>
                    Price
                </td>
                <td>
                    Type
                </td>
                <td>
            </tr>
            <c:out value="${pizza.type}"/>
            </td>
            <c:forEach items="${pizzas}" var="pizza">
                <tr>
                    <td>
                        <c:out value="${pizza.name}"/>
                    </td>
                    <td>
                        <c:out value="${pizza.price}"/>
                    </td>
                    <td>
                        <c:out value="${pizza.pizzaType}"/>
                    </td>
                    <td> <a href="<c:url value="/pizza/edit?id=${pizza.id}" />">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>
</t:genericpage>
