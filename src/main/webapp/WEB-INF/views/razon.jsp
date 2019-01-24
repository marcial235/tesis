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
                                                        <option value="1">CHDRAUI</option>
                                                        <!--<c:forEach items="${listEmpresas}" var="emp">
                                                            <option value="${emp.id}">${emp.empresa}</option>
                                                        </c:forEach>-->
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="card card-plain col-md-6">
                                                <div class="header">
                                                    <h4 class="title">Listado de estados financieros</h4>
                                                </div>
                                                <div class="form-group">
                                                    <select class="form-control">
                                                        <option value="1">1 2018-01-31</option>
                                                        <!--<c:forEach items="${listEmpresas}" var="emp">
                                                            <option value="${emp.id}">${emp.empresa}</option>
                                                        </c:forEach>-->
                                                    </select>
                                                </div>
                                            </div>
                                            <hr>
                                            <div class="col-md-12">
                                                <div class="header">
                                                    <h4 class="title">Razones financieras calculadas</h4>
                                                </div>
                                                <table class="table table-hover table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>Razon financiera</th>
                                                            <th>Formula</th>
                                                            <th>Valor</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>Razon corriente</td>
                                                            <td>Activo corriente / Pasivo circulante</td>
                                                            <td class="danger">0.80</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Razon ACIDA</td>
                                                            <td>(Activo corriente - Inventarios) / Pasivo circulante</td>
                                                            <td class="danger">0.27</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Razon de deuda</td>
                                                            <td>Pasivo total / Activo total</td>
                                                            <td class="danger">0.48</td>
                                                        </tr>
                                                        <tr>
                                                            <td>Razon de calidad de deuda</td>
                                                            <td>Recursos ajenos a corto plazo / Recursos ajenos</td>
                                                            <td class="danger">2.07</td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>    
                                        <div class="pull-right">
                                            <a href="${pageContext.request.contextPath}/resultados" class="btn btn-sm btn-success btn-icon"><i class="ti-bolt"></i> Analisis difuso</a>
                                            <!--<button type="submit" class="btn btn-info btn-fill btn-wd"><i class="ti-bolt"></i> Analisis difuso</button>-->
                                        </div>
                                        <br><br>
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
        <script type="text/javascript">
        $("a[href]").click(function () {
            console.log('Click');
            var url = this.href;
            setTimeout(function () {
                location.href = url;
            }, 10000);
            return false;
        });
    </script>
</html>