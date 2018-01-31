<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilo.css" />
    </head>
    <body>

        <div id="principal">
            <h2>Listado de personas</h2>
            <ul>
                <c:forEach var="item" items="${listado}">
                    <li>${item.nombre}</li>
                    <ul>
                        <li>${item.fechaNacimiento}</li>
                            <c:if test="${item.getClass().name.equals('es.albarregas.beans.Tecnologo')}">
                            <li>A&ntilde;os de estudio : ${item.yearEstudio}</li>
                            </c:if>
                            <c:if test="${item.getClass().name.equals('es.albarregas.beans.Normal')}">
                            <li>Ocupaci&oacute;n : ${item.ocupacion}</li>
                            </c:if> 
                            <c:if test="${item.getClass().name.equals('es.albarregas.beans.Tester')}">
                            <li>Herramientas de tester : ${item.herramientasDeTester}</li>
                            </c:if> 
                            <c:if test="${item.getClass().name.equals('es.albarregas.beans.Programador')}">
                            <li>Lenguaje favorito : ${item.lenguajeFavorito}</li>
                            </c:if>        
                            <c:if test="${item.getClass().name.equals('es.albarregas.beans.Programador')}">
                            <li>A&ntilde;os de experiencia : ${item.aniosDeExperiencia}</li>
                            </c:if> 
                    </ul>
                </c:forEach>
            </ul>
            <br />
            <p><a href="${contexto}/" class="enlace">Men&uacute; inicial</a></p>
        </div>
    </body>
</html>