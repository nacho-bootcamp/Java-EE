<%-- 
    Document   : listadoUsuario
    Created on : 27 oct 2023, 19:42:58
    Author     : eri y nacho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Usuarios</title>
    </head>
    <body>
        <h1>Listado de Usuarios</h1>
        <<ul>
            <c:forEach items="${usuario}" var="usuario">
                <li>${usuario.username} ${usuario.password}</li>
            </c:forEach>
        </ul>

    </body>
</html>
