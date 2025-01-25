<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(120deg, #84fab0, #8fd3f4);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 30px 40px;
            border-radius: 15px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 100%;
            max-width: 400px;
        }

        .container h2 {
            margin-bottom: 20px;
            color: #007bff;
        }

        p {
            font-size: 16px;
            color: #555;
            margin: 10px 0;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            margin-top: 20px;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome, ${student.name}!</h2>
        <p>Your email: ${student.email}</p>
        <p>Your address: ${student.address}</p>
        <form action="logout" method="post">
            <button type="submit">Logout</button>
        </form>
    </div>
</body>
</html>
