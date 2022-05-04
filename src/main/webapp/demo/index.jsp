<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html>
    <head>
        <!-- Head -->
        <%@include file="include/header.jspf"  %>
    </head>
    <body style="padding: 10px">

        <div id="layout">
            <!-- Toggle -->
            <%@include file="include/toggle.jspf"  %>

            <!-- Menu -->
            <%@include file="include/menu.jspf"  %>

            <div id="main">
                <div class="header">
                    <h1>Company</h1>
                    <h2>CRUD</h2>
                </div>
                <img width="1200" src="${pageContext.request.contextPath}/image/JPA_CRUD_Lab.png"> 
            </div>
        </div>
        <!-- Foot -->
        <%@include file="include/footer.jspf"  %>
    </body>
</html>