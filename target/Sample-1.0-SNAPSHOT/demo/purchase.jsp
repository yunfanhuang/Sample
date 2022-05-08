<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <h1>Purchase</h1>
                    <h2>進貨</h2>
                </div>
                <table class="pure-table" style="border: none;">
                    <tr>
                        <td valign="top">
                            <!-- 列表 -->
                            <fieldset class="pure-form">
                                <legend>Inventory list</legend>
                                <table class="pure-table pure-table-bordered" width="100%">
                                    <thead>
                                        <tr>
                                            <th nowrap>ID</th>
                                            <th nowrap>Name</th>
                                            <th nowrap>Image</th>
                                            <th nowrap>庫存量</th>
                                            <th nowrap>進貨均價</th>
                                            <th nowrap>銷貨均價</th>
                                            <th nowrap>售價一</th>
                                            <th nowrap>售價二</th>
                                            <th nowrap>買進數量</th>
                                            <th nowrap>買進價格</th>
                                            <th nowrap>買進</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="i" items="${ employee }">
                                        <form class="pure-form" method="post" action="${pageContext.request.contextPath}/demo/purchase">
                                            <tr>
                                                <td><input type="text" name="pid" value="${ i.id }" readonly style="max-width: 50px" /></td>
                                                <td>${ i.name }</td>
                                                <td><img style="cursor: zoom-in" id="blah" src="${ i.image==null?space:i.image }" width="${ i.image==null?'0':'100' }" /></td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###" value="${ i.qty }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.puCost }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.saCost }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.price1 }" />
                                                </td>
                                                <td>
                                                    <fmt:formatNumber type="number" pattern="###,###.0" value="${ i.price2 }" />
                                                </td>
                                                <td><input type="number" name="quantity" value="0" style="max-width: 100px" /></td>
                                                <td><input type="number" name="price" value="0" style="max-width: 100px" /></td>
                                                <td><button type="submit" class="pure-button pure-button-primary">Submit</button></td>
                                            </tr>
                                        </form>
                                    </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </td>
                    </tr>
                    <tr>
                        <td valign="top">
                            <!-- 列表 -->
                            <fieldset class="pure-form">
                                <legend>Purchase list</legend>
                                <table class="pure-table pure-table-bordered" width="100%">
                                    <thead>
                                        <tr>
                                            <th nowrap>ID</th>
                                            <th nowrap>PID</th>
                                            <th nowrap>品名</th>
                                            <th nowrap>價格</th>
                                            <th nowrap>數量</th>
                                            <th nowrap>進貨時間</th>
                                            <th nowrap>User</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="p" items="${ purchases }">
                                            <tr>
                                                <td>${ p.id }</td>
                                                <td>${ p.product.id }</td>
                                                <td>${ p.product.name }</td>
                                                <td>${ p.price }</td>
                                                <td>${ p.quantity }</td>
                                                <td>${ p.date }</td>
                                                <td>${ p.user.name }</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table> 
                            </fieldset>
                        </td>
                    </tr>
                </table> 
            </div>
        </div>

        <!-- Foot -->
        <%@include file="include/footer.jspf"  %>

    </body>
</html>