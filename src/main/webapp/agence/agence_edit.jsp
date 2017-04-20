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
	
	var agenceName = document.getElementById("agenceName").value;
	var agencePhone = document.getElementById("agencePhone").value; 
	var agenceAddress = document.getElementById("agenceAddress").value;
	var agenceContact = document.getElementById("agenceContact").value;
	var agenceStatus = document.getElementById("agenceStatus").value;
	var agenceCode = document.getElementById("agenceCode").value;
	
	if(agenceName==""){
		alert('请填写网点机构名称!');
		document.getElementById('agenceName').focus();
		return false;
	}
	if(agencePhone==""){
		alert('请填写网点机构电话!');
		document.getElementById('agencePhone').focus();
		return false;
	}
	if(agenceAddress==""){
		alert('请填写网点机构地址!');
		document.getElementById('agenceAddress').focus();
		return false;
	}
	if(agenceContact==""){
		alert('请填写网点机构联系人!');
		document.getElementById('agenceContact').focus();
		return false;
	}
	if(agenceStatus=="0"){
		alert('请选择状态!');
		document.getElementById('agenceStatus').focus();
		return false;
		
	}if(agenceCode==""){
		alert('请填写网点机构代码!');
		document.getElementById('agenceCode').focus();
		return false;
	}
	

}
</script>

<script type="text/javascript">
function chageAction (obj){	
	agenceform.action="${pageContext.request.contextPath}/agence/agenceAction!updateAgence";
	}
</script>


<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/agence/agenceAction!addAgence" name="agenceform" method="post" onsubmit="return validateForm(this)" >
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
			<input type="hidden" name="agence.agenceId" value="${agence.agenceId }">
			<input type="hidden" name="agence.agencePid" value="${pid}">
			</td>
		</tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">
            <font color="RED" class="STYLE3">*</font>网点机构名称：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
			<input name="agence.agenceName" type="text" value="${agence.agenceName }" id="agenceName" size="45"/></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">
            <font color="RED" class="STYLE3">*</font> 网点机构电话：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="agence.agencePhone" type="text" value="${agence.agencePhone }" id="agencePhone" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">网点机构电话2：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="agence.agencePhone2" type="text" value="${agence.agencePhone2 }" id="agencePhone2" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">网点机构电话3：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="agence.agencePhone3" type="text" value="${agence.agencePhone3 }" id="agencePhone3" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">
            <font color="RED" class="STYLE3">*</font> 网点机构地址：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="agence.agenceAddress" type="text" value="${agence.agenceAddress }" id="agenceAddress" size="45"/></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">
            <font color="RED" class="STYLE3">*</font>网点机构联系人：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="agence.agenceContact" type="text" value="${agence.agenceContact }" id="agenceContact" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">
            <font color="RED" class="STYLE3">*</font> 状态：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
            	<select name="agence.agenceStatus" id="agenceStatus">
            		<option value="0">--请选择--</option>
					<option value="1" ${agence.agenceStatus==1?"selected":"" }>有效</option>
					<option value="2" ${agence.agenceStatus==2?"selected":"" }>无效</option>
				</select>
			</td>
         </tr>
          <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">
            <font color="RED" class="STYLE3">*</font> 网点机构代码：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="agence.agenceCode" type="text" value="${agence.agenceCode }" id="agenceCode" /></td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">备注：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<textarea name="agence.agenceRemark" cols="30" rows="6">${agence.agenceRemark }</textarea></td>
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