<%--
  Created by IntelliJ IDEA.
  User: Mantixop
  Date: 3/9/16
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <li class="active"><a href="/user/edit">Account settings</a></li>
                <li class="active"><a href="/order/makeOrder">Make order</a></li>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
                <li class="active"><a href="/user/users">Users</a></li>
                <li class="active"><a href="/pizza/pizzas">Pizzas</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li class="active">
                    <form action="/logout" method="post">
                        <input class="btn btn-link" type="submit" value="logout"/>
                        <sec:csrfInput/>
                    </form>
                </li>
            </sec:authorize>
        </ul>

