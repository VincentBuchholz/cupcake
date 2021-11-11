<%@ page import="business.util.Initializer" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    Initializer initializer = new Initializer();
    if(request.getServletContext().getAttribute("bottomList") == null) {
        request.getServletContext().setAttribute("bottomList", initializer.getBottomList());
    }
    if(request.getServletContext().getAttribute("toppingList") == null) {
        request.getServletContext().setAttribute("toppingList", initializer.getToppingList());
    }

%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Cupcake</title>
    <link rel="stylesheet" href="../style.css">
</head>
<body>
<div class="container">
    <div class="top">
        <div class="text-center" id="headerimg">
        </div>
            <img src="${pageContext.request.contextPath}/files/olskercupcakes.png" height="auto" width="100%"/>

        <div class="buttons mt-3 float-end">
            <a class="btn btn-primary" href="fc/loginpage" role="button">Login</a>
            <a class="btn btn-primary" href="fc/registerpage" role="button">Sign up</a>
        </div>
    </div>
    <div class="content">

        <table class="table table-striped" id="bottoms">
            <thead>
            <tr>
                <th scope="col">Bottom</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="bottomItem" items="${applicationScope.bottomList}">
            <tr>
                <td>${bottomItem.name}</td>
                <td>${bottomItem.price}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-striped" id="toppings">
            <thead>
            <tr>
                <th scope="col">Topping</th>
                <th scope="col">Price</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="toppingItem" items="${applicationScope.toppingList}">
                <tr>
                    <td>${toppingItem.name}</td>
                    <td>${toppingItem.price}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="bottom"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
