<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Languages</h1>

<table>
<thead>
<tr>Id</tr>
<tr>Name</tr>
<tr>Creator</tr>
<tr>Version</tr>
<tr>Action</tr>

<tbody>
<tr>
<c:forEach items="${allLanguages}" var="language">
<td><c:out value="${language.id}"></c:out>
<td><c:out value="${language.name}" ></c:out>
<td><c:out value="${language.creator}"></c:out>
<td><c:out value="${language.version}"></c:out>
<a href="/language/${language.id}/edit">Edit</a>
<a href="/language/${language.id}/delete">Delete</a> 
</c:forEach>

</tbody>
</table>

<form:form action="/language" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="version">Version</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>  
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>


