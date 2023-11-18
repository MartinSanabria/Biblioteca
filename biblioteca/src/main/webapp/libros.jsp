<%-- 
    Document   : libros
    Created on : 10-22-2023, 10:58:30 PM
    Author     : Alejandro
--%>

<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <title>Administracion de libros</title>
    </head>
    <body>
        <header>
            <jsp:include page="./navbar.jsp"></jsp:include>
        </header>
        <div class="container mt-3">
            <h1 class="text-center">Biblioteca virtual</h1>
            <div class="row">
                <c:forEach var="libro" items="${libros}">
                    <div class="col">
                            <div class="card mt-5" style="width: 18rem;">
                                <img src="${libro.foto}"
                                     class="card-img-top" alt="Imagen del producto" style="height: 15rem;">
                                <div class="card-body">
                                    <h5 class="card-title text-center" name="nombreProducto" id="nombreProducto">Titulo: ${libro.nombre}</h5>
                                    <p class="card-text">Autor: ${libro.autor}</p>
                                    <p class="card-text">Cantidad en stock: ${libro.cantidad}</p>
                                    
                                    <form method="POST" action="ControllerCargarPrestamo">
                                        <input type="hidden" name="id_libro" value="${libro.id_libro}"/>
                                        <input type="hidden" name="titulo" value="${libro.nombre}"/>
                                        <input type="hidden" name="foto" value="${libro.foto}"/> 


                                        <div class="form-floating mb-3">
                                            <input type="text" class="form-control" id="cantidad" name="cantidad"
                                                placeholder="Ingrese la cantidad" required>
                                            <label for="cantidad">Ingrese la cantidad a prestar</label>
                                        </div>
                                        <p class="text-center"><button type="submit" class="btn btn-success">Prestar</button></p>
                                    </form>
                                    <c:if test="${libro.id_libro eq id}">
                                        <h6>${msj}</h6>
                                    </c:if>
                                </div>
                            </div>
                    </div>
            </c:forEach> 
        </div>
              
    </div>
<c:if test="${not empty errorMessage}">
    <script>
       Swal.fire({
        position: 'top-end',
        icon: 'error',
        title: '${errorMessage}',
        showConfirmButton: false,
        timer: 1500
      })
    </script>
</c:if>
<c:if test="${not empty successMessage}">
    <script>
        Swal.fire({
           position: 'top-end',
           icon: 'success',
           title: '${successMessage}',
           showConfirmButton: false,
           timer: 1500
         });
    </script>
</c:if>
<script>
    function confirmDelete() {
        Swal.fire({
            title: '¿Estás seguro?',
            text: "¡No podrás revertir esto!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, eliminarlo'
        }).then((result) => {
            if (result.isConfirmed) {
                // Si se confirma, envía el formulario
                document.getElementById("deleteForm").submit();
            }
        });
    }
</script>
        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
