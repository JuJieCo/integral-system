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
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
<script type="text/javascript">
jQuery(function($) {
	   	$("span[name=ltp]").toggle(
	  		function(){
	  			
	  			var tr = $(this).parent().parent();
	  			
	  			if(tr.next().attr("[trn]")=='prog'){
					tr.next().remove();
				}
				var str = "<tr [trn]=prog><td colspan=10><table cellspacing=0 cellpadding=0 width=100%>";
				str +="<tr><td class=porg_td>&nbsp;&nbsp;</td><td class=porg_td>积分条目</td><td class=porg_td>客户积分产生时间</td><td class=porg_td>本次产生积分</td></tr>";
				
				$.getJSON("${pageContext.request.contextPath}/integral/integraCusMainAction!queryByCusMainId",{cusMainId:$(this).attr("data")},function(data){
					
					$(data).each(function(i,v){
						 	str += "<tr><td class=porg_td2>&nbsp;&nbsp;</td><td class=porg_td2>"+v.cust_details_hold1+"</td><td class=porg_td2>"+v.cust_details_integral_date+"</td>"
						+"<td class=porg_td2>"+v.cust_details_integral+"</td></tr>";
					});
					str += "</table></td></tr>";
					tr.after($(str));
				});
	  		},
	  		function(){
	  			var tr = $(this).parent().parent();
	  			tr.next().hide();
	  		}
	  	);
	  	
	}); 
</script>
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
	   <form action="${pageContext.request.contextPath}/integral/integraCusMainAction!queryAllIntegraCusMain" name="form1" method="post">
	   <table width="100%"  bgcolor="#EFF6FE">
	  <tr >
	  <td class="STYLE4" > 
	  &nbsp;客户姓名 ：<input name="integraCusMain.integralCustomer.custName" type="text" size="8" value="${integraCusMain.integralCustomer.custName }"/>
	  &nbsp;证件号码 ：<input name="integraCusMain.integralCustomer.custCode" type="text" size="20" value="${integraCusMain.integralCustomer.custCode }"/>
	  &nbsp;手机号码 ：<input name="integraCusMain.integralCustomer.custMobile" type="text" size="11" value="${integraCusMain.integralCustomer.custMobile}"/>
	  &nbsp;客户状态 ：<select name="integraCusMain.integralCustomer.custStatus">
	 	<option value="">--全部--</option>
		<option value="1" ${integraCusMain.integralCustomer.custStatus==1?'selected':'' }>正常</option>
		<option value="2" ${integraCusMain.integralCustomer.custStatus==2?'selected':"" }>冻结</option>
	  </select>
	  <br> &nbsp;网点机构：
	 	<select name="integraCusMain.integralCustomer.agenceId">
	  		<option value="">--全部--</option>
	  		<s:iterator value="agenceListagenceList" var="one">
	  			<option value="${one.agenceId}" ${one.agenceId==integraCusMain.integralCustomer.agenceId?'selected':''}>${one.agenceName}</option>
	  		</s:iterator>
   		</select>
	   &nbsp;&nbsp;<input type="button"  value="查询" class="btn_mouseout" onclick="document.forms.form1.submit();">
	  </td>
	    <td class="STYLE4" > </td>
	  <td class="STYLE4" > </td>
	  <td align="right">
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
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">姓名</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">身份证</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户层级</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">归属机构</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">年度</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">兑换积分</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">积分结余</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">最新积分日期</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">状态</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">操作</span></td>
          </tr>
		  <!-- 迭代-->
	     <s:iterator value="integraCusMainList" var="cusMainList" >	
		 <tr>   
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.integralCustomer.custName }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.integralCustomer.custCode }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center">
            <span class="STYLE1">
             <c:if test="${cusMainList.integralCustomer.custLevel eq 1 }">&nbsp;白金</c:if>
			 <c:if test="${cusMainList.integralCustomer.custLevel eq 2 }">&nbsp;白银</c:if>
			 <c:if test="${cusMainList.integralCustomer.custLevel eq 3 }">&nbsp;黑金</c:if>
			 <c:if test="${cusMainList.integralCustomer.custLevel eq 4 }">&nbsp;黄金</c:if>
            </span>
            </td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.integralCustomer.agenceName }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.cust_main_time }</span></td>
             <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.cust_integral_calls }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.cust_integral_remain }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.new_integral_date }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center">
              <span class="STYLE1">
				<c:if test="${cusMainList.integralCustomer.custStatus eq 1 }">&nbsp;正常</c:if>
				<c:if test="${cusMainList.integralCustomer.custStatus eq 2 }">&nbsp;冻结</c:if>
			  </span>
			</td>
			 <td height="20" bgcolor="#FFFFFF" align="center">
               <span name=ltp data=${cusMainList.cust_main_id} class="STYLE1" style="cursor:pointer" >查看积分明细</span>
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