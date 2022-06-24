<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 6.4.22
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>FlyAway</title>
</head>
<body>
<h1> Booking page</h1>
<h2>  Ticket(s) from
    ${paramValues.departure[0]}   at
    ${paramValues.departureDate[0]} ------> arrival to
    ${paramValues.destination[0]} at
    ${paramValues.arrivalDate[0]} operated by
    ${paramValues.airline[0]}
</h2>
<form method=post action="paypage">
    <c:forEach var="i" begin="1" end="${paramValues.needed[0]}" step="1" >
        <h3>Enter Passenger${i} name </h3>
        <input type="text" name="passenger" id="passenger"> <br>
    </c:forEach>
    <h3>Enter card number </h3>
    <input type="text" name="cardnumber" id="cardnumber"> <br><br>
    <input type="hidden" name="flightid" value=${paramValues.flightID[0]}>
    <button type="submit">Book flight !</button>
</form>
</body>
</html>
