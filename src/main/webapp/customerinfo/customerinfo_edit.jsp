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
	
	var custName = document.getElementById("custName").value;
	var custCode = document.getElementById("custCode").value; 
	var custBirthday = document.getElementById("custBirthday").value; 
	var custLevel = document.getElementById("custLevel").value;
	var agenceId = document.getElementById("agenceId").value;
	var custCpManager = document.getElementById("custCpManager").value;
	
	if(custName==""){
		alert('请填写客户姓名!');
		document.getElementById('custName').focus();
		return false;
	}
	if(custCode==""){
		alert('请填写客户证件号码!');
		document.getElementById('custCode').focus();
		return false;
	}
	if(custBirthday==""){
		alert('请填写客户的生日!');
		document.getElementById('custBirthday').focus();
		return false;
	}
	if(custLevel=="0"){
		alert('请选择客户级别!');
		document.getElementById('custLevel').focus();
		return false;	
	}
	if(agenceId==""){
		alert('请选择客户所属机构!');
		document.getElementById('agenceId').focus();
		return false;	
	}	
	if(custCpManager==""){
		alert('请选择所属客户经理!');
		document.getElementById('custCpManager').focus();
		return false;	
	}	

}
</script>

<script type="text/javascript">
function chageAction (obj){	
	customerinfoform.action="${pageContext.request.contextPath}/customerInfo/customerInfoAction!updateCustomerInfo";
	
	}
</script>


<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/customerInfo/customerInfoAction!addCustomerInfo" name="customerinfoform" method="post" onsubmit="return validateForm(this)" >
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
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><font color="RED" class="STYLE3">*</font> 客户姓名：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custName" type="text" value="${customerInfo.custName }" id="custName" size="45"  ${editsub==1?"disabled":""} />
			<input type="hidden" name="customerInfo.custId" value="${customerInfo.custId }">
			<input type="hidden" name="method2" value="${method2 }">
			<input type="hidden" name="right" value="${right }">
			</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><font color="RED" class="STYLE3">*</font> 客户证件号码 ：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custCode" type="text" value="${customerInfo.custCode }" id="custCode" size="45" ${editsub==1?"disabled":""} /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><font color="RED" class="STYLE3">*</font> 生日：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input onfocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" class="Wdate"  name="customerInfo.custBirthday" type="text" value="${customerInfo.custBirthday }" id="custBirthday"/></td> 
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">地址：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custAddress" type="text" value="${customerInfo.custAddress }" id="custAddress" size="45" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">区号：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custAreaCode" type="text" value="${customerInfo.custAreaCode }" id="custAreaCode" size="45"   /></td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">家庭电话：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custHomePhone" type="text" value="${customerInfo.custHomePhone }" id="custHomePhone" size="45"   /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">办公电话：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custOfferPhone" type="text" value="${customerInfo.custOfferPhone }" id="custOfferPhone" size="45"  /></td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">手机号码：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custMobile" type="text" value="${customerInfo.custMobile }" id="custMobile" size="45"  /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">电子邮件：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custEmail" type="text" value="${customerInfo.custEmail }" id="custEmail" size="45" /></td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">邮编：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%"><input name="customerInfo.custZipCode" type="text" value="${customerInfo.custZipCode }" id="custZipCode" size="45" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><font color="RED" class="STYLE3">*</font> 级别：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">
            	<select name="customerInfo.custLevel" id="custLevel" >
            		<option value="0">--请选择--</option>
					<option value="1" ${customerInfo.custLevel==1?"selected":"" }>白金</option>
					<option value="2" ${customerInfo.custLevel==2?"selected":"" }>白银</option>
					<option value="3" ${customerInfo.custLevel==3?"selected":"" }>黑金</option>
					<option value="4" ${customerInfo.custLevel==4?"selected":"" }>黄金</option>
				</select>
			</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">状态：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">
				<c:if test="${editsub==0}">
				<select name="customerInfo.custStatus" id="custStatus" ${editsub==1?"disabled":""}>
            		<option value="1">正常</option>
					<option value="2">冻结</option>
				</select>
				</c:if>
				<c:if test="${editsub==1}">
					<c:if test="${customerInfo.custStatus eq 1 }">&nbsp;正常</c:if>
					<c:if test="${customerInfo.custStatus eq 2 }">&nbsp;冻结</c:if>
				</c:if>
			</td>
         </tr>
         <tr>
         	<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">登记时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" >
			<c:if test="${editsub==0 }"> ${custRegistTime} 	<input type="hidden" name="customerInfo.custRegistTime" value="${custRegistTime }"> </c:if>
			<c:if test="${editsub==1}">${customerInfo.custRegistTime}</c:if>
		 	</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><font color="RED" class="STYLE3">*</font> 所属机构：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">
			<c:if test="${editsub == 0 }">${customerInfo.agenceName } <input type="hidden" name="customerInfo.agenceId" value="${customerInfo.agenceId }" id="agenceId"> </c:if> 
			<c:if test="${right == 0 }">${customerInfo.agenceName } <input type="hidden" name="customerInfo.agenceId" value="${customerInfo.agenceId }" id="agenceId"> </c:if> 
			<c:if test="${right == 1 }">
		 		<select name="customerInfo.agenceId" id="agenceId">
		 			<option value="" ${customerInfo.agenceId == ""?"selected":"" } >--请选择--</option>
					<c:forEach items="${allAgence }" var="list">
					<option value="${list.agenceId }" ${list.agenceId == customerInfo.agenceId ?"selected":"" } >${list.agenceName }</option>
					</c:forEach>
				</select>
			</c:if> 
			</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><font color="RED" class="STYLE3">*</font> 所属客户经理：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%" colspan="3">
			<c:if test="${editsub == 0 }">${customerInfo.sysUserName } <input type="hidden" name="customerInfo.custCpManager" value="${customerInfo.custCpManager }" id="custCpManager"></c:if> 
			 <c:if test="${right == 0 }">${customerInfo.sysUserName } <input type="hidden" name="customerInfo.custCpManager" value="${customerInfo.custCpManager }" id="custCpManager"></c:if> 
			 <c:if test="${right == 1 }">
			 <select name="customerInfo.custCpManager" id="custCpManager">
			 		<option value="" ${customerInfo.custCpManager == ""?"selected":"" } >--请选择--</option>
					<c:forEach items="${allUser }" var="list">
					<option value="${list.sysUserId }" ${list.sysUserId == customerInfo.custCpManager ?"selected":"" } >${list.sysUserName }</option>
					</c:forEach> 
				</select>
			 </c:if> 
			</td> 
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%" colspan="1">备注：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%" colspan="3"><textarea name="customerInfo.custRemark" cols="60" rows="6">${customerInfo.custRemark }</textarea></td>
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
					<input  type="submit"  value="提交" onclick="chageAction(); ">
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