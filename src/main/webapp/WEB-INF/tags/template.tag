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

    <!-- CSS -->
    <link rel="stylesheet" href="assets/libraries/materialize/css/materialize.css"></link>

</head>
<body>

<header>
    <div class="navbar-fixed">
        <nav>
            <div class="nav-wrapper amber darken-1">
                <div class="container">
                    <a href="" class="brand-logo amber-text text-lighten-3">Logo</a>
                </div>
            </div>
        </nav>
    </div>
</header>

<main id="content" class="container">
    <jsp:doBody></jsp:doBody>
</main>

<footer>

</footer>

</body>
</html>
