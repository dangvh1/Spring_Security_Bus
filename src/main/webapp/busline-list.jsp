<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <title>Title</title>
    <style>
        #table td, #table th {
            border: 2px solid rgb(0, 0, 0);
            padding: 40px;
        }
        .table{
            margin: 0px auto;
        }

    </style>
</head>
<body>
<div>
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: burlywood">
        <a class="navbar-brand" href="#">Bus</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/page">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"href="${pageContext.request.contextPath}/buslines" >Thêm Danh Sách Tuyến Đường</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/driver-list">Driver</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/busline-list">Busline</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/driver-assignment">Assignment</a>
                    </div>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" name="keyword" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>

</div>
<div>
    <h3 style="text-align: center">Danh Sách Tuyến Đường</h3>
</div>
<table class="table" id="table">
    <tr>
        <th>ID</th>
        <th>Tên Tuyến Đường</th>
        <th>Khoảng Cách</th>
        <th>Số Điểm Dừng</th>
        <th>action</th>

    </tr>
    <c:forEach var="busline" items="${buslines}">
        <tr>
            <td>${busline.id}</td>
            <td>${busline.buslineName}</td>
            <td>${busline.distance} km</td>
            <td>${busline.stopNumber}</td>
            <td>
                <button type="submit" ><a href="${pageContext.request.contextPath}/busline-remove/${busline.id}">Delete</a></button>
                <button type="submit" ><a href="${pageContext.request.contextPath}/busline-update/${busline.id}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>