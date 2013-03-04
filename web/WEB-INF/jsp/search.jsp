<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html;charset=windows-1251" %>
<jsp:include page="template/header.jsp"/>

Результаты поиска
<br/>
<div class="content">
    <c:forEach items="${search}" var="car">
        <a href="<c:out value="/article/${car.id}"/>">${car.shortName}</a>
    </c:forEach>
</div>



<jsp:include page="template/footer.jsp"/>