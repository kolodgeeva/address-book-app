<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<div class="container">
    <H1>Edit contact</H1>
    <FORM action="" method="post" role="form">
        <div class="form-group">
            <LABEL for="name">Name: </LABEL>
            <INPUT type="text" id="name" name="name" class="form-control" value="${contact.getName()}" >
        </div>
        <div class="form-group">
            <LABEL for="phone">Phone: </LABEL>
            <INPUT type="text" id="phone" name="phone" class="form-control" value="${contact.getPhone()}" >
        </div>
        <div class="form-group">
            <input type="hidden" name="id" value="${contact.getId()}">
            <INPUT type="submit" value="Save" class="btn btn-primary">
        </div>
    </FORM>
</div>
</body>
</html>