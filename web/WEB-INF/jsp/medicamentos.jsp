<%-- 
    Document   : medicamentos
    Created on : Oct 29, 2017, 10:05:10 PM
    Author     : josej
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Listado Medicamentos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Medicamentos</h1>
                <p>
                    <a href="<c:out value="addMedicamento.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="false"></span>Agregar</a>
                </p>
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Diagnostico</th>
                            <th>Nombre</th>
                            <th>Dosis</th>
                            <th>Cantidad</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_med}" /> </td>
                                <td> <c:out value="${dato.cod_diag}" /> </td>
                                <td> <c:out value="${dato.nom_med}" /> </td>
                                <td> <c:out value="${dato.dosis_med}"/> </td>
                                <td> <c:out value="${dato.cant_med}"/> </td>
                                <td>
                                  <a href="<c:out value="editMedicamento.htm?id=${dato.cod_med}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteMedicamento.htm?id=${dato.cod_med}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
