
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
    <p>注册学生</p>
    <form action="reg" method="post">
        <table>
            <tr>
                <td>id</td>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <td>name</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td>age</td>
                <td><input type="text" name="age"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="注册学生"></td>
            </tr>
        </table>
    </form>
</body>
</html>
