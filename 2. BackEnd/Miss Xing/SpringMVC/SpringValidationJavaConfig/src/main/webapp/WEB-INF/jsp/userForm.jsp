<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 29.4.22
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Add a new User</title>
    <style>
        .error{color: red}
    </style>
</head>
<body>

<h1><spring:message code="userForm.title"/></h1>
<form:form modelAttribute="newUser">
    <form:errors path="*" cssClass="error"/>
    <p><spring:message code="user.name"/> <form:input path="name"/> <form:errors path="name" cssClass="error"/> </p>
    <p><spring:message code="user.email"/> <form:input path="email"/> <form:errors path="email" cssClass="error"/></p>
    <p><spring:message code="user.birthday" text="My Birthday" /> <form:input path="birthday"/> <form:errors path="birthday" cssClass="error"/></p>
    <p>Age: <form:input path="age" /> <form:errors path="age" cssClass="error"/></p>
    <p>Role:
        <form:select path="role" >
            <form:option value="Select Role" />
            <form:options items="${roles}" />
        </form:select>
        <form:errors path="role" cssClass="error"/>
    </p>
    <p> Address Info:</p>
    <p> Street: <form:input path="address.street" /> <form:errors path="address.street" cssClass="error"/></p>
    <p> State: <form:input path="address.state" /> <form:errors path="address.state" cssClass="error"/></p>
    <p> Zip code: <form:input path="address.zipcode" /> <form:errors path="address.zipcode" cssClass="error"/></p>
    <input type="submit" value="Add" />
</form:form>

</body>
</html>
