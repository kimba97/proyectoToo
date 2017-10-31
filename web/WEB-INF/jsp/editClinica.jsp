<%-- 
    Document   : editClinica
    Created on : Oct 30, 2017, 12:11:32 AM
    Author     : josej
--%>

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
                <li><a href="<c:url value="clinicas.htm"/>">Clinicas<a/>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar clinicas</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="clinicas">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="nom_Clin">nombre:</form:label>
                            <form:input path="nom_Clin" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="Dep_Clin">departamento:</form:label>
                            <form:input type="text" path="Dep_Clin" cssClass="form-control"/>
                        </p>   
                        
                        <p>
                            <form:label path="Muni_Clin">municipio:</form:label>
                            <form:input type="text" path="Muni_Clin" cssClass="form-control"/>
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
