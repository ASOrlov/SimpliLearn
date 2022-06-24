<%@ page import="com.example.HF004.Counter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<body>
The page count is:
<%=
    Counter.getCount()
%>
</body>
</html>