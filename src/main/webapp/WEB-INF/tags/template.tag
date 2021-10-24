<%--
  Created by IntelliJ IDEA.
  User: beatriz
  Date: 10/22/21
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@tag description="Template principal" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@attribute name="title"%>

<html>
<head>
    <title>${title}</title>
    <base href="${pageContext.request.contextPath}/">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="icon" type="image/png" href="assets/images/favicon.ico" />

    <!-- CSS -->
    <link rel="stylesheet" href="assets/resources/styles/main.css"></link>
    <link rel="stylesheet" href="assets/resources/styles/template.css"></link>
    <link rel="stylesheet" href="assets/libraries/materialize/css/materialize.css"></link>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"></link>


</head>
<body class="grey lighten-3">

<header>
    <div class="navbar-fixed">
        <nav>
            <div class="nav-wrapper amber darken-1">
                <a href="" class="brand-logo amber-text text-lighten-3">
                    <img
                        src="assets/images/logo.png"
                        class="img-responsive" height="70px"></img>
                </a>
            </div>
        </nav>
    </div>
</header>

<div class="row m0">
    <div class="col s3 p0">
        <div class="my-sidenav">
            <ul class="gray-text text-lighten-3">
                <li class="mb1"><a href="nova-compra">Nova compra</a></li>
                <li><div class="mb1 divider"></div></li>
                <li class="mb1"><a href="suas-compras">Suas compras</a></li>
            </ul>
        </div>
    </div>

    <div class="col s9">
        <main id="content" class="container main-content">

            <div class="">
                <jsp:doBody></jsp:doBody>

            </div>
        </main>
    </div>
</div>


<footer class="page-footer grey lighten-3 p0">
    <div class="footer-copyright grey-text text-darken-2">
        &#169; Copyright 2021 - Todos os direitos reservados
    </div>
</footer>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
<!--<script type="text/javascript" src="assets/libraries/materialize/js/materialize.min.js"></script>-->

</body>
</html>
