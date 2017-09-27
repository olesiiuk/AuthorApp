<%--
  Created by IntelliJ IDEA.
  User: olesi
  Date: 7/28/2017
  Time: 5:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${author.name} ${author.lastName}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css"/>
</head>
<body>
<h1>Author's detail</h1>

<form:form action="${pageContext.request.contextPath}/authors/${author.id}" method="post" modelAttribute="author">
    <p><input type="hidden" value="${author.id}"></p>
    <table>
        <tr>
            <td>Name </td>
            <td><form:input path="name"/>
                <form:errors path="name" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Last name </td>
            <td><form:input path="lastName"/></td>
            <td><form:errors path="lastName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Email </td>
            <td><form:input path="email"/>
                <form:errors path="email" cssClass="error"/>
            </td>
        </tr>
        <%--<tr>--%>
            <%--<td></td>--%>
            <%--<td>yyyy-MM-dd</td>--%>
        <%--</tr>--%>
        <tr>
            <td>Birthday </td>
            <td><form:input path="birthday" placeholder="yyyy-MM-dd"/>
                <form:errors path="birthday" cssClass="error"/>
            </td>
        </tr>
    </table>
    <p>Has <a href="${pageContext.request.contextPath}/authors/${author.id}/books">${author.books.size()}</a> books</p>

    <p><input type="submit"></p>
</form:form>
<p><a href="${pageContext.request.contextPath}/authors">Authors list</a></p>
</body>
</html>
