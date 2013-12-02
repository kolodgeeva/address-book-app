<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>

<div class="container">

    <h3>Your address book</h3>

    <a class="btn btn-primary"  href="/addContact">Add new contact</a>

    <table class="table">
        <tr>
            <th>Item id</th>
            <th>Contact name</th>
            <th>Contact phone</th>
            <th>Action</th>
        </tr>
    <c:forEach items="${addresses}" var="address">
        <tr>
            <td>${address.getId()}</td>
            <td>${address.getName()}</td>
            <td>${address.getPhone()}</td>
            <td>
                <a class="btn btn-primary" href="/editAddress?addressId=${address.getId()}">Edit</a>
                <a class="btn btn-primary"  href="/deleteAddress?addressId=${address.getId()}" onclick="if(confirm('Delete address?')) return true; else return false;">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>