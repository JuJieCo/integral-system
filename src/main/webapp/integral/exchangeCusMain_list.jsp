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
function doSubmit(){
	  document.form1.action = "${pageContext.request.contextPath}/integral/integraCusMainAction!updateExchangCusMain";
	  document.form1.submit();
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
      <tr>
	  <td width="8"  background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  <td >
	  <form action="" name="form1" method="post">
	  <s:token name="s_token"></s:token>
	  </td>		
	  <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  </tr>  
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td>
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">姓名</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">身份证</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">客户层级</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">归属机构</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">年度</span></td>
             <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">兑换积分</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">积分结余</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="9%"><span class="STYLE1">最新积分日期</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="8%"><span class="STYLE1">状态</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="8%"><span class="STYLE1">操作</span></td>        
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
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">
            <input name="custName" type="hidden" value="${custName }" />
            <input name="custCode" type="hidden" value="${custCode }" />
            <input name="cust_main_id" type="hidden" value="${cusMainList.cust_main_id }" /><input name="cust_integral_remain" type="text" value="${cusMainList.cust_integral_remain }" /></span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${cusMainList.new_integral_date }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center">
              <span class="STYLE1">
				<c:if test="${cusMainList.integralCustomer.custStatus eq 1 }">&nbsp;正常</c:if>
				<c:if test="${cusMainList.integralCustomer.custStatus eq 2 }">&nbsp;冻结</c:if>
			  </span>
			</td>
            <td height="20" bgcolor="#FFFFFF" align="center">
            	<span class="STYLE1">
            	  <input type="button" name="" style="color: red;" value="修改" onclick="if(confirm('确定要修改客户积分？')){doSubmit();}"/>
            	</span>
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