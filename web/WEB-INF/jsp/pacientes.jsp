<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1, maximum-scale=1, mainimum-scale=1">
        <title>Listado de pacientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <h2>Pacientes</h2>
                <p>
                    <a href="<c:out value="addPersona.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus " aria-hidden="false"></span>Agregar</a>
                   <a href="<c:out value="#"/>" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="false"></span>Buscar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo de paciente</th>
                            <th>Dui</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Genero</th>
                            <th>Fecha de nacimiento</th>
                            <th>Municipio</th>
                            <th>Departamento</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_pac}" /> </td>
                                <td> <c:out value="${dato.dui}"/> </td>
                                <td> <c:out value="${dato.nombre_p}" /> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td> <c:out value="${dato.sexo_p}" /> </td>
                                <td> <c:out value="${dato.fech_nac}"/> </td>
                                <td> <c:out value="${dato.munic_p}" /> </td>
                                <td> <c:out value="${dato.dep_p}"/> </td>
                                <td>
                                    <!--Modificar estos campos -->
                                <!--ya esta--> <a href="<c:out value="editPacientes.htm?id=${dato.dui}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deletePaciente.htm?id=${dato.cod_pac}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
                
    </body>
</html>
