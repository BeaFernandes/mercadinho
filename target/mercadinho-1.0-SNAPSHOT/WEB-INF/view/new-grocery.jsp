<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Nova compra">
    <jsp:body>
        <p>${market}</p>
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
                        <form action="nova-compra" method="post" class="col s12" id="grocery-form" name="grocery-form">
                            <select class="browser-default inline my-input" id="market" name="market">
                                <option value="0" disabled selected>Escolha um mercado</option>
                            </select>
                            <button type="submit" hidden>Enviar</button>
                        </form>
                    </div>
                    <div class="col s1 p0 center">
                        <a href="cadastrar-mercado">  <i class="material-icons">add</i> </a>
                    </div>
                </div>
                <div class="row mb0">
                    <div class="col s12">
                        Total
                        <div class="input-field inline m0">
                            <input id="total" name="total" type="email" class="my-input" placeholder="R$ 0,00" value="${total}" readonly>
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
                    <th class="col s2">Total</th>
                </tr>
                </thead>
            </table>
            <form action="adicionar-item" method="post" name="item-form">
                <div class="row mb0">
                    <div class="input-field col s3">
                        <input placeholder="Produto" id="name" name="name" type="text" class="validate my-input" required>
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="R$ 0,00" id="price" name="price" type="text" class="validate my-input calculate-total" required>
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="0" id="amount" name="amount" type="text" class="validate my-input calculate-total" required>
                    </div>
                    <div class="input-field col s2">
                        <input placeholder="R$ 0,00" id="total_per_item" name="total_per_item" type="text" class="validate my-input" readonly>
                    </div>
                    <div class="input-field col s1 valign-wrapper pointer submit">
                        <i class="material-icons">check</i>
                    </div>
                </div>
            </form>
        </div>
        <div class="row">
            <c:if test="${not empty items}">
                <table class="responsive-table highlight">
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>${item.getName()}</td>
                            <td>${item.getPrice()}</td>
                            <td>${item.getAmount()}</td>
                            <td>${item.getTotal()}</td>
                            <!--TO DO - Implementar lógica do botão clear-->
                            <td><i class="material-icons pointer">clear</i></td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty items}">
                <div class="row">
                    <div class="col s12 center-align">
                        Não há itens na lista
                    </div>
                </div>
            </c:if>
        </div>
        <div class="row">
            <div class="col right">
                <button class="btn waves-effect waves-light amber darken-1" type="button" id="grocery-submit" name="grocery-submit">Terminar</button>
            </div>
        </div>
        <script>
            window.onload = function () {

                if(localStorage['market'] != null){
                    $('#market').val(localStorage['market']);
                }

                $('.calculate-total').change(function (){
                    let price = $('#price').val() == "" ? 0 : parseFloat($('#price').val());
                    let amount = $('#amount').val() == "" ? 1 : parseInt($('#amount').val());
                    let total = (function () {
                        if (price == 0){
                            return 0;
                        } else {
                            return price*amount;
                        }
                    });

                    $('#total_per_item').val(total);

                    console.log($('#market').val());
                });

                $('#market').change(function (){
                    localStorage['market'] = $(this).find(':selected').val();
                });

                $.get('mercados', function (data) {
                    let $select = $('#market');

                    $.each(data, function (index, item){
                       $('<option>').val(item.name).text(item.name).appendTo($select);
                    });
                });
                
                $('.submit').click(function (){
                    document.forms["item-form"].submit();
                });

                $('#grocery-submit').click(function (){
                    document.forms["grocery-form"].submit();
                });

                    /*.ajax({
                    url: 'nova-compra',
                    type: 'POST',
                    data: jQuery.param({ market: $('#market').val() }),
                    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                });*/

                //$('#grocery-submit').click(function (){
                 //   $.post('nova-compra', {market: $('#market'))
                //});

            }
            $(document).ready(function() {
                M.updateTextFields();
            });
        </script>
    </jsp:body>
</t:template>
