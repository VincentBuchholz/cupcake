<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

        <div class="buttons float-end">
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
            <tr>
                <td>Chocolate</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Vanilla</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Nutmeg</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Pistacio</td>
                <td>6.0</td>
            </tr>
            <tr>
                <td>Almond</td>
                <td>7.0</td>
            </tr>
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
            <tr>
                <td>Chocolate</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Blueberry</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Rasberry</td>
                <td>5.0</td>
            </tr>
            <tr>
                <td>Crispy</td>
                <td>6.0</td>
            </tr>
            <tr>
                <td>Strawberry</td>
                <td>6.0</td>
            </tr>
            <tr>
                <td>Rum/Raisin</td>
                <td>7.0</td>
            </tr>
            <tr>
                <td>Orange</td>
                <td>8.0</td>
            </tr>
            <tr>
                <td>Lemon</td>
                <td>8.0</td>
            </tr>
            <tr>
                <td>Blue cheese</td>
                <td>9.0</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="bottom"></div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</body>
</html>
