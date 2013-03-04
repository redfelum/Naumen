<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html;charset=windows-1251" %>
<script>
    function confirmDelete(delUrl) {
        if (confirm("Are you sure you want to delete")) {
            document.location = delUrl;
        }
    }
</script>

<jsp:include page="../template/header.jsp" />
<div class="content">
    <h2>Full name</h2> ${article.fullName}<br/>
    <H2>Text of article</H2>  <br/>
    ${article.body}
    <br/>
    <a href="javascript:confirmDelete('delete/${id}')">Удалить эту статью</a>


</div>
<jsp:include page="../template/footer.jsp" />
