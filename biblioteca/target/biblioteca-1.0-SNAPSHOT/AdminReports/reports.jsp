<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layouts/header.jsp" />

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<div class="container mt-3">
    <h2>Reporte de libros</h2>

<div class="row mt-5 mb-5 d-flex justify-content-between">
    <form id="filtroForm" action="ReportController" method="GET" class="col-sm-8">
        <div class="row">
            <div class="col-sm-3 mt-3">
                <label for="categoriaSelect">Seleccionar Categoría:</label>
            </div>
            <div class="col-sm-9 mt-2">
                <select id="categoriaSelect" class="form-select" name="categoriaId" onchange="filtrarLibros()">
                    <option value="0">Todas las categorías</option>
                    <c:forEach var="categoria" items="${categorias}">
                        <option value="${categoria.id_categoria}" 
                                <c:if test="${categoria.id_categoria eq selectedCategoryId}">selected</c:if>>
                            ${categoria.nombre}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </form>
    <div class="col-sm-4 mb-2">
        <button onclick="descargarPDF()" class="btn btn-secondary mt-2">Descargar PDF</button>
    </div>
</div>

    <c:choose>
         <c:when test="${empty libros && !selectedCategoryId.equals('0')}">
            <h2>No hay libros en esta categoría</h2>
        </c:when>
        <c:otherwise>
            <div class="table-responsive">
                <table id="librosTable" class="table table-striped table-bordered text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Libro</th>
                            <th>Autor</th>
                            <th>Categoría</th>
                            <!-- Agrega más columnas según tus necesidades -->
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="libro" items="${libros}">
                            <tr>
                                <td>${libro.nombre}</td>
                                <td>${libro.autor}</td>
                                <td>${librosData[libro.id_libro].nombreCategoria}</td>
                                <!-- Agrega más celdas según tus necesidades -->
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </c:otherwise>
    </c:choose>
</div>

<script src="https://rawgit.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js"></script>

<script>
    function filtrarLibros() {
        var categoriaSelect = document.getElementById("categoriaSelect");
        var selectedCategoriaId = categoriaSelect.value;

        // Redirige a la URL con el parámetro categoriaId
        window.location.href = "ReportController?categoriaId=" + selectedCategoriaId;
    }

    // Establecer la categoría seleccionada en el select después de cargar la página
    document.getElementById("categoriaSelect").value = "${selectedCategoryId}";
</script>

<script>
    function descargarPDF() {
        console.log("Descargando PDF...");

        // HTML personalizado para el contenido del PDF
        var contenidoHTML = '' +
            '<h2 style="text-align: center;">Registro de Libros</h2>' +
            '<table class="table table-striped table-bordered text-center" style="width: 100%; margin-top: 30px;">' +
                '<thead class="table-dark">' +
                    '<tr>' +
                        '<th>Libro</th>' +
                        '<th>Autor</th>' +
                        '<th>Categoría</th>' +
                        '<th>Cantidad</th>' +
                    '</tr>' +
                '</thead>' +
                '<tbody>';

        <c:forEach var="libro" items="${libros}">
            contenidoHTML += '' +
                '<tr>' +
                    '<td>${libro.nombre}</td>' +
                    '<td>${libro.autor}</td>' +
                    '<td>${librosData[libro.id_libro].nombreCategoria}</td>' +
                    '<td>${libro.cantidad}</td>' +
                '</tr>';
        </c:forEach>

        contenidoHTML += '' +
                '</tbody>' +
            '</table>';

        // Configuración de opciones para html2pdf
        var opciones = {
            margin: 10,
            filename: 'Reporte_Libros.pdf',
            html2canvas: { scale: 2 },
            jsPDF: { unit: 'mm', format: 'a4', orientation: 'portrait' }
        };

        // Crea el PDF utilizando html2pdf con el HTML personalizado
        html2pdf().from(contenidoHTML).set(opciones).save();
    }
</script>


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
<script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>

<jsp:include page="../layouts/footer.jsp"/>
