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
<script>
 function validateForm(formname){
	
	var integraCusMain = document.getElementById("integraCusMainID").value;
	var cust_details_integral_date = document.getElementById("cust_details_integral_dateID").value; 
	var rules_id = document.getElementById("rules_idID").value;
	var cust_money = document.getElementById("cust_moneyID").value;
	var cust_details_integral = document.getElementById("cust_details_integralID").value;
	var cust_details_status = document.getElementById("cust_details_statusID").value;
	var cust_details_createtime = document.getElementById("cust_details_createtimeID").value;
	
	if(integraCusMain==""){
		alert('请填写客户积分主表编号!');
		document.getElementById('integraCusMainID').focus();
		return false;
	}
	if(cust_details_integral_date==""){
		alert('请填写客户积分产生时间!');
		document.getElementById('cust_details_integral_dateID').focus();
		return false;
	}
	if(rules_id==""){
		alert('请填写积分规则编号!');
		document.getElementById('rules_idID').focus();
		return false;
	}
	if(cust_money==""){
		alert('请填写本次资金数量!');
		document.getElementById('cust_moneyID').focus();
		return false;
	}
	if(cust_details_integral==""){
		alert('请填写本次产生积分!');
		document.getElementById('cust_details_integralID').focus();
		return false;
		
	}
	if(cust_details_status=="0"){
		alert('请选择状态!');
		document.getElementById('cust_details_statusID').focus();
		return false;
		
	}
	if(cust_details_createtime==""){
		alert('请填写本次产生积分!');
		document.getElementById('cust_details_createtimeID').focus();
		return false;
		
	}
	

}
</script>

<script type="text/javascript">
function chageAction (obj){	
	intecusdetform.action="${pageContext.request.contextPath}/integral/integraCusDetailsAction!updateIntegraCusDetails";
	intecusdetform.submit();
	}
</script>


<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/integral/integraCusDetailsAction!addIntegraCusDetails" name="intecusdetform" method="post"  >
<s:token name="s_token"></s:token>
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
            <td>
			<input type="hidden" name="integraCusDetails.cust_details_id " value="${integraCusDetails.cust_details_id }">
			</td>
		</tr>
          
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户积分主表编号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusDetails.integraCusMain" type="text" value="${integraCusDetails.integraCusMain }" id="integraCusMainID " /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户积分产生时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusDetails.cust_details_integral_date " type="text" value="${integraCusDetails.cust_details_integral_date }" id="cust_details_integral_dateID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">积分规则编号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusDetails.rules_id " type="text" value="${integraCusDetails.rules_id }" id="rules_idID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">本次资金数量：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusDetails.cust_money" type="text" value="${integraCusDetails.cust_money }" id="cust_moneyID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">本次产生积分：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusDetails.cust_details_integral" type="text" value="${integraCusDetails.cust_details_integral }" id="cust_details_integralID" size="45"/></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">状态：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
            	<select name="integraCusDetails.cust_details_status" id="cust_details_statusID">
            		<option value="0">--请选择--</option>
					<option value="1" ${integraCusDetails.cust_details_status ==1?"selected":"" }>状态1</option>
					<option value="2" ${integraCusDetails.cust_details_status ==2?"selected":"" }>状态2</option>
				</select>
			</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">明细产生时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusDetails.cust_details_createtime" type="text" value="${integraCusDetails.cust_details_createtime }" id="cust_details_createtimeID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">备注：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<textarea name="integraCusDetails.cust_details_remark" cols="30" rows="6">${integraCusDetails.cust_details_remark }</textarea></td>
         </tr>
            	
        </table>
		</td>
        <td  width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table> 
    </td>
 </tr>
  <tr>
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/resource/images/tab_18.gif" width="12" height="35" /></td>
        <td>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4"></td>
            <td height="35" background="${pageContext.request.contextPath}/resource/images/tab_19.gif">
              <table border="0" align="center" cellpadding="0" cellspacing="0" id="form_oper">
                <tr> <td >
                <c:if test="${editsub==0 }">
					<input  type="submit"  value="提交"/>
					<input  type="reset"   value="清空"/>
				</c:if>
				<c:if test="${editsub==1 }">
					<input  type="button"  value="提交" onclick="chageAction(); ">
				</c:if>
					
					<input  type="button" value="返回" onclick="history.go(-1)"/>	
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
 </form>
</body>
</html>