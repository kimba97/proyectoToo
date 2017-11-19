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
                <li><a href="<c:url value="expedientes.htm"/>"><strong>Listado Expedientes /</strong><a/>
           </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para buscar expediente</div>
                <div class="panel-body">
                    <form:form method="post" commandName="expedientes">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="codExpe">Codigo Expediente:</form:label>
                            <form:input path="codExpe" cssClass="form-control"/>
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
                <h4>  Expediente encontrado: </h4>
                
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
                                  
                                  <a href="<c:out value="editExpedientes.htm?id=${dato.cod_expe}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <!-- Falta cambiar esto-->
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
