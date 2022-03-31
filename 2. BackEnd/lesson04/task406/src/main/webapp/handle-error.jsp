<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
        <!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Error Handling page</title>
</head>
<body>

You caused a ${pageContext.exception}

<%
    //See above
    //exception.printStackTrace(response.getWriter());
%>
<hr>
An exception was generated. Details are above:<br>
</body>
</html>
