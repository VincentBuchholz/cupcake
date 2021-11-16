<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Cupcake</title>
    <link rel="stylesheet" href="../style.css">
</head>
<body>
<div class="container">
    <div class="top">
        <div class="text-center" id="headerimg">
            <img src="${pageContext.request.contextPath}/files/olskercupcakes.png" height="auto" width="100%"/>
        </div>
    </div>
    <div class="content">
        <div class="loginform col-12 col-md-8 col-lg-6 col-xl-5 text-center m-auto mt-5">
            <form class="card p-3 bg-light shadow-lg p-3 mb-5 bg-white rounded" name="login"
                  action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <h3 class="mb-5">Create account</h3>
                <c:if test="${requestScope.error != null }">
                    <p style="color:red">
                            ${requestScope.error}
                    </p>
                </c:if>
                <div class="form-outline mb-4">
                    <input type="text" id="firstName" name="firstName" class="form-control form-control-lg"
                           placeholder="First name"/>
                </div>
                <div class="form-outline mb-4">
                    <input type="text" id="lastName" name="lastName" class="form-control form-control-lg"
                           placeholder="Last name"/>
                </div>
                <div class="form-outline mb-4">
                    <input type="email" id="email" name="email" class="form-control form-control-lg"
                           placeholder="Email"/>
                </div>
                <div class="form-outline mb-4">
                    <input type="password" id="password1" name="password1" class="form-control form-control-lg"
                           placeholder="Password"/>
                </div>
                <div class="form-outline mb-4">
                    <input type="password" id="password2" name="password2" class="form-control form-control-lg"
                           placeholder="Repeat password"/>
                </div>
                <button class="btn btn-primary btn-lg btn-block" type="submit">Sign up</button>
            </form>
        </div>


    </div>
    <div class="bottom"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>




