<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="col-md-4 col-md-offset-4">
    <h4>Create Notice</h4>
    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="notice">
        <div class="form-group">
            <label for="inputNotice">Notice: </label>
            <sf:textarea name="text" path="text" rows="10" cols="20" class="form-control"
                         id="inputNotice"></sf:textarea>
            <sf:errors path="text" cssClass="alert-danger"></sf:errors>
        </div>
        <button type="submit" class="btn btn-success">Create Notice</button>
        <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
    </sf:form>
</div>
