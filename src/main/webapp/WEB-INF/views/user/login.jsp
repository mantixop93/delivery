<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 3/9/16
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<t:genericpage>
    <jsp:attribute name="title">
        <s:message code="label.login"/>
    </jsp:attribute>
    <jsp:attribute name="header">
      <s:message code="label.login"/>
    </jsp:attribute>
    <jsp:body>
        <form class="form-horizontal" action="login" method="post">
            <div class="form-group">
                <label class="col-sm-2 control-label"><s:message code="user.edit.email" /></label>
                <div class="col-sm-10">
                    <input id="username_or_email" name="username" type="text" class="form-control" placeholder="test"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"><s:message code="label.user.password" /></label>
                <div class="col-sm-10">
                    <input id="password" name="password" type="password" class="form-control" placeholder="password"/>
                </div>
            </div>
            <input class="btn-lg btn-primary pull-right" name="commit" type="submit" value="<s:message code="label.login" />" />
            <sec:csrfInput />
        </form>
    </jsp:body>
</t:genericpage>

