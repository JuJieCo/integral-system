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
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr height="30">
	  <td width="8"  background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  <td >
	  <form action="${pageContext.request.contextPath}/customerInfo/customerInfoAction!queryCustomerInfoList" name="form1" method="post">
	  <table width="100%"  bgcolor="#EFF6FE">
	  <tr >
	  <td class="STYLE4" > 
	  &nbsp;客户姓名 ：<input name="customerInfo.custName" type="text" size="8" value="${customerInfo.custName }"/>
	  &nbsp;&nbsp;状态 ：<select name="customerInfo.custStatus">
	 	<option value="0">--全部--</option>
		<option value="1" ${customerInfo.custStatus==1?"selected":"" }>正常</option>
		<option value="2" ${customerInfo.custStatus==2?"selected":"" }>冻结</option>
	  </select>
	  &nbsp;&nbsp;级别 ：<select name="customerInfo.custLevel">
	 	<option value="0">--全部--</option>
		<option value="1" ${customerInfo.custLevel==1?"selected":"" }>白金</option>
		<option value="2" ${customerInfo.custLevel==2?"selected":"" }>白银</option>
		<option value="3" ${customerInfo.custLevel==3?"selected":"" }>黑金</option>
		<option value="4" ${customerInfo.custLevel==4?"selected":"" }>黄金</option>
	  </select>
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  value="查询" class="btn_mouseout" onclick="document.forms.form1.submit();">
	  </td>
	  <td class="STYLE4" > </td>
	  <td class="STYLE4" > </td>
	  <td align="right">
	  <c:if test="${getSysUserIsManger==1 }">
	 	<input name="button11" type="button" value="新增客户" class="btn_mouseout" onclick="location.href='${pageContext.request.contextPath}/customerInfo/customerInfoAction!showAdd';">&nbsp;&nbsp;
	  </c:if>
	  </td>
	  </tr> 
		</table>
		</form></td>		
	  <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  </tr>
	  
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td>
        <form action="" name="form2" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户姓名</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户证件号码 </span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">级别</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">状态</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">登记时间</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="15%"><span class="STYLE1">操作</span></td>          
          </tr>
		  <!-- 迭代-->
	     <s:iterator value="customerInfoList" var="list" >	
		 <tr>   
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.custName }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.custCode }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">
				<c:if test="${list.custLevel eq 1 }">&nbsp;白金</c:if>
				<c:if test="${list.custLevel eq 2 }">&nbsp;白银</c:if>
				<c:if test="${list.custLevel eq 3 }">&nbsp;黑金</c:if>
				<c:if test="${list.custLevel eq 4 }">&nbsp;黄金</c:if>
			</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">
				<c:if test="${list.custStatus eq 1 }">&nbsp;正常</c:if>
				<c:if test="${list.custStatus eq 2 }">&nbsp;冻结</c:if>
			</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.custRegistTime }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center">
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/customerInfo/customerInfoAction!queryCustomerInfoByID?method=show&custId=${list.custId }">查看</a></span>&nbsp;
            	 <c:if test="${getSysUserIsManger==1 }">
            		<span class="STYLE1"><a href="${pageContext.request.contextPath}/customerInfo/customerInfoAction!queryCustomerInfoByID?method=showedit&custId=${list.custId }&right=0">修改</a></span>&nbsp;
            	</c:if>
            	<c:if test="${getSysUserIsManger==0 }">
            		<span class="STYLE1"><a href="${pageContext.request.contextPath}/customerInfo/customerInfoAction!queryCustomerInfoByID?method=showedit&custId=${list.custId }&right=1">修改</a></span>&nbsp;
                </c:if>
            </td>
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