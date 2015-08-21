<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title"></tiles:getAsString></title>
</head>
<body>
<div>
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
</div>
<div>
    <tiles:insertAttribute name="content"></tiles:insertAttribute>
</div>
<div>
    <tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>
</html>
