<%-- 
    Document   : usuario
    Created on : 10-22-2023, 10:56:33 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <jsp:include page="navbar.jsp"></jsp:include>
        </header>
        
        <div class="container mt-4">
            <div class="row">
                <div class="col">
                    <form action="ControllerUser" method="POST">
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
                        
                        <div class="form-floating mb-3">
                            <select class="form-select" id="rol" name="rol" aria-label="Roles">
                              <option selected>Habra el menú de opciones</option>
                              <option value="1">Admin</option>
                              <option value="2">Alumno</option>
                            </select>
                            <label for="rol">Seleccione el rol</label>
                        </div>
                        
                       <div class="form-floating">
                           <input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
                           <label for="pass">Password</label>
                       </div>

                       <p class="text-center pt-3"><button class="btn btn-success" type="submit">Ingresar</button></p>
                   </form>
                </div>
                <div class="col">
                    <c:choose>
                        <c:when test="${not empty usuarios}">
                            <table class="table mt-4">
                                <thead>
                                    <tr>
                                        <th scope="col">id</th>
                                        <th scope="col">Nombres</th>
                                        <th scope="col">Apellidos</th>
                                        <th scope="col">UserName</th>
                                        <th scope="col">Tipo de usuario</th>
                                        <th scope="col">Estado</th>
                                        <th scope="col">Password</th>
                                        <th scope="col">actions</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="usuario" items="${usuarios}">
                                        <tr>
                                          <td>${usuario.id_usuario}</td>
                                          <td>${usuario.nombres}</td>
                                          <td>${usuario.apellidos}</td>
                                          <td>${usuario.username}</td>
                                          <td>${usuario.rolName}</td>
                                          <c:choose>
                                              <c:when test="${usuario.estado eq 'a'}">
                                                  <td>Activo</td>
                                              </c:when>
                                              <c:when test="${usuario.estado eq 'd'}">
                                                  <td>Desactivo</td>
                                              </c:when>
                                          </c:choose>
                                          
                                          <td>${usuario.password_user}</td>
                                          
                                          
                                          
                                          <td><a class="btn btn-warning" href="ControllerUser?action=edit&id=${usuario.id_usuario}"><i class="fa-regular fa-pen-to-square"></i></a>
                                               <c:choose>
                                                    <c:when test="${usuario.estado eq 'a'}">
                                                        <a class="btn btn-danger" href="ControllerUser?action=del&id=${usuario.id_usuario}"><i class="fa-solid fa-trash-can"></i></a></td>
                                                    </c:when>
                                                    <c:when test="${usuario.estado eq 'd'}">
                                                        <a class="btn btn-dark" href="ControllerUser?action=act&id=${usuario.id_usuario}"><i class="fa-solid fa-rotate-left"></i></a></td>
                                                    </c:when>
                                                </c:choose>
                                            
                                        </tr>
                                    </c:forEach> 
                                </tbody>
                          </table>
                        </c:when>
                        <c:otherwise>
                            <h6 class="text-center mt-4">No hay datos Usuarios</h6>
                        </c:otherwise>
                    </c:choose>

                    <h3>${msj}</h3>
                </div>
            </div>
            
        </div>
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
