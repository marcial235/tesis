<%-- 
    Document   : valores
    Created on : Oct 1, 2018, 8:45:05 PM
    Author     : ISC. Cristian Enr�quez
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
        <title>Informaci�n financiera</title>
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
                        <li class="active">
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
                            <!--<a class="navbar-brand" href="#">Template</a>-->
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
                                        <p>Configuraci�n</p>
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
                                        <div class="row ">
                                            <div class="card card-plain col-md-12">
                                                <div class="header">
                                                    <h4 class="title">Listado de empresas en el sistema</h4>
                                                </div>
                                                <div class="form-group">
                                                    <select class="form-control">
                                                        <c:forEach items="${listEmpresas}" var="emp">
                                                            <option value="${emp.id}">${emp.nempresa}</option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                        <hr>
                                        <div class="clearfix"></div>
                                        <div class="header">
                                            <h4 class="title">Informaci�n financiera</h4>
                                        </div>
                                        <div class="table-responsive">
                                            <div class="col-md-12" style="overflow-x: scroll">
                                            <c:if test="${!empty listValores}">
                                                <table class="table table-hover">
                                                    <thead style="font-size: 9px; text-align: center;">
                                                        <tr>
                                                            <th>ID</th>
                                                            <th>Activo corriente</th>
                                                            <th>Pasivo circulante</th>
                                                            <th>Costo de los materiales</th>
                                                            <th>Capital circulante</th>
                                                            <th>Derechos de cobros comerciales</th>
                                                            <th>Efectivo</th>
                                                            <th>Prestamos</th>
                                                            <th>Prestamos a corto plazo</th>
                                                            <th>Recursos propios</th>
                                                            <th>Activo total</th>
                                                            <th>Ventas netas</th>
                                                            <th>Activos No corrientes</th>
                                                            <th>Inventarios</th>
                                                            <th>Capital de trabajo</th>
                                                            <th>Pasivos totales</th>
                                                            <th>Acciones</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody style="font-size: 11px;">
                                                        <c:forEach items="${listValores}" var="valor">
                                                            <tr>
                                                                <td>${valor.id}</td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.ca}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.cl}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.cm}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.cc}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.ddc}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.ef}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.ra}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.racp}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.rp}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.ta}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.ntsls}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.nca}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.invt}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.wrkcp}" /></td>
                                                                <td><fmt:formatNumber currencySymbol="$" type="number" maxIntegerDigits="30" value="${valor.tl}" /></td>
                                                                <td>
                                                                    <a href="${pageContext.request.contextPath}/razones/calcular/${valor.id}" class="btn btn-sm btn-success btn-icon"><i class="ti-bar-chart-alt"></i> Calcular razones</a>
                                                                    <!--<a href="${pageContext.request.contextPath}/razones/calcula/${valor.id}" class="btn btn-sm btn-success btn-icon"><i class="ti-eye">Ver razones</i></a>-->
                                                                </td>
                                                            </tr>
                                                        </c:forEach>
                                                    </tbody>
                                                </table>
                                            </c:if>
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
                        &copy; <script>document.write(new Date().getFullYear())</script>,<a href="http://www.cristianenriquez.com"> Cristian Enr�quez</a>
                    </div>
                </div>
            </footer>

        </div>
    </body>
</html>