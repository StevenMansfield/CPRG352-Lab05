<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <div>
                <label>Username: </label>
                <input type="text" name="username" value="${username}">
            </div>
            <div>
                <label>Password: </label>
                <input type="text" name="password" value="${password}">
            </div>
            <div>
                <input type="submit" name="Log In">
            </div>
                <c:if test="${loggedOut}">
                    <p>You have been successfully logged out.</p>
                </c:if>
                <c:if test="${invalid}">
                    <p>Username or password is invalid. Please try again.</p>
                </c:if>
        </form>
    </body>
</html>