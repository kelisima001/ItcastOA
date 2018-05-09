<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>My JSP 'list.jsp' starting page</title>
    
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%-- <s:iterator value="#roleList">
    	<s:property value="id"/>
    	<s:property value="name"/>
    	<s:property value="description"/>
    	<a href="roleAction_delete?id=<s:property value='id'/>">删除</a>
    </s:iterator> --%>
    
    <s:iterator value="#roleList">
    	${id},
    	${name},
    	${description},
    	<%-- <a href="${pageContext.request.contextPath}/roleAction_delete.action?id=${id}" 
    	onclick="return confirm('确定要删除吗?')">删除</a> --%>
    	<!-- 等于下面 -->
    	
    	<s:a action="roleAction_editUI?id=%{id}">修改</s:a>
    	<s:a action="roleAction_delete?id=%{id}" onclick="return confirm('确定要删除吗?')">删除</s:a>
    	<br>
    </s:iterator>
    <s:a action="roleAction_addUI">添加</s:a>
  </body>
</html>
