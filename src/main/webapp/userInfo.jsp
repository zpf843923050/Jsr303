<%--
  Created by IntelliJ IDEA.
  User: index
  Date: 2019-08-03
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<h3>文件下载</h3>
<a href="${pageContext.request.contextPath}/download?fileName=${userSu.image.originalFilename}"/><br>
${userSu.image.originalFilename}
</body>
</html>
