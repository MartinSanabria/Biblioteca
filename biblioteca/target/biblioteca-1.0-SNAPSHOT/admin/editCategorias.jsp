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
        <title>Biblioteca | Edit categorias</title>
    </head>
    <body>
        <header>
            <jsp:include page="navbar.jsp"></jsp:include>
        </header>

        
        <div class="container bg-light" style="margin-top: 25px">
            
            <div class="text-center pt-5">
            <img src="../Assets/Logo.png" alt="biblioteca-logo" width="250" height="250" />
            <h2>Modificar una categoria</h2>
        </div>

        <div class="card">
            <!-- Start Card Body -->
            <div class="card-body">
                <!-- Start Form -->
                <form action="/biblioteca/CategoriaController"  method="post" >
                    <!-- Start Input Name -->
                    <div class="form-group">
                        <label>Nombre categoria</label>
                        <input type="text" class="form-control" id="inputName" name="name"  required />
                        <small class="form-text text-muted">Por favor ingrese el nombre de la categoria</small>
                    </div>
                    <!-- End Input Name -->

           
                    <!-- Start Input Edicion -->
                    <div class="form-group">
                        <label>Nombre de la edicion</label>
                        <input type="text" class="form-control" id="inputEdition" name="edicion" required />

                    </div>

                    <hr />

                    <!-- Start Submit Button -->
                    <button class="btn btn-primary btn-block col-lg-2" type="submit">Modificar</button>
                    <!-- End Submit Button -->
                </form>
                <!-- End Form -->
            </div>
            <!-- End Card Body -->
        </div>
        <!-- End Card -->
        </div>
        

        <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
        <script>
            // Function to get query parameters from the URL
            function getQueryParam(name) {
                const urlParams = new URLSearchParams(window.location.search);
                return urlParams.get(name);
            }

            // Populate form fields with values from query parameters
            window.onload = function() {
                var idCategoria = getQueryParam("id");
                var nombreCategoria = getQueryParam("name");
                var edicionCategoria = getQueryParam("edicion");

                
                var inputName = document.getElementById("inputName");
                var inputEdition = document.getElementById("inputEdition");
              
                // Set values to the respective form fields
               
                inputName.value = nombreCategoria;
                inputEdition.value = edicionCategoria;
                inputName.text = nombreCategoria;
                inputEdition.text = edicionCategoria;
            };
        </script>
    </body>
    
</html>
