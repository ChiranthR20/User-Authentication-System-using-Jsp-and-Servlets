<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - FoodClone</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>
 <div class="wrapper">
        <div class="form-container">
            <form class="form" id="login-form" action="login" method="post">
                <h2>Login</h2>
                <div class="input-group">
                    <input type="email" id="login-email" placeholder="Email" required name="email">
                </div>
                <div class="input-group">
                    <input type="password" id="login-password" placeholder="Password" required name="password">
                </div>
                <button type="submit" class="btn">Login</button>
                <p>Don't have an account? <a href="Register.jsp">Sign up</a></p>
            </form>
        </div>
    </div>

</body>
</html>