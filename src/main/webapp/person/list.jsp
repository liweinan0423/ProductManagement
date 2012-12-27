<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>人员管理</title>
</head>
<body>
<div id="buttons">
    <a href="<s:url namespace="/person" action="create" />">新增人员</a>
</div>
<div id="productList">
    <table>
        <thead>
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>部门</th>
            <th>用户名</th>
            <th>角色</th>
            <th>所在项目</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="person" items="${personList}" varStatus="status">
            <tr>
                <td>
                        ${status.index + 1}
                </td>
                <td>
                        ${person.name}
                </td>
                <td>
                        ${person.department}
                </td>
                <td>
                        ${person.login}
                </td>
                <td>
                        ${person.role}
                </td>
                <td>
                        ${person.project}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/person/edit.action?id=${person.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/person/delete.action?id=${person.id}" onclick="if (confirm('是否确定')) {return true} else {return false;}">删除</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div id="pageToolBar">
        <label>
            第${pageNo}页/共${totalPages}页
        </label>
        <c:if test="${hasPreviousPage}">
            <a href="${pageContext.request.contextPath}/person/list.action?pageNo=${pageNo - 1}">上一页</a>
        </c:if>

        <c:if test="${hasNextPage}">
            <a href="${pageContext.request.contextPath}/person/list.action?pageNo=${pageNo + 1}">下一页</a>
        </c:if>
    </div>
</div>
</body>
</html>