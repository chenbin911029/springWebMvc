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
<a href="testRedirect">Test Redirect</a>
<br><br>
<a href="testView">Test View</a>
<br><br>

<a href="testViewAndViewResolver">Test ViewAndViewResolver</a>
<br><br>
<!--
		模拟修改操作
		1. 原始数据为: 1, Tom, 123456,tom@atguigu.com,12
		2. 密码不能被修改.
		3. 表单回显, 模拟操作直接在表单填写对应的属性值
	-->
<form action="testModelAttribute" method="Post">
    <input type="hidden" name="id" value="1"/>
    username: <input type="text" name="username" value="Tom"/>
    <br>
    email: <input type="text" name="email" value="tom@atguigu.com"/>
    <br>
    age: <input type="text" name="age" value="12"/>
    <br>
    <input type="submit" value="Submit"/>
</form>
<br><br>
<a href="testSessionAttributes">Test SessionAttributes</a>
<br><br>
<a href="testMap">Test Map</a>
<br><br>
<a href="testModelAndView">Test ModelAndView</a>
<br><br>

<a href="testServletAPI">Test ServletAPI</a>
<br><br>

<form action="testPojo" method="post">
    username: <input type="text" name="username"/>
    <br>
    password: <input type="password" name="password"/>
    <br>
    email: <input type="text" name="email"/>
    <br>
    age: <input type="text" name="age"/>
    <br>
    city: <input type="text" name="address.city"/>
    <br>
    province: <input type="text" name="address.province"/>
    <br>
    <input type="submit" value="Submit"/>
</form>
<br><br>

<a href="testCookieValue">Test CookieValue</a>
<br><br>

<a href="testRequestHeader">Test RequestHeader</a>
<br><br>

<a href="testRequestParam?username=atguigu&age=11">Test RequestParam</a>
<br><br>

<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="PUT"/>
    <input type="submit" value="TestRest PUT"/>
</form>
<br><br>

<form action="testRest/1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="TestRest DELETE"/>
</form>
<br><br>

<form action="testRest" method="post">
    <input type="submit" value="TestRest POST"/>
</form>
<br><br>

<a href="testRest/1">Test Rest Get</a>
<br><br>






</body>
</html>


