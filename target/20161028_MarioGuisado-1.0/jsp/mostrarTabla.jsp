<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.albarregas.beans.Ave" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <title>Mostrar Tabla</title>
    </head>
    <body>
        <div class="container">
            <h1>Contenido de la base de datos</h1></br>
            <form action="modificarBorrar?destino=<%=request.getParameter("destino")%>" method="post">
            <table class="table">
                <tr>
                    <th>Anilla</th>
                    <th>Especie</th>
                    <th>Lugar de avistamiento</th>
                    <th>Fecha</th>
                    <%
                        switch(request.getParameter("destino")){
                            case "update":
                        %>
                        <th>Elija cual quiere modificar</th>
                        <%
                            break;
                            case "delete":
                        %>
                        <th>Elija cuales quiere borrar</th>
                        <%
                            break;
                        }
                    %>
                </tr>
                <%
                    ArrayList<Ave> aves = (ArrayList)request.getAttribute("aves");
                    for(int i = 0; i<aves.size();i++){
                        %>
                        <tr>
                            <td><%= aves.get(i).getAnilla()%></td>
                            <td><%= aves.get(i).getEspecie()%></td>
                            <td><%= aves.get(i).getLugar()%></td>
                            <td><%= aves.get(i).getFecha()%></td>
                            <%
                                switch(request.getParameter("destino")){
                                    case "update":
                                        %>
                                        <td><input type="radio" name="update" value="<%= aves.get(i).getAnilla()%>"/></td>
                                        <%
                                        break;
                                    case "delete":
                                    %>
                                        <td><input type="checkbox" name="delete" value="<%= aves.get(i).getAnilla()%>"/></td>
                                        <%
                                        break;
                                }
                                %>
                        </tr>
                        <%
                    }
                    %>
            </table>
            <input type="submit" name="continuar" value="Continuar"/>
            </form>
        </div>
    </body>
</html>
