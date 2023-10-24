<%-- 
    Document   : verCategorias
    Created on : Oct 24, 2023, 11:33:03 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelos.Categoria"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <title>Biblioteca | Ver categorias </title>
    </head>
    <body>
        <header>
            <jsp:include page="navbar.jsp"></jsp:include>
            </header>

            <div class="container bg-light" style="margin-top: 25px">
                <div class="text-center pt-5">
                    <img src="/biblioteca/Assets/Logo.png" alt="biblioteca-logo" width="250" height="250" />
                    <h2>Lista de categorias</h2>
                </div>

                <div class="table-responsive">
                    <table class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Correlativo</th>
                                <th>Nombre</th>
                                <th>Estado</th>
                                <th>Edicion</th>
                                <th>Acciones</th>

                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="categorias" items="${categorias}">
                            <tr>
                                <td>CC00${categorias.getId_categoria()}</td>
                                <td>${categorias.getNombre()}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${categorias.estado eq 1}">
                                            Activo
                                        </c:when>
                                        <c:otherwise>
                                            Inactivo
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>${categorias.getEdicion()}</td>
                                <td>
                                    <div class="d-flex">
                                        <a href="LibroController?action=edit&id=${libro.id_libro}" class="btn btn-dark me-1"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                            </svg>
                                        </a>
                                        <c:choose>
                                            <c:when test="${categorias.estado eq 1}">
                                                <form id="deleteForm" action="CategoriaController?action=deactivate&id=${categorias.getId_categoria()}" method="post">
                                                    <button type="button" class="btn" onclick="confirmDelete(this);" data-id="${categorias.getId_categoria()}">
                                                         <img src="/biblioteca/Assets/encender.png" alt="biblioteca-logo" width="30" height="30" />
                                                                                                     
                                                    </button>
                                                </form>
                                            </c:when>
                                            <c:otherwise>
                                                <form id="activateForm" action="CategoriaController?action=activate&id=${categorias.getId_categoria()}" method="post">
                                                <button type="button" class="btn" onclick="confirmActivate(this);" data-id="${categorias.getId_categoria()}">
                                                    <img src="/biblioteca/Assets/apagar.png" alt="biblioteca-logo" width="30" height="30" />  
                                                </button>
                                                </form>
                                            </c:otherwise>

                                        </c:choose>
                                    </div> 
                                </td>
                            </tr>  
                        </c:forEach>    
                    </tbody>
                </table>
            </div>
        </div>


        <!-- End Card -->

        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
                                                function confirmDelete(button) {
                                                    var idCategoria = button.getAttribute('data-id');
                                                    Swal.fire({
                                                        title: '¿Estás seguro de desactivarlo?',
                                                        text: "",
                                                        icon: 'warning',
                                                        showCancelButton: true,
                                                        confirmButtonColor: '#3085d6',
                                                        cancelButtonColor: '#d33',
                                                        confirmButtonText: 'Sí, desactivarlo'
                                                    }).then((result) => {
                                                        if (result.isConfirmed) {
                                                            // Update the form action with the idCategoria value
                                                            var form = document.getElementById("deleteForm");
                                                            form.action = 'CategoriaController?action=deactivate&id=' + idCategoria;
                                                            // Submit the form
                                                            form.submit();
                                                        }
                                                    });
                                                }
                                                
                                                
                                                
                                                function confirmActivate(button) {
                                                    var idCategoria = button.getAttribute('data-id');
                                                    Swal.fire({
                                                        title: '¿Estás seguro de activarlo?',
                                                        text: "",
                                                        icon: 'warning',
                                                        showCancelButton: true,
                                                        confirmButtonColor: '#3085d6',
                                                        cancelButtonColor: '#d33',
                                                        confirmButtonText: 'Sí, activarlo'
                                                    }).then((result) => {
                                                        if (result.isConfirmed) {
                                                            // Update the form action with the idCategoria value
                                                            var form = document.getElementById("activateForm");
                                                            form.action = 'CategoriaController?action=activate&id=' + idCategoria;
                                                            // Submit the form
                                                            form.submit();
                                                        }
                                                    });
                                                }

        </script>
    </body>
</html>

