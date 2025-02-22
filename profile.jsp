<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(to right, #ff7e5f, #feb47b);
            text-align: center;
            color: white;
        }
        .container {
            max-width: 80%;
            padding: 20px;
        }
        h1 {
            font-size: 3rem;
            margin-bottom: 10px;
        }
        p {
            font-size: 1.2rem;
            opacity: 0.8;
        }
        @media (max-width: 768px) {
            h1 {
                font-size: 2.5rem;
            }
            p {
                font-size: 1rem;
            }
        }
    </style>
</head>
<%
String name1 = (String) session.getAttribute("fullname");

%>
<body>
    <div class="container">
        <h1>Welcome <%= name1 %> to Our Website</h1>
        <p>We are glad to have you here. Explore and enjoy your stay!</p>
    </div>
</body>
</html>
    