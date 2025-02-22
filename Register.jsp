<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup - FoodClone</title>
 <link rel="stylesheet" href="style.css">
</head>
<body>


 <div class="wrapper">
        <div class="form-container"> 
            <form class="form" id="signup-form" action="register" method="post">
                <h2>Sign Up</h2>
                <div class="input-group">
                    <input type="text" id="signup-name" placeholder="Full Name" required name="fullname">
                </div>
                <div class="input-group">
                    <input type="email" id="signup-email" placeholder="Email" required name="email">
                </div>
                <div class="input-group">
                    <input type="password" id="signup-password" placeholder="Password" required name="password">
                </div>
                <button type="submit" class="btn">Sign Up</button>
                <p>Already have an account? <a href="login.jsp">Login</a></p>
            </form>
        </div>
    </div>



</body>
</html>