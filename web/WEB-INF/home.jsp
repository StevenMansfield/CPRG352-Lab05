<%-- 
    Document   : home
    Created on : Oct 6, 2021, 8:31:55 PM
    Author     : 786821
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <h3>Hello ${sessionUsername}.</h3>
        <a href="login?logout">Log Out</a>
    </body>
</html>
