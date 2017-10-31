<%-- 
    Document   : editMedicamento
    Created on : Oct 29, 2017, 10:04:56 PM
    Author     : josej
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Editar Medicamento</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="medicamentos.htm"/>">Medicamentos<a/>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar medicamentos</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="medicamentos">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="cod_Med">codigo:</form:label>
                            <form:input path="cod_Med" cssClass="form-control" readonly="true"/>
                            
                        </p>
                        
                        <p>
                            <form:label path="Nom_Med">nombre:</form:label>
                            <form:input type="text" path="Nom_Med" cssClass="form-control"/>
                        </p>  
                        
                        <p>
                            <form:label path="cant_Med">cantidad:</form:label>
                            <form:input type="number" path="cant_Med" cssClass="form-control"/>
                        </p>  
                        
                        <p>
                            <form:label path="dosis_Med">dosis:</form:label>
                            <form:input type="text" path="dosis_Med" cssClass="form-control"/>
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
