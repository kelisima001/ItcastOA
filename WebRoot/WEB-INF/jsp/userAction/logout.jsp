<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
<title>您已退出量资OA+CRM系统</title>
	<link href="${pageContext.request.contextPath}/style/blue/logout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function closeWindow(){
		if(confirm("您确定要关闭本页吗？")){
			window.opener=null;
			window.open('','_self');
			window.close();
		}
		else{}
	}
	
</script>
</head>

<body>
	<table border=0 cellspacing=0 cellpadding=0 width=100% height=100%>
		<tr>
			<td align=center>
				<div id=Logout>
					<div id=AwokeMsg><img id=LogoutImg src="${pageContext.request.contextPath}/style/blue/images/logout/logout.gif" border=0 /><img id=LogoutTitle src="${pageContext.request.contextPath}/style/blue/images/logout/logout1.gif" border=0 /></div>
					<div id=LogoutOperate>
                    <img src="${pageContext.request.contextPath}/style/blue/images/logout/logout2.gif" border=0 /> 
                    <a href="${pageContext.request.contextPath}/userAction_loginUI.action">重新进入系统</a>
                    <!--<img src="${pageContext.request.contextPath}/style/blue/images/logout/logout3.gif" border=0 />
                     <a onclick="javascript:closeWindow()">关闭当前窗口</a> -->
                    </div>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>
