<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新增人员</title>
</head>
<body>
<div id="newProductForm">
    <form action="${pageContext.request.contextPath}/person/save.action" method="POST">
        <fieldset>
            <legend>新增人员</legend>
            <p>
                <label for="name">姓名:</label>
                <input id="name" type="text" name="name"/>
            </p>

            <p>
                <label for="department">部门:</label>
                <select id="department">
                    <s:iterator value="departmentList" var="department">
                        <option value="${department.name}">${department.name}</option>
                    </s:iterator>
                </select>
            </p>

            <p>
                <label for="password">密码:</label>
                <input type="password" id="password" name="password" />
            </p>

            <p>
                <label for="confirmPassword">确认密码:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" />
            </p>

            <p>
                <label>角色:</label>
                <label for="projectDev">项目开发人员</label>
                <input id="projectDev" type="radio" name="role" value="PROJECT_DEV" />
                <label for="productDev">产品开发人员</label>
                <input id="productDev" type="radio" name="role" value="PRODUCT_DEV" />
            </p>
            <p>
                <label for="project">所在项目</label>
                <select id="project">
                    <c:forEach var="project" items="${projectList}">
                        <option value="${project.name}">${project.name}</option>
                    </c:forEach>
                </select>
            </p>

            <div id="buttons">
                <input type="submit" value="确定"/>
                <input type="reset" value="重置"/>
                <input type="button" value="返回" onclick="history.back()" />
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>