<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<HTML>
<HEAD>
    
	<TITLE>量资OA+CRM</TITLE>
	<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	<LINK HREF="${pageContext.request.contextPath}/style/blue/login.css" type=text/css rel=stylesheet />
	<script type="text/javascript">
		$(function(){
			document.forms[0].loginName.focus();
		});
		
		if(window.parent()!=window){
			window.parent.location.reload(true);
		}
	</script>
</HEAD>

<BODY LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0 CLASS=PageBody >
<s:form method="post" name="actForm" action="userAction_login.action">
    <DIV ID="CenterAreaBg">
        <DIV ID="CenterArea">
            <DIV ID="LogoImg"><p>量资OA+CRM系统</p></DIV>
            <DIV ID="LoginInfo">
            
                <TABLE BORDER=0 CELLSPACING=0 CELLPADDING=0 width=100%>
                    <tr>
                    	<td colspan="3"><!-- 显示错误 -->
                    		<font color="red"><s:fielderror/></font>
                    	</td>
                    </tr>
                    <TR>
                        <TD width=45 CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/login/userId.gif" /></TD>
                        <TD><s:textfield cssClass="TextField required" tabindex="1" name="loginName" /></TD>
                        <TD ROWSPAN="2" STYLE="padding-left:10px;"><INPUT TYPE="image" tabindex="3" SRC="${pageContext.request.contextPath}/style/blue/images/login/userLogin_button.gif"/></TD>
                    </TR>
                    <TR>
                        <TD CLASS="Subject"><IMG BORDER="0" SRC="${pageContext.request.contextPath}/style/blue/images/login/password.gif" /></TD>
                        <TD><s:password SIZE="20" cssClass="TextField required" tabindex="2" showPassword="false" name="password" /></TD>
                    </TR>
                </TABLE>
            </DIV>
            <DIV ID="CopyRight"><A HREF="javascript:void(0)">&copy; 2010 版权所有 itcast</A></DIV>
        </DIV>
    </DIV>
</s:form>
</BODY>

</HTML>

