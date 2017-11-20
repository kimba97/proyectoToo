<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Agregar Consulta</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="consultas.htm"/>">Consultas<a/>
                <li class="active">Consulta</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Formulario para editar Consultas</div>
                <div class="panel-body">
                    <form:form method="post" commandName="consultas">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        
                        
                        <p>
                            <form:label path="sintom">Sintomas: </form:label>
                            <form:input path="sintom" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="trat_Med">Tratamiento Medico: </form:label>
                            <form:input path="trat_Med" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="fecha_Cons">Fecha de Consulta</form:label>
                            <form:input placeholder="yyyy-mm-dd" path="fecha_Cons" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="hora_Cons">Hora Consulta: </form:label>
                            <form:input path="hora_Cons" cssClass="form-control"/>
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

