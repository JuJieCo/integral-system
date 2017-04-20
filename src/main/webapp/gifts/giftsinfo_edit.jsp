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
<style type="text/css">
.star {
	color: #F00000;
	font-size: 14px;
}

</style>


<script>
function validateForm(formname){
	
	var giftsName = document.getElementById("giftsName").value;
	var giftsType = document.getElementById('giftsType').value;
	var giftsTotal = document.getElementById('giftsTotal').value;
	var giftsIntegral = document.getElementById('giftsIntegral').value;
	var giftsStartTime = document.getElementById('giftsStartTime').value;
	var giftsEndTime = document.getElementById('giftsEndTime').value;
	var wzjOrgId = document.getElementById('wzjOrgId').value;
	var reg =/^[0-9]*[1-9][0-9]*$/;  
	if(giftsName==""){
		alert('请填写礼品名称!');
		document.getElementById('giftsName').focus();
		return false;
	}
	if(giftsType==""){
		alert('请填写礼品类别!');
		document.getElementById('giftsType').focus();
		return false;
	}
	if(giftsTotal.match(reg)){
		if(giftsTotal==""){
			alert('请填写礼品总数量,必须是数字!');
			document.getElementById('giftsTotal').focus();
			return false;
		}
	}else{
		alert('请填写礼品总数量,必须是数字!');
		document.getElementById('giftsTotal').focus();
		return false;
	}
	if(giftsIntegral.match(reg)){
		if(giftsIntegral==""){
			alert('请填写礼品所需积分,必须是数字!');
			document.getElementById('giftsIntegral').focus();
			return false;
		}
	}else{
		alert('请填写礼品所需积分,必须是数字!');
		document.getElementById('giftsIntegral').focus();
		return false;
	}
	if(giftsStartTime==""){
		alert('请选择开始时间!');
		document.getElementById('giftsStartTime').focus();
		return false;
	}
	if(giftsEndTime==""){
		alert('请选择结束时间!');
		document.getElementById('giftsEndTime').focus();
		return false;
	}
	if(wzjOrgId=="0"){
		alert('请选择外包机构!');
		document.getElementById('wzjOrgId').focus();
		return false;
	}

}
</script>
<script type="text/javascript">
function changeNum(){	
	var giftsTotal = document.getElementById('giftsTotal').value;
	var giftsRemain = document.getElementById('giftsRemain').value;
	
	if(giftsRemain!=giftsTotal){
		document.getElementById('giftsRemain').value=giftsTotal;
	}
	setTimeout("changeNum()",100);
	
	}
</script>
<script type="text/javascript">
function chageAction (obj){	
	giftsform.action="${pageContext.request.contextPath}/gifts/giftsInfoAction!updateGiftsInfo";
	}
</script>


<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
</head>

<body>
<form action="${pageContext.request.contextPath}/gifts/giftsInfoAction!addGiftsInfo" name="giftsform" method="post" onsubmit="return validateForm(this)" >
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
           <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>礼品名称：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="giftsInfo.giftsName" type="text" value="${giftsInfo.giftsName }" id="giftsName" /></td>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>礼品类别：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="giftsInfo.giftsType" type="text" value="${giftsInfo.giftsType }" id="giftsType"/>
			<input type="hidden" name="giftsInfo.giftsId" value="${giftsInfo.giftsId }">
			</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>礼品总数量：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="giftsInfo.giftsTotal" type="text"  value="${giftsInfo.giftsTotal }" id="giftsTotal" size="2" onkeypress="return changeNum();" />
			&nbsp;&nbsp;剩余：<input type="text" value="${giftsInfo.giftsRemain }" name="giftsInfo.giftsRemain" readonly="readonly" id="giftsRemain" size="2">
			</td>
			<td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>所需积分：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input name="giftsInfo.giftsIntegral" type="text" value="${giftsInfo.giftsIntegral }" id="giftsIntegral" /></td>          
         </tr> 
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>开始时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input onfocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" class="Wdate"  name="giftsInfo.giftsStartTime" type="text" value="${giftsInfo.giftsStartTime }" id="giftsStartTime" /></td>  
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>结束时间：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;&nbsp;<input onfocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" class="Wdate"  name="giftsInfo.giftsEndTime" type="text" value="${giftsInfo.giftsEndTime }" id="giftsEndTime" /></td>
         </tr>         
         <tr>
          <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>外包机构：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
			 <select name="giftsInfo.wzjOrgId" id="wzjOrgId">
            		<option value="0">--请选择--</option>
            		<c:if test="${editsub==1 }">
            		<option value="${giftsInfo.wzjOrgId }" selected="selected">${giftsInfo.wzjOrgName }</option>
            		</c:if>
					<c:forEach items="${wzjslist }" var="list">
					<option value="${list.wzjOrgId }">${list.wzjOrgName }</option>
					</c:forEach>
				</select>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%"><span class="star" >*</span>状态：</td>
            <td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%">&nbsp;
            	<select name="giftsInfo.giftsStatus" id="giftsStatus">
					<option value="0" ${giftsInfo.giftsStatus==1?"selected":"" }>正常</option>
					<option value="1" ${giftsInfo.giftsStatus==2?"selected":"" }>停止</option>
				</select>
			</td>
         </tr>
         <tr>
            <td height="22" align="right" bgcolor="#FFFFFF" class="STYLE3" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">备注：</td>
			<td height="22" align="left" bgcolor="#FFFFFF" class="STYLE3" width="30%" colspan="3">&nbsp;&nbsp;<textarea name="giftsInfo.giftsRemark" cols="30" rows="6">${giftsInfo.giftsRemark }</textarea></td>
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