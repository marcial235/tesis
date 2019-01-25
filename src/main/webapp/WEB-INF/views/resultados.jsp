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
                                    <h4 class="title">Conjuntos y valores de pertenencia</h4>
                                </div>
                                <hr>
                                <div class="card col-md-12" >
                                    <div class="cr-chart"></div>
                                    <div class="footer">
                                        <div class="footer">
                                            <div class="chart-legend">
                                                <table class="table table-hover table-bordered">
                                                    <tbody>
                                                        <tr>
                                                            <td><i class="fa fa-circle text-warning"></i> Valor lingüistico malo: </td>
                                                            <td><label id="tlml"></label></td>
                                                            <td><i class="fa fa-circle text-danger"></i> Valor lingüistico regular: </td>
                                                            <td><label id="tlrl"></label></td>
                                                            <td><i class="fa fa-circle text-info"></i> Valor lingüistico bueno: </td>
                                                            <td><label id="tlbn"></label></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                                Bueno
                                                Regular
                                                Malo
                                            </div>
                                            <hr>
                                            <div class="stats">
                                                <i class="ti-target"></i> Membership functions
                                            </div>
                                        </div>
                                    </div>
                                </div>                                    
                                <div class="clearfix"></div>
                            </div>
                            <hr>
                        </div>
                        <!-- Variables de pertenencia -->
                        <div class="row">
                            <div class=" card col-lg-12 col-md-12">
                                <div class="header">
                                    <h4 class="title">Resultados del analisis financiero con logica difusa</h4>
                                </div>
                                <hr>
                                <div class="card col-md-12">
                                    <table class="table table-hover table-bordered">
                                        <tbody>
                                            <tr>
                                                <td>Tipo de desborrosificador</td>
                                                <td>Center Of Gravity</td>
                                            </tr>
                                            <tr>
                                                <td>Valor desborrosificado</td>
                                                <td><label id="ef"></label></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="card col-md-12">
                                    <div class="ct-chart"></div>

                                    <div class="footer">
                                        <div class="footer">
                                            <div class="chart-legend">
                                                <i class="fa fa-circle text-info"></i> Bueno
                                                <i class="fa fa-circle text-danger"></i> Regular
                                                <i class="fa fa-circle text-warning"></i> Malo
                                                <i class="fa fa-circle text-success"></i> Centro de gravedad
                                            </div>
                                            <hr>
                                            <div class="stats">
                                                <i class="ti-target"></i> Defuzzier value
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
        var bueno = valores.values.bn;
        var regular = valores.values.rg;
        var malo = valores.values.ml;
        var ef = valores.values.ef;
        $("#tlbn").text(bueno);
        $("#tlrl").text(regular);
        $("#tlml").text(malo);
        $("#ef").text(ef);
        var total = parseFloat(bueno)+parseFloat(regular)+parseFloat(malo);
        var cog = parseInt(ef)+6;
        
        //Arreglo para posicionar el centro de gravedad
        var arreglo = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
        arreglo [cog] = 1;

        var data = {
            labels: ['Bueno', 'Malo', 'Regular'],
            series: [bueno, malo, regular]
        };

        var options = {
            width: '100%',
            labelInterpolationFnc: function (value) {
                return value[0]
            },
            showLabel: true
        };

        var responsiveOptions = [
            ['screen and (min-width: 640px)', {
                    chartPadding: 0,
                    labelOffset: 0,
                    labelDirection: 'explode',
                    labelInterpolationFnc: function (value) {
                        return value;
                    }
                }],
            ['screen and (min-width: 1024px)', {
                    labelOffset: 0,
                    chartPadding: 10
                }]
        ];

        Chartist.Pie('.cr-chart', data, options, responsiveOptions);


        Chartist.Line('.ct-chart', {
            labels: [-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35],
            series: [
                    [0, , , , , , , , , , 1, , , , , , , , , , , 0, , , , , , , , , , , , , , , ],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, , , , , , , , , , 1, , , , , , , , , , 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, , , , , , , , , ,1 , , , , , , , , , , 0, , , , , , ],
                    arreglo
            ]
        }, {
            high: 1,
            showArea: true,
            showLine: true,
            showPoint: false,
            fullWidth: true,
            axisX: {
                showLabel: true,
                showGrid: true
            }
        });
    </script>
</html>
