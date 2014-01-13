<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">

</head>
<body>
<div class="alert alert-danger">
    <H1>Error information</H1>
    <p>The status code : ${statusCode}</p>
    <p>Servlet Name : ${servletName}</p>
    <p>Exception Type : ${throwable.getClass().getName()}</p>
    <p>The request URI : ${requestUri}</p>
    <p>The exception message : ${throwable.getMessage()}</p>
</div>
</body>
</html>