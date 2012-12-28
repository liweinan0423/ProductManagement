<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新增产品</title>
</head>
<body>
<jsp:include page="/navigator.jsp" />
<div id="newProductForm">
    <form action="${pageContext.request.contextPath}/product/save.action" method="POST">
        <fieldset>
            <legend>新增产品</legend>
            <p>
                <label for="name">产品名称:</label>
                <input id="name" type="text" name="name"/>
            </p>

            <p>
                <label for="cost">产品成本:</label>
                <input id="cost" type="text" name="cost" validator="number" maxlength="7"/>
            </p>

            <p>
                <label for="architecture">技术体系:</label>
                <select id="architecture" name="architecture">
                    <option value="J2EE">J2EE</option>
                    <option value="Java桌面">Java桌面</option>
                    <option value=".Net">.Net</option>
                    <option value="Domino">Domino</option>
                    <option value="Android">Android</option>
                </select>
            </p>

            <p>
                <label for="suitableProject">适用项目:</label>
                <select id="suitableProject" name="suitableProject">
                    <option value="企业应用">企业应用</option>
                    <option value="移动应用">移动应用</option>
                    <option value="企业集成">企业集成</option>
                    <option value="数据分析">数据分析</option>
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