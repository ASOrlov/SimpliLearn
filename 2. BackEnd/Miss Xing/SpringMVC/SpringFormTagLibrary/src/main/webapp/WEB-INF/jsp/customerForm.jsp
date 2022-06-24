<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 26.4.22
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new Customer</title>
</head>
<body>

<h1>Add new Customer</h1>
<form:form action="saveCustomer" method="post" modelAttribute="customer">

    <p>First Name: <form:input path="first"/></p>
    <p>Last Name: <form:input path="last"/></p>
    <p>Phone Number: <form:input path="phone"/></p>

    <p> Select your country:
            <%--<form:select path="country.id" items="${countryList}"/>--%>
            <%--<form:select path="country.id" items="${countryMap}"/>--%>
            <%--<form:select path="country.id" items="${countryObjectList}" itemLabel="name" itemValue="id"/>--%>
        <form:select path="country.id" >
            <form:option value="-------">Please select a Category </form:option>
            <form:options items="${countryObjectList}" itemLabel="name" itemValue="id"></form:options>


        </form:select>
    </p>

    <input type="submit" value="Add Customer">

</form:form>

</body>
</html>
