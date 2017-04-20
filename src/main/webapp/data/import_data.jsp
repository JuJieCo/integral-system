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
	function doSubmit(type){
		if($("input[type=file]").val()==''&&type!='up'){
			alert("请先选择一个文件！");
			return;
		}
		if(type=='base'){
			document.forms.dataform.action = "${pageContext.request.contextPath}/data/dataAction!importBasice";
		}
		if(type=='zl'){
			document.forms.dataform.action = "${pageContext.request.contextPath}/data/dataAction!importIncremental";
		}
		if(type=='up'){
			document.forms.dataform.action = "${pageContext.request.contextPath}/data/dataAction!updateTempTable";
		}
		document.forms.dataform.submit();
		
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
<form action="" name="dataform" method="post" enctype="multipart/form-data">
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
            <td height="30" align="right" bgcolor="#FFFFFF" class="STYLE3" width="30%" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">第一步：</td>
			<td height="30" align="left"  bgcolor="#FFFFFF" class="STYLE3">
				&nbsp;&nbsp;选择月份 &nbsp;&nbsp;<script type="text/javascript">var year = new Date().getFullYear();document.write(year);</script>年
				&nbsp;&nbsp;<select name="ym">
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
							document.write("<option value="+year+""+(i>=10?i:'0'+i)+">"+i+"月</option>");
						}
					</script>
				</select>
				&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/data/dataAction!downTemplate" >下载模板</a>
			</td>
         </tr>
         <tr>
            <td height="30" align="right" bgcolor="#FFFFFF" class="STYLE3" width="30%" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">第二步：</td>
			<td height="30" align="left"  bgcolor="#FFFFFF" class="STYLE3">
				&nbsp;&nbsp;上传Excel文件
				&nbsp;&nbsp;<input type="file" name="excelFile" />
				&nbsp;&nbsp;<font style="color:red">注：文件中的记录数不要超过一万条</font>
			</td>
         </tr> 
         <tr>
            <td height="30" align="right" bgcolor="#FFFFFF" class="STYLE3" width="30%" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">第三步：</td>
			<td height="30" align="left"  bgcolor="#FFFFFF" class="STYLE3">
				&nbsp;&nbsp;<input type="button" name="" value="基本导入" onclick="doSubmit('base')"/>
				&nbsp;&nbsp;<input type="button" name="" value="增量导入" onclick="doSubmit('zl')"/>
			</td>
         </tr>     
         <tr>
            <td height="30" align="right" bgcolor="#FFFFFF" class="STYLE3" width="30%" background="${pageContext.request.contextPath}/resource/images/bg.gif" width="20%">第四步：</td>
			<td height="30" align="left"  bgcolor="#FFFFFF" class="STYLE3">
				&nbsp;&nbsp;<input type="button" name="" value="同步数据" onclick="doSubmit('up')"/>
			</td>
         </tr>    
         <tr>
         	<td colspan="2" bgcolor="#FFFFFF" style="font-size:12px;line-height:25px">
         		<hr />
         		<div style="margin-left:50px"><font style="font-weight:bold;color:red">基本导入和增量导入的区别：</font></div>
         		<div style="margin-left:100px">基本导入：基本导入操作首先删除服务器上原有的数据，然后保存导入的数据。</div>
         		<div style="margin-left:100px">增量导入：增量导入操作保留服务器上原有的数据，导入的数据和已有的数据（全部字段信息）相同，系统则不做处理；无则新增，不同则修改。</div>
         		<div style="margin-left:100px">同步数据：同步“个贷”，“三方存管”，“国债”的数据到导入的文件中。</div>
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
		<span style="font-size:13px;font-weight:bold;color:#ffffff">数据正在导入中，请稍等...</span>
	</div>
	<div style="margin-top:10px"><img src="${pageContext.request.contextPath}/resource/images/jdt_xh.gif" /></div>
</div>
 
<script type="text/javascript">
	var result = '${result}';
	if(result=='1'){
		alert("导入成功,导入数据量为：'${rowNumber}'条记录。");
	}
	if(result=='0'){
		alert("导入失败！");
	}
</script> 
 <script type="text/javascript">
	var resultUp = '${resultUp}';
	if(resultUp=='1'){
		alert("数据同步成功！");
	}
	if(resultUp=='0'){
		alert("数据同步失败！");
	}
</script> 
 
</body>
</html>