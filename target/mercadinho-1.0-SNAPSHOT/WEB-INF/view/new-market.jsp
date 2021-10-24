<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template title="Cadastrar mercado">
    <jsp:body>
        <div class="row">
            <div class="col">
                <h4>Digite o nome do mercado</h4>
            </div>
        </div>
        <div class="row">
            <div class="col s12">
                <form action="cadastrar-mercado" method="post">
                        Mercadinho
                        <div class="input-field inline">
                            <input name="name" type="text" class="my-input">
                        </div>
                    <div class="row">
                        <div class="col right">
                            <button class="btn waves-effect waves-light amber darken-1" type="submit" name="action">Cadastrar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


        <script>
            $(document).ready(function() {
                M.updateTextFields();
            });
        </script>
    </jsp:body>
</t:template>
