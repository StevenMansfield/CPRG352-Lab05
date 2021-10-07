<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="home">
            <div>
                <label>Username: </label>
                <input type="text" name="username" value="">
            </div>
            <div>
                <label>Password: </label>
                <input type="text" name="password" value="">
            </div>
            <div>
                <input type="submit" name="Log In">
            </div>
        </form>
    </body>
</html>