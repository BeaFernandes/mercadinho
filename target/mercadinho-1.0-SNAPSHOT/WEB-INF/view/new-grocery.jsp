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
                <div class="row mb0">
                    <div class="col s12">
                        Mercadinho da vez
                        <div class="input-field inline m0">
                            <input id="email_inline" type="email" class="my-input">
                        </div>
                        <a href="cadastrar-mercado">  <i class="material-icons">add</i> </a>
                    </div>
                </div>
                <div class="row mb0">
                    <div class="col s12">
                        Total
                        <div class="input-field inline m0">
                            <input id="email_inline" type="email" class="my-input">
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
                    <th class="col s3">Data</th>
                    <th class="col s3">Dia da semana</th>
                    <th class="col s3">Mercado</th>
                    <th class="col s3">Total da compra</th>
                </tr>
                </thead>
            </table>
            <form class="col s12">
                <div class="row mb0">
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                </div>
                <div class="row mb0">
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                    <div class="input-field col s3">
                        <input placeholder="Placeholder" id="first_name" type="text" class="validate my-input">
                    </div>
                </div>
            </form>
        </div>
        <script>
            $(document).ready(function() {
                M.updateTextFields();
            });
        </script>
    </jsp:body>
</t:template>
