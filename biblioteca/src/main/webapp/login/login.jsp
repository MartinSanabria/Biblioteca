<%-- 
    Document   : login
    Created on : 10-22-2023, 10:56:11 PM
    Author     : Alejandro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <head>
            <jsp:include page="../navbar.jsp"></jsp:include>
        </head>

        <div class="container">
            <div class="container mt-5 bg-dark rounded-5" style="height: 500px; width: 500px;">
                <h2 class="text-center pt-5 text-white">Login</h2>
                
                <form method="POST" action="ControllerLogin" id="formLogin">
                    <div class="form-floating mb-3">
                        <input type="text" class="form-control" id="username" name="username"
                               placeholder="username" required>
                        <label for="username">Ingrese su nombre de usuario</label>
                    </div>
                    <div class="form-floating">
                        <input type="password" class="form-control" id="pass" name="pass" placeholder="Password" required>
                        <label for="pass">Password</label>
                    </div>
                    <p class="text-center"><button type="submit" class="btn btn-success mt-5">Login</button></p>
                </form>
                <% 
                    String msj = (String) request.getAttribute("msj");
                    if (msj != null) {
                    %>
                        <h6 class="text-white m-3"><%= request.getAttribute("msj") %></h6>
                    <%
                    } 
                %>
               
                <p class="text-center mt-5"><a href="ControllerRegister" class="btn btn-warning">Registrarse</a></p>
            </div>
        </div>
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
