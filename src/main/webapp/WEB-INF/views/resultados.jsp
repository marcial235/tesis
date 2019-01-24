<%-- 
    Document   : resultados
    Created on : Apr 3, 2018, 7:08:12 AM
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
        <title>Resultados</title>
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
                        <li>
                            <a href="${pageContext.request.contextPath}/razones">
                                <i class="ti-stats-up"></i>
                                <p>Razones financieras</p>
                            </a>
                        </li>
                        <li class="active">
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
                            <div class=" card col-lg-12 col-md-12">
                                <div class="header">
                                    <h4 class="title">Resultados del analisis financiero con logica difusa ${response}</h4>
                                </div>
                                <hr>
                                <div class="card col-md-5">
                                    <table class="table table-hover table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Tipo de desborosificador</td>
                                                <td>Center Of Gravity</td>
                                            </tr>
                                            <tr>
                                                <td>Valor desborrosificado</td>
                                                <td>11.241128256975045</td>
                                            </tr>
                                            <tr>
                                                <td>Termino malo: </td>
                                                <td>0.022683192827135424</td>
                                            </tr>
                                            <tr>
                                                <td>Termino bueno: </td>
                                                <td>0.7538345719745755</td>
                                            </tr>
                                            <tr>
                                                <td>Termino regular: </td>
                                                <td>0.45884921138292234</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="card col-md-6">
                                    <div id="razonDeuda" class="ct-chart"></div>

                                    <div class="footer">
                                        <div class="footer">
                                            <div class="chart-legend">
                                                <i class="fa fa-circle text-info"></i> Bueno
                                                <i class="fa fa-circle text-danger"></i> Regular
                                                <i class="fa fa-circle text-warning"></i> Malo
                                            </div>
                                            <hr>
                                            <div class="stats">
                                                <i class="ti-target"></i> CHDRAUI
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
        var valores = ${response};
        console.log(valores);
        
        var bueno = valores.values.bn;
        console.log(bueno);
        Chartist.Line('.ct-chart', {
            series: [
                [0, bueno, 0],
                [0, 0, valores.values.ml, 0],
                [0, 0, 0, valores.values.rg, 0]
            ]
        }, {
            low: 0,
            showArea: true
        });
    </script>
</html>
