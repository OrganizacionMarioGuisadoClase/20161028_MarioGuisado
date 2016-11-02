<%-- 
    Document   : errorInsercion
    Created on : 02-nov-2016, 22:07:44
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <h1 class="text-danger text-center"><%= request.getAttribute("error")%></h1><br/>
            <a href="<%= request.getContextPath()%>" class="btn btn-default">Inicio</a>
        </div>        
    </body>
</html>
