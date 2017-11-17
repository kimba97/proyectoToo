<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Buscar Usuario</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="usuarios.htm"/>"><strong>Listado Usuarios /</strong><a/>
           </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para buscar usuario</div>
                <div class="panel-body">
                    <form:form method="post" commandName="usuarios">
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="usuario">Codigo Paciente:</form:label>
                            <form:input path="usuario" cssClass="form-control"/>
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
                <h4>  Usuario encontrado: </h4>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>usuario</th>
                            <th>password</th>
                            
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.username}" /> </td>
                                <td> <c:out value="${dato.contrasenia}"/> </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>  
             
             
    </body>
</html>
