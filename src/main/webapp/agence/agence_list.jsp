<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/fn.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>

<link href="${pageContext.request.contextPath}/resource/css/date/date.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/date/jquery.datepicker.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/date/datepicker_lang_CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/js/date/loading.js"type="text/javascript"></script>
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
	  <table width="100%"  bgcolor="#EFF6FE">
	  <tr >
	  <form action="${pageContext.request.contextPath}/agence/agenceAction!queryAgenceList" name="form1" method="post">
	  <td width="58%"  class="STYLE4" >&nbsp;</td>
	  </form>
	  <td width="24%">&nbsp;</td>
	  <td width="18%"  class="STYLE4">  
	  		<input type="button"  value="新增主菜单" class="btn_mouseout" onclick="location.href='${pageContext.request.contextPath}/agence/agenceAction!showAdd';"/>	
	 </td>
	  </tr>  
		</table></td>
	
				
	  <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
	  </tr>
	  
	  <tr>
        <td width="8" background="${pageContext.request.contextPath}/resource/images/tab_15.gif">&nbsp;</td>
        <td>
        <form action="${pageContext.request.contextPath}/task/taskAction!deleteTask" name="form2" method="post">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
           <tr>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">网点机构名称</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">网点机构电话</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">网点机构电话2</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">网点机构电话3</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">网点机构联系人</span></td>
            <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">状态</span></td>
             <td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="auto"><span class="STYLE1">网点机构代码</span></td>
           	<td  height="22" align="center" background="${pageContext.request.contextPath}/resource/images/bg.gif" bgcolor="#FFFFFF" width="18%"><span class="STYLE1">操作</span></td>          
          </tr>
		    <!-- 迭代  第一层-->
		    <s:iterator value="agenceList" var="one">
		    <tr>   
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${one.agenceName}</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${one.agencePhone }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${one.agencePhone2 }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${one.agencePhone3 }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${one.agenceContact }</span></td>
            <td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">
				<c:if test="${one.agenceStatus eq 1 }">&nbsp;有效</c:if>
				<c:if test="${one.agenceStatus eq 2 }">&nbsp;无效</c:if>
			</span></td>
			<td height="20" bgcolor="#FFFFFF" align="center"><span class="STYLE1">${one.agenceCode }</span></td>
            
            <td height="20" bgcolor="#FFFFFF" align="center">
                 
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/agence/agenceAction!queryAgenceByID?method=show&agenceId=${one.agenceId}">查看</a></span>&nbsp;
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/agence/agenceAction!showAdd?agenceId=${one.agenceId }">新增子项</a></span>&nbsp;
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/agence/agenceAction!queryAgenceByID?method=showedit&agenceId=${one.agenceId }">修改</a></span>&nbsp;
            	<span class="STYLE1"><a href="${pageContext.request.contextPath}/agence/agenceAction!deleteAgence?agenceId=${one.agenceId }" onclick="return(confirm('确认要删除吗?'))">删除</a></span>
	
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