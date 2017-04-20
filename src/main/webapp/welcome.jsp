<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<c:if test="${sessionUser.sysUserIsManger!=1}">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 1px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #4AA3D8;
}
html { overflow-x: hidden; overflow-y: hidden; border:0;} 
-->
</style>
</c:if>
</head>
<script type="text/javascript">
function load(){	
	form1.action="${pageContext.request.contextPath }/customerInfo/customerInfoAction!queryBirthdayReminder";
	form1.submit();
}
</script>
<c:if test="${sessionUser.sysUserIsManger==1}">
<body onload="load()">
<%@include file="../customerinfo/birthdayreminder.jsp" %>
</c:if>
<c:if test="${sessionUser.sysUserIsManger!=1}">
<body>
<table width="768" height="500" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td bgcolor="#4AA3D8"></td>
  </tr>
  <tr>
    <td><table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="top"><img src="${pageContext.request.contextPath}/resource/images/welcome.gif" width="768" height="536"/></td>
      </tr>
    </table></td>
  </tr>
</table>
</c:if>
</body>
</html>