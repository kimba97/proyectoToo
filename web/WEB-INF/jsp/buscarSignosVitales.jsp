<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Buscar Expediente</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="signosVitales.htm"/>"><strong>Listado Signos Vitales/</strong><a/>
           </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario el historial de signos vitales del paciente</div>
                <div class="panel-body">
                    <form:form method="post" commandName="signos">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="Paciente">Codigo Paciente:</form:label>
                            <form:input path="Paciente" cssClass="form-control"/>
                        </p>
                        <p>   
                            <input type="submit" value="Buscar" class="btn btn-primary"/>
                        </p> 
                    </form:form>
                </div>
            </div>
                
        </div>
                        
       <div class="container">
            <div class="row">
                <h4> Signos del paciente encontrado: </h4>
                
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