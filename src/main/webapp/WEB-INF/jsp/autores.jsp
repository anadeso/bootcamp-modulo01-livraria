<%--
  Created by IntelliJ IDEA.
  User: anasousa
  Date: 9/2/21
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CADASTRO DE AUTOR</title>
    <link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body class="container">
    <form action="<c:url value="/autores"/>"  method="POST">
        <div class="form-group">
            <label for="nome">Nome</label>
            <input id="nome" class="form-control" name="nome">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" class="form-control" name="email">
        </div>
        <div class="form-group">
            <label for="data">Data de Nascimento</label>
            <input id="data" class="form-control" name="data">
        </div>
        <div class="form-group">
            <label for="minic">Mini Currículo</label>
            <input id="minic" class="form-control" name="minic">
        </div>
        <input type="submit"  value="Gravar" class="mt-2 btn-primary">
    </form>
    <h1 class="text-center">LISTA DE AUTORES</h1>
    <table lass="table table-striped table-hover table-bordered">
        <thead>
            <tr>
                <th>NOME</th>
                <th>EMAIL</th>
                <th>DATA NASCIMENTO</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${autores}" var="t">
            <tr>
                <td>${t.nome}</td>
                <td>${t.email}</td>
                <td>${t.data}</td>
                <td>${t.minic}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
