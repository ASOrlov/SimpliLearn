<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>FlyAway</title>
</head>
<body>
<h1> List of compatible flights</h1>

<c:forEach var="res" items="${sRes}" >
    <form method=post action="bookFlight.jsp">
        Departure from
            ${res.departure}   at
            ${res.departureDate} ------> arrival to
            ${res.destination} at
            ${res.arrivalDate} operated by
            ${res.airline} availaible
            ${res.amount} tickets

        <input type="hidden" name="flightID" value=${res.id}>
        <input type="hidden" name="amount" value=${res.amount}>
        <input type="hidden" name="departure" value=${res.departure}>
        <input type="hidden" name="destination" value=${res.destination}>
        <input type="hidden" name="departureDate" value=${res.departureDate}>
        <input type="hidden" name="arrivalDate" value=${res.arrivalDate}>
        <input type="hidden" name="airline" value=${res.airline}>
        <input type="hidden" name="needed" value=${paramValues.number[0]}>

        <button type="submit">Book</button>
    </form> <br>
</c:forEach>

</body>
</html>