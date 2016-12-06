<%-- 
    Document   : index
    Created on : Nov 26, 2016, 4:05:31 PM
    Author     : erick.araujo
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
    <jsp:attribute name="extraStyles">
        <link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
    </jsp:attribute>
    <jsp:attribute name="extraScripts">
        <script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
    </jsp:attribute>
    <jsp:body>
        <div class="table">
            <div class ="container min-container">
                <div class='well'>
                    <h1>Hello!</h1>
                    <a href="<c:url value='/listarEstado'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Adicionar novo Estado</a>
                </div>
            </div>
        </div>
    </jsp:body>
</template:admin>
