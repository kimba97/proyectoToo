<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1, maximum-scale=1, mainimum-scale=1">
        <title>Listado Expedientes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <h2>Expedientes</h2>
                <p>
                    <a href="<c:out value="addExpediente.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus " aria-hidden="false"></span>Agregar</a>
                   <a href="<c:out value=""/>" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="false"></span>Buscar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo de expediente</th>
                            <th>Codigo de paciente</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Profesion u Oficio</th>
                            <th>Estado Civil</th>
                            <th>Nombre de Padre</th>
                            <th>Nombre de la madre</th>
                            <th>Conjuye</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_expe}" /> </td>
                                <td> <c:out value="${dato.cod_pac}"/> </td>
                                <td> <c:out value="${dato.nombre_p}" /> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td> <c:out value="${dato.profesi_pac}" /> </td>
                                <td> <c:out value="${dato.estad_civ}"/> </td>
                                <td> <c:out value="${dato.nom_papa}" /> </td>
                                <td> <c:out value="${dato.nom_mama}"/> </td>
                                <td> <c:out value="${dato.pareja}" /> </td>
                                <td>
                                  <!-- Falta cambiar esto-->
                                  <a href="<c:out value="editUser.htm?id=${dato.username}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteUser.htm?id=${dato.username}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
               
    </body>
</html>
