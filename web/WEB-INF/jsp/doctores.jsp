<%-- 
    Document   : doctores
    Created on : 11-15-2017, 08:50:21 PM
    Author     : abdiel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Listado de Doctores</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Doctores</h1>
                <p>
                    <a href="<c:out value="addDoctor.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="false"></span>Agregar </a>
                    <a href="buscarDoctor.htm" class="btn btn-primary" data-toggle="modal"><span class="glyphicon glyphicon-search " aria-hidden="false"></span>Buscar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo Especialidad</th>
                            <th>Especialidad</th>
                            <th>Empleado</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_esp}" /> </td>
                                <td> <c:out value="${dato.nom_esp}" /> </td>
                                <td> <c:out value="${dato.cod_emp}"/> </td>
                                <td> <c:out value="${dato.nombre_p}"/> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td>
                                  <a href="<c:out value="editDoctor.htm?id=${dato.cod_esp}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteDoctor.htm?id=${dato.cod_esp}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                  
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
