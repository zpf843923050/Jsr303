<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-03
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>

    <title>用户注册</title>
</head>
<body>
<h2>用户注册</h2>
<form action="${pageContext.request.contextPath}/uploadUserImage" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName"></td>
        </tr>
        <tr>
            <td>请上传头像:</td>
            <td><input type="file" name="image"></td>
        </tr>
        <tr>
            <td><input type="submit" value="注册"></td>
        </tr>
    </table>

</form>
</body>
</html>
