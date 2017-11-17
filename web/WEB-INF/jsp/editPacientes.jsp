<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8"/>
        <title>Editar Pacientes</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="pacientes.htm"/>">Pacientes<a/>
                <li class="active">Editar</li>
            </ol>
            <div class="panel panel-primary">
                <div class="panel-heading">Editar usuarios</div>
                <div class="panel-body">
                    
                    <form:form method="post" commandName="pacientes">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="clinica">Codigo de Clinica:</form:label>
                            <form:input path="clinica" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="nombre_P">Nombre: </form:label>
                            <form:input path="nombre_P" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="apel_P">Apellido: </form:label>
                            <form:input path="apel_P" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="sexo_P">Sexo:</form:label>
                            <form:input  path="sexo_P" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="fecha_Nacim">Fecha de Nacimiento</form:label>
                            <form:input path="fecha_Nacim" placeholder="yyyy-mm-dd" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="Munic_P">Municipio: </form:label>
                            <form:input path="Munic_P" cssClass="form-control"/>
                        </p>
                        <p>
                            <form:label path="Dep_P">Departamento: </form:label>
                            <form:input path="Dep_P" cssClass="form-control"/>
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
