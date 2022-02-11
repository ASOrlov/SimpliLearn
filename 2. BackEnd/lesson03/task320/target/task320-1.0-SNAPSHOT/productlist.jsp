<%@ page import="java.util.*" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.ecommerce.model.EProduct" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align=center>List of all products in database</h1>
<p>
<%
List products = (List)request.getAttribute("products");
for (Object product : products) {
  out.print("<br>" + (EProduct)product);
}
%>
</body>
</html>
