<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<H1>Login</H1>
<FORM action="" method="post" role="form">
    <div class="form-group">
        <LABEL for="login">Login: </LABEL>
        <INPUT type="text" id="login" name="login" class="form-control" >
    </div>
    <div class="form-group">
        <LABEL for="password">Password: </LABEL>
        <INPUT type="password" id="password" name="password" class="form-control" >
    </div>
    <div class="form-group">
        <INPUT type="submit" value="Sign in" class="btn btn-primary">
        <INPUT type="reset" value="Reset" class="btn btn-warning">
        <a href="/auth" class="btn btn-danger">Sign up</a>
    </div>

</FORM>
</body>
</html>