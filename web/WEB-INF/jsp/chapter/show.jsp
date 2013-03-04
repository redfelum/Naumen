<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html;charset=windows-1251" %>


<jsp:include page="../template/header.jsp"/>
<script>
    function confirmDelete(delUrl) {
        if (confirm("Are you sure you want to delete")) {
            document.location = delUrl;
        }
    }
</script>


<div class="content">
        <c:forEach items="${chapter}" var="chap">
            <a href="<c:out value="/article/${chap.id}"/>">${chap.shortName}</a>
        </c:forEach>
    <br/>
    <br/>

    <a href="javascript:confirmDelete('delete/${id}')">Удалить эту главу</a>
</div>



<jsp:include page="../template/footer.jsp"/>

