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
                <li><a href="<c:url value="pacientes.htm"/>"><strong>Listado Pacientes /</strong><a/>
           </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para buscar paciente</div>
                <div class="panel-body">
                    <form:form method="post" commandName="pacientes">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Pac">Codigo Paciente:</form:label>
                            <form:input path="cod_Pac" cssClass="form-control"/>
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
                <h4>  Paciente encontrado: </h4>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>Codigo de paciente</th>
                            <th>Dui</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Genero</th>
                            <th>Fecha de nacimiento</th>
                            <th>Municipio</th>
                            <th>Departamento</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.cod_pac}" /> </td>
                                <td> <c:out value="${dato.dui}"/> </td>
                                <td> <c:out value="${dato.nombre_p}" /> </td>
                                <td> <c:out value="${dato.apel_p}"/> </td>
                                <td> <c:out value="${dato.sexo_p}" /> </td>
                                <td> <c:out value="${dato.fech_nac}"/> </td>
                                <td> <c:out value="${dato.munic_p}" /> </td>
                                <td> <c:out value="${dato.dep_p}"/> </td>
                                <td>
                                    <!--Modificar estos campos -->
                                <!--ya esta--> <a href="<c:out value="editPacientes.htm?id=${dato.dui}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
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
