<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Get Header Example</title>
</head>
<body>



<c:choose>

  <c:when test = "${paramValues.office[0] != null}">
    value of Office obtained : ${paramValues.office[0] } <br>
  </c:when>

  <c:otherwise>
    No value of Office found<br>
  </c:otherwise>
</c:choose>



<%
  //See above
  //String office = request.getParameter("office");
  //if (office != null)
  //  out.println("value of Office obtained :" + office + "<br>");
  //else
  //  out.println("No value of Office found<br>");
%>

</body>
</html>
