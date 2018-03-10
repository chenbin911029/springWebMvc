<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Enrollment Detail Confirmation</title>
    <%--<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>--%>
</head>
<body>
<div class="success">
    Confirmation message : ${success}
    <br>
    We have also sent you a confirmation mail to your email address : ${student.email}.
</div>

<h4>Sucess Page</h4>

time: ${requestScope.time }
<br><br>
names: ${requestScope.names }
<br><br>

request user: ${requestScope.user }
<br><br>

session user: ${sessionScope.user }
<br><br>

request school: ${requestScope.school }
<br><br>

session school: ${sessionScope.school }
<br><br>

<fmt:message key="i18n.username"></fmt:message>
<br><br>

<fmt:message key="i18n.password"></fmt:message>
<br><br>
</body>
</html>