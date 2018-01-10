<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<br />
<nav class="navbar navbar-expand-sm bg-light navbar-light">
    <ul class="navbar-nav flex-column">
        <li class="nav-item <c:if test="${active == 'qllp'}">active</c:if>">
            <a class="nav-link" href="/">Quản lý loại phòng</a>
        </li>
        <li class="nav-item <c:if test="${active == 'qlp'}">active</c:if>">
            <a class="nav-link" href="#">Quản lý phòng</a>
        </li>
        <li class="nav-item <c:if test="${active == 'dpoff'}">active</c:if>">
            <a class="nav-link" href="#">Đặt phòng offline</a>
        </li>
    </ul>
</nav>




