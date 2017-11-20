<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1, maximum-scale=1, mainimum-scale=1">
        <title>Listado de signosVitales</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <h2>Signos Vitales</h2>
                <p>
                    <a href="<c:out value="addSignosVitales.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus " aria-hidden="false"></span>Agregar</a>
                    <a href="<c:out value="buscarSignosVitales.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="false"></span>Buscar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Codigo de paciente</th>
                            <th>Temperatura</th>
                            <th>Altura</th>
                            <th>Presion Cardiaca</th>
                            <th>Presion Arterial</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_sin}" /> </td>
                                <td> <c:out value="${dato.cod_pac}"/> </td>
                                <td> <c:out value="${dato.temp}" /> </td>
                                <td> <c:out value="${dato.altura}"/> </td>
                                <td> <c:out value="${dato.pres_cardi}" /> </td>
                                <td> <c:out value="${dato.pres_art}"/> </td>
                                <td>
                                   <!-- Pendiente-->
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

