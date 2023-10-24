<%-- Document : navbar Created on : 10-22-2023, 11:04:49 PM Author : Alejandro --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="">Libros</a>
                </li>
            </ul>             
        </div>
        
        <a class="btn btn-primary position-relative me-5" href="ControllerCarrito">
            <i class="fa-solid fa-book" style="font-size: 20px"></i>
            <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
              3<!--Se debe cargar en base a la sesion con -->
              <span class="visually-hidden">unread messages</span>
            </span>
        </a>
        <a class="btn btn-danger" href="ControllerLogin?action=deleteSesion"> <i class="fa-solid fa-right-from-bracket" style="font-size: 20px;"></i></a>
    </div>
</nav>