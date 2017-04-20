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

<script type="text/javascript">

function isNumber(oNum) { 
	if(!oNum) return false; 
	var strP=/^\d+(\.\d+)?$/; 
	if(!strP.test(oNum)) return false; 
	try{ 
		if(parseFloat(oNum)!=oNum) return false; 
	} catch(ex) { 
	return false; 
	} 
	return true; 
	}
function selectPage(currentPage){
	var form = document.forms.form1;
	var pz = $("#fsz").val();
	var opz = $("#odfsz").val();
	if(parseInt(pz)>parseInt(opz)){
		currentPage = 1;
	}
	if(jQuery.trim(pz)!=''&&isNumber(pz)&&pz.charAt(0)!='0'){
		form.action = form.action+"&page.currentPage="+currentPage;
		form.action = form.action+"&page.pageSize="+pz;
	}else{
	alert("请先确认输入的每页显示记录数的格式正确！");
	return;
	}
	form.submit();
	}
</script>
<script>
function validateForm(formname){
	var custcode = document.getElementById("custcode").value;
	if(custcode==""){
		alert('请填写客户证件号!');
		document.getElementById('custcode').focus();
		return false;
	}
}
</script>
<style type="text/css">
.star {
	color: #F00000;
	font-size: 12px;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
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
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr height="30">
	  <td width="8"  background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  <td >
	  <form action="${pageContext.request.contextPath }/exchangeGifts/exchangeGiftsAction!exchangeGiftsCustInfo" name="form1" method="post" onsubmit="return validateForm(this)">
	  <table width="100%"  bgcolor="#EFF6FE">
	  <tr >
	  <td class="STYLE4" > 
	  &nbsp;&nbsp;客户证件号 ：<input name="custcode" type="text" size="25" value="${custcode }" id="custcode"/>
	  &nbsp;&nbsp;&nbsp;&nbsp;<span class="star">*${message }</span>&nbsp;&nbsp;<input type="submit"  value="查询礼品" class="btn_mouseout">
	 <c:if test="${tag eq 'tag' }">
	  &nbsp;&nbsp;&nbsp;客户：<span class="star">${custName }</span>&nbsp;&nbsp;&nbsp;的可用积分为：<span class="star">${custIntegralRemain }分</span>
	  </c:if>
	  </td>
	  <td class="STYLE4" ></td>
	  <td class="STYLE4" ></td>
	  <td class="STYLE4"></td>
	  </tr> 
	</table>
	</form></td>		
	  <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  </tr>  
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">礼品类别</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">礼品名称</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="10%"><span class="STYLE1">所需积分</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="10%"><span class="STYLE1">剩余数量</span></td>           
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="10%"><span class="STYLE1">历史对换数量</span></td>
           	<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="10%" ><span class="STYLE1">操作</span></td>          
          </tr>
		  <!-- 迭代-->
	     <s:iterator value="giftsInfoList" var="list" status="index">	
		 <tr>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.giftsType }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.giftsName }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.giftsIntegral }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.giftsRemain }</span></td>
           	<td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.giftsCalls }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"> <span class="STYLE1">
            <a href="${pageContext.request.contextPath }/exchangeGifts/exchangeGiftsAction!exchangeGifts?giftsId=${list.giftsId }&custId=${custId }&giftsIntegral=${list.giftsIntegral }&custcode=${exchangeGifts.custCode }" onclick="return(confirm('确认要兑换吗?'))">兑换</a></span>
           </td>
          </tr> 
       </s:iterator>
		 <!--迭代 end  -->
        </table>
		</td>
        <td  width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${pageContext.request.contextPath}/resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/resource/images/tab_18.gif" width="12" height="35" /></td>
        <td>&nbsp;</td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>