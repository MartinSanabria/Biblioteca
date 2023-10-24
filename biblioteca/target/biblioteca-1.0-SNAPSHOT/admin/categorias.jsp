<%-- 
    Document   : categorias
    Created on : 10-22-2023, 10:56:56 PM
    Author     : Alejandro
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
        <title>Biblioteca | Categorias</title>
    </head>
    <body class="container bg-light">
        <header>
            <jsp:include page="navbar.jsp"></jsp:include>
        </header>

        <div class="text-center pt-5">
            <img src="../Assets/Logo.png" alt="biblioteca-logo" width="250" height="250" />
            <h2>Agrega una nueva categoria</h2>
        </div>

        <div class="card">
            <!-- Start Card Body -->
            <div class="card-body">
                <!-- Start Form -->
                <form id="bookForm" action="#" method="" >
                    <!-- Start Input Name -->
                    <div class="form-group">
                        <label for="inputName">Nombre categoria</label>
                        <input type="text" class="form-control" id="inputName" name="name" placeholder="Categoria" required />
                        <small class="form-text text-muted">Por favor ingrese el nombre de la categoria</small>
                    </div>
                    <!-- End Input Name -->

                    <!-- Start Input Estado -->
                    <div class="form-group">
                        <label for="inputEmail">Email</label>
                        <select type="text" class="form-control" id="selectEstado" name="estado" placeholder="Seleccione el estado"  required>
                            <option value="Activo">Activo</option>
                        </select>
                        <small class="form-text text-muted">Estado activo por ser una categoria nueva.</small>
                    </div>
                    <!-- End Input Estado -->

                    <!-- Start Input Edicion -->
                    <div class="form-group">
                        <label for="inputEdicion">Edicion</label>
                        <input type="text" class="form-control" id="inputEdicion" name="edicion" placeholder="Edicion" required />

                    </div>

                    <hr />

                    <!-- Start Submit Button -->
                    <button class="btn btn-primary btn-block col-lg-2" type="submit">Agregar</button>
                    <!-- End Submit Button -->
                </form>
                <!-- End Form -->
            </div>
            <!-- End Card Body -->
        </div>
        <!-- End Card -->

        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
    </body>
</html>
