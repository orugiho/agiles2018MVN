<%-- 
    Document   : index.jsp
    Created on : 03-oct-2018, 20:49:03
    Author     : orugiho
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${archivos}" var="archivo">
            <h1>Nombre : ${archivo.key} </h1><br/>
            <c:out escapeXml="false" value="${archivo.value}"/>
        </c:forEach>
    </body>
</html>
