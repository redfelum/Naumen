<%@ page import="java.util.ArrayList" %>
<%@ page import="helpers.ChapterHelpers" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="helpers.BreadCrumbs" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" media="screen" href="/resources/style.css"/>
    <title></title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div id="header">
    <%
        ArrayList<String> res = BreadCrumbs.getInstance().getCrumbs();
        for (int i = res.size() - 1; i >= 0; i--) {
    %>


    <%=res.get(i)%>
    <%}
    BreadCrumbs.getInstance().clear();%>
    <br/>
    <a href="<c:out value="/"/>">На главную</a>
    <a href="<c:out value="/article/new"/>">Добавть статью</a>
    <a href="<c:out value="/chapter/new"/>">Добавить главу</a>
    <br/>

    <form action="/search" method="GET">
        <table>
            <tr>
                <th>Поиск</th>
                <td><input type="text" name="text"/></td>
            </tr>
            <tr>
                <td rowspan="2"><input type="submit" value="Search"/></td>
            </tr>
        </table>
    </form>

</div>

