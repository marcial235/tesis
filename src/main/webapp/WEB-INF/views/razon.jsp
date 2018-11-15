<%-- 
    Document   : razon
    Created on : Oct 3, 2018, 5:52:17 PM
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
        <title>Información financiera</title>
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
                        <li>
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
                        <li class="active">
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
                                    <div class="content">
                                        <div class="row">
                                            <div class="card card-plain col-md-6">
                                                <div class="header">
                                                    <h4 class="title">Listado de empresas</h4>
                                                </div>
                                                <div class="form-group">
                                                    <select class="form-control">
                                                        <c:forEach items="${listEmpresas}" var="emp">
                                                            <option value="${emp.id}">${emp.empresa}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="card card-plain col-md-6">
                                                <div class="header">
                                                    <h4 class="title">Listado de estados financieros</h4>
                                                </div>
                                                <div class="form-group">
                                                    <select class="form-control">
                                                        <c:forEach items="${listEmpresas}" var="emp">
                                                            <option value="${emp.id}">${emp.empresa}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="col-md-12">
                                                <div class="header">
                                                    <h4 class="title">Razones financieras calculadas</h4>
                                                </div>
                                                <div class="content">
                                                    <form action='<c:url value="/analisis"/>'>
                                                        <div class="row">
                                                            <!-- Nav tabs -->
                                                            <ul class="nav nav-tabs" role="tablist">
                                                                <li role="presentation" class="active"><a href="#rotacion" aria-controls="home" role="tab" data-toggle="tab">Razones de rotación</a></li>
                                                                <li role="presentation"><a href="#solvencia" aria-controls="solvencia" role="tab" data-toggle="tab">Razones de solvencia</a></li>
                                                                <li role="presentation"><a href="#liquidez" aria-controls="liquidez" role="tab" data-toggle="tab">Razones de liquidez</a></li>
                                                            </ul>

                                                            <!-- Tab panes -->
                                                            <div class="tab-content">
                                                                <div role="tabpanel" class="tab-pane fade in active" id="rotacion">
                                                                    <div class="card col-md-12">
                                                                        <c:forEach items="${listRazonesRotacion}" var="rrot">
                                                                            <div class="header">
                                                                                <h5 class="title">${rrot.nRazon}</h5>
                                                                            </div>
                                                                            <div class="content table-responsive table-full-width">
                                                                                <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                    <thead >
                                                                                    <th>Concepto 1</th>
                                                                                    <th>Concepto 2</th>
                                                                                    <th>Valor de razón corriente</th>
                                                                                    <th>Interpretación de resultado</th>
                                                                                    </thead>
                                                                                    <tbody>
                                                                                        <tr>
                                                                                            <td>Valor 1</td>
                                                                                            <td>Valor 2</td>
                                                                                            <td>${rrot.valor}</td>
                                                                                            <td>Lorem ipsum....</td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table>
                                                                            </div>
                                                                        </c:forEach>
                                                                    </div>
                                                                    <!--<div class="header">
                                                                            <h5 class="title">Rotación del activo total</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead >
                                                                                <th>Ventas netas</th>
                                                                                <th>Activos totales</th>
                                                                                <th>Valor de razón corriente</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Rotación del activo no corriente</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Ventas netas</th>
                                                                                <th>Activos no corrientes</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Rotación del activo corriente</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Ventas netas</th>
                                                                                <th>Activos corrientes</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Rotación de los clientes</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Ventas netas</th>
                                                                                <th>Derechos de cobros comerciales</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Rotación de almacen</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width" >
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Ventas netas</th>
                                                                                <th>Inventario</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Rotación del capital circulante</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Ventas netas</th>
                                                                                <th>Capital circulante</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>-->
                                                                </div>
                                                                <div role="tabpanel" class="tab-pane fade" id="solvencia">
                                                                    <div class="card col-md-12">
                                                                        <div class="header">
                                                                            <h5 class="title">Coeficiente de endeudamiento</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead >
                                                                                <th>Recursos ajenos</th>
                                                                                <th>Recursos propios</th>
                                                                                <th>Valor de coeficiente de endeudamiento</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Calidad de la deuda</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Recursos ajenos a corto plazo</th>
                                                                                <th>Recursos ajenos</th>
                                                                                <th>Calidad de deuda</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Razón de deuda</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Pasivos totales</th>
                                                                                <th>Activos totales</th>
                                                                                <th>Valor de razón de deuda</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div role="tabpanel" class="tab-pane fade" id="liquidez">
                                                                    <div class="card col-md-12">
                                                                        <div class="header">
                                                                            <h5 class="title">Capital de trabajo</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead >
                                                                                <th>Activo corriente</th>
                                                                                <th>Pasivo circulante</th>
                                                                                <th>Valor del capital de trabajo</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Capital de trabajo neto</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Activo corriente</th>
                                                                                <th>Pasivo circulante</th>
                                                                                <th>Activo total</th>
                                                                                <th>Capital de trabajo neto</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Capital de trabajo neto sobre deudas a corto plazo</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Activo corriente</th>
                                                                                <th>Pasivo circulante</th>
                                                                                <th>Valor de razón</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Test acido</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Activo corriente</th>
                                                                                <th>Inventario</th>
                                                                                <th>Pasivo circulante</th>
                                                                                <th>Valor Test</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Días de medición del intervalo de tiempo</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width" >
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Activo corriente</th>
                                                                                <th>Costo de los materiales</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Razón corriente</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Activo corriente</th>
                                                                                <th>Pasivo circulante</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                        <div class="header">
                                                                            <h5 class="title">Razón de efectivo</h5>
                                                                        </div>
                                                                        <div class="content table-responsive table-full-width">
                                                                            <table class="table table-hover" style="font-size: 0.9em !important;">
                                                                                <thead>
                                                                                <th>Efectivo</th>
                                                                                <th>Pasivo circulante</th>
                                                                                <th>Valor</th>
                                                                                </thead>
                                                                                <tbody>
                                                                                    <tr>
                                                                                        <td>01526363</td>
                                                                                        <td>01526363</td>
                                                                                        <td>0.855224</td>
                                                                                    </tr>
                                                                                </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="pull-right">
                                                                <button type="submit" class="btn btn-info btn-fill btn-wd">Realizar análisis</button>
                                                            </div>
                                                        </div> 
                                                    </form>                                     
                                                </div>
                                            </div>
                                        </div>                                        
                                    </div>
                                    <div class="clearfix"></div>
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
    </body>
</html>