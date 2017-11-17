<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
         <meta name="viewport" content="width=device-width,user-scalable=no, initial-scale=1, maximum-scale=1, mainimum-scale=1">
        <title>Listado Usuarios</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    </head>
    <body>
        
        <div class="container">
            <div class="row">
                <h2>Usuarios</h2>
                <p>
                    <a href="<c:out value="addUser.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-plus " aria-hidden="false"></span>Agregar</a>
                    <!--<a href="#ventanaBuscar" class="btn btn-primary" data-toggle="modal"><span class="glyphicon glyphicon-plus " aria-hidden="false"></span>Agregar2</a>-->
                    <a href="<c:out value="buscarUsuario.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="false"></span>Buscar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>username</th>
                            <th>password</th>
                            <th>Acciones</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td> <c:out value="${dato.username}" /> </td>
                                <td> <c:out value="${dato.contrasenia}"/> </td>
                                <td>
                                  <a href="<c:out value="editUser.htm?id=${dato.username}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                  <a href="<c:out value="deleteUser.htm?id=${dato.username}"/>"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                            
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
                
       <!-- <div class="container">
            <br>
            
            <div class="modal fade" id="ventanaBuscar">
               <div class="modal-dialog">
                   <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" arial-hidden="true">&times;</button>
		          <h4 class="modal-tittle">Buscar usuario</h4>
		      </div>
                        <div class="modal-body">
                           <p>
                               <a href="<//c:out value="addPaciente.htm"/>" class="btn btn-primary"><span class="glyphicon glyphicon-user" aria-hidden="false"></span>Paciente</a>
                               <a href="<//c:out value="#"/>" class="btn btn-primary"><span class="glyphicon glyphicon-user" aria-hidden="false"></span>Empleado</a>
                           </p>
                        </div>
                   </div>
                    
               </div>
            </div>
    </div>
 
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"> </script>--> 
                
         
                
    </body>
</html>
