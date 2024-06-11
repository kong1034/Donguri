<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Layout Page</title>
</head>
<body>

<jsp:include page="/header.jsp"></jsp:include>

<div class="content">
    <c:set var="contentPage" value="${empty request.getAttribute('contentPage') ? '/defaultContent.jsp' : request.getAttribute('contentPage')}" />
    <jsp:include page="${contentPage}" />
</div>

<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>