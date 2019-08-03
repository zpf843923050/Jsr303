<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-02
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" %>
<html>
<head>
    <title>文件上传</title>

</head>
<body>
<h2>文件上传</h2>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td>文件描述:</td>
            <td><input type="text" name="description"></td>
        </tr>
        <tr>
            <td>选择文件:</td>
            <td><input type="file" name="file"></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传" /></td>
        </tr>
    </table>
</form>
</body>
</html>
