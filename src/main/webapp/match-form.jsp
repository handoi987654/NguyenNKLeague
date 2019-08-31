<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Match Form</h1>
<form:form modelAttribute="matchModel" action="/match/add" method="post">
    <form:label path="firstClubID">First Club:</form:label>
    <form:select path="firstClubID" items="${clubList}" itemValue="id" itemLabel="name"/><br>
    <form:errors path="firstClubID" cssStyle="color: red"/><br>
    <form:label path="secondClubID">Second Club:</form:label>
    <form:select path="secondClubID" items="${clubList}" itemValue="id" itemLabel="name"/><br>
    <form:errors path="secondClubID" cssStyle="color: red"/><br>
    <form:label path="date">Date:</form:label>
    <form:input path="date" type="date"/><br>
    <form:errors path="date" cssStyle="color: red"/><br>
    <button type="submit">Add Match</button>
</form:form>
