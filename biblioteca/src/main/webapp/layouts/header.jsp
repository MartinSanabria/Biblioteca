<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <title>Biblioteca</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>

    <nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
         <img src="/biblioteca/Assets/LogoOnlyNoBackground.png" alt="" width="50" height="50">
        <a class="navbar-brand" href="#">Biblioteca
           
        </a>

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
                    <a class="nav-link" href="/biblioteca/ControllerUser">Usuarios</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/biblioteca/LibroController">Libros</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Categoria</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/biblioteca/CategoriaController">Ver categorias</a></li>
                        <li><a class="dropdown-item" href="/biblioteca/admin/categorias.jsp">Agregar categorias</a></li>
                    </ul>
                </li>             
            </ul>             
        </div>
        <a class="btn btn-danger" href="ControllerLogin?action=deleteSesion"> <i class="fa-solid fa-right-from-bracket" style="font-size: 20px;"></i></a>
    </div>
</nav>
 