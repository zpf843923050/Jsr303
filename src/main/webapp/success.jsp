<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-02
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
欢迎:${user.userName}登录
登录名:${user.loginName}
密码:${user.password}
年龄:${user.age}
邮箱:${user.email}
生日:<fmt:formatDate value="${user.birthday}"/>
</body>
</html>
