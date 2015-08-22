<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Java Spring Framework: Notices</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <c:url value="/"></c:url>
                <li class="active"><a href="<c:url value="/"></c:url>">Home</a></li>
                <%--<li><a href="#about">About</a></li>--%>
                <%--<li><a href="#contact">Contact</a></li>--%>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>