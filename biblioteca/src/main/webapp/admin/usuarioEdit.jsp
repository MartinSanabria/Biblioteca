<%-- 
    Document   : usuarioEdit
    Created on : 11-17-2023, 06:49:06 AM
    Author     : Alejandro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <title>User Edit</title>
    </head>
    <body>
        <header>
            <jsp:include page="navbar.jsp"></jsp:include>
        </header>
        
        <div class="container mt-3">
            <form action="ControllerUserEdit" method="POST">
                <input type="hidden" name="id" id="id" value="${usuario.id_usuario}">
            
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="nombre"  name="nombre" placeholder="Ingrese sus nombres" required value="${usuario.nombres}">
                    <label for="nombre">ingrese sus nombres</label>
                </div> 
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="apellido"  name="apellido" placeholder="Ingrese sus apellidos" required value="${usuario.apellidos}">
                    <label for="apellido">ingrese sus apellidos</label>
                </div>    
                <div class="form-floating mb-3">
                    <input type="text" class="form-control" id="username"  name="username" placeholder="Ingrese su nombre de usuario" required value="${usuario.username}">
                    <label for="username">ingrese su nombre de usuario</label>
                </div> 

                 <div class="form-floating mb-3">
                     <select class="form-select" id="rol" name="rol" aria-label="Roles">
                      
                       <c:choose>
                           <c:when test="${usuario.rol == 1}">
                               <option value="1" selected>Admin</option>
                               <option value="2" >Alumno</option>
                           </c:when>
                            <c:when test="${usuario.rol == 2}">
                                <option value="1" >Admin</option>
                                <option value="2" selected>Alumno</option>
                           </c:when>
                       </c:choose>
                     </select>
                     <label for="rol">Seleccione el rol</label>
                 </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Password" value="${usuario.password_user}">
                    <label for="pass">Password</label>
                </div>

                <p class="text-center pt-3"><button class="btn btn-warning" type="submit">Modificar</button></p>
            </form>
        </div>
        
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>        
    </body>
</html>
