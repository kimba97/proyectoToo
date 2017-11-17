<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="expedientes.htm"/>">Listado Expedientes<a/>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar Expediente</div>
                <div class="panel-body">
                    <form:form method="post" commandName="expedientes">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="profesion">Profesion u Oficio</form:label>
                            <form:input path="profesion" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="estadoCivil">Estado Civil</form:label>
                            <form:input path="estadoCivil" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="nomMadre">Nombre de la Madre</form:label>
                            <form:input path="nomMadre" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="nomPadre">Nombre del Padre</form:label>
                            <form:input path="nomPadre" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="nomConyuge">Nombre de Conyuge</form:label>
                            <form:input path="nomConyuge" cssClass="form-control"/>
                        </p>
                        
                        <p>   
                            <input type="submit" value="Guardar" class="btn btn-primary"/>
                        </p> 
                    </form:form>
   
       
                </div>
            </div>
                
        </div>
    </body>
</html>

