<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="col-md-4 col-md-offset-4">
    <h4>Send Message</h4>
    <hr/>
    <sf:form method="post" commandName="message">
        <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
        <div class="form-group">
            <label for="inputName">Your Name: </label>
            <sf:input type="text" path="name" name="name" class="form-control" id="inputName"
                      placeholder="Enter Name"/>
            <sf:errors path="name" cssClass="alert-danger"></sf:errors>
        </div>

        <div class="form-group">
            <label for="inputEmail">Your Email: </label>
            <sf:input type="email" path="email" name="email" class="form-control" id="inputEmail"
                      placeholder="Enter Email"/>
            <sf:errors path="email" cssClass="alert-danger"></sf:errors>
        </div>

        <div class="form-group">
            <label for="inputSubject">Subject: </label>
            <sf:input type="text" path="subject" name="subject" class="form-control" id="inputSubject"
                      placeholder="Enter Subject"/>
            <sf:errors path="subject" cssClass="alert-danger"></sf:errors>
        </div>

        <div class="form-group">
            <label for="inputContent">Content: </label>
            <sf:textarea name="content" path="content" rows="10" cols="20" class="form-control" type="text"
                         id="inputContent"></sf:textarea>
            <sf:errors path="content" cssClass="alert-danger"></sf:errors>
        </div>

        <button type="submit" class="btn btn-success">Send Message</button>
        <a href="${pageContext.request.contextPath}/" type="button" class="btn btn-primary">Back to Home</a>
    </sf:form>
</div>
<script>
    var password1 = document.getElementById('inputPassword');
    var password2 = document.getElementById('inputConfirmPassword');

    var checkPasswordValidity = function () {
        if (password1.value != password2.value) {
            password1.setCustomValidity('Passwords must match.');
        } else {
            password1.setCustomValidity('');
        }
    };

    password1.addEventListener('change', checkPasswordValidity, false);
    password2.addEventListener('change', checkPasswordValidity, false);

    var form = document.getElementById('userForm');
    form.addEventListener('submit', function () {
        checkPasswordValidity();
        if (!this.checkValidity()) {
            event.preventDefault();
            //Implement you own means of displaying error messages to the user here.
            password1.focus();
        }
    }, false);
</script>