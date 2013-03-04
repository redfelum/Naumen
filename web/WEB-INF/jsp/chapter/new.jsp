<%@ page import="model.ChapterModel" %>
<%@ page import="entity.Chapter" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=windows-1251" %>

<jsp:include page="../template/header.jsp"/>


<div class="content">
    <form:form method="post" commandName="chapter">
        <table>
            <tr>
                <td>Short name:</td>
                <td><form:input path="shortName"/></td>
                <td><span class="error"><form:errors path="shortName"/></span></td>
            </tr>

            <tr>
                <td>Full name:</td>
                <td><form:input path="fullName"/></td>
                <td><span class="error"><form:errors path="fullName"/></span></td>
            </tr>

            Chapter :
            <%
                ChapterModel model = new ChapterModel();
                List<Chapter> res = model.getChapterList();
            %>
            <select name="parentId">
                <option value=""></option>

                <%for (int i = 0; i < res.size(); i++) {%>
                <option value=<%=model.getChapter(res.get(i).getId()).getId()%>>
                    <%=res.get(i).getShortName()%>
                </option>
                <%}%>
            </select>

            <tr>
                <td colspan="3"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </form:form>

</div>


<jsp:include page="../template/footer.jsp"/>
