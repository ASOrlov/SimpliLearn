<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 29.4.22
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

<p>Channel Name: ${channel}</p>

<h1>User Saved Successfully </h1>
<p>Name: ${savedUser.name}</p>
<p>Email: ${savedUser.email}</p>
<p>Birthday: ${savedUser.birthday}</p>
<p>Age: ${savedUser.age}</p>
<p>Role: ${savedUser.role}</p>

<p>Profile Image: <img src="<spring:url value="/${savedUser.profileImage.originalFilename}" />" ></p>

<h2>Address</h2>

<p>Street: ${savedUser.address.street}</p>
<p>State: ${savedUser.address.state}</p>
<p>Zip code: ${savedUser.address.zipcode}</p>


</body>
</html>
