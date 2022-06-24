<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 26.4.22
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up Form</title>
</head>
<body>

<form action="save" method="post">
    <p> First Name: <input name="firstName"></p>
    <p> Last Name: <input name="lastName"></p>

    <p>Address:</p>
    <p>Street:<input name="address.street"></p>
    <p>ZipCode:<input name="address.zipcode"></p>
    <input type="submit" value="Sign Up">
</form>

</body>
</html>
