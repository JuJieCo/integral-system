<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户等级查询明细</title>

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

	function getWidth(str){
		var fontNum = 0;
		if(str.length==0){
			fontNum = 2;
		}
		for(n=0;n<str.length;n++){
			if(str.charCodeAt(n)>=128){
				fontNum = fontNum + 2;
			}else{
				fontNum = fontNum + 1;
			}
		}
		return 7*fontNum+5;
	 } 
	
	 function doEdit(obj){
		for(i=4;i<8;i++){
			$(obj).find("div").eq(i).find("span").find("span").each(function(i,v){
				if(i%2!=0){
					var str = $(v).text();

					$(obj).data($(v).attr("name"),str);

					var input = document.createElement("input");
					$(input).attr("type","text");
					$(input).val($(v).html());
					$(input).css({width:getWidth(str),height:"18px"});
					$(input).bind("keyup",function(){
						var wh = getWidth($(this).val())+"px";
						$(this).css({width:wh,height:"18px"});
					});
					$(v).html($(input));
				}
			});
		}
		$(obj).find("div").eq(8).show();
		$(obj).unbind("dblclick");
		$(obj).removeAttr("ondblclick");
		
	 };

	 function doReset(rob){
		var obj = $(rob).parent().parent().parent();
		for(i=4;i<8;i++){
			$(obj).find("div").eq(i).find("span").find("span").each(function(i,v){
				if(i%2!=0){
					$(v).html($(obj).data($(v).attr("name")));
				}
			});
		}
		$(obj).find("div").eq(8).hide();
		$(obj).bind("dblclick",function(){
			doEdit(obj);
		});
	 }

	 function doSubmit(sob){
		var obj = $(sob).parent().parent().parent();
		var param = "";
		for(i=4;i<8;i++){
			$(obj).find("div").eq(i).find("span").find("span").each(function(i,v){
				if(i%2!=0){
					param += $(v).attr("name")+"="+$(v).find("input").val()+"&";
				}
			});
		}
		param += "dataDetails.dataId="+$("input[type=hidden]",obj).val();
		$.ajax({
		   type: "POST",
		   url: "${pageContext.request.contextPath}/data/dataAction!editAjaxData",
		   data: param,
		   success: function(rs){
		     if(rs=='success'){
		    	 alert("修改成功!");
		    	 for(i=4;i<8;i++){
		 			$(obj).find("div").eq(i).find("span").find("span").each(function(i,v){
		 				if(i%2!=0){
							$(obj).data($(v).attr("name"),$(v).find("input").val());	
						}
		 			});
		 		}
		    	 doReset(sob);
		      }
		   }
		}); 
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
        <td style="padding:10px">
        <s:iterator value="dataList" var="one" status="i">
        <s:if test="#i.Even">
        <div style="background-color:#EFF6FE;width:100%;font-size:12px;line-height:20px;border:2px solid #D6ECFA;padding:5px" ondblclick="doEdit(this)">
        </s:if>
        <s:else>
        <div style="background-color:white;width:100%;font-size:12px;line-height:20px;border:2px solid #D6ECFA;padding:5px" ondblclick="doEdit(this)">
        </s:else>
        	<input type="hidden" name="dataDetails.dataId" value="${one.dataId}" />
			<div>
				<span style="width:16px"><img src="./../resource/images/lt.gif" class="ldt"/></span>
				<span style="width:16%"><span>客户姓名:</span><span>${one.dataCustName}</span></span>
				<span style="width:30%"><span>归属机构:</span><span>${one.dataCustOrg}</span></span>
				<span style="width:27%"><span>证件种类:</span><span>${one.dataCustCodetype}</span></span>
				<span><span>证件号码:</span><span>${one.dataCustCode}</span></span>
			</div>
			<div style="display:none">
				<span style="width:23px"></span>
				<span style="width:16%"><span>区&nbsp;&nbsp;&nbsp;&nbsp;号:</span><span>${one.dataCustAreacode}</span></span>
				<span style="width:30%"><span>家庭电话:</span><span>${one.dataCustHomephone}</span></span>
				<span style="width:27%"><span>办公电话:</span><span>${one.dataCustOfficephone}</span></span>
				<span><span>手机号码:</span><span>${one.dataCustMobile}</span></span>
			</div>
			<div style="display:none">
				<span style="width:23px"></span>
				<span style="width:16%"><span>邮&nbsp;&nbsp;&nbsp;&nbsp;编:</span><span>${one.dataCustZipcode}</span></span>
				<span><span>地    址:</span><span>${one.dataCustAddress}</span></span>
			</div>
			<div><hr/></div>
			<div>
				<span style="width:16%"><span>客户层级:</span><span name="dataDetails.dataCustLevel">${one.dataCustLevel}</span></span>
				<span style="width:21%"><span>VIP理财卡号:</span><span name="dataDetails.dataVipCode">${one.dataVipCode}</span></span>
				<span style="width:18%"><span>当前理财卡类别:</span><span name="dataDetails.dataCardType">${one.dataCardType}</span></span>
				<span style="width:17%"><span>理财经理名称:</span><span name="dataDetails.dataLcManager">${one.dataLcManager}</span></span>
				<span style="width:16%"><span>是否办理信用卡:</span><span name="dataDetails.dataCreditCard">${one.dataCreditCard}</span></span>
				<span><span>特殊客户:</span><span name="dataDetails.dataTxCust">${one.dataTxCust}</span></span>
			</div>
			<div>
				<span style="width:25%"><span>总资产(折人民币):</span><span name="dataDetails.dataMoneyTotal">${one.dataMoneyTotal}</span></span>
				<span style="width:30%"><span>住房按揭贷款首付款:</span><span name="dataDetails.dataFirstPay">${one.dataFirstPay}</span></span>
				<span style="width:26%"><span>券商集合理财:</span><span name="dataDetails.dataQsLc">${one.dataQsLc}</span></span>
				<span><span>信托计划:</span><span name="dataDetails.dataXtJh">${one.dataXtJh}</span></span>
			</div>
			<div>
				<span style="width:25%"><span>人民币存款:</span><span name="dataDetails.dataRmbDeposit">${one.dataRmbDeposit}</span></span>
				<span style="width:30%"><span>人民币理财:</span><span name="dataDetails.dataRmbInvestment">${one.dataRmbInvestment}</span></span>
				<span style="width:26%"><span>外币存款(折美元):</span><span name="dataDetails.dataUsDeposit">${one.dataUsDeposit}</span></span>
				<span><span>外币理财(折美元):</span><span name="dataDetails.dataUsInvestment">${one.dataUsInvestment}</span></span>
			</div>
			<div>
				<span style="width:25%"><span>基金:</span><span name="dataDetails.dataFund">${one.dataFund}</span></span>
				<span style="width:30%"><span>国债:</span><span name="dataDetails.dataNationaldebt">${one.dataNationaldebt}</span></span>
				<span style="width:26%"><span>实物黄金:</span><span name="dataDetails.dataPhysicalGold">${one.dataPhysicalGold}</span></span>
				<span><span>第三方存管:</span><span name="dataDetails.dataThreeStore">${one.dataThreeStore}</span></span>
			</div>
			<div style="display:none;margin-top:10px">
				<span style="width:70%"></span>
				<span><img src="${pageContext.request.contextPath}/resource/images/data_reset_button.gif" onclick="doReset(this)" style="cursor:pointer"/></span>
				<span><img src="${pageContext.request.contextPath}/resource/images/data_save_button.gif" onclick="doSubmit(this)" style="cursor:pointer"/></span>
			</div>
	
        </s:iterator>
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