<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:template title="Sua comprinha">
    <jsp:body>
        <h5>Comprinha de ${date}</h5>
        <div class="row">
            <div class="col s6">
                Mercadinho da vez: <span class="text-bold">${market}</span>
            </div>
            <div class="col s6">
                Total: <span class="text-bold">${total}</span>
            </div>
        </div>

        <table class="striped responsive-table theme-text">
            <thead>
                <tr>
                    <th>Produto</th>
                    <th>Preço Un.</th>
                    <th>Quantidade</th>
                    <th>Total</th>
                </tr>
            </thead>
            <tbody>
                <c:if test="${not empty items}">
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.name}</td>
                            <td>${item.getFormatedPrice()}</td>
                            <td>${item.amount}</td>
                            <td>${item.getFormatedTotal()}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>

        </table>
    </jsp:body>
</t:template>