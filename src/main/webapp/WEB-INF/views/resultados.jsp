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
<script type="text/javascript">
    $(document).ready(function () {
        var data = {
            labels: ['1', '2', '3', '4'],
            series: [
                [39.6342, 38.9611, 38.0909, 50.7793],
                [58.4843, 58.8060, 57.6225, 57.9330],
                [56.6965, 57.4678, 55.7392, 54.47]
            ]
        };

        var options = {
            seriesBarDistance: 10,
            axisX: {
                showGrid: false
            },
            height: "300px"
        };

        var responsiveOptions = [
            ['screen and (max-width: 640px)', {
                    seriesBarDistance: 5,
                    axisX: {
                        labelInterpolationFnc: function (value) {
                            return value[0];
                        }
                    }
                }]
        ];

        Chartist.Line('#razonDeuda', data, options, responsiveOptions);

    }
    );
</script>
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
                            <div class="col-lg-12 col-md-12">
                                <div class="content">
                                    <form action='<c:url value="/analisis"/>'>
                                        <div class="row">
                                            <div class="card col-md-12">

                                                <!-- Nav tabs -->
                                                <ul class="nav nav-tabs" role="tablist">
                                                    <li role="presentation" class="active"><a href="#solvencia" aria-controls="solvencia" role="tab" data-toggle="tab">Ratios de solvencia</a></li>
                                                    <li role="presentation"><a href="#rotacion" aria-controls="home" role="tab" data-toggle="tab">Ratios de rotación</a></li>
                                                    <li role="presentation"><a href="#liquidez" aria-controls="liquidez" role="tab" data-toggle="tab">Ratios de liquidez</a></li>
                                                </ul>

                                                <!-- Tab panes -->
                                                <div class="tab-content">
                                                    <div role="tabpanel" class="tab-pane fade in active" id="solvencia">
                                                        <div class="card col-md-6">
                                                            <div class="header">
                                                                <h4 class="title">Razón de deuda</h4>
                                                            </div>
                                                            <div class="content table-responsive table-full-width">
                                                                <table class="table table-hover">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Año</th>
                                                                            <th>&nbsp;</th>
                                                                            <th>Pasivos totales</th>
                                                                            <th>Activos totales</th>
                                                                            <th>Razón de deuda</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>2015</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>1</td>
                                                                            <td>30977382</td>
                                                                            <td>78158203</td>
                                                                            <td>39.63420449</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>2</td>
                                                                            <td>30607762</td>
                                                                            <td>78559662</td>
                                                                            <td>38.96116814</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>3</td>
                                                                            <td>30040026</td>
                                                                            <td>78864026</td>
                                                                            <td>38.09091106</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>4</td>
                                                                            <td>51716061</td>
                                                                            <td>101844703</td>
                                                                            <td>50.77933312</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>2016</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>1</td>
                                                                            <td>71129638</td>
                                                                            <td>121621645</td>
                                                                            <td>58.48435778</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>2</td>
                                                                            <td>74113410</td>
                                                                            <td>126030206</td>
                                                                            <td>58.80606908</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>3</td>
                                                                            <td>71449895</td>
                                                                            <td>123996343</td>
                                                                            <td>57.62258247</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>4</td>
                                                                            <td>74778147</td>
                                                                            <td>129076843</td>
                                                                            <td>57.93304613</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>2017</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>1</td>
                                                                            <td>72086834</td>
                                                                            <td>127144982</td>
                                                                            <td>56.69656235</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>2</td>
                                                                            <td>75874823</td>
                                                                            <td>132029994</td>
                                                                            <td>57.46786825</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>3</td>
                                                                            <td>72015079</td>
                                                                            <td>129199902</td>
                                                                            <td>55.73926751</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>4</td>
                                                                            <td>70442481</td>
                                                                            <td>129317142</td>
                                                                            <td>54.4726553</td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div class="card col-md-6">
                                                            <div id="razonDeuda" class="ct-chart"></div>

                                                            <div class="footer">
                                                                <div class="footer">
                                                                    <div class="chart-legend">
                                                                        <i class="fa fa-circle text-info"></i> 2015
                                                                        <i class="fa fa-circle text-danger"></i> 2016
                                                                        <i class="fa fa-circle text-warning"></i> 2017
                                                                    </div>
                                                                    <hr>
                                                                    <div class="stats">
                                                                        <i class="ti-target"></i> EMPRESA S.A.B. de C.V.
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div role="tabpanel" class="tab-pane fade" id="rotacion">
                                                        <div class="card col-md-12">
                                                            <div class="header">
                                                                <h4 class="title">Rotación del activo total</h4>
                                                            </div>
                                                            <div class="content table-responsive table-full-width">
                                                                <table class="table table-hover">
                                                                    <thead>
                                                                    <th>Año</th>
                                                                    <th>Ventas netas</th>
                                                                    <th>Activos totales</th>
                                                                    <th>Valor de razón corriente</th>
                                                                    <th>Fecha de cálculo</th>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>2016</td>
                                                                            <td>01526363</td>
                                                                            <td>01526363</td>
                                                                            <td>0.855224</td>
                                                                            <td>2018-04-11</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>2015</td>
                                                                            <td>01526363</td>
                                                                            <td>01526363</td>
                                                                            <td>0.855224</td>
                                                                            <td>2018-04-11</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>2014</td>
                                                                            <td>01526363</td>
                                                                            <td>01526363</td>
                                                                            <td>0.855224</td>
                                                                            <td>2018-04-11</td>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div role="tabpanel" class="tab-pane fade" id="liquidez">
                                                        <div class="card col-md-12">
                                                            <div class="header">
                                                                <h4 class="title">Razón corriente</h4>
                                                            </div>
                                                            <div class="content table-responsive table-full-width">
                                                                <table class="table table-hover">
                                                                    <thead>
                                                                        <tr>
                                                                            <th>Año</th>
                                                                            <th>Trimestre</th>
                                                                            <th>Activo circulante</th>
                                                                            <th>Pasivo circulante</th>
                                                                            <th>Razon corriente</th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody>
                                                                        <tr>
                                                                            <td>2015</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>1</td>
                                                                            <td>22045024</td>
                                                                            <td>18892192</td>
                                                                            <td>1.166885452</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>2</td>
                                                                            <td>22684324</td>
                                                                            <td>18242583</td>
                                                                            <td>1.243482022</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>3</td>
                                                                            <td>23242305</td>
                                                                            <td>17802287</td>
                                                                            <td>1.305579727</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>4</td>
                                                                            <td>46085122</td>
                                                                            <td>22556102</td>
                                                                            <td>2.043133251</td></tr>
                                                                        <tr>
                                                                            <td>2016</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>1</td>
                                                                            <td>31736594</td>
                                                                            <td>26534355</td>
                                                                            <td>1.196056735</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>2</td>
                                                                            <td>34863272</td>
                                                                            <td>31894594</td>
                                                                            <td>1.09307778</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>3</td>
                                                                            <td>33497747</td>
                                                                            <td>123996343</td>
                                                                            <td>1.067877998</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>4</td>
                                                                            <td>36660798</td>
                                                                            <td>129076843</td>
                                                                            <td>0.979334489</td></tr>
                                                                        <tr>
                                                                            <td>2017</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>1</td>
                                                                            <td>35089977</td>
                                                                            <td>34050837</td>
                                                                            <td>1.030517312</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>2</td>
                                                                            <td>40697721</td>
                                                                            <td>39317150</td>
                                                                            <td>1.03511371</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>3</td>
                                                                            <td>37966909</td>
                                                                            <td>35233030</td>
                                                                            <td>1.077594206</td></tr>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>4</td>
                                                                            <td>37847591</td>
                                                                            <td>38328993</td>
                                                                            <td>0.987440265</td></tr>
                                                                    </tbody>
                                                                </table>
                                                                </table>
                                                            </div>
                                                        </div>
                                                        <div class="card col-md-12">
                                                            <div class="header">
                                                                <h4 class="title">Capital de trabajo</h4>
                                                            </div>
                                                            <div class="content table-responsive table-full-width">
                                                                <table class="table table-hover">
                                                                    <thead>
                                                                        <tr><th>Año</th><th>Trimestre</th><th>Activo circulante</th><th>Pasivo circulante</th><th>Capital de trabajo</th></tr></thead><tbody>
                                                                        <tr><td>2015</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                        <tr><td>&nbsp;</td><td>1</td><td>22045024</td><td>18892192</td><td>0.166885452</td></tr>
                                                                        <tr><td>&nbsp;</td><td>2</td><td>22684324</td><td>18242583</td><td>0.243482022</td></tr>
                                                                        <tr><td>&nbsp;</td><td>3</td><td>23242305</td><td>17802287</td><td>0.305579727</td></tr>
                                                                        <tr><td>&nbsp;</td><td>4</td><td>46085122</td><td>22556102</td><td>1.043133251</td></tr>
                                                                        <tr><td>2016</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                        <tr><td>&nbsp;</td><td>1</td><td>31736594</td><td>26534355</td><td>0.196056735</td></tr>
                                                                        <tr><td>&nbsp;</td><td>2</td><td>34863272</td><td>31894594</td><td>0.09307778</td></tr>
                                                                        <tr><td>&nbsp;</td><td>3</td><td>33497747</td><td>31368515</td><td>0.067877998</td></tr>
                                                                        <tr><td>&nbsp;</td><td>4</td><td>36660798</td><td>37434399</td><td>-0.020665511</td></tr>
                                                                        <tr><td>2017</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                        <tr><td>&nbsp;</td><td>1</td><td>35089977</td><td>34050837</td><td>0.030517312</td></tr>
                                                                        <tr><td>&nbsp;</td><td>2</td><td>40697721</td><td>39317150</td><td>0.03511371</td></tr>
                                                                        <tr><td>&nbsp;</td><td>3</td><td>37966909</td><td>35233030</td><td>0.077594206</td></tr>
                                                                        <tr><td>&nbsp;</td><td>4</td><td>37847591</td><td>38328993</td><td>-0.012559735</td></tr>
                                                                    </tbody></table>
                                                            </div>
                                                        </div>
                                                        <div class="card col-md-12">
                                                            <div class="header">
                                                                <h4 class="title">Prueba acida</h4>
                                                            </div>
                                                            <div class="content table-responsive table-full-width">
                                                                <table class="table table-hover">
                                                                    <thead><tr class="tableizer-firstrow"><th>Año</th><th>Trimestre</th><th>Activo circulante</th><th>Pasivo circulante</th><th>Inventarios</th><th>Prueba Acida</th></tr></thead><tbody>
                                                                        <tr><td>2015</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                        <tr><td>&nbsp;</td><td>1</td><td>22045024</td><td>18892192</td><td>15806298</td><td>0.330227747</td></tr>
                                                                        <tr><td>&nbsp;</td><td>2</td><td>22684324</td><td>18242583</td><td>16756134</td><td>0.324964398</td></tr>
                                                                        <tr><td>&nbsp;</td><td>3</td><td>23242305</td><td>17802287</td><td>17004014</td><td>0.350420763</td></tr>
                                                                        <tr><td>&nbsp;</td><td>4</td><td>46085122</td><td>22556102</td><td>17588848</td><td>1.263350999</td></tr>
                                                                        <tr><td>2016</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                        <tr><td>&nbsp;</td><td>1</td><td>31736594</td><td>26534355</td><td>21434655</td><td>0.388249083</td></tr>
                                                                        <tr><td>&nbsp;</td><td>2</td><td>34863272</td><td>31894594</td><td>24805098</td><td>0.315356703</td></tr>
                                                                        <tr><td>&nbsp;</td><td>3</td><td>33497747</td><td>31368515</td><td>24254415</td><td>0.294669097</td></tr>
                                                                        <tr><td>&nbsp;</td><td>4</td><td>36660798</td><td>37434399</td><td>25967715</td><td>0.285648582</td></tr>
                                                                        <tr><td>2017</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>
                                                                        <tr><td>&nbsp;</td><td>1</td><td>35089977</td><td>34050837</td><td>26016129</td><td>0.266479441</td></tr>
                                                                        <tr><td>&nbsp;</td><td>2</td><td>40697721</td><td>39317150</td><td>30269449</td><td>0.265234688</td></tr>
                                                                        <tr><td>&nbsp;</td><td>3</td><td>37966909</td><td>35233030</td><td>27693970</td><td>0.291571261</td></tr>
                                                                        <tr><td>&nbsp;</td><td>4</td><td>37847591</td><td>38328993</td><td>26501724</td><td>0.296012655</td></tr>
                                                                    </tbody></table>

                                                            </div>
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
</html>
