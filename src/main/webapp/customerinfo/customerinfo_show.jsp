<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>

</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="${pageContext.request.contextPath}/resource/images/tab_05.gif">
    	<%@include file="../common/table_top.jsp" %>
    </td>
  </tr>
  <tr>
    <td>
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户姓名：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custName }</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户证件号码 ：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custCode }</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">生日：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custBirthday }</td> 
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">地址：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custAddress }</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">区号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custAreaCode }</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">家庭电话：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custHomePhone }</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">办公电话：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custOfferPhone }</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">手机号码：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custMobile }</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">电子邮件：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custEmail }</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">邮编：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.custZipCode }</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">级别：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">
            	<c:if test="${customerInfo.custLevel eq 1 }">&nbsp;白金</c:if>
				<c:if test="${customerInfo.custLevel eq 2 }">&nbsp;白银</c:if>
				<c:if test="${customerInfo.custLevel eq 3 }">&nbsp;黑金</c:if>
				<c:if test="${customerInfo.custLevel eq 4 }">&nbsp;黄金</c:if>
			</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">状态：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">
			  	<c:if test="${customerInfo.custStatus eq 1 }">&nbsp;正常</c:if>
				<c:if test="${customerInfo.custStatus eq 2 }">&nbsp;冻结</c:if>
			</td>
         </tr>
         <tr>
         	<fmt:formatDate value="${customerInfo.custRegistTime}"  var="crt" pattern="yyyy-MM-dd" type="date"/>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">登记时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" >${crt}</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">所属机构：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">${customerInfo.agenceName }</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">所属客户经理：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%" colspan="3">${customerInfo.sysUserName}</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%" colspan="1">备注：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%" colspan="3"><textarea name="customerInfo.custRemark" cols="28" rows="6" readonly="readonly">${customerInfo.custRemark }</textarea></td>
         </tr>
		  </table>
		</td>
        <td  width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/resource/images/tab_18.gif" width="12" height="35" /></td>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4"></td>
            <td height="35" background="${pageContext.request.contextPath}/resource/images/tab_19.gif">
              <table border="0" align="center" cellpadding="0" cellspacing="0" id="form_oper">
                <tr><td >
				<input type="button" value="返回" onclick="history.go(-1)"/>	
				</td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>