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

    <h3>Your contacts</h3>

    <div class="row">
        <div class="col-lg-12">
            <a class="btn btn-primary"  href="/addContact">Add new contact</a>
            <a class="btn btn-danger"  href="/logout?action=logout">Logout</a>
        </div>
    </div>

    <table class="table">
        <tr>
            <th>Item id</th>
            <th>Contact name</th>
            <th>Contact phone</th>
            <th>Action</th>
        </tr>
    <c:forEach items="${contacts}" var="contact">
        <tr>
            <td>${contact.getId()}</td>
            <td>${contact.getName()}</td>
            <td>${contact.getPhone()}</td>
            <td>
                <a class="btn btn-primary" href="/editContact?contactId=${contact.getId()}">Edit</a>
                <a class="btn btn-primary"  href="/deleteContact?contactId=${contact.getId()}" onclick="if(confirm('Delete contact?')) return true; else return false;">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>