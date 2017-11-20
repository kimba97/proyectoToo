<%-- 
    Document   : vistaEnfermero
    Created on : Nov 20, 2017, 5:49:18 AM
    Author     : josej
--%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">

        <title>Opciones</title>

        <!-- Bootstrap core CSS -->
        <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">

        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <link href="dashboard.css" rel="stylesheet">

        <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    </head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <body>

        <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand"><hi>ADMINISTRAR</hi></a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="inicio.htm">Salir</a></li>
                    </ul>
                    <form class="navbar-form navbar-right">
                    </form>
                </div>
            </div>
        </nav>
    <center>
        <br>
        <br>
        <br>
        <div class="container-fluid" class="text-center">
            <div class="row">
                <div class="col-lg4">
                    <ul class="nav nav-sidebar">

                        <div class="container marketing">
                            <div class="row">
                                <div class="col-lg-4">
                                    <a href="addPersona.htm">
                                        <img src="public/imagenes/paciente.png" class="img-circle" width="100px" height="100px"/></a>
                                    <li><a href="addPersona.htm">Agregar Persona</a></li>
                                    <p>En este enlace se podrán añadir personas al sistema.</p>
                                </div><!-- /.col-lg-4 -->

                                <div class="col-lg-4">
                                    <a href="expedientes.htm">
                                        <img src="public/imagenes/expediente.ico" class="img-circle" width="100px" height="100px"/> </a>
                                    <li><a href="expedientes.htm">Empleados</a></li>
                                    <p>En este enlace se podrán consultar, añadir, buscar, editar y eliminar los expedientes de los pacientes.</p>
                                </div>
                                
                                <div class="col-lg-4">
                                     <a href="pacientes.htm">
                                         <img src="public/imagenes/paciente.png" class="img-circle" width="100px" height="100px"/></a>
                                    <li><a href="pacientes.htm">Pacientes</a></li>
                                    <p>En este enlace se podrán consulta, añadir, buscar, editar y eliminar los diferentes pacientes registrados en el sistema.</p>
                                </div><!-- /.col-lg-4 -->
                            </div>
                        </div>
                        <br>
                        <br> 
                        <div class="container marketing">
                            <div class="row">
                                

                                <div class="col-lg-4">
                                    <a href="consulta.htm">
                                        <img src="public/imagenes/consulta.png" class="img-circle" width="100px" height="100px"/></a>
                                    <li><a href="consulta.htm">Consultas</a></li>
                                     <p>En este enlace se podrán consultar, añadir, buscar, editar y eliminar las consultas asignadas a los diferentes pacientes pertenecientes a las clinicas.</p>
                                </div>
                            </div>
                        </div>
                    </ul>
                </div>
            </div>
        </div>
    </center>
    
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
        <script src="../../dist/js/bootstrap.min.js"></script>
        <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
        <script src="../../assets/js/vendor/holder.min.js"></script>
        <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
        <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
    </body>
</html>