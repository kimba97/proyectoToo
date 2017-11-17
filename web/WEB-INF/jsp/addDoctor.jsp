<%-- 
    Document   : addDoctor
    Created on : 11-15-2017, 09:49:48 PM
    Author     : abdiel
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>JSP Page</title>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
        <script src="<c:url value="/resources/js/main.js" />"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="index.htm"/>">Inicio<a/>
                <li class="active">Agregar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para agregar nuevas Doctores</div>
                <div class="panel-body">
                    <form:form method="post" commandName="doctores">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Esp">Codigo de Especialidad:</form:label>
                            <form:input type="text" path="cod_Esp" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="cod_Emp">Empleado</form:label>
                            <form:input type="text" path="cod_Emp" cssClass="form-control"/>
                            
                        </p>
                        <p>
                            <form:label path="nom_Esp">Especialidad:</form:label>
                            <form:input type="text" path="nom_Esp" cssClass="form-control"/>
                        </p>
                        
                        
                        <p>   
                            <input type="submit" value="Siguiente" class="btn btn-primary"/>
                        </p>
                        
                    </form:form>
                </div>
            </div>
                
        </div>
    </body>
</html>

