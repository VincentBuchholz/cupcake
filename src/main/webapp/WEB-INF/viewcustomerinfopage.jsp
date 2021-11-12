<%@ page import="business.util.Initializer" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    Initializer initializer = new Initializer();
    request.getServletContext().setAttribute("customerOrderList", initializer.getCustomerOrderList(Integer.parseInt(request.getParameter("customerID"))));
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
                                <a class="nav-link" href="${pageContext.request.contextPath}/fc/vieworderpage">Orders</a>
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
            <div class="row">
                <div class="col">
                    <h1 class="display-4">Customer info</h1>
                    <form action="${pageContext.request.contextPath}/fc/UpdateBalanceCommand" method="POST">
                        <input type="hidden" name="customerID" value="${requestScope.customerID}">
                        <div class="form-group">
                            <label for="firstname">First name</label>
                            <input type="text" class="form-control" id="firstname" value="${requestScope.customerFirstName}"disabled>
                        </div>
                        <div class="form-group">
                            <label for="firstname">Last name</label>
                            <input type="text" class="form-control" id="lastname" value="${requestScope.customerLastName}"disabled>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" id="email" value="${requestScope.customerEmail}" disabled>
                        </div>
                        <div class="form-group">
                            <label for="userBalance">Balance</label>
                            <input type="number" class="form-control" id="userBalance" name="userBalance" value="${requestScope.customerBalance}">
                        </div>
                        <button type="submit" class="btn btn-primary mt-2">Save</button>
                    </form>
                </div>
                <div class="col">
                    <h1 class="display-4">Orders</h1>
                    <table class="table table-striped" id="bottoms">
                        <thead>
                        <tr>
                            <th scope="col">Order ID</th>
                            <th scope="col">Date</th>
                            <th scope="col"></th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach var="orderItem" items="${applicationScope.customerOrderList}">
                            <form action="${pageContext.request.contextPath}/fc/vieworderinfopage" method="POST">
                                <input type="hidden" value="${orderItem.id}" name="customerOrderID">
                        <tr>
                            <td>${orderItem.id}</td>
                            <td>${orderItem.date}</td>
                            <td class="text-end">
                                <button type="submit" name="editbtn" value="" class="btn btn-outline-primary"><i
                                        class="bi bi-info-circle"></i></button>
                            </form>
                                <button type="submit" name="removebtn" value="" class="btn btn-outline-danger"><i
                                        class="bi bi-trash"></i></button>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
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