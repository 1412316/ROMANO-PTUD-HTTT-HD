<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>

<head>
    <title><tiles:getAsString name="title" /></title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
    <script src="<c:url value="/resources/js/popper.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

    <tiles:insertAttribute name="js_css" />
</head>

<body>
    <tiles:insertAttribute name="header" />
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <tiles:insertAttribute name="body" />
            </div>
        </div>
    </div>
    <tiles:insertAttribute name="footer" />
</body>

</html>
