<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-03
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h3>欢迎${user.userName}访问</h3>
<table border="1">
    <tr>
        <th>封面</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${requestScope.book_list}" var="book">
        <tr>
            <td><img src="images/${book.bookImage}" height="60"></td>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.bookPrice}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
