<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Listado Empleados</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Empleados</h1>
                <p>
                    <a href="<c:out value="addPersona1.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="false"></span>Agregar</a>
                    <a href="#ventanaBuscar" class="btn btn-primary" data-toggle="modal"><span class="glyphicon glyphicon-search " aria-hidden="false"></span>Buscar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Dui</th>
                            <th>Username</th>
                            <th>Puesto</th>
                            <th>Salario</th>
                            
                            <th>Clinica</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Sexo</th>
                            <th>Fecha de nacimieto</th>
                            <th>Municipio</th>
                            <th>Departamento</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_Emp}" /> </td>
                                <td> <c:out value="${dato.dui}" /> </td>
                                <td> <c:out value="${dato.username}" /> </td>
                                <td> <c:out value="${dato.puest_emp}"/> </td>
                                <td> <c:out value="${dato.salario}"/> </td>
                                <td> <c:out value="${dato.cod_clin}"/> </td>
                                <td> <c:out value="${dato.nombre_p}"/> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td> <c:out value="${dato.sexo_p}"/> </td>
                                <td> <c:out value="${dato.fech_nac}"/> </td>
                                <td> <c:out value="${dato.munic_p}"/> </td>
                                <td> <c:out value="${dato.dep_p}"/> </td>
                                <td>
                                  <a href="<c:out value="editEmpleado.htm?id=${dato.cod_emp}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteEmpleado.htm?id=${dato.cod_emp}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
