<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Buscar Consultas</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="consultas.htm"/>"><strong>Listado Consultas /</strong><a/>
           </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para buscar Consulta</div>
                <div class="panel-body">
                    <form:form method="post" commandName="consultas">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Cons">Codigo consulta:</form:label>
                            <form:input path="cod_Cons" cssClass="form-control"/>
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
                <h4>  Consulta encontrado: </h4>
                
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
                                    <!--Modificar estos campos -->
                                 <a href="<c:out value="editPacientes.htm?id=${dato.dui}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deletePaciente.htm?id=${dato.cod_pac}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>  
             
             
    </body>
</html>