<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="row col-md-10 col-md-offset-1">
    <h4>Notices Home</h4>
    <hr/>
    <div class="col-md-3">
        <ul class="nav nav-pills nav-stacked">

            <c:choose>
                <c:when test="${hasNotice}">
                    <li>
                        <a href="<c:url value='/createnotice' />">Update current Notice</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="<c:url value='/createnotice' />">Create Notices</a>
                    </li>
                </c:otherwise>
            </c:choose>

            <%--<li>--%>
            <%--<a href="${pageContext.request.contextPath}/notices" >Show Notices</a>--%>
            <%--</li>--%>
            <%--<li>--%>
            <%--<a href="${pageContext.request.contextPath}/createnotice" >Create--%>
            <%--Notices</a>--%>
            <%--</li>--%>
            <sec:authorize access="!isAuthenticated()">
                <li>
                    <a href="<c:url value='/login' />">Log in</a>
                </li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li>
                    <a href="<c:url value='/j_spring_security_logout' />">Log out</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li>
                    <a href="<c:url value='/admin' />">Admin Page</a>
                </li>
            </sec:authorize>
        </ul>
    </div>
    <div class="col-md-9">
        <table class="table table-striped">
            <tr>
                <th width="5%">ID</th>
                <th width="15%">Name</th>
                <th width="30%">Email</th>
                <th width="50%">Notice</th>
            </tr>
            <c:forEach var="notice" items="${notices}">
                <tr>
                    <td><c:out value="${notice.id}"></c:out></td>
                    <td><c:out value="${notice.user.name}"></c:out></td>
                    <td><c:out value="${notice.user.email}"></c:out></td>
                    <td><c:out value="${notice.text}"></c:out></td>
                </tr>
                <%--<p><c:out value="${notice}"></c:out></p>--%>
            </c:forEach>
        </table>
    </div>
</div>