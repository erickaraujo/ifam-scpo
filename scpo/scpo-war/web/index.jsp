<%-- 
    Document   : index
    Created on : Nov 26, 2016, 4:05:31 PM
    Author     : erick.araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello!</h1>
        <form action="./resources/estado/" method="GET">
            First Name: <input type="text" name="first_name">
            <br />
            Last Name: <input type="text" name="last_name" />
            <input type="submit" value="Submit" />
        </form>
    </body>
</html>
