<%-- 
    Document   : clinicas
    Created on : Oct 30, 2017, 12:11:47 AM
    Author     : josej
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Listado Clinicas</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Clinicas</h1>
                <p>
                    <a href="<c:out value="addClinica.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="false"></span>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Nombre</th>
                            <th>Departamento</th>
                            <th>Municipio</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_clin}" /> </td>
                                <td> <c:out value="${dato.nom_clin}" /> </td>
                                <td> <c:out value="${dato.dep_clin}"/> </td>
                                <td> <c:out value="${dato.muni_clin}"/> </td>
                                <td>
                                  <a href="<c:out value="editClinica.htm?id=${dato.cod_clin}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteClinica.htm?id=${dato.cod_clin}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
