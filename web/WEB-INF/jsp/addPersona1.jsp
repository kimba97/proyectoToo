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
                <div class="panel-heading">Formulario para agregar nuevas Personas</div>
                <div class="panel-body">
                    <form:form method="post" commandName="personas">
                        <h1>Complete los siguientes campos</h1>
                        <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                        <p>
                            <form:label path="dui">dui:</form:label>
                            <form:input path="dui" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="clinica">codigo clinica</form:label>
                            <form:input type="text" path="clinica" cssClass="form-control"/>
                            
                        </p>
                        <p>
                            <form:label path="nombre_P">Nombre:</form:label>
                            <form:input path="nombre_P" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="apel_P">Apellido</form:label>
                            <form:input type="text" path="apel_P" cssClass="form-control"/>
                            
                        </p> 
                        <p>
                            <form:label path="sexo_P">sexo:</form:label>
                            <form:input path="sexo_P" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="fecha_Nacim">Fecha Nacimiento</form:label>
                            <form:input type="text" placeholder="yyyy-mm-dd" path="fecha_Nacim" cssClass="form-control"/>
                            
                        </p> 
                        <p>
                            <form:label path="Munic_P">Municipio</form:label>
                            <form:input path="Munic_P" cssClass="form-control"/>
                        </p>
                        
                        <p>
                            <form:label path="Dep_P">Departamento</form:label>
                            <form:input type="text" path="Dep_P" cssClass="form-control"/>
                            
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



