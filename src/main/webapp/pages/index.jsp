<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 16.01.2017
  Time: 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2>Users</h2>
    <table class="table table-hover">
        <tr>
            <th>ID</th>
            <th>Firstname</th>
            <th>Lastname</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td><a class="btn btn-danger" href="/delete?id=${user.id}">Remove</a>
                    <a class="btn btn-success"
                       href="/update?id=${user.id}&first_name=${user.firstName}&last_name=${user.lastName}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-info" href="/insert">Create new user</a>
</div>
</body>
</html>
