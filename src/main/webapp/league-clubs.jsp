<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>League Clubs</h1>
<p>
    <c:forEach items="${clubList}" var="club" varStatus="status">
        #<c:out value="${status.index + 1}"/> -
        <c:out value="${club.name}"/><br>
    </c:forEach>
</p>