<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Add a Player</h1>
<form:form modelAttribute="playerModel" method="post" action="/player/add">
    <form:label path="name">Name:</form:label>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    <form:label path="clubID">Club:</form:label>
    <form:select path="clubID" items="${clubList}" itemValue="id" itemLabel="name"/><br>
    <form:errors path="clubID" cssStyle="color: red"/><br>
    <button type="submit">Add Player</button>
</form:form>