<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户分析-综合查询-客户资产明细</title>

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
		form.action = form.action+"?page.currentPage="+currentPage;
		form.action = form.action+"&page.pageSize="+pz;
	}else{
	alert("请先确认输入的每页显示记录数的格式正确！");
	return;
	}
	form.submit();
	}
</script>

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
    <td>
   
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    
      <tr height="30">
	  <td width="8"  background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  <td>
	    
	  <form action="${pageContext.request.contextPath}/report/reportAction!queryDetailsByAll" name="form1" method="post">
	  <table width="100%"  bgcolor="#EFF6FE"> 
	  <tr>
	  <td  class="STYLE1">
	  查询条件
	  </td>
	  </tr>
	  	  <tr >
	   <td class="STYLE4" > 人民币存款：<input name="dataDetails.dataRmbDeposit" type="text" size="8" value="${dataDetails.dataRmbDeposit}"/>元 止 <input name="dataDetails.dataHold2" type="text" size="8" value="${dataDetails.dataHold2}"/>元
	  </td>
 <td class="STYLE4" >&nbsp;&nbsp;&nbsp;&nbsp;外币存款：<input name="dataDetails.dataUsDeposit" type="text" size="8" value="${dataDetails.dataUsDeposit}"/>元 止 <input name="dataDetails.dataHold3" type="text" size="8" value="${dataDetails.dataHold3}"/>元
	 </td>
	   <td class="STYLE4" >人民币理财：<input name="dataDetails.dataRmbInvestment" type="text" size="8" value="${dataDetails.dataRmbInvestment}"/>元 止 <input name="dataDetails.dataRemark" type="text" size="8" value="${dataDetails.dataRemark}"/>元
	
	  </tr>	  
 <tr >
 
    <td class="STYLE4" >&nbsp;&nbsp;&nbsp;&nbsp;外币理财：<input name="dataDetails.dataUsInvestment" type="text" size="8" value="${dataDetails.dataUsInvestment}"/>元 止 <input name="dataDetails.dataVipCode" type="text" size="8" value="${dataDetails.dataVipCode }"/>元  
 <td class="STYLE4">第三方存管：<input name="dataDetails.dataThreeStore" type="text" size="8" value="${dataDetails.dataThreeStore}"/>元 止 <input name="dataDetails.dataCardType" type="text" size="8" value="${dataDetails.dataCardType }"/>元</td>
	   <td class="STYLE4" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;个 贷：<input name="dataDetails.dataFirstPay" type="text" size="8" value="${dataDetails.dataFirstPay }"/>元 止 <input name="dataDetails.dataCustZipcode" type="text" size="8" value="${dataDetails.dataCustZipcode }"/>元</td>
	  </tr>
	  <tr >
	    <td class="STYLE4">&nbsp;&nbsp;&nbsp;&nbsp;总 资 产：<input name="dataDetails.dataMoneyTotal" type="text" size="8" value="${dataDetails.dataMoneyTotal}"/>元 止 <input name="dataDetails.dataHold1" type="text" size="8" value="${dataDetails.dataHold1}"/>元
	
	  <td class="STYLE4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级 别 ：<select name="dataDetails.dataCustLevel">
	 	<option value="">--全部--</option>
		<option value="白金" >白金</option>
		<option value="白银" >白银</option>
		<option value="黑金" >黑金</option>
	    <option value="黄金" >黄金</option>
	  </select>
	  </td>
	  <td class="STYLE4" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性 别：<select name="dataDetails.dataYm">
	 	<option value="0">--全部--</option>
		<option value="1" ${dataDetails.dataYm==1?"selected":"" }> 男 </option>
		<option value="2" ${dataDetails.dataYm==2?"selected":"" }> 女</option>		
	  </select>
	  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    <input type="button"  value="查询" class="btn_mouseout" onclick="document.forms.form1.submit();">
	  </td>
	     <td align="left">	      
	  </td>
	</tr>
		</table>
		</form>
		</td>		
	  <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  </tr>
	  
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td >
        <form action="" name="form2" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户姓名</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户证件号码 </span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">级别</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">总资产</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">人民币存款</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">人民币理财</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">外币理财</span></td> 
           	<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">国债</span></td>  
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">个贷</span></td>  
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">三方存管</span></td>  
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户级别</span></td>  
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">电话</span></td>  
          </tr>
		  <!-- 迭代-->
	     <s:iterator value="dataList" var="list" >	
		 <tr>   
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataCustName }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataCreditCard }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataCustLevel }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataMoneyTotal }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataRmbDeposit }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataUsDeposit }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataRmbInvestment }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataUsInvestment }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataNationaldebt }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataFirstPay }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataThreeStore }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.dataCustMobile }</span></td>
			
          </tr> 
       </s:iterator>
		 <!--迭代 end  -->
        </table>
        </form>
		</td>
        <td  width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${pageContext.request.contextPath}/resource/images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="${pageContext.request.contextPath}/resource/images/tab_18.gif" width="12" height="35" /></td>
        <td><%@include file="../common/page.jsp" %></td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>