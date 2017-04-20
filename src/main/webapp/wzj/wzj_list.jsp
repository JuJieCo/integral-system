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
	  <form action="${pageContext.request.contextPath}/wzj/wzjAction!queryWzjList" name="form1" method="post">
	  <table width="100%"  bgcolor="#EFF6FE">
	  <tr >
	  <td class="STYLE4" > 
	  &nbsp;机构名称 ：<input name="wzj.wzjOrgName" type="text" size="25" value="${wzj.wzjOrgName }"/>
	  &nbsp;&nbsp;机构联系人 ：<input name="wzj.wzjOrgContact" type="text" size="10" value="${wzj.wzjOrgContact }"/>
	  &nbsp;&nbsp;状态 ：<select name="wzj.wzjOrgStatus">
	 	<option value="0">--全部--</option>
		<option value="1" ${wzj.wzjOrgStatus==1?"selected":"" }>有效</option>
		<option value="2" ${wzj.wzjOrgStatus==2?"selected":"" }>无效</option>
	  </select>
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button"  value="查询" class="btn_mouseout" onclick="document.forms.form1.submit();">
	  </td>
	  <td class="STYLE4" > </td>
	  <td class="STYLE4" > </td>
	  <td align="right">
	 <input name="button11" type="button" value="新增机构" class="btn_mouseout" onclick="location.href='${pageContext.request.contextPath}/wzj/wzjAction!showAdd';">&nbsp;&nbsp;
	 
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
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">机构名称</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">机构电话</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">机构电话2</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">机构电话3</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">机构联系人</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">状态</span></td>
           	<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="15%"><span class="STYLE1">操作</span></td>          
          </tr>
		  <!-- 迭代-->
	     <s:iterator value="wzjList" var="list" >	
		 <tr>   
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.wzjOrgName }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.wzjOrgPhone }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.wzjOrgPhone2 }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.wzjOrgPhone3 }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${list.wzjOrgContact }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">
				<c:if test="${list.wzjOrgStatus eq 1 }">&nbsp;有效</c:if>
				<c:if test="${list.wzjOrgStatus eq 2 }">&nbsp;无效</c:if>
			</span></td>
            
            <td height="20" bgcolor="#FFFFFF" align="center">
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/wzj/wzjAction!queryWzjByID?method=show&wzjOrgId=${list.wzjOrgId }">查看</a></span>&nbsp;
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/wzj/wzjAction!queryWzjByID?method=showedit&wzjOrgId=${list.wzjOrgId }">修改</a></span>&nbsp;
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/wzj/wzjAction!deleteWzj?wzjOrgId=${list.wzjOrgId }" onclick="return(confirm('确认要删除吗?'))">删除</a></span>
          		
            	
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
        <td>&nbsp;</td>
        <td width="16"><img src="${pageContext.request.contextPath}/resource/images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</body>
</html>