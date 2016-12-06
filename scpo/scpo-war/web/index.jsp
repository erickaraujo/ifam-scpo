<%-- 
    Document   : index
    Created on : Nov 26, 2016, 4:05:31 PM
    Author     : erick.araujo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="; charset=UTF-8">
        <!--<meta http-equiv="refresh" content=0;url="./listarEstado"/>-->
        <title>Sistema de Cadastro de Pessoas Online</title>
        <script src="http://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<script src="js/app-ajax.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Hello!</h1>
        <form action='./listarEstado' method='get'>
            <button type='submit' id='sasa' name='bla'> bla</button>
        </form>
        
        ${listarEstado}        
   </body>
</html>
