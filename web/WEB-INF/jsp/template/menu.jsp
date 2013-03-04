<%@ page import="java.util.ArrayList" %>
<%@ page import="helpers.ChapterHelpers" %>
<%@page contentType="text/html;charset=windows-1251" %>

<div id="menu">
    <%
        ArrayList<String> res = ChapterHelpers.getInstance().getMenu();
        for (int i = 0; i < res.size(); i++) {
    %>

    <%=res.get(i)%>
    <%}%>
</div>