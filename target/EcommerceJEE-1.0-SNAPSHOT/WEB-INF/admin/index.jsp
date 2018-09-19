<%-- 
    Document   : index
    Created on : 12-Febrero-2018, 10:24:59
    Author     : Christian Camilo Gámez
--%>

<%@page import="mx.com.lickodev.ecommercejee.cad.MarcaCad"%>
<%@page import="mx.com.lickodev.ecommercejee.javabeans.Marca"%>
<%@page import="mx.com.lickodev.ecommercejee.javabeans.Categoria"%>
<%@page import="mx.com.lickodev.ecommercejee.cad.CategoriaCad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestión de productos |  Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
        <!--Se agrag doble "../" ya que no se encuentra en la carpeta raiz y hay que retorceder en las carpetas para que lo encunetre-->
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
                    <div class="col-sm-10 clearfix">
                        <h3>Gestionar Producto</h3>
                        <form action="ControlProducto" method="post">
                            <div class="form-one">
                                Nombre: <br/>
                                <input type="text" name="nombre" value="" placeholder="Nombre Producto" required="true"/>
                                <hr/>
                                Precio(MXN): <br/>
                                <input type="number" name="precio" value="0" min="0" placeholder="Precio"/>
                                <br/>
                                Precio Promo(MXN):<br/>
                                <input type="number" name="precionuevo" value="0" min="0" placeholder="Precio Nuevo"/><hr/>
                                Precio(USD): <br/>
                                <input type="number" name="preciousd" value="0" min="0" placeholder="Precio"/>
                                <br/>
                                Precio Promo(USD):<br/>
                                <input type="number" name="precionuevousd" value="0" min="0" placeholder="Precio Nuevo"/><hr/>
                                Precio(COP): <br/>
                                <input type="number" name="preciocop" value="0" min="0" placeholder="Precio"/>
                                <br/>
                                Precio Promo(COP):<br/>
                                <input type="number" name="precionuevocop" value="0" min="0" placeholder="Precio Nuevo"/><hr/>
                                Precio(PEN): <br/>
                                <input type="number" name="preciopen" value="0" min="0" placeholder="Precio"/>
                                <br/>
                                Precio Promo(PEN):<br/>
                                <input type="number" name="precionuevopen" value="0" min="0" placeholder="Precio Nuevo"/><hr/>
                                Stock: <br/>
                                <input type="number" name="cantidad" value="1" min="1" placeholder="Cantidad"/><br/>
                                Marca: <br/>
                                <select name="Marca">
                                    <option>Seleccionar Marca</option>
                                    <% for (Marca marca : MarcaCad.listarTodoDeMarcas()) {%>
                                    <option value="<%= marca.getCodigo()%>"><%= marca.getNombre()%></option>
                                    <% }%>
                                </select>
                                <br/>
                                Categoria: <br/>
                                <select name="Categoria">
                                    <option>Seleccionar Categoria</option>
                                    <% for (Categoria categoria : CategoriaCad.listarTodoDeCategorias()) {%>
                                    <option value="<%= categoria.getCodigo()%>"><%= categoria.getNombre()%></option>
                                    <% }%>
                                </select>
                                <br/>
                                Descripcion: <br/><textarea name="descripcion" rows="4" cols="20" placeholder="Descripcion" required="true">
                                </textarea><br/>
                                Nuevo?:<input type="checkbox" name="nuevo" value="ON" checked="checked" />
                                Recomendado?:<input type="checkbox" name="recomendado" value="OFF" />
                                Visible?:<input type="checkbox" name="visible" value="ON" checked="checked" />
                                <hr/>
                                Seleccionar Imagen del Producto<input  type="file" name="imagen" value="Seleccionar una imagen" required="true" />
                                <hr/>
                                <input class="btn btn-success"  name="accion" type="submit" value="Registrar" />
                                <input class="btn btn-default" name="accion" type="submit" value="Consultar" />
                                <input class="btn btn-warning" name="accion" type="submit" value="Actualizar" />
                                <input class="btn btn-danger" name="accion" type="submit" value="Borrar" />

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <%@include file="../../WEB-INF/footer.jsp" %>
        <%@include file="../../WEB-INF/js.jsp" %>
    </body>
</html>