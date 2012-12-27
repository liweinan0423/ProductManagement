<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>产品问题管理平台</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/public/login.action" method="POST">
    <fieldset>
        <legend>用户登录</legend>
        <c:if test="${message != null }">
            <div class="error">${message}</div>
        </c:if>
        <p>
            <label for="username">用户名</label>
            <input id="username" name="login"/>
        </p>
        <p>
            <label for="password">密码</label>
            <input id="password" type="password" name="password" />
        </p>

        <p>
            <input type="submit" value="登录" />
        </p>
    </fieldset>
</form>
</body>
</html>