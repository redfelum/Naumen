<%@ page import="model.ChapterModel" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Chapter" %>
<%@page contentType="text/html;charset=windows-1251" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<jsp:include page="../template/header.jsp"/>
<div class="content">
    <form:form method="post" commandName="article">

        Short name:
        <form:input path="shortName"/>
        <span class="error"><form:errors path="shortName"/></span>
        <br/>


        Full name:</td>
        <form:input path="fullName"/>
        <span class="error"><form:errors path="fullName"/></span>
        <br/>

        Chapter :
        <%
            ChapterModel model = new ChapterModel();
            List<Chapter> res = model.getChapterList();
        %>
        <select name="chapter_id">
            <option value="0"></option>

            <%for (int i = 0; i < res.size(); i++) {%>
            <option value=<%=model.getChapter(res.get(i).getId()).getId()%>>
                <%=res.get(i).getShortName()%>
            </option>
            <%}%>
        </select>
        <br/>

        Body:</td>

        <form:textarea  path="body"/>
        <span class="error"><form:errors path="body"/></span>
        <br/>


        <input type="submit" value="Submit"/>
        <br/>

    </form:form>
</div>


<jsp:include page="../template/footer.jsp"/>
