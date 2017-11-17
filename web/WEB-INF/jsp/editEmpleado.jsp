<%-- 
    Document   : editEmpleado
    Created on : Oct 30, 2017, 12:58:30 AM
    Author     : josej
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Editar Empleados</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="empleados.htm"/>">Empleados<a/>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar empleados</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="empleados">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Emp">codigo:</form:label>
                            <form:input type="text" path="cod_Emp" cssClass="form-control" readonly="true"/>
                        </p>
                        <p>
                            <form:label path="username">username:</form:label>
                            <form:input type="text" path="username" cssClass="form-control"/>
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
