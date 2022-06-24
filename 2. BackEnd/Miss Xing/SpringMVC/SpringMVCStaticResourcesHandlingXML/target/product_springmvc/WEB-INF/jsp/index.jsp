<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 25.4.22
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Static resource handling</title>
</head>
<body>

<img src="resources/images/dog.jpg" />
<img src="<spring:url value='/resources/images/dog.jpg' />" />

<pre>
   <mvc:resources mapping="/abc/**" location="/resources/" />
</pre>

<img src="abc/images/user/cat.jpg">
<img src="abc/images/dog.jpg">

</body>
</html>
