<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<div class="container">
    <H1>Add new contact</H1>
    <FORM action="" method="post" role="form">
        <div class="form-group">
            <LABEL for="name">Name: </LABEL>
            <INPUT type="text" id="name" name="name" class="form-control" >
        </div>
        <div class="form-group">
            <LABEL for="phone">Phone: </LABEL>
            <INPUT type="text" id="phone" name="phone" class="form-control" >
        </div>
        <div class="form-group">
            <INPUT type="submit" value="Add" class="btn btn-primary">
        </div>
    </FORM>
</div>
</body>
</html>