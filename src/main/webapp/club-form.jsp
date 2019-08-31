<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Add Club</h1>
<form:form modelAttribute="club" action="/club/add" method="post">
    <form:label path="name">Name:</form:label>
    <form:input path="name"/><br>
    <form:errors path="name" cssStyle="color: red"/><br>
    <button type="submit">Add Club</button>
</form:form>
