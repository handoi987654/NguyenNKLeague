<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Club Rank</h1>
<p>
    <c:forEach items="${clubList}" var="club" varStatus="status">
        #<c:out value="${status.index + 1}"/> -
        <c:out value="${club.name}"/> -
        Point: <c:out value="${club.point}"/><br>
    </c:forEach>
</p>
