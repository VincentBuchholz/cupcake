<%@ page import="business.util.Initializer" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<%
    Initializer initializer = new Initializer();
    if (request.getServletContext().getAttribute("bottomList") == null) {
        request.getServletContext().setAttribute("bottomList", initializer.getBottomList());
    }
    if (request.getServletContext().getAttribute("toppingList") == null) {
        request.getServletContext().setAttribute("toppingList", initializer.getToppingList());
    }


%>


<style>
    <%@include file="/WEB-INF/css/style.css"%>
</style>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" rel="stylesheet">
    <title>Cupcake</title>
    <link rel="stylesheet" href="../style.css">
</head>
<body>
<div class="container">
    <div class="top">
        <div class="text-center" id="headerimg">
            <img src="${pageContext.request.contextPath}/files/olskercupcakes.png" height="auto" width="100%"/>
        </div>

        <div id="navigation">
            <!-- Navbar -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <!-- Container wrapper -->
                <div class="container-fluid">
                    <!-- Toggle button -->
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarSupportedContent" aria-controls="navbarNavDropdown"
                            aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <i class="fas fa-bars"></i>
                    </button>

                    <!-- Collapsible wrapper -->
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <!-- Navbar brand -->
                        <!-- Left links -->
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link active" href="${pageContext.request.contextPath}/fc/customerpage">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/fc/myorderpage">My
                                    orders</a>
                            </li>
                        </ul>
                        <!-- Left links -->
                    </div>
                    <!-- Collapsible wrapper -->

                    <!-- Right elements -->
                    <div class="d-flex align-items-center">
                        <!-- Icon -->
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            <li class="nav-item">
                                <a class="nav-link " href="${pageContext.request.contextPath}/fc/logoutcommand">Logout</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#" style="pointer-events: none;"> ${sessionScope.email}</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/fc/cart">
                                    <i class="bi bi-cart"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <!-- Right elements -->
                </div>
                <!-- Container wrapper -->
            </nav>
        </div>
    </div>
    <div class="content">
        <div class="jumbotron bg-light mt-5 p-5 shadow-lg p-3 mb-5 bg-white rounded">
            <h1 class="display-4">Welcome ${sessionScope.firstName}!</h1>
            <p class="lead">The best cupcakes in town, choose here:</p>
            <form action="${pageContext.request.contextPath}/fc/addToCartCommand" method="POST">
                <input type="hidden" name="user" value="${sessionScope.user.id}">
                <div class="row">
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="sel1">Select bottom:</label>
                            <select class="form-control" name="selectBottom" id="sel1">
                                <c:forEach var="bottomItem" items="${applicationScope.bottomList}">
                                    <option value="${bottomItem.id}">${bottomItem.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="sel1">Select topping:</label>
                            <select class="form-control" name="selectTopping" id="sel2">
                                <c:forEach var="toppingItem" items="${applicationScope.toppingList}">
                                    <option value="${toppingItem.id}">${toppingItem.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-sm">
                        <div class="form-group">
                            <label for="sel3">Amount:</label>
                            <select class="form-control" name="amount" id="sel3">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>5</option>
                                <option>6</option>
                                <option>7</option>
                                <option>8</option>
                                <option>9</option>
                            </select>
                        </div>
                        <button class="btn btn-primary btn-lg btn-block mt-3 float-end" type="submit">Add to cart
                        </button>
                    </div>

                    <!-- Modal -->
                    <div class="modal right fade " id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header justify-content-center">
                                    <p class="modal-title"><i class="bi bi-check-circle"></i> Product added to cart</p>
                                </div>
                                <div class="modal-body " style="flex:none !important;">
                                    <c:if test="${requestScope.success != null }">
                                    <script type="text/javascript">
                                        $(window).on('load', function () {
                                            $('#myModal').modal('show');
                                        });
                                    </script>
                                    <div clas="row" style="display: flex">
                                        <div class="col-4 p-1">
                                            <img class="shopcart-item-img"
                                                 src="${pageContext.request.contextPath}${requestScope.cupcakeIMG}"/>
                                        </div>
                                        <div class="col-8 p-1">
                                            <p class="fw-bold m-0">Cupcake</p>
                                            <p>${requestScope.success}</p>
                                        </div>
                                    </div>
                                    </c:if>
                                </div>

                                <div class="modal-footer">
                                    <button type="button" class="btn btn-primary w-100"
                                            onclick="location.href='${pageContext.request.contextPath}/fc/cart'">GO TO CART
                                    </button>
                                    <button type="button" class="btn btn-secondary w-100" data-bs-dismiss="modal">KEEP SHOPPING
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
<div class="bottom"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>

