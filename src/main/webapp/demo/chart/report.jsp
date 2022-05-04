<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <!-- Head -->
        <%@include file="../include/header.jspf"  %>
    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="../include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="../include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Chart</h1>
                    <h2>圖表分析</h2>
                </div>
                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                <script type="text/javascript">
                    google.charts.load('current', {'packages': ['corechart']});
                    google.charts.setOnLoadCallback(drawChart);
                    function drawChart() {
                        chart1();
                        chart2();
                        chart3();
                        chart4();
                        chart5();
                    }
                </script>
                <%@include file="chart1.jspf"  %>
                <%@include file="chart2.jspf"  %>
                <%@include file="chart3.jspf"  %>
                <%@include file="chart4.jspf"  %>
                <%@include file="chart5.jspf"  %>
            </div>
        </div>
        <!-- Foot -->
        <%@include file="../include/footer.jspf"  %>
    </body>
</html>