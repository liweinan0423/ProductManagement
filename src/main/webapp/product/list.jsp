<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>产品管理</title>
</head>
<body>
<jsp:include page="/navigator.jsp" />
<div id="buttons">
    <a href="<s:url namespace="/product" action="create" />">新增产品</a>
</div>
<div id="productList">
    <table>
        <thead>
        <tr>
            <th>序号</th>
            <th>产品名称</th>
            <th>产品成本</th>
            <th>技术体系</th>
            <th>适用项目</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="issue" items="${productList}" varStatus="status">
            <tr>
                <td>
                        ${status.index + 1}
                </td>
                <td>
                        ${issue.name}
                </td>
                <td>
                        ${issue.cost}
                </td>
                <td>
                        ${issue.architecture}
                </td>
                <td>
                        ${issue.suitableProject}
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/edit.action?id=${issue.id}">修改</a>
                    <a href="${pageContext.request.contextPath}/product/delete.action?id=${issue.id}" onclick="if (confirm('是否确定')) {return true} else {return false;}">删除</a>
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
            <a href="${pageContext.request.contextPath}/product/list.action?pageNo=${pageNo - 1}">上一页</a>
        </c:if>

        <c:if test="${hasNextPage}">
            <a href="${pageContext.request.contextPath}/product/list.action?pageNo=${pageNo + 1}">下一页</a>
        </c:if>
    </div>
</div>
</body>
</html>