<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>提交问题</title>
</head>
<body>
<jsp:include page="/navigator.jsp" />
<div id="newProductForm">
    <form action="${pageContext.request.contextPath}/issue/save.action" method="POST">
        <fieldset>
            <legend>提交问题</legend>
            <p>
                <label for="productId">产品名称:</label>
                <select id="productId" name="productId">
                    <c:forEach var="product" items="${productList}">
                        <option value="${product.id}">${product.name}</option>
                    </c:forEach>
                </select>
            </p>

            <p>
                <label for="version">版本号:</label>
                <input id="version" type="text" name="version" />
            </p>

            <p>
                <label for="module">产品模块:</label>
                <input id="module" name="module" />
            </p>

            <p>
                <label for="severity">严重程度:</label>
                <select id="severity" name="severity">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </p>
            <p>
                <label for="projectTeam">反馈项目组:</label>
                <input id="projectTeam" type="text" value="${currentUser.project}" />
            </p>
            <p>
                <label for="creator">提交人:</label>
                <input id="creator" name="creator" value="${currentUser.name}">
            </p>
            <p>
                <label for="description">详细描述:</label>
                <textarea id="description" name="description" cols="50" rows="5"></textarea>
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