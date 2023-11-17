    <%-- 
    Document   : prestamo
    Created on : 10-22-2023, 10:58:39 PM
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
        
        <div class="container">
            <h3 class="text-center">Listado de prestamos</h3>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">Foto</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Cantidad</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="libro" items="${libros}">
                        <tr>
                            <td><img src="${libro.foto}" style="width: 50px; height: 50px"></td>
                            <td>${libro.nombre}</td>
                            <td>${libro.cantidad}</td>
                            <td><a class="btn btn-warning" href="ControllerPrestamo?action=edit&id_libro=${libro.id_libro}"><i class="fa-regular fa-pen-to-square"></i></a>
                                <a class="btn btn-danger" href="ControllerPrestamo?action=del&id_libro=${libro.id_libro}"><i class="fa-solid fa-trash-can"></i></a></td>
                        </tr> 
                    </c:forEach> 
                </tbody>
            </table>
            <c:choose>
                <c:when test="${not empty conteoLibros or conteoLibros > 0}">
                    <p class="text-center"><a class="btn btn-success" href="ControllerSavePrestamo?action=prestar">Prestar</a></p>
                    <p class="text-center"><a class="btn btn-danger" href="ControllerSavePrestamo?action=cancel">Cancelar prestamo</a></p>
                </c:when>
            </c:choose>
            <h6 class="text-center">${msj}</h6>
        </div>
        
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
