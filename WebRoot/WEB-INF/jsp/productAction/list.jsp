<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>产品列表</title>
    <%@ include file="/WEB-INF/jsp/public/common.jspf" %>
    <script type="text/javascript">
    </script>
</head>
<body>

<div id="Title_bar">
    <div id="Title_bar_Head">
        <div id="Title_Head"></div>
        <div id="Title"><!--页面标题-->
            <img border="0" width="13" height="13" src="${pageContext.request.contextPath}/style/images/title_arrow.gif"/> 版块管理
        </div>
        <div id="Title_End"></div>
    </div>
</div>

<div id="MainArea">
    <table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align="CENTER" valign="MIDDLE" id="TableTitle">
            	<td width="150px">产品名称</td>
            	<td width="300px">产品短名称</td>
            	<td width="300px">产品图片</td>
            	<td width="400px">产品短说明</td>
                <td width="50px">产品说明</td>
                
                <td width="300px">授权</td>
                <td width="250px">创建时间</td>
                <td width="250px">更新时间</td>
                
                <td width="150px">相关操作</td>
            </tr>
        </thead>

		<!--显示数据列表-->
        <tbody id="TableData" class="dataContainer" datakey="forumList">
        	<s:iterator value="#productList">
				<tr class="TableDetail1 template">
					<td>${name}&nbsp;</td>
					<td>${shortName}&nbsp;</td>
					<td><img src="${pageContext.request.contextPath}/style/images/${url}"/></td>
					<td>${shortDescription}&nbsp;</td>
					<td>${description}&nbsp;</td>
					
					<td>
	                	<s:iterator value="departments">
	                		${name}
	                	</s:iterator>
	                </td>
					<td>${createTime}&nbsp;</td>
					<td>${updateTime}&nbsp;</td>
					
					<td><s:a action="product_delete?id=%{id}" onclick="return delConfirm()">删除</s:a>
						<s:a action="product_editUI?id=%{id}">修改</s:a>
						
					</td>
				</tr>
			</s:iterator>
        </tbody>
    </table>
    
    <!-- 其他功能超链接 -->
    <div id="TableTail">
        <div id="TableTail_inside">
            <s:a href="product_addUI"><img src="${pageContext.request.contextPath}/style/images/createNew.png" /></s:a>
        </div>
    </div>
</div>

<div class="Description">
	说明：<br />
	1，显示的列表按其sortOrder值升序排列。<br />
	2，可以通过上移与下移功能调整顺序。最上面的不能上移，最下面的不能下移。<br />
</div>

</body>
</html>