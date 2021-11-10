<%@ page import="business.util.Initializer" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Initializer initializer = new Initializer();
    if (request.getServletContext().getAttribute("bottomList") == null) {
        request.getServletContext().setAttribute("bottomList", initializer.getBottomList());
    }
    if (request.getServletContext().getAttribute("toppingList") == null) {
        request.getServletContext().setAttribute("toppingList", initializer.getToppingList());
    }

%>
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
                                <a class="nav-link" href="${pageContext.request.contextPath}/fc/customerpage">Home</a>
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
                        <a class="text-reset me-3" href="#">
                            <i class="fas fa-shopping-cart"></i>
                        </a>
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
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
            <h1 class="display-2">Your orders</h1>
            <table class="table table-striped" id="bottoms">
                <thead>
                <tr>
                    <th scope="col">Order id</th>
                    <th scope="col">Date</th>
                    <th scope="col">Total price</th>
                    <th scope="col"></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1231</td>
                    <td>10.10.2021</td>
                    <td>30.00</td>
                    <td><a href="${pageContext.request.contextPath}/fc/myorderinfopage">
                        <button type="button" class="btn btn-outline-primary float-end"><i
                                class="bi bi-info-circle"></i></button>
                    </a></td>
                </tr>
                <tr>
                    <td>3231</td>
                    <td>10.10.2021</td>
                    <td>20.00</td>
                    <td><a href="${pageContext.request.contextPath}/fc/myorderinfopage">
                        <button type="button" class="btn btn-outline-primary float-end"><i
                                class="bi bi-info-circle"></i></button>
                    </a></td>
                </tr>
                <tr>
                    <td>5231</td>
                    <td>10.10.2021</td>
                    <td>10.00</td>
                    <td><a href="${pageContext.request.contextPath}/fc/myorderinfopage">
                        <button type="button" class="btn btn-outline-primary float-end"><i
                                class="bi bi-info-circle"></i></button>
                    </a></td>
                </tr>
                <tr>
                    <td>12231</td>
                    <td>10.10.2021</td>
                    <td>50.00</td>
                    <td><a href="${pageContext.request.contextPath}/fc/myorderinfopage">
                        <button type="button" class="btn btn-outline-primary float-end"><i
                                class="bi bi-info-circle"></i></button>
                    </a></td>
                </tr>
                <tr>
                    <td>13231</td>
                    <td>10.10.2021</td>
                    <td>60.00</td>
                    <td><a href="${pageContext.request.contextPath}/fc/myorderinfopage">
                        <button type="button" class="btn btn-outline-primary float-end"><i
                                class="bi bi-info-circle"></i></button>
                    </a></td>
                </tr>
                </tbody>
            </table>

        </div>
    </div>
    <div class="bottom"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>