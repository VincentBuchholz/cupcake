<%@ page import="business.util.Initializer" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Initializer initializer = new Initializer();

    request.setAttribute("orderID",request.getParameter("customerOrderID"));
    request.getServletContext().setAttribute("orderLineList", initializer.getOrderlines(Integer.parseInt(request.getParameter("customerOrderID"))));
    request.getServletContext().setAttribute("orderTotalPrice", initializer.getOrderTotalPrice(Integer.parseInt(request.getParameter("customerOrderID"))));

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
                                <a class="nav-link" href="${pageContext.request.contextPath}/fc/employeepage">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/fc/viewcustomerpage">Customers</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="${pageContext.request.contextPath}/fc/vieworderpage">Orders</a>
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
            <h1 class="display-2">Order ID: ${requestScope.orderID}</h1>
            <table class="table table-striped" id="bottoms">
                <thead>
                <tr>
                    <th scope="col">Bottom</th>
                    <th scope="col">Topping</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Price</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="orderLineItem" items="${applicationScope.orderLineList}">
                <tr>
                    <td>${orderLineItem.bottomName}</td>
                    <td>${orderLineItem.toppingName}</td>
                    <td>${orderLineItem.amount}</td>
                    <td>${orderLineItem.price}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="mt-3 text-end">
                <h3>Total price:</h3>
                <h3>${applicationScope.orderTotalPrice}</h3>
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