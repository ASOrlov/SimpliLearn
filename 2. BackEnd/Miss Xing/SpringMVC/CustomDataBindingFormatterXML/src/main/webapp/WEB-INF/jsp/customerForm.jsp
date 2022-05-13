<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 26.4.22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Customer</title>
</head>
<body>

<h1>Add new Customer</h1>
<form action="saveCustomer" method="post">

    <p>First Name: <input name="first"/></p>
    <p>Last Name: <input name="last"/></p>
    <p>Phone Number: <input name="phone"/></p>

    <input type="submit" value="Add Customer">

</form>

</body>
</html>
