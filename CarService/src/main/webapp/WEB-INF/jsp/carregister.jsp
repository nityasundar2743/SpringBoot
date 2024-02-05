<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<h1>This is the signup page</h1>
<form:form action="done" modelAttribute="Vehicle">
Car Number :
<form:input path="RegisterationNumber"/>
<br>
Car Name :
<form:select path="CarName">
<form:option value="Seltos"></form:option>
<form:option value="others"></form:option>
</form:select>
<br>
Covered in Warranty :
<form:select path="CarDetails">
<form:option value="YES"></form:option>
<form:option value="NO"></form:option>
</form:select>
<br>
Any Remarks :
<form:input path="CarWork"/>
<input type="submit">
</form:form>
</html>
