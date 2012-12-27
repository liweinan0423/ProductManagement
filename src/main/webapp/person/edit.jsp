<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改人员</title>
</head>
<body>
<div id="newProductForm">
    <form action="${pageContext.request.contextPath}/person/update.action" method="POST">
        <input type="hidden" name="id" value="${person.id}" />
        <fieldset>
            <legend>修改人员</legend>
            <p>
                <label for="name">姓名:</label>
                <input id="name" type="text" name="name" value="${person.name}"/>
            </p>

            <p>
                <label for="department">部门:</label>
                <select id="department">
                    <s:iterator value="departmentList" var="department">
                        <option value="${department.name}" ${person.department.name eq department.name ? 'selected' : ''}>${department.name}</option>
                    </s:iterator>
                </select>
            </p>

            <p>
                <label>角色:</label>
                <label for="projectDev">项目开发人员</label>
                <input id="projectDev" type="radio" name="role" value="PROJECT_DEV" ${person.role eq 'PROJECT_DEV' ? 'checked' : ''} />
                <label for="productDev">产品开发人员</label>
                <input id="productDev" type="radio" name="role" value="PRODUCT_DEV" ${person.role eq 'PRODUCT_DEV' ? 'checked' : ''}/>
            </p>
            <p>
                <label for="project">所在项目</label>
                <select id="project">
                    <c:forEach var="project" items="${projectList}">
                        <option value="${project.name}" ${person.project.name eq project.name ? 'selected' : ''}>${project.name}</option>
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