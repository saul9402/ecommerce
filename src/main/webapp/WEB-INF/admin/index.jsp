<%-- 
    Document   : index
    Created on : 12-Febrero-2018, 10:24:59
    Author     : Christian Camilo Gámez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestión de productos |  Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
        <%@include file="../../WEB-INF/css.jsp" %>
    </head><!--/head-->
    <body>
        <!--Con la etiqueta include le dices a java que vas a incluir un archivo que contiene informacion que puede usar
        es como los fragments en thymeleaf-->
        <%@include file="../../WEB-INF/header.jsp" %>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                    </div>

                    <div class="col-sm-9 padding-right">
                        <h3>Gestionar Producto</h3>

                    </div>
                </div>
            </div>
        </section>
        <%@include file="../../WEB-INF/footer.jsp" %>
        <%@include file="../../WEB-INF/js.jsp" %>
    </body>
</html>