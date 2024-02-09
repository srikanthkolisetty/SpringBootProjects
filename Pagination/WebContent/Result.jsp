<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:out value="(${!empty list && list ne null})"/>
<table border="1">

<tr><th>Name</th><th>Course</th><th>Age</th></tr>

<c:choose>

<c:when test="${!empty list && list ne null}">
<c:out value="${test}"/>
<c:forEach var="row" items="${list}">
<tr><td>${row.name}</td><td>${row.course}</td><td>${row.age}</td></tr>
</c:forEach>
</c:when>
<c:otherwise>
"No Records Found with the suitable data."
</c:otherwise>
</c:choose>
</table>
<c:forEach var="count" begin="1" end="${pageCount}">
<a href="./controller/second?s1=${count}">[${count}]</a>
</c:forEach>
</body>
</html>