<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layouts/header.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <div class="container mt-3">
        <h1>Control de Libros</h1>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end mb-3">
            <a href="LibroController?action=new" class="btn btn-primary">Agregar</a>
        </div>
        <div class="table-responsive">
            <table class="table table-striped table-bordered text-center">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Autor</th>
                        <th>Cantidad</th>
                        <th>Foto</th>
                        <th>Estado</th>
                        <th>Categoria</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="libro" items="${libros}">
                        <tr>
                            <td>${libro.getIdLibro()}</td>
                            <td>${libro.getNombre()}</td>
                            <td>${libro.getAutor()}</td>
                            <td>${libro.getCantidad()}</td>
                            <td><img src="${libro.getFoto()}" alt="${libro.getNombre()}" style="max-height: 120px; max-width: 60px"/></td>
                            <td>
                                    <c:choose>
                                        <c:when test="${libro.getEstado() eq 1}">
                                            Activo
                                        </c:when>
                                        <c:otherwise>
                                            Inactivo
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            <td>${librosData[libro.id_libro].nombreCategoria}</td>
                            <td>
                                
                                        
                                        
                                        <c:choose>
                                            <c:when test="${libro.getEstado() eq 1}">
                                            <div class="d-flex justify-content-center">
                                                <a href="LibroController?action=edit&id=${libro.getIdLibro()}" class="btn btn-dark me-1">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                                    </svg>
                                                </a>
                                                    
                                                    <form id="deleteForm" action="LibroController?action=delete&id=${libro.getIdLibro()}" method="post">
                                                        <button type="button" class="btn btn-danger" onclick="confirmDelete(this);" data-id="${libro.getIdLibro()}">
                                                            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
                                                                <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2zm3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2z"/>
                                                            </svg>
                                                        </button>
                                                    </form>
                                            </div>  
                                        </c:when>
                                        <c:otherwise>
                                            <div class="d-flex justify-content-center">
                                            <form id="activeForm" action="LibroController?action=active&id=${libro.getIdLibro()}" method="post">
                                                <button type="button" class="btn btn-warning" onclick="confirmActive(this);" data-id="${libro.getIdLibro()}">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-unlock-fill" viewBox="0 0 16 16">
                                                        <path d="M11 1a2 2 0 0 0-2 2v4a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h5V3a3 3 0 0 1 6 0v4a.5.5 0 0 1-1 0V3a2 2 0 0 0-2-2z"/>
                                                    </svg>
                                               </button>
                                            </form>
                                            </div> 
                                        </c:otherwise>
                                    </c:choose>
                                        
                                    
                                        
                                      
                        
                        </td>
                    </tr>  
                </c:forEach>    
            </tbody>
        </table>
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
    function confirmDelete(button) {
        var idLibro = button.getAttribute('data-id');
        Swal.fire({
            title: '?Est?s seguro?',
            text: "?No podr?s revertir esto!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'S?, Desactivar'
        }).then((result) => {
            if (result.isConfirmed) {
                // Update the form action with the idCategoria value
                var form = document.getElementById("deleteForm");
                form.action = 'LibroController?action=delete&id=' + idLibro;
                // Submit the form
                form.submit();
            }
        });
    }
    
    
    
    function confirmActive(button) {
        var idLibro = button.getAttribute('data-id');
        Swal.fire({
            title: '?Est?s seguro?',
            text: "?No podr?s revertir esto!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'S?, Activar'
        }).then((result) => {
            if (result.isConfirmed) {
                // Update the form action with the idCategoria value
                var form = document.getElementById("activeForm");
                form.action = 'LibroController?action=active&id=' + idLibro;
                // Submit the form
                form.submit();
            }
        });
    }

</script>
<script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>

<jsp:include page="../layouts/footer.jsp"/>