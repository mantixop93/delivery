<%@ tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="title" fragment="true" %>
<%@ attribute name="header" fragment="true" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        <jsp:invoke fragment="title"/>
    </title>
    <link href="/resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Delivery</a>
        </div>
        <jsp:include page="/WEB-INF/views/menu.jsp"/>
    </div>
</nav>

<div class="container">
    <div class="hero-unit">
        <h2>
            <jsp:invoke fragment="header"/>
        </h2>
        <jsp:doBody/>
    </div>
</div>
</body>
</html>