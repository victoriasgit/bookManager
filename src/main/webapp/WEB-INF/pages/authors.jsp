<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Authors Page</title>

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

<h1>Author List</h1>

<c:if test="${!empty listAuthors}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Surname</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listAuthors}" var="author">
            <tr>
                <td>${author.authorId}</td>
                <td><a href="/authordata/${author.authorId}" target="_blank">${author.authorSurname}</a></td>
                <td>${author.authorName}</td>
                <td><a href="<c:url value='/author/edit/${author.authorId}'/>">Edit</a></td>
                <td><a href="<c:url value='/author/remove/${author.authorId}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>


<h1>Add a Author</h1>

<c:url var="addAction" value="/authors/add"/>

<form:form action="${addAction}" commandName="author">
    <table>
        <c:if test="${!empty author.authorSurname}">
            <tr>
                <td>
                    <form:label path="authorId">
                        <spring:message text="AUTHOR_ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="authorId" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="authorId"/>
                </td>
            </tr>
        </c:if>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<form:label path="authorId">--%>
                    <%--<spring:message text="Author"/>--%>
                <%--</form:label>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<form:input path="authorId"/>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <tr>
            <td>
                <form:label path="authorSurname">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="authorSurname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="authorName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="authorName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty author.authorSurname}">
                    <input type="submit"
                           value="<spring:message text="Edit Author"/>"/>
                </c:if>
                <c:if test="${empty author.authorSurname}">
                    <input type="submit"
                           value="<spring:message text="Add Author"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>