<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 26.4.22
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Detail</title>
</head>
<body>

<p>Name: ${customer.first} ${customer.last}</p>
<p>Phone Number: ${customer.phone.areaCode} ${customer.phone.prefix} ${customer.phone.number}</p>


</body>
</html>
