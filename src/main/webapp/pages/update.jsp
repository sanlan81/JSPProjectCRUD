<%--
  Created by IntelliJ IDEA.
  User: Sasha
  Date: 17.01.2017
  Time: 21:25
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
    <h2>User <%=request.getParameter("first_name")%> <%=request.getParameter("last_name")%>
    </h2>
    <form class="form-horizontal" action="update" method="POST">

        <div class="form-group">
            <label class="control-label col-sm-2" for="email"></label>
            <div class="col-sm-10">
                <input type="hidden" name="id" value=<%=request.getParameter("id")%> hide class="form-control" id="i"
                       placeholder="Enter first name">
            </div>
        </div>


        <div class="form-group">
            <label class="control-label col-sm-2" for="email">First name:</label>
            <div class="col-sm-10">
                <input type="text" required name="first_name"
                       value=<%=request.getParameter("first_name")%> class="form-control" id="email"
                       placeholder="Enter first name">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="pwd">Last name:</label>
            <div class="col-sm-10">
                <input type="text" required name="last_name"
                       value=<%=request.getParameter("last_name")%> class="form-control" id="pwd"
                       placeholder="Enter last name">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Update</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
