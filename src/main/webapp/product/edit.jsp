<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>新增产品</title>
</head>
<body>
<div id="newProductForm">
    <form action="${pageContext.request.contextPath}/product/update.action" method="POST" onsubmit="onFormSubmit()">
        <input type="hidden" name="id" value="${product.id}"/>
        <fieldset>
            <legend>新增产品</legend>
            <p>
                <label for="name">产品名称:</label>
                <input id="name" type="text" name="name" value="${product.name}"/>
            </p>

            <p>
                <label for="cost">产品成本:</label>
                <input id="cost" type="number" name="cost" value="${product.cost}"/>
            </p>

            <p>
                <label for="architecture">技术体系:</label>
                <select id="architecture" name="architecture">
                    <option value="J2EE" ${product.architecture eq 'J2EE' ? 'selected' : ''}>J2EE</option>
                    <option value="Java桌面" ${product.architecture eq 'Java桌面' ? 'selected' : ''}>Java桌面</option>
                    <option value=".Net" ${product.architecture eq '.Net' ? 'selected' : ''}>.Net</option>
                    <option value="Domino" ${product.architecture eq 'Domino' ? 'selected' : ''}>Domino</option>
                    <option value="Android" ${product.architecture eq 'Android' ? 'selected' : ''}>Android</option>
                </select>
            </p>

            <p>
                <label for="suitableProject">适用项目:</label>
                <select id="suitableProject" name="suitableProject">
                    <option value="企业应用" ${product.suitableProject eq '企业应用' ? 'selected' : ''}>企业应用</option>
                    <option value="移动应用" ${product.suitableProject eq '移动应用' ? 'selected' : ''}>移动应用</option>
                    <option value="企业集成" ${product.suitableProject eq '企业集成' ? 'selected' : ''}>企业集成</option>
                    <option value="数据分析" ${product.suitableProject eq '数据分析' ? 'selected' : ''}>数据分析</option>
                </select>
            </p>
            <div id="buttons">
                <input type="submit" value="确定"/>
                <input type="reset" value="重置"/>
                <input type="button" value="返回" onclick="history.back()"/>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>