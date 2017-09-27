<%--
  Created by IntelliJ IDEA.
  User: olesi
  Date: 7/28/2017
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title> books</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css"/>
</head>
<body>
<h1>${author.name} ${author.lastName}'s books</h1>
<form:form action="${pageContext.request.contextPath}/authors/${author.id}/books/"
           method="post" modelAttribute="bookModel">
    <table border="2">
        <tr>
            <%--<th>#</th>--%>
            <th>Title</th>
            <th>Publish date</th>
        </tr>
        <c:forEach items="${bookModel.books}" var="book" varStatus="status">
            <tr>
                <td>
                    <input type="hidden" name="books[${status.index}].id" value="${book.id}"/>
                    <input type="hidden" name="books[${status.index}].aid" value="${book.aid}" />
                    <input type="text" name="books[${status.index}].title" value="${book.title}"/>
                </td>
                <td>
                    <input type="text" name="books[${status.index}].publishDate" value="${book.publishDate}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><input type="submit" value="Save changes"></p>
</form:form>

<form:form action="${pageContext.request.contextPath}/authors/${author.id}/books/save" method="post"
           modelAttribute="book">
    <input type="hidden" name="${book.aid}" value="${author.id}"/>
    <table>
        <tr>
            <th>Book title</th>
            <th>Publish date</th>
        </tr>
        <tr>
            <td><form:input path="title"/></td>
            <td><form:input path="publishDate" placeholder="yyyy-MM-dd"/></td>
        </tr>
        <tr >
            <td></td>
            <td><input type="submit" value="Add new book"></td>
        </tr>
    </table>

</form:form>


<p><a href="${pageContext.request.contextPath}/authors/${author.id}">Back to authors info</a></p>
<p><a href="${pageContext.request.contextPath}/authors">Authors list</a></p>
</body>
</html>


<%--<td>${status.count}</td>--%>
<%--<td>--%>
<%--<input type="hidden" name="books[${status.index}].id" value="${book.id}"/>--%>
<%--&lt;%&ndash;<input type="hidden" name="books[${status.index}].author" value="${author.id}">&ndash;%&gt;--%>
<%--<input name="books[${status.index}].title" value="${book.title}"/>--%>
<%--</td>--%>
<%--<td>--%>
<%--<input name="books[${status.index}].publishDate" value="${book.publishDate}"/>--%>
<%--</td>--%>