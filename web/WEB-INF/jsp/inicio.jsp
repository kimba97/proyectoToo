<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
         <title>Bienvenidos</title>
        <meta charset=UTF-8" />
        <meta name="viewport" content="width=device-width, 
	user-scalable=no, initial-scale=1, maximum-scale=1, mainimum-scale=1">
        <link rel="stylesheet" href="<c:url value="/public/css/inicio.css" />" />
     </head>
    <body>
        <form:form method="post" commandName="login" >
            <form:input type="text" placeholder="usuario" path="usuario" />
            <form:input type="password" placeholder="contraseña" path="psw" />
            <input type="submit" value="login">
        </form:form>
        
    </body>
    

</html>