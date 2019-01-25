<%-- 
    Document   : home
    Created on : Aug 10, 2018, 11:05:25 PM
    Author     : ISC. Cristian Enríquez
--%>
<%@ include file="include.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Carga de archivos</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="sidebar" data-background-color="white" data-active-color="danger">

                <div class="sidebar-wrapper">
                    <div class="logo">
                        <a href="#" class="simple-text">
                            <img src="<c:url value="/resources/img/msf.png"/>" style="max-width: 180px;">
                        </a>
                    </div>

                    <ul class="nav">
                        <li class="active">
                            <a href=<c:url value="/"/>>
                                <i class="ti-upload"></i>
                                <p>Carga de archivos</p>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/valores">
                                <i class="ti-panel"></i>
                                <p>Detalles</p>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/razones">
                                <i class="ti-stats-up"></i>
                                <p>Razones financieras</p>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/resultados">
                                <i class="ti-support"></i>
                                <p>Recomendaciones</p>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>

            <div class="main-panel">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar bar1"></span>
                                <span class="icon-bar bar2"></span>
                                <span class="icon-bar bar3"></span>
                            </button>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <i class="ti-user"></i>
                                        <p>Bienvenido Usuario</p>
                                        <b class="caret"></b>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Notification 1</a></li>
                                        <li><a href="#">Notification 2</a></li>
                                        <li><a href="#">Notification 3</a></li>
                                        <li><a href="#">Notification 4</a></li>
                                        <li><a href="#">Another notification</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="ti-settings"></i>
                                        <p>Configuración</p>
                                    </a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </nav>


                <div class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-lg-12 col-md-12">
                                <div class="card">
                                    <div class="header">
                                        <h4 class="title">Seleccionar archivo</h4>
                                    </div>
                                    <div class="content">
                                        <form  method="POST" action="${pageContext.request.contextPath}/file/uploadFile" enctype="multipart/form-data" modelAttribute="valor">
                                            <div class="row">
                                                <div class="col-md-1"></div>
                                                <div class="col-md-11">

                                                    <div class="form-group">
                                                        <label class="control-label">Archivo: </label>
                                                        <input type="file" class="form-control" name="file"> 
                                                    </div>
                                                </div>                                        
                                            </div>
                                            <hr>
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Seleccionar empresa:</label>
                                                        <select class="form-control">
                                                            <option value="0"> -- </option>
                                                            <option value="1">VIVA</option>
                                                            <option value="2">BACHOCO</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Nombre empresa:</label>
                                                        <input type="text" class="form-control" name="nombreempresa"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="pc">Fecha de estado financiero</label>
                                                        <input type="date" class="form-control" name="fechaemision"> 
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Activo corriente:</label>
                                                        <input type="text" class="form-control" name="ac"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="pc">Pasivo corriente</label>
                                                        <input type="text" class="form-control" name="cc"> 
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Inventarios:</label>
                                                        <input type="text" class="form-control" name="cm"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="pc">Pasivo fijo</label>
                                                        <input type="text" class="form-control" name="cc"> 
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Costo de materiales:</label>
                                                        <input type="text" class="form-control" name="cm"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="pc">Capital circulante</label>
                                                        <input type="text" class="form-control" name="cc"> 
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Efectivo:</label>
                                                        <input type="text" class="form-control" name="ef"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="pc">Prestamos o recursos ajenos</label>
                                                        <input type="text" class="form-control" name="ra"> 
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Equidad o recursos propios:</label>
                                                        <input type="text" class="form-control" name="rp"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="pc">Recursos ajenos a corto plazo</label>
                                                        <input type="text" class="form-control" name="racp"> 
                                                    </div>
                                                </div>
                                                <div class="col-md-12">
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Activo total</label>
                                                        <input type="text" class="form-control" name="at"> 
                                                    </div>
                                                    <div class="form-group col-md-6">
                                                        <label class="control-label" for="ac">Pasivo total</label>
                                                        <input type="text" class="form-control" name="at"> 
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="text-center">
                                                <button type="submit" class="btn btn-info btn-fill btn-wd">Subir archivo</button>
                                            </div>
                                            <div class="clearfix"></div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <footer class="footer">
                    <div class="container-fluid">
                        <div class="copyright pull-right">
                            &copy; <script>document.write(new Date().getFullYear())</script>,<a href="http://www.cristianenriquez.com"> Cristian Enríquez</a>
                          
                        </div>
                    </div>
                </footer>
            </div>
        </div>
    </body>
</html>

