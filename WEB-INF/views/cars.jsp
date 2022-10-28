<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8" />
    <title>Car</title>
    <style>table th, table td {padding: 5px;}</style>
</head>

<body>
<h1>th:each</h1>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Mark</th>
        <th>Color</th>
        <th>Number</th>
    </tr>

    <tr th:each="lst : ${list}">
        <td th:utext="${lst.id}">id</td>
        <td th:utext="${lst.mark}">mark</td>
        <td th:utext="${lst.color}">color</td>
        <td th:utext="${lst.number}">number</td>
    </tr>

</table>
</body>
</html>
