<%-- 
    Document   : formularioInsertar
    Created on : 28-oct-2016, 17:35:44
    Author     : Mario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <title>Formulario Insertar</title>
    </head>
    <body>
        <div class="container">
            <h1>Inserte los datos del nuevo registro</h1>
            <form action="insertar" method="post">
                <fieldset>
                    <legend>Datos del ave</legend>
                    <div class="form-group">
                        <label for="anilla">Anilla:</label>
                        <input type="text" id="anilla" name="anilla" class="form-control" placeholder="Introduzca anilla" required minlength="3" maxlength="3" title="Deben ser 3 caracteres."/>
                    </div>
                    <div class="form-group">
                        <label for="especie">Especie:</label>
                        <input type="text" id="especie" name="especie" class="form-control" placeholder="Introduzca especie" required maxlength="20" title="Máximo 20 caracteres."/>
                    </div>
                    <div class="form-group">
                        <label for="lugar">Lugar del avistamiento:</label>
                        <input type="text" id="anilla" name="lugar" class="form-control" placeholder="Introduzca lugar del avistamiento" required maxlength="50" title="Máximo 50 caracteres."/>
                    </div>
                    <div class="form-group">
                        <label>Fecha:</label>
                        <select name="dia">
                            <% for(int i = 1; i<=31 ; i++){ %>
                            <option value="<%=i%>"><%=i%></option>
                            <% } %>
                        </select>
                        <label> / </label>
                        <select name="mes">
                            <% for(int i = 1; i<=12 ; i++){ %>
                            <option value="<%=i%>"><%=i%></option>
                            <% } %>
                        </select>
                        <label> / </label>
                        <select name="anno">
                            <% for(int i = 2000; i<=2016 ; i++){ %>
                            <option value="<%=i%>"><%=i%></option>
                            <% } %>
                        </select>
                    </div>
                </fieldset>
                <input type="submit" class="btn btn-default" name="enviar" value="Enviar"/>
            </form>
        </div>
    </body>
</html>
