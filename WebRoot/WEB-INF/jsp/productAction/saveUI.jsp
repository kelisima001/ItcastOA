<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>版块设置</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
</head>
<body>

<!-- 标题显示 -->
<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 版块设置
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<!--显示表单内容-->
<div id="MainArea">
    <s:form action="product_%{id==null?'add':'edit'}">
    <s:hidden name="id"/>
        <div class="ItemBlock_Title1"><!-- 信息说明<DIV CLASS="ItemBlock_Title1">
        	<IMG BORDER="0" WIDTH="4" HEIGHT="7" SRC="${pageContext.request.contextPath}/style/blue/images/item_point.gif" /> 版块信息 </DIV>  -->
        </div>
        
        <!-- 表单内容显示 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td width="100">产品名称</td>
                        <td><s:textfield name="name" cssClass="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td width="100">产品短名称</td>
                        <td><s:textfield name="shortName" cssClass="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td width="100">产品图片</td>
                        <td><img src="${pageContext.request.contextPath}/style/images/${url}"/> *</td>
                    </tr>
                    <tr>
                        <td>产品短说明</td>
                        <td><s:textarea name="shortDescription" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                    <tr>
                        <td>产品说明</td>
                        <td><s:textarea name="description" cssClass="TextareaStyle"></s:textarea></td>
                    </tr>
                    <tr>
                        <td width="100">能销售的部门</td>
                        <td><s:select list="#departmentList" name="departmentIds" listKey="id" listValue="name"
                            cssClass="SelectStyle" multiple="true" size="10"></s:select></td>
                    </tr>
                    <tr>
                        <td width="100">创建日期</td>
                        <td><s:textfield name="createTime" cssClass="InputStyle" /> *</td>
                    </tr>
                    <tr>
                        <td width="100">更新日期</td>
                        <td><s:textfield name="updateTime" cssClass="InputStyle" /> *</td>
                    </tr>
                    
                </table>
            </div>
        </div>
        
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
            <a href="javascript:history.go(-1);"><img src="${pageContext.request.contextPath}/style/images/goBack.png"/></a>
        </div>
    </s:form>
</div>

<div class="Description">
	说明：<br />
	1，新添加的版块默认显示在最下面。<br />
</div>

</body>
</html>

