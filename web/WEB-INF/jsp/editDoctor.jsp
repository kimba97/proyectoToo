

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Editar Clinica</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="doctores.htm"/>">Doctores<a/>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar Doctores</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="doctores">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Esp">codigo Especialidad:</form:label>
                            <form:input path="cod_Esp" cssClass="form-control" readonly="true"/>
                        </p>
                        <p>
                            <form:label path="nom_Esp">nombre de Especialidad:</form:label>
                            <form:input path="nom_Esp" cssClass="form-control"/>
                        </p>
                        
                         
                            <input type="submit" value="Enviar" class="btn btn-primary"/>
                        </p>
                        
                    </form:form>
                </div>
            </div>
                
        </div>
    </body>
</html>
