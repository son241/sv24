<%-- 
    Document   : add
    Created on : Sep 18, 2022, 5:29:01 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="List" method="post">
            Id: <input type="text" name="txtId" id="id" required><br>
            Name: <input type="text" name="txtName" id="name" required><br>
            Gender: <input type="radio" name="txtGender" value="Male" class="gender" checked> Male
            <input type="radio" name="txtGender" value="Female" class="gender"> Female<br>
            DOB: <input type="date" name="txtDOB" placeholder="2016/12/02" id="DOB"><br>
            <input style="cursor: pointer" type="submit" value="Create">
        </form>
        <script src="./main.js"></script>
    </body>
</html>
