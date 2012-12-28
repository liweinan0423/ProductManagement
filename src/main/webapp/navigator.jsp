<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/skin.css" />
</head>
<body>

<ul class="nav">
    <li class="nav_first">
        <a href="${pageContext.request.contextPath}/product/list.action">产品管理</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/person/list.action">人员管理</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/issue/list.action">问题管理</a>
    </li>
</ul>
<div class="principal">
    当前登录人: ${currentUser.name} | <a href="${pageContext.request.contextPath}/public/logout.action">退出</a>
</div>
<div class="clear"></div>
<hr />
</body>
</html>