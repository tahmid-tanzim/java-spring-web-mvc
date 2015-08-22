<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="icon" href="../../favicon.ico">--%>

    <title><tiles:getAsString name="title"></tiles:getAsString></title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/resources/lib/bootstrap/css/bootstrap.min.css'></c:url>" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='/resources/css/notices-main.css'></c:url>" rel="stylesheet">
</head>
<body>
<div>
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div class="container">
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<div>
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>
