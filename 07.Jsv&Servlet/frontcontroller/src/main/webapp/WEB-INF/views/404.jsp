<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>404 - Page Not Found</title>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300;400;700&display=swap" rel="stylesheet">
    <!-- Custom CSS -->
    <style>
        body {
            font-family: 'Raleway', sans-serif;
            background: linear-gradient(135deg, #a1c4fd, #c2e9fb);
            color: #fff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
        }

        .container {
            text-align: center;
            animation: bounceIn 2s ease-in-out;
        }

        h1 {
            font-size: 10em;
            margin: 0;
            color: rgba(255, 255, 255, 0.9);
            text-shadow: 0 0 30px rgba(0, 0, 0, 0.3);
            animation: bounce 4s cubic-bezier(.36,.07,.19,.97) infinite;
        }

        h3 {
            font-size: 2em;
            margin: 20px 0;
            color: rgba(255, 255, 255, 0.8);
            text-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
            animation: bounce 5s cubic-bezier(.36,.07,.19,.97) infinite;
        }

        @keyframes bounce {
            0% {
                transform: translateX(0);
            }
            20% {
                transform: translateX(-50px) rotate(-5deg);
            }
            40% {
                transform: translateX(50px) rotate(5deg);
            }
            60% {
                transform: translateX(-30px) rotate(-3deg);
            }
            80% {
                transform: translateX(30px) rotate(3deg);
            }
            100% {
                transform: translateX(0);
            }
        }

        @keyframes bounceIn {
            0% {
                transform: scale(0.5);
                opacity: 0;
            }
            60% {
                transform: scale(1.2);
                opacity: 1;
            }
            80% {
                transform: scale(0.9);
            }
            100% {
                transform: scale(1);
            }
        }

        .back-link {
            display: inline-block;
            margin-top: 30px;
            padding: 15px 30px;
            font-size: 1.2em;
            text-decoration: none;
            color: #008cba;
            background-color: #fff;
            border-radius: 50px;
            transition: background-color 0.3s ease, transform 0.3s ease;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
            animation: bounce 6s cubic-bezier(.36,.07,.19,.97) infinite;
        }

        .back-link:hover {
            background-color: #89a9f4;
            color: #fff;
            transform: translateY(-5px) scale(1.05);
        }

        .back-link:active {
            transform: translateY(-2px);
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
        }
    </style>
</head>
<body>
<div class="container">
    <h1>404</h1>
    <h3>요청하신 페이지가 존재하지 않습니다.</h3>
    <a href="/" class="back-link">홈으로 돌아가기</a>
</div>
</body>
</html>
