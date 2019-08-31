<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Match List</h1>
<p>
    <c:forEach items="${matchList}" var="match" varStatus="status">
        <c:out value="${match.firstClub.name}"/> -
        <c:out value="${match.secondClub.name}"/> -
        <c:out value="${match.date}"/> |
        <c:choose>
            <c:when test="${match.result == null}">
                <br>
                <form:form modelAttribute="resultModel" action="update-result" method="post">
                    <form:hidden path="matchID" value="${match.id}"/>
                    <form:input path="firstGrade"/> : <form:input path="secondGrade"/>
                    <button type="submit">Update Result</button><br>
                    <form:errors path="firstGrade" cssStyle="color: red"/><br>
                    <form:errors path="secondGrade" cssStyle="color: red"/><br>
                </form:form>
            </c:when>
            <c:otherwise>
                <c:out value="${match.result}"/><br>
            </c:otherwise>
        </c:choose>
    </c:forEach>
</p>
