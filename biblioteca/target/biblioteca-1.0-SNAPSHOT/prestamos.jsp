<%-- 
    Document   : prestamos
    Created on : 11-04-2023, 02:41:22 PM
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
        <title>Devoluciones</title>
    </head>
    <body>
        <header>
            <jsp:include page="./navbar.jsp"></jsp:include>
        </header>
        
        <div class="container">
            <form method="POST" action="ControllerReportPrestamo">
                <div class="row">
                    <div class="col-11">
                        <div class="form-floating">
                            <select class="form-select" id="idPrestamo" name="idPrestamo" aria-label="Floating label select example">
                                <option value="0" selected>Fechas de los prestamos</option>
                                <c:forEach var="prestamo" items="${prestamos}">
                                    <option value="${prestamo.id_prestamo}">${prestamo.fecha_sistema}</option>
                                </c:forEach>
                            </select>
                            <label for="idPrestamo">Works with selects</label>
                        </div>
                    </div>
                    <div class="col-1">
                        <button type="submit" class="btn btn-success">Buscar</button>
                    </div>
                </div>
            </form>
            <c:choose>
                <c:when test="${not empty LdetPrestamo}">
                    <table class="table mt-4">
                        <thead>
                            <tr>
                                <th scope="col">Foto</th>
                                <th scope="col">Titulo</th>
                                <th scope="col">Cantidad prestada</th>
                                <th scope="col">Fecha prestamo</th>
                                <th scope="col">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="prestamo" items="${LdetPrestamo}">
                                <tr>
                                  <td><img src="${prestamo.foto}" style="width: 50px; height: 50px"></td>
                                  <td>${prestamo.nombreLibro}</td>
                                  <td>${prestamo.cantidad}</td>
                                  <td>${prestamo.fecha_sistema}</td>
                                  <td>
                                        <a class="btn btn-danger" href="ControllerReportPrestamo?action=backOne&id=${prestamo.id_det_prestamo}&idLibro=${prestamo.id_libro}"><i class="fa-solid fa-share-from-square"></i></a>
                                  </td>
                                </tr>
                            </c:forEach> 
                        </tbody>
                  </table>
                    <p class="text-center"> <a href="ControllerReportPrestamo?action=backAll&id=${id}" class="btn btn-warning">Delvolver todo</a></p>
                </c:when>
                <c:otherwise>
                    <h6 class="text-center mt-4">No hay datos prestamos</h6>
                </c:otherwise>
            </c:choose>
            
        </div>
             
          
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
