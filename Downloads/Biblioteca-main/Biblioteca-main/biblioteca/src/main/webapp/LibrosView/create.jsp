
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="../layouts/header.jsp"/>

<div class="container mt-3">
    <form action="/biblioteca/LibroController?action=create" method="post">
        <div class="mb-3">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="mb-3">
            <label for="autor">Autor: </label>
           <input type="text" class="form-control" id="autor" name="autor" required>
        </div>
        <div class="mb-3">
            <label for="cantidad">Cantidad: </label>
            <input type="number" class="form-control" id="cantidad" min="0" step="1" name="cantidad" required>
        </div>
        <div class="mb-3">
            <label for="categoria">Categoría: </label>
            <select class="form-control" id="categoria" name="categoria" required>
                 <option value="" selected>Selecciona una opción</option>
                <c:forEach var="categoria" items="${categorias}">
                    <option value="${categoria.getId_categoria()}">${categoria.getNombre()}</option>
                </c:forEach>
            </select>
        </div>
       <div class="mb-3">
            <label for="imagen">Direccion de la imagen: </label>
            <input type="text" class="form-control" id="imagen" name="imagen" required>
        </div>

        <div class="mb-3 row mt-3">
                <div class="offset-sm-5 col-sm-8">
                    <button type="submit" class="btn btn-primary">Agregar</button>
                    <a href="/biblioteca/LibroController" class="btn btn-secondary "> Regresar</a>
                </div>
            </div>
    </form>
</div>
<jsp:include page="../layouts/footer.jsp"/>