<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="contexto" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta</title>
        <link rel="stylesheet" type="text/css" href="${contexto}/CSS/estilo.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript" src="${contexto}/JS/alta.js"></script>
    </head>
    <body>

        <div id="principal">
            <h2>Actualizaci&oacute;n de datos</h2>
            <form method="post" action="control">
                <table>
                    <tr>
                        <td>Nombre</td>
                        <td><input type="text" name="nombre" required /></td>
                    </tr>
                    <tr>
                        <td>Fecha de nacimiento</td>
                        <td><input type="date" name="fechaNac"  /></td>
                    </tr>
                    <tr>
                        <td>Tipo de persona</td>
                        <td>
                            <select name="tipo" id="tipo">
                                <option value="tecnologo">Tecn&oacute;logo</option>
                                <option value="normal">Normal</option>
                                <option value="programador">Programador</option>
                                <option value="tester">Tester</option>
                            </select></td>
                    </tr>

                    <tr id="table">
                        <td>A&ntilde;os estudio</td><td><input type='text' name='yearEstudio' required/></td>
                    </tr>

                    <tr>
                        <td colspan="2"><input type="submit" name="enviar" value="Enviar" class="boton" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>