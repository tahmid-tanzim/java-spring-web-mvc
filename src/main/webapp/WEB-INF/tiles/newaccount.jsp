<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="col-md-4 col-md-offset-4">
    <h4>Create User</h4>
    <sf:form method="post" action="${pageContext.request.contextPath}/createaccount" commandName="user" id="userForm">
        <div class="form-group">
            <label for="inputusername">Username: </label>
            <sf:input type="text" path="username" name="username" class="form-control" id="inputusername"
                      placeholder="Enter Username"/>
            <sf:errors path="username" cssClass="alert-danger"></sf:errors>
        </div>
        <div class="form-group">
            <label for="inputEmail">Email: </label>
            <sf:input type="text" path="email" name="email" class="form-control" id="inputEmail"
                      placeholder="Enter Email"/>
            <sf:errors path="email" cssClass="alert-danger"></sf:errors>
        </div>

        <div class="form-group">
            <label for="inputPassword">Password: </label>
            <sf:input type="password" path="password" name="password" class="form-control" id="inputPassword"/>
            <sf:errors path="password" cssClass="alert-danger"></sf:errors>
        </div>

        <div class="form-group">
            <label for="inputConfirmPassword">Confirm Password: </label>
            <input type="password" name="confirmpassword" class="form-control" id="inputConfirmPassword"/>
        </div>

        <button type="submit" class="btn btn-success">Create User</button>
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