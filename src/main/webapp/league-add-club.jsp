<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Add Club To League</h1>
<form method="post" action="${pageContext.request.contextPath}/league/add-club">
    <select name="clubID">
        <c:forEach items="${clubList}" var="club">
            <option value="${club.id}">${club.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Add Club to League</button>
</form>
