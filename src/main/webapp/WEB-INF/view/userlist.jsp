<%--
  Created by IntelliJ IDEA.
  User: chenbin
  Date: 2017/9/11
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC表单处理之-密码</title>
</head>
<body>

<h2>提交的用户信息</h2>
<table>
    <tr>
        <td>用户名：</td>
        <td>${username}</td>
    </tr>
    <tr>
        <td>密码：</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td>地址：</td>
        <td>${address}</td>
    </tr>
    <tr>
        <td>是否订阅新闻</td>
        <td>${receivePaper}</td>
    </tr>
    <tr>
        <td>喜欢的技术/框架</td>
        <td>
            <c:forEach items="${favoriteFrameworks}" var="favorite">
                ${favorite}
            </c:forEach>
           <%-- <% String[] favoriteFrameworks = (String[])request.getAttribute("favoriteFrameworks");
            for(String framework: favoriteFrameworks) {
                out.println(framework);
            }%>--%>
        </td>
    </tr>
    <tr>
        <td>喜欢的数字：</td>
        <td>${favoriteNumber}</td>
    </tr>
    <tr>
        <td>国家：</td>
        <td>${country}</td>
    </tr>
    <tr>
        <td>技术：</td>
        <td>
            <c:forEach items="${skills}" var="skill">
                ${skill}
            </c:forEach>
            <%--<%
                String[] skills = (String[]) request.getAttribute("skills");
                for (String skill : skills) {
                    out.println(skill);
                }
            %>--%>
        </td>
    </tr>
    <tr>
        <td>性别：</td>
        <td>${(gender=="M"? "男" : "女")}</td>
    </tr>
</table>

</body>
</html>
