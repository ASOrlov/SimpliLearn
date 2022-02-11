<%@ page import="java.util.*" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 3.12.21
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align=center>Beer Recommendations JSP</h1>
<p>
        <%
List styles = (List)request.getAttribute("styles");
Iterator it = styles.iterator();
while(it.hasNext()) {
out.print("<br>try: " + it.next());
}
%>
</body>
</html>
