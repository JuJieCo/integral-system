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
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户积分主表编号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;${integraCusDetails.integraCusMain}</td>
		  </tr>
		  <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户积分产生时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;${integraCusDetails.cust_details_integral_date }</td>
		  </tr>
		  <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">积分规则编号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;${integraCusDetails.rules_id  }</td>
		  </tr>
		  <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">本次资金数量：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;${integraCusDetails.cust_money }</td>
		  </tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"> 本次产生积分：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;${integraCusDetails.cust_details_integral}</td>
		  </tr>
		  <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"> 状态：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">
				<c:if test="${integraCusDetails.cust_details_status eq 1 }">&nbsp;状态1</c:if>
				<c:if test="${integraCusDetails.cust_details_status eq 2 }">&nbsp;状态2</c:if>
			</td>
		  </tr>
		  <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">明细产生时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;${integraCusDetails.cust_details_createtime }</td>
		  </tr>
		  <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif">备注：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" colspan="3">&nbsp;<textarea name="notice.content" cols="30" rows="6" readonly="readonly">${integraCusDetails.cust_details_remark  }</textarea> </td>
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