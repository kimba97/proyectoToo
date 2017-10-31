<%-- 
    Document   : addEmpleado
    Created on : Oct 30, 2017, 12:58:18 AM
    Author     : josej
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Agregar Empleado</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="empleados.htm"/>">Empleados<a/>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para agregar nuevos empleados</div>
                <div class="panel-body">
                    <form:form method="post" commandName="empleados">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Emp">Codigo:</form:label>
                            <form:input type="text" path="cod_Emp" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="dui">DUI:</form:label>
                            <form:input type="text" path="dui" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="user">Username:</form:label>
                            <form:input type="text" path="user" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="salario">Salario:</form:label>
                            <form:input type="money" path="salario" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="puest_Emp">Puesto:</form:label>
                            <form:input type="text" path="puest_Emp" cssClass="form-control"/>
                        </p>   
                        <p>   
                            <input type="submit" value="Enviar" class="btn btn-primary"/>
                        </p>
                        
                    </form:form>
                </div>
            </div>
                
        </div>
    </body>
</html>

