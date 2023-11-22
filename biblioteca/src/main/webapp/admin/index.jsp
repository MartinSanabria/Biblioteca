<%-- Document : index Created on : 10-22-2023, 10:55:24 PM Author : Alejandro --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
                crossorigin="anonymous">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
                crossorigin="anonymous"></script>
            <title>JSP Page</title>
        </head>

        <body>
            <header>
                <jsp:include page="navbar.jsp"></jsp:include>
            </header>
            
            <div class="container-fluid">
                <div id="carouselExampleCaptions" class="carousel slide">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                    </div>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="https://tendenciasv.com/wp-content/uploads/2021/10/biblioteca.jpg"
                                class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Biblioteca</h5>
                                <p>Presta tus libros favoritos.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://laverdadnoticias.com/__export/1633500625764/sites/laverdad/img/2021/10/06/el_salvador_.jpeg_1914911257.jpeg"
                                class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Logeate</h5>
                                <p>Logeate para poder prestar tus libros favoritos.</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="https://lapagina.com.sv/wp-content/uploads/2022/02/Biblioteca-2-2-2048x1448.jpeg"
                                class="d-block w-100" alt="...">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>No olvides!</h5>
                                <p>Devuelve tus libros con responsabilidad</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>


            <div class="container mt-5">
                <div class="row">
                    <div class="col">
                        <h1>Descripcion</h1>
                        <h6>Crea tu usuario y empieza a entrar en mundos de fantasia, terror, comedio, romance,
                            informacion, etc. podras prestar tus libros
                            favoritos y devolverlos
                        </h6>
                    </div>
                    <div class="col">
                        <img src="https://www.sldcassam.in/images/login.png" style="width: 500px; height: 300px;"
                            alt="...">
                    </div>
                </div>

                <div class="row">
                    <div class="col">
                        <img src="https://th.bing.com/th/id/R.bd4b5189659a669e497c290611fdaf42?rik=U2UnZXQZLppl%2bA&riu=http%3a%2f%2fwww.recreoviral.com%2fwp-content%2fuploads%2f2015%2f05%2fArte-hecha-con-libros-32.jpg&ehk=k1RBj%2bw78cdUNJo2Qzby2Jj8ysC90YQW1Uo7Oa4nCd8%3d&risl=&pid=ImgRaw&r=0"
                            style="width: 500px; height: 300px;" alt="...">
                    </div>
                    <div class="col">
                        <h1>Arte</h1>
                        <h6>
                            Empieza a disfrutar libros de arte como <br><br>
                            1. "El arte de amar" de Erich Fromm

                            No se trata específicamente de arte visual, pero Fromm explora la conexión entre el arte y
                            el amor, ofreciendo una perspectiva única sobre la creatividad y la expresión.
                            <br><br>
                            2. "Historia del arte" de Ernst Gombrich

                            Una obra clásica que proporciona una visión general de la historia del arte, desde la
                            prehistoria hasta el siglo XX. Es accesible y bien ilustrada.
                            <br><br>
                            3. "El color del arte" de Victoria Finlay

                            Este libro explora la historia de los pigmentos utilizados en la pintura, proporcionando una
                            fascinante visión de cómo los colores han influido en la creación artística a lo largo del
                            tiempo.

                        </h6>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col">
                        <h1>Ficcion</h1>
                        <h6>
                            1. "Cien años de soledad" de Gabriel García Márquez

                            Una obra maestra de la literatura latinoamericana que combina realismo mágico con una
                            historia familiar épica.
                            <br><br>
                            2. "1984" de George Orwell

                            Una novela distópica que explora temas de control gubernamental, vigilancia y manipulación
                            de la verdad.
                            <br><br>
                            3. "To Kill a Mockingbird" (Matar a un ruiseñor) de Harper Lee

                            Una obra clásica que aborda cuestiones de raza y justicia en el sur de Estados Unidos
                            durante la década de 1930.
                        </h6>
                    </div>
                    <div class="col">
                        <img src="https://th.bing.com/th/id/OIP.pp0WvYPMtx5Iq2e6eEBIZAHaEC?rs=1&pid=ImgDetMain"
                            style="width: 500px; height: 300px;" alt="...">
                    </div>
                </div>

            </div>
            <script src="https://kit.fontawesome.com/201886318c.js" crossorigin="anonymous"></script>
        </body>

        </html>