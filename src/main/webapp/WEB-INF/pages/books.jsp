<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Books Page</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<br/>
<br/>

<h1>Book List</h1>

<form>
    <p><input type="search" name="bookTitle" placeholder="find book by title">
        <input type="submit" value="find"></p>
</form>

<form>
    <p><input type="search" name="bookGenre" placeholder="find book by genre">
        <input type="submit" value="find"></p>
</form>

<c:if test="${!empty listBooks}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Title</th>
            <th width="120">AuthorName</th>
            <th width="120">AuthorSurname</th>
            <th width="120">Price</th>
            <th width="120">Genre</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listBooks}" var="book">
            <tr>
                <%--<td>${book.bookId}</td>--%>
                <td>${book.bookId}</td>
                    <td>${book.bookTitle}</td>
                    <td>${book.authorName}</td>
                    <td>${book.authorSurname}</td>
                    <td>${book.genreTitle}</td>
                    <td>${book.price}</td>

                <%--<td><a href="/bookdata/${book.bookId}" target="_blank">${book.bookTitle}</a></td>--%>
                <%--<td>${book.authorId}</td>--%>
                <%--<td>${book.price/100}${book.price%100}</td>--%>
                <td><a href="<c:url value='/book/edit/${book.bookId}'/>">Edit</a></td>
                <td><a href="<c:url value='/book/remove/${book.bookId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Book</h1>

<c:url var="addAction" value="/books/add"/>

<form:form action="${addAction}" commandName="book" method="post">
    <table>
        <c:if test="${!empty book.bookTitle}">
            <tr>
                <td>
                    <form:label path="bookId">
                        <spring:message text="BOOK_ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="bookId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="bookId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="bookTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="bookTitle"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="authorId" >
                    <spring:message text="Author"/>
                </form:label>
            </td>
            <td>
                <%--<form:input path="authorId"/>--%>
                <select name="authorId" id="authorId" required>
                    <c:forEach items="${listAuthors}" var="author">
                        <option value="${author.authorId}">${author.authorSurname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="price">
                    <spring:message text="Price"/>
                </form:label>
            </td>
            <td>
                <form:input path="price"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="genreId">
                    <spring:message text="genre"/>
                </form:label>
            </td>
            <td>
                <%--<form:input path="genreId"/>--%>
                <select name="genreId" id="genreId" required>
                    <c:forEach items="${listGenres}" var="genre">
                        <option value="${genre.genreId}">${genre.genreTitle}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty book.bookTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit Book"/>"/>
                </c:if>
                <c:if test="${empty book.bookTitle}">
                    <input type="submit"
                           value="<spring:message text="Add Book"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
