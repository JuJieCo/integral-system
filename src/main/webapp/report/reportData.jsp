<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户登记查询</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>



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
	
	jQuery(function($){
		$(".ldt").toggle(
				function(){
					$(this).attr("src","./../resource/images/dt.gif");
					$(this).parent().parent().next().show();
					$(this).parent().parent().next().next().show();
				},
				function(){
					$(this).attr("src","./../resource/images/lt.gif");
					$(this).parent().parent().next().hide();
					$(this).parent().parent().next().next().hide();
				}
		 );
		
		$("input","#ta_page").css({height:"18px"});
		
	 });

	
	


	
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
	  <form action="${pageContext.request.contextPath}/report/reportAction!queryDataDetailsByCond" name="form1" method="post" style="margin:0px;padding:0px">
	  <table width="100%"  bgcolor="#EFF6FE">
	  <tr>
	  <td class="STYLE4" >
	  	&nbsp;&nbsp;选择月份 &nbsp;&nbsp;<script type="text/javascript">var year = new Date().getFullYear();document.write(year);</script>年
		&nbsp;&nbsp;<select name="dataDetails.dataYm">
			<script type="text/javascript">
				var year = new Date().getFullYear();
				var month = new Date().getMonth()+1;
				var i = 0 ;
				if(month==1||month==12){
					i = month;
				}else{
					i = month - 1;
				}
				for(;i<=12;i++){
					var value = year+""+(i>=10?i:'0'+i);
					var ck = "";
					if(value=='${dataDetails.dataYm}'){
						ck = "selected";
					}
					document.write("<option value="+value+" "+ck+">"+i+"月</option>");
				}
			</script>
		</select>
	  	&nbsp;<input type="button"  value="查询" class="btn_mouseout" onclick="document.forms.form1.submit();">&nbsp;
	  </td>	
	  </tr>  
	  </table>
	  </form>
	  </td>
	  <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  </tr>
	  <tr>
	   <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" >
         <div style="background-color:${pageContext.request.contextPath}/resource/images/bg.gif;width:100%;font-size:12px;line-height:20px;border:1px solid #D6ECFA;padding:1px" >
			
				<span style="width:16px"></span>
				<span style="width:16%"><span class="STYLE1">序号</span><span></span></span>
				<span style="width:20%"><span>客户级别</span><span></span></span>
				<span style="width:20%"><span>人数</span><span></span></span>
				<span style="width:20%"><span>操作</span><span></span></span>
			</div>
				</td>
				   </tr>
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td>
     <c:forEach items="${dataList}" var="one" varStatus="idx">
         <div  style="background-color:#EFF6FE;width:100%;font-size:12px;line-height:20px;border:1px solid #D6ECFA;padding:1px">
				<span style="width:16px">&nbsp;</span>
				<span style="width:16%"><span>${idx.count}</span></span>
				<span style="width:20%"><span>${one.dataCustLevel}</span></span>
				<span style="width:20%"><span>${one.dataHold1}</span></span>
			<span style="width:20%"><span><a href="${pageContext.request.contextPath}/report/reportAction!queryByAccLevel?acclevel=${one.dataCustLevel}">详细</a></span><span></span></span>
			</div>
        </c:forEach>
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