<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1, maximum-scale=1, mainimum-scale=1">
        <title>Listado de consultas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <h2>Consultas</h2>
                <p>
                   
                   <a href="<c:out value="buscarConsulta.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="false"></span>Buscar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo de consulta</th>
                            <th>Codigo de expediente</th>
                            <th>Codigo de signos vitales</th>
                            <th>Codigo del paciente</th>
                            <th>Nombre del paciente</th>
                            <th>Apellido del paciente</th>
                            <th>Nombre del medico</th>
                            <th>Apellido del medico</th>
                            <th>Fecha de consulta</th>
                            <th>Hora de consulta</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_cons}" /> </td>
                                <td> <c:out value="${dato.cod_expe}"/> </td>
                                <td> <c:out value="${dato.cod_sin}" /> </td>
                                <td> <c:out value="${dato.cod_pac}"/> </td>
                                <td> <c:out value="${dato.nombre_p}" /> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td> <c:out value="${dato.nombre_p}" /> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td> <c:out value="${dato.fecha_cons}" /> </td>
                                <td> <c:out value="${dato.hora_cons}"/> </td>
                                <td>
                                    
                                  <a href="<c:out value="editConsultas.htm?id=${dato.cod_cons}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteConsulta.htm?id=${dato.cod_cons}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
                
    </body>
</html>
