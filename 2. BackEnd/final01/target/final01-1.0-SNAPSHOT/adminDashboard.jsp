<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 8.4.22
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>FlyAway</title>
</head>
<body>
<a href="logout">Click here to logout from admin page</a><br><br>

<div align="left">
    <h2> You can change your password</h2>
    <form name=Login method="post" action="changepassword">
        <table width="50%" border="0">
            <tr valign="top">
                <td width="40%">Enter old password</td>
                <td><input type="password" name="oldpassword" id="oldpassword" maxlength=30></td>
            </tr>
            <tr valign="top">
                <td width="40%">Enter new password</td>
                <td><input type="password" name="newpassword" id="password" maxlength=30></td>
            </tr>
            <tr valign="top">
                <td colspan=2 width="100%">
                    <button>Change password</button>
                </td>
            </tr>
        </table>
    </form>
</div>

<br>

<h3> List of airlines: </h3>
<c:forEach var="res" items="${airlines}" >
    ${res.name} <br>
</c:forEach>
<br>

<h3> List of places: </h3>
<c:forEach var="res" items="${airports}" >
    ${res.name}<br>
</c:forEach>

<h3> List of flights: </h3>
<table width="50%" border="0">
    <tr valign="top">
        <td width="40%"><b>Source:</b></td>
        <td width="40%"><b>Destination:</b></td>
        <td width="40%"><b>Airline:</b></td>
        <td width="40%"><b>Price:</b></td>
    </tr>
    <c:forEach var="res" items="${miniflights}" >
        <tr valign="left">
            <td width="40%">${res.source}</td>
            <td width="40%">${res.destination}</td>
            <td width="40%">${res.airline}</td>
            <td width="40%">${res.price}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
