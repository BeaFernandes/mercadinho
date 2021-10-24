<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Nova compra">
    <jsp:body>
        <div class="row">
            <div class="col s4">
                <h4>Vamos lá!</h4>
            </div>
            <div class="col s8 right-align">
                <div class="row">
                    <div class="col s7">
                        Mercadinho da vez
                    </div>
                    <div class="col s4 p0">
                        <select class="browser-default inline my-input" id="market" name="market">
                            <option value="" disabled selected>Escolha um mercado</option>
                        </select>
                    </div>
                    <div class="col s1 p0 center">
                        <a href="cadastrar-mercado">  <i class="material-icons">add</i> </a>
                    </div>
                </div>
                <div class="row mb0">
                    <div class="col s12">
                        Total
                        <div class="input-field inline m0">
                            <input id="total" name="total" type="email" class="my-input" placeholder="R$ 0,00" disabled>
                        </div>
                        <i class="material-icons white-text">attach_money</i>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <table class="striped responsive-table">
                <thead>
                <tr class="theme-text">
                    <th class="col s3">Produto</th>
                    <th class="col s3">Preço Un.</th>
                    <th class="col s3">Quantidade</th>
                    <th class="col s3">Total</th>
                </tr>
                </thead>
            </table>
            <form action="nova-compra" method="post" class="col s12">
                <c:forEach var="i" begin="1" end="5">
                    <div class="row mb0">
                        <div class="input-field col s3">
                            <input placeholder="Produto" id="product${i}" name="product${i}" type="text" class="validate my-input">
                        </div>
                        <div class="input-field col s3">
                            <input placeholder="R$ 0,00" id="price${i}" name="price${i}" type="text" class="validate my-input">
                        </div>
                        <div class="input-field col s3">
                            <input placeholder="0" id="amount${i}" name="amount${i}" type="text" class="validate my-input">
                        </div>
                        <div class="input-field col s3">
                            <input placeholder="R$ 0,00" id="total_per_item${i}" name="total_per_item${i}" type="text" class="validate my-input" disabled>
                        </div>
                    </div>
                </c:forEach>
                <div class="row">
                    <div class="col right">
                        <i class="material-icons">add</i>
                    </div>
                </div>
            </form>
        </div>
        <script>
            window.onload = function () {
                $.get('mercados', function (data) {
                    let $select = $('#market');

                    $.each(data, function (index, item){
                       $('<option>').val(item.id).text(item.name).appendTo($select);
                    });
                });
            }
            $(document).ready(function() {
                M.updateTextFields();
            });
        </script>
    </jsp:body>
</t:template>
