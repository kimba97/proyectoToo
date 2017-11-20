<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Buscar Doctor</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="doctores.htm"/>"><strong>Listado Doctores /</strong><a/>
           </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para buscar Doctor</div>
                <div class="panel-body">
                    <form:form method="post" commandName="doctores">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Esp">Codigo Especialista:</form:label>
                            <form:input path="cod_Esp" cssClass="form-control"/>
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
                <h4>  Doctor encontrado: </h4>
                
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
                                  
                                  <a href="<c:out value="editDoctor.htm?id=${dato.cod_Esp}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <!-- Falta cambiar esto-->
                                  <a href="<c:out value="deleteDoctor.htm?id=${dato.nom_Esp}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>  
             
             
    </body>
</html>

