<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-4 col-md-offset-4">
    <c:choose>
        <c:when test="${notice.id > 0}">
            <h4>Update Notice</h4>
        </c:when>
        <c:otherwise>
            <h4>Create Notice</h4>
        </c:otherwise>
    </c:choose>
    <hr/>
    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="notice">
        <sf:hidden path="id" name="id"/>
        <div class="form-group">
            <label for="inputNotice">Notice: </label>
            <sf:textarea name="text" path="text" rows="10" cols="20" class="form-control"
                         id="inputNotice"></sf:textarea>
            <sf:errors path="text" cssClass="alert-danger"></sf:errors>
        </div>
        <button type="submit" class="btn btn-success">Save Notice</button>
        <c:if test="${notice.id > 0}">
            <button id="delete" name="delete" class="btn btn-danger">Delete</button>
        </c:if>

        <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
    </sf:form>
</div>
