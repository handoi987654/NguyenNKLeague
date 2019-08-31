<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Player List</h1>
<p>
    <c:forEach items="${playerList}" var="player" varStatus="status">
        #<c:out value="${status.index + 1}"/> -
        <c:out value="${player.name}"/> -
        Club: <c:out value="${player.club.name}"/><br>
    </c:forEach>
</p>