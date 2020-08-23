<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Spring Workshop</title>
    <link rel="stylesheet" type="text/css"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css">
    <link rel="stylesheet" type="text/css" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
          integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="schedules-content">
    <table class="table border-bottom">
        <thead>
        <tr class="d-flex">
            <td scope="col" class="col-3 center">tytuł
            </th>
            <td scope="col" class="col-2 center">autor
            </th>
            <td scope="col" class="col-2 center">wydawnictwo
            </th>
            <td scope="col" class="col-2 center">isbn
            </th>
            <td scope="col" class="col-2 center">akcje
            </th>
        </tr>
        </thead>
        <tbody class="text-color-lighter">
        <c:forEach items="${books}" var="book">
            <tr class="d-flex">
                <td class="col-3"><c:out value="${book.title}"/></td>
                <td class="col-2"><c:out value="${book.author}"/></td>
                <td class="col-2"><c:out value="${book.publisher}"/></td>
                <td class="col-2"><c:out value="${book.isbn}"/></td>
                <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
                    <a href="<c:url value="/admin/books/delete/${book.id}"/>"
                       onclick="return confirm('Na pewno chcesz usunąć ten rekord?')"
                       class="btn btn-danger rounded-0 text-light m-1">usuń</a>
                    <a href="<c:url value="/admin/books/edit/${book.id}"/>"
                       class="btn btn-warning rounded-0 text-light m-1">edytuj</a></td>
            </tr>
        </c:forEach>
        <tr class="d-flex">
            <td class="d-flex align-items-center justify-content-center flex-wrap">
                <a href='<c:url value="/admin/books/add"/>'
                   class="btn btn-success rounded-0 text-light m-1">dodaj książkę</a>
            </td>
        </tr>
        </tbody>
    </table>
    <jsp:include page="footer.jsp"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
            integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
            integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
            crossorigin="anonymous"></script>
</body>
</html>


