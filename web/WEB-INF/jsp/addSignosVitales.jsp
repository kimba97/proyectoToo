<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Agregar Usuario</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="signosVitales.htm"/>">Listado de Signos Vitales/<a/>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para agregar signos vitales de pacientes</div>
                <div class="panel-body">
                    <form:form method="post" commandName="signos">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="temp">Temperatura:</form:label>
                            <form:input path="temp" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="altura">Altura:</form:label>
                            <form:input path="altura" cssClass="form-control"/>
                        </p>   
                        <p>
                            <form:label path="pres_Cardi">Presion Cardiaca:</form:label>
                            <form:input path="pres_Cardi" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="pres_art">Presion Arterial:</form:label>
                            <form:input path="pres_art" cssClass="form-control"/>
                        </p> 
                        <p>
                            <form:label path="Paciente">codigo del paciente:</form:label>
                            <form:input path="Paciente" cssClass="form-control"/>
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

</html>