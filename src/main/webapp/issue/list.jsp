<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>问题管理</title>
</head>
<body>
<jsp:include page="/navigator.jsp" />
<div id="buttons">
    <c:if test="${currentUser.role eq 'PROJECT_DEV' or currentUser.id eq '-1'}">
        <a href="<s:url namespace="/issue" action="new" />">提交问题</a>
    </c:if>
</div>
<div id="productList">
    <table>
        <thead>
        <tr>
            <th>序号</th>
            <th>产品名称</th>
            <th>问题版本号</th>
            <th>产品模块</th>
            <th>严重程度</th>
            <th>反馈项目组</th>
            <th>提交日期</th>
            <th>提交人</th>
            <th>问题状态</th>
            <th>问题有效性</th>
            <th>解决人</th>
            <th>解决日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator var="issue" value="issueList" status="s">
            <tr>
                <td>
                        ${s.index + 1}
                </td>
                <td>
                        ${issue.product.name}
                </td>
                <td>
                        ${issue.version}
                </td>
                <td>
                        ${issue.module}
                </td>
                <td>
                        ${issue.severity}
                </td>
                <td>
                        ${issue.projectTeam}
                </td>
                <td>
                    <s:date name="createDate" format="yyyy-MM-dd"/>
                </td>
                <td>
                        ${issue.creator}
                </td>
                <td>
                        ${issue.status}
                </td>
                <td>
                        ${issue.valid ? '有效' : '无效'}
                </td>
                <td>
                        ${issue.resolver}
                </td>
                <td>
                    <s:date name="resolveDate" format="yyyy-MM-dd"/>
                </td>
                <td>
                    <c:if test="${(currentUser.role eq 'PROJECT_DEV' or currentUser.id eq '-1') and (issue.status eq '未解决')}">
                        <a href="${pageContext.request.contextPath}/issue/changeValid.action?id=${issue.id}">
                            <c:if test="${issue.valid}">
                                置为无效
                            </c:if>
                            <c:if test="${!issue.valid}">
                                置为有效
                            </c:if>
                        </a>
                    </c:if>
                    &nbsp;
                    <c:if test="${currentUser.role eq 'PRODUCT_DEV' or currentUser.id eq '-1'}">
                        <c:if test="${issue.status eq '未解决' and issue.valid}">
                            <a href="${pageContext.request.contextPath}/issue/resolve.action?id=${issue.id}">解决</a>
                        </c:if>
                    </c:if>
                </td>
            </tr>
        </s:iterator>
        </tbody>
    </table>
    <div id="pageToolBar">
        <label>
            第${pageNo}页/共${totalPages}页
        </label>
        <c:if test="${hasPreviousPage}">
            <a href="${pageContext.request.contextPath}/issue/list.action?pageNo=${pageNo - 1}">上一页</a>
        </c:if>

        <c:if test="${hasNextPage}">
            <a href="${pageContext.request.contextPath}/issue/list.action?pageNo=${pageNo + 1}">下一页</a>
        </c:if>
    </div>
</div>
</body>
</html>