<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-03
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页</title>
</head>
<body>
<h3>登录页面</h3>
<form action="${pageContext.request.contextPath}/login2" method="post">
    <font color="red">${requestScope.message}</font>
    <table>
        <tr>
            <td>登录名:</td>
            <td><input type="text" id="loginName" name="loginName"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
