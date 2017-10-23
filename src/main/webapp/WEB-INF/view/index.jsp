<%--
  Created by IntelliJ IDEA.
  User: chenbin
  Date: 2017/9/12
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Spring MVC页面重定向</title>
</head>
<body>
<h2>Spring MVC页面重定向</h2>
<p>点击下面的按钮将结果重定向到新页面</p>
<form:form method="GET" action="/webController/redirect">
    <table>
        <tr>
            <td><input type="submit" value="页面重定向" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>


