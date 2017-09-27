<%--
  Created by IntelliJ IDEA.
  User: olesi
  Date: 7/20/2017
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authors</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css"/>
</head>
<body>
    <h1>Authors list</h1>

    <table border="1">
        <tr>
            <th>Name</th>
            <th>Last name</th>
            <th>Email</th>
            <th>Delete?</th>
        </tr>
        <c:forEach items="${authorList}" var="author" varStatus="status">
            <tr>
                <td>${author.name}</td>
                <td>${author.lastName}</td>
                <td><a href="${pageContext.request.contextPath}/authors/${author.id}">${author.email}</a></td>
                <td><a href="${pageContext.request.contextPath}/authors/${author.id}/delete">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/authors/new" >Add new author</a>

</body>
</html>
