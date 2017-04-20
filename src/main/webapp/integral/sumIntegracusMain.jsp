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

<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/blockUI.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/constant.js" type="text/javascript"></script>
<script type="text/javascript">
	function doSubmit(){
	  document.forms.sumIntegraform.action = "${pageContext.request.contextPath}/integral/integraCusMainAction!addIntegraCusMain";
	  document.forms.sumIntegraform.submit();
	  $.blockUI({    
		  message: $('#box'),    //要弹出的元素box  
		  css: {    //弹出元素的CSS属性  
			  top: '50%',  
			  left: '50%',  
	          textAlign: 'center',  
	          marginLeft: '-200px',  
	          marginTop: '-100px',  
			  width: '400px',  
			  background: 'none' 
		  }  
	 });  
	 }
</script>

</head>

<body>
<form action="" name="sumIntegraform" method="post">
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
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6">
          <tr>
            <td height="30" align="right" bgcolor="#FFFFFF" class="STYLE3" width="30%" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">计算&nbsp;&nbsp;&nbsp;&nbsp;
			     <script type="text/javascript">var year = new Date().getFullYear();document.write(year);</script>&nbsp;&nbsp;年&nbsp;
				 <script type="text/javascript">
						var year = new Date().getFullYear();
						var month = new Date().getMonth()+1;
						var i = 0 ;
						if(month==1||month==12){
							i = month;
						}else{
							i = month - 1;
						}
						 	 document.write("<input value="+year+""+(i>=10?i:'0'+i)+" type='hidden' name='ym'></input>"+i+"&nbsp;&nbsp;月");
					 
					  </script>
				  &nbsp;&nbsp;&nbsp;客户积分:&nbsp;&nbsp;
			</td>
			<td height="30" align="left"  bgcolor="#FFFFFF" class="STYLE3">
			 	&nbsp;&nbsp;<input type="button" name="" style="color: red;" value="开始计算" onclick="if(confirm('确定要计算客户积分？')){doSubmit()}"/>
			</td> 
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
                <tr><td>&nbsp;</td></tr>
              </table>
            </td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    
    </td>
  </tr>
</table>
 </form>
 <div style="display:none;height:100px" id="box">
	<div style="margin-top:20px">
		<span style="font-size:13px;font-weight:bold;color:#ffffff">正在计算客户积分中，请稍等...</span>
	</div>
	<div style="margin-top:10px"><img src="${pageContext.request.contextPath}/resource/images/jdt_xh.gif" /></div>
</div>
 
<script type="text/javascript">
	var result = '${result}';
	if(result=='1'){
		alert("上月客户积分已经计算成功。");
	}
	if(result=='0'){
		alert("上月客户积分计算失败,请重新计算！");
	}
</script> 
</body>
</html>