<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width"/>
<title>demo</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.2.1/dist/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
 	<div class="row">
 		<div class="col-md-12">
 			<img src="${pageContext.request.contextPath}/resources/images/image1.jpg">
 			<div class="text-center">
 				<h2>Ý kiến phản hồi</h2>
 			</div>
 		</div>
 	</div>
</div>
    <h2>Users List</h2>
    <table>
      <tr>
        <th>Id</th>
        <th>Question</th>
      </tr>
      <c:forEach items="${questions}" var="user">
        <tr>
          <td>${user.id}</td>
          <td>${user.question}</td>
        </tr>
      </c:forEach>

    </table>

</body>
</html>