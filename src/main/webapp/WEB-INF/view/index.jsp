<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:template title="Suas comprinhas">
    <jsp:body>
        <h4>Suas comprinhas</h4>

        <table class="striped responsive-table theme-text">
            <thead>
                <tr class="theme-text">
                    <th>Data</th>
                    <th>Mercado</th>
                    <th>Total da compra</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty groceries}">
                    <c:forEach var="grocery" items="${groceries}">
                        <tr>
                            <td>${grocery.getFormatedDate()}</td>
                            <td>${grocery.market}</td>
                            <td>${grocery.getFormatedTotal()}</td>
                            <td>
                                <form action="sua-compra" method="get">
                                    <input type="text" name="id" value="${grocery.id}" hidden>
                                    <div class="submit pointer"><i class="material-icons">open_in_browser</i></div>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty groceries}">
                    <tr>
                        <td colspan="3" class="center-align">
                            Nenhuma lista encontrada
                        </td>
                    </tr>
                </c:if>
            </tbody>

        </table>
        <script>
            window.onload = function () {
                $('.submit').click(function (){
                    document.forms[0].submit();
                });
            }
        </script>
    </jsp:body>
</t:template>