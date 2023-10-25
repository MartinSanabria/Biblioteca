<%-- 
    Document   : register
    Created on : 10-22-2023, 11:48:42 PM
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
        <header>
            <jsp:include page="navbar.jsp"></jsp:include>
        </header>

        <div class="container mt-5">
            <h5 class="text-center">Registro del alumno</h5>
            <form action="ControllerRegister" method="POST">
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="nombre"  name="nombre" placeholder="Ingrese sus nombres" required>
                    <label for="nombre">ingrese sus nombres</label>
                </div> 
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="apellido"  name="apellido" placeholder="Ingrese sus apellidos" required>
                    <label for="apellido">ingrese sus apellidos</label>
                </div>    
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="username"  name="username" placeholder="Ingrese su nombre de usuario" required>
                    <label for="username">ingrese su nombre de usuario</label>
                </div> 
                <div class="form-floating">
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
                    <label for="pass">Password</label>
                </div>

                <p class="text-center pt-3"><button class="btn btn-success" type="submit">Ingresar</button></p>
            </form>
        </div>
        
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
