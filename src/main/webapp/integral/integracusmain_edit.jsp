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
	
	var integralCustomer = document.getElementById("integralCustomerID").value;
	var cust_main_time = document.getElementById("cust_main_timeID").value; 
	var cust_integral_totle = document.getElementById("cust_integral_totleID").value;
	var cust_integral_calls = document.getElementById("cust_integral_callsID").value;
	var cust_integral_remain = document.getElementById("cust_integral_remainID").value;
	var cust_main_status = document.getElementById("cust_main_statusID").value;
	
	if(integralCustomer==""){
		alert('请填写客户编号!');
		document.getElementById('integralCustomerID').focus();
		return false;
	}
	if(cust_main_time==""){
		alert('请填写年度!');
		document.getElementById('cust_main_timeID').focus();
		return false;
	}
	if(cust_integral_totle==""){
		alert('请填写累计积分!');
		document.getElementById('cust_integral_totleID').focus();
		return false;
	}
	if(cust_integral_calls==""){
		alert('请填写兑换积分!');
		document.getElementById('cust_integral_callsID').focus();
		return false;
	}
	if(cust_integral_remain==""){
		alert('请填写积分结余!');
		document.getElementById('cust_integral_callsID').focus();
		return false;
	}
	if(cust_main_status=="0"){
		alert('请选择状态!');
		document.getElementById('cust_integral_remainID').focus();
		return false;
		
	}
	

}
</script>

<script type="text/javascript">
function chageAction (obj){	
	integracusmainform.action="${pageContext.request.contextPath}/integral/integraCusMainAction!updateIntegraCusMain";
	integracusmainform.submit();
	}
</script>


<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/integral/integraCusMainAction!addIntegraCusMain" name="integracusmainform" method="post" onsubmit="return validateForm(this)" >
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
			<input type="hidden" name="integraCusMain.cust_main_id" value="${integraCusMain.cust_main_id }">
			</td>
		</tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">客户编号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
			<input name="integraCusMain.integralCustomer" type="text" value="${integraCusMain.integralCustomer }" id="integralCustomerID" size="45"/></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">年度：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusMain.cust_main_time" type="text" value="${integraCusMain.cust_main_time }" id="cust_main_timeID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">累计积分：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusMain.cust_integral_totle" type="text" value="${integraCusMain.cust_integral_totle }" id="cust_integral_totleID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">兑换积分：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusMain.cust_integral_calls" type="text" value="${integraCusMain.cust_integral_calls }" id="cust_integral_callsID" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">积分结余：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="integraCusMain.cust_integral_remain" type="text" value="${integraCusMain.cust_integral_remain }" id="cust_integral_remainID" size="45"/></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">状态：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
            	<select name="integraCusMain.cust_main_status" id="cust_main_statusID">
            		<option value="0">--请选择--</option>
					<option value="1" ${integraCusMain.cust_main_status==1?"selected":"" }>状态1</option>
					<option value="2" ${integraCusMain.cust_main_status==2?"selected":"" }>状态2</option>
				</select>
			</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">备注：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<textarea name="integraCusMain.cust_main_remark" cols="30" rows="6">${integraCusMain.cust_main_remark }</textarea></td>
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