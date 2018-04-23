<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Genres Page</title>

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

<h1>Genre List</h1>

<c:if test="${!empty listGenres}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Genre</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listGenres}" var="genre">
            <tr>
                <td>${genre.genreId}</td>
                <td><a href="/genredata/${genre.genreId}" target="_blank">${genre.genreTitle}</a></td>
                <td><a href="<c:url value='/genre/edit/${genre.genreId}'/>">Edit</a></td>
                <td><a href="<c:url value='/genre/remove/${genre.genreId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Genre</h1>

<c:url var="addAction" value="/genres/add"/>

<form:form action="${addAction}" commandName="genre">
    <table>
        <c:if test="${!empty genre.genreTitle}">
            <tr>
                <td>
                    <form:label path="genreId">
                        <spring:message text="GENRE_ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="genreId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="genreId"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="genreTitle">
                    <spring:message text="Title"/>
                </form:label>
            </td>
            <td>
                <form:input path="genreTitle"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty genre.genreTitle}">
                    <input type="submit"
                           value="<spring:message text="Edit Genre"/>"/>
                </c:if>
                <c:if test="${empty genre.genreTitle}">
                    <input type="submit"
                           value="<spring:message text="Add Genre"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
