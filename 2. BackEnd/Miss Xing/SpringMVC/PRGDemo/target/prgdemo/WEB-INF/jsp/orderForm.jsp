<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 26.4.22
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Order Form</title>
</head>
<body>

<form:form action="saveOrder" modelAttribute="order" >
    <p>Name: <form:input path="productName" /> </p>
    <p>Quantity: <form:input path="quantity" /></p>
    <input type="submit" value="Place Order">



</form:form>

</body>
</html>
