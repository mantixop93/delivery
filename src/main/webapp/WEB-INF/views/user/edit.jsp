<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 3/9/16
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:genericpage>
    <jsp:attribute name="title">
        <s:message code="user.edit.title"/>
    </jsp:attribute>
    <jsp:attribute name="header">
      <s:message code="user.edit.lable"/>
    </jsp:attribute>
    <jsp:body>
        <form action="edit" method="post">
            <input type="hidden" name="id" value="${user.id}"/>
            <s:message code="user.edit.address"/> <input type="text" name="address" value="${user.address}">
            <s:message code="user.edit.name"/> <input type="text" name="name" value="${user.name}">
            <s:message code="user.edit.phone"/> <input type="text" name="phone" value="${user.phone}">
            <input type="submit" name="Ok">
            <sec:csrfInput />
        </form>
    </jsp:body>
</t:genericpage>


