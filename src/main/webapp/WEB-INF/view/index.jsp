<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:template title="Suas comprinhas">
    <jsp:body>
        <div class="row valign-wrapper">
            <div class="col s6">
                <h4>Suas comprinhas</h4>
            </div>
            <div class="col s6 right-align">
                <div class="row">
                    <div class="right m1">Início da sessão: ${sessionStart}</div>
                </div>
                <div class="row">
                    <div class="right m1">1ª sessão últimas 24h: ${firstSession}</div>
                </div>
                <div class="row">
                    <p class="big">
                        Você tem ${counter} comprinha(s) ao todo
                    </p>
                </div>
            </div>

        </div>

        <table class="striped responsive-table theme-text">
            <thead>
                <tr class="theme-text">
                    <th>Data</th>
                    <th>Mercado</th>
                    <th>Total da compra</th>
                    <th>Ver</th>
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
                                <form action="sua-compra" method="get" class="m0">
                                    <input type="text" name="id" value="${grocery.id}" hidden>
                                    <button class="btn-flat valign-wrapper grey-text" type="submit"><i class="material-icons">open_in_browser</i></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${empty groceries}">
                    <tr>
                        <td colspan="4" class="center-align">
                            Nenhuma lista encontrada
                        </td>
                    </tr>
                </c:if>
            </tbody>

        </table>
    </jsp:body>
</t:template>