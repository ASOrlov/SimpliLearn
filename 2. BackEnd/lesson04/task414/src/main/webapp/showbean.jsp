<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 31.3.22
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product properties form</title>
</head>
<body>

<jsp:useBean id="product" class="com.example.task414.Product" scope="session" >
<jsp:setProperty name="product" property="*" />
</jsp:useBean>

Product is: <jsp:getProperty name="product" property="name" /> <br>
Id is     : <jsp:getProperty  name="product" property="productId" /> <br>
Price is  : <jsp:getProperty  name="product" property="price" /> <br>

</body>
</html>
