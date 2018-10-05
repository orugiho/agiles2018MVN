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
            <h3><b>Nombre</b> : ${archivo.key} </h3><br/>
            <div style="border:1px">
            <c:out escapeXml="false" value="${archivo.value}"/>
            </div>
        </c:forEach>
    </body>
</html>
