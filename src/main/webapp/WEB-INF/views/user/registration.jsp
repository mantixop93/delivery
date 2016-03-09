<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 3/2/16
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title><s:message code="title.registraion"></s:message></title>
</head>
<body>
<H1>
    <s:message code="label.registration"></s:message>
</H1>
<form:form modelAttribute="user" method="POST" enctype="utf8">
    <br>
    <tr>
        <td><label><s:message code="lable.user.email"></s:message>
        </label>
        </td>
        <td><form:input path="email" value="" /></td>
        <form:errors path="email" element="div" />
    </tr>
    <tr>
        <td><label><s:message code="label.user.password"></s:message>
        </label>
        </td>
        <td><form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <button type="submit"><s:message code="lable.form.submit"></s:message>
    </button>
</form:form>
<br>
</body>
</html>