<%--
  Created by IntelliJ IDEA.
  User: biqi
  Date: 2020-08-01
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  一个模块对应一个Servlet  --%>
<a href="${pageContext.request.contextPath}/test?methodName=addCourse">新建课程</a>
<a href="${pageContext.request.contextPath}/test?methodName=findByName">根据课程名查询</a>
<a href="${pageContext.request.contextPath}/test?methodName=findByStatus">根据状态查询</a>
</body>
</html>
