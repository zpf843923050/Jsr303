<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-02
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title>测试JSR303</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
</head>
<body>
<h3>注册页面</h3>
<form:form modelAttribute="user" action="login">
    <table>
        <tr>
            <td> 登录名:</td>
            <td><form:input path="loginName"/></td>
            <td><form:errors path="loginName" cssStyle="color: red"/></td>
        </tr>
        <tr>

            <td> 密码:</td>
            <td><form:input path="password"/></td>
            <td><form:errors path="password"/></td>
        </tr>
        <tr>

            <td> 用户名:</td>
            <td><form:input path="userName"/></td>
            <td><form:errors path="userName" cssStyle="color: red"/></td>
        </tr>
        <tr>

            <td> 年龄:</td>
            <td><form:input path="age"/></td>
            <td><form:errors path="age" cssStyle="color: red"/></td>
        </tr>
        <tr>

            <td> 邮箱:</td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssStyle="color: red"/></td>
        </tr>
        <tr>

            <td> 生日:</td>
            <td><form:input path="birthday"/></td>
            <td><form:errors path="birthday" cssStyle="color: red"/></td>
        </tr>
        <tr>

            <td> 电话:</td>
            <td><form:input path="phone"/></td>
            <td><form:errors path="phone" cssStyle="color: red"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
