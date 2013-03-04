
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="template/header.jsp" />
<div class="content">
    <H2>Все главы</H2><br/>
    <c:forEach items="${chapter}" var="car">
        <a href="<c:out value="/chapter/${car.id}"/>">${car.shortName}</a>
        <br/>
    </c:forEach>
    <br/>
</div>
<jsp:include page="template/footer.jsp" />

