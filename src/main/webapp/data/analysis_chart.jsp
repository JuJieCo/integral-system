<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="${pageContext.request.contextPath}/resource/js/jquery-1.4.2.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/data/swfobject.js"></script>

<script type="text/javascript">
	var barcolor = new Array();
</script>
  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分析结果 图表</title>
</head>
<body leftmargin="8" topmargin="8">

<%
	List custemList= (List)request.getAttribute("custemList");
	List moneyChangList= (List)request.getAttribute("moneyChangList");
	
	
	
	//判断2个list 
	if(custemList!=null&&moneyChangList!=null){
		
	
		
	System.out.println("custemList:"+custemList.size()+"  moneyChangList:"+moneyChangList.size());
	
	List ym = (List)custemList.get(0);
	String xxx = "";
	for(int i = 0 ; i < ym.size() ; i++){
		if(i==0){
			xxx += (String)ym.get(0);
		}else{
			xxx += ","+(String)ym.get(i);
		}
	}
	
	List values = (List)custemList.get(2);
	String maxValue = (String)values.get(0);
	double dmax = Double.parseDouble(maxValue);
	if(dmax%10!=0.0){
		dmax = dmax + (10-dmax%10);
	}
	System.out.println(dmax);
	
	int ymCount = ym.size();
	int barCount = 6;
	String[] bars = new String[barCount];
	
	for(int j = 0 ; j < barCount ; j++){
		for(int n = 1 ; n <= ymCount ; n++){
			if(n==1){
				bars[j] = (String)values.get(j*ymCount+n);
			}else{
				bars[j] += ","+(String)values.get(j*ymCount+n);
			}	
		}
	}
	
	List valuesM = (List)moneyChangList.get(2);
	String maxValueM = (String)valuesM.get(0);
	double dmaxM = Double.parseDouble(maxValueM);
	if(dmaxM%10!=0.0){
		dmaxM = dmaxM + (10-dmaxM%10);
	}
	System.out.println(dmaxM);
	
	int ymCountM = ym.size();
	int barCountM = 6;
	String[] barsM = new String[barCountM];
	
	for(int j = 0 ; j < barCountM ; j++){
		for(int n = 1 ; n <= ymCountM ; n++){
			if(n==1){
				barsM[j] = (String)valuesM.get(j*ymCountM+n);
			}else{
				barsM[j] += ","+(String)valuesM.get(j*ymCountM+n);
			}	
		}
	}
	
	System.out.println(bars);
		
%>

<div id="flashcontent" style="overflow:scroll;scrollbar-3dlight-color:#46A3FF; scrollbar-arrow-color:#FFFFFF; scrollbar-track-color:#FFFFFF; scrollbar-darkshadow-color:#46A3FF; scrollbar-face-color:#46A3FF; scrollbar-highlight-color:#FFFFFF; scrollbar-shadow-color:#46A3FF"></div>

<script type="text/javascript">

	var fash = new SWFObject("open-flash-chart.swf","flashcontent", "800", "300", "5", "#ffffff");
	fash.addVariable("variables","true");
	fash.addVariable("title","理财客户数量变化统计图 单位：(人),{font-size: 18;}");
	fash.addVariable("y_label_size","15");
	fash.addVariable("y_ticks","5,10,10");
	
	 
	fash.addVariable("bar_3d","90,#567895,本外币储蓄存款,13");
	fash.addVariable("bar_3d_2","90,#4ffee2,本外币储蓄理财,13");
	fash.addVariable("bar_3d_3","90,#467500,基金,13");
	fash.addVariable("bar_3d_4","90,#000000,国债,13");
	fash.addVariable("bar_3d_5","90,#336666,个贷,13");
	fash.addVariable("bar_3d_6","90,#6C3365,三方存管,13");
	 
	fash.addVariable("values",'<%=bars[0]%>');
	fash.addVariable("values_2",'<%=bars[1]%>');
	fash.addVariable("values_3",'<%=bars[2]%>');
	fash.addVariable("values_4",'<%=bars[3]%>');
	fash.addVariable("values_5",'<%=bars[4]%>');
	fash.addVariable("values_6",'<%=bars[5]%>');

	 
	fash.addVariable("x_labels",'<%=xxx%>');
	fash.addVariable("x_label_style","12,#9933CC,0,1");
	fash.addVariable("x_ticks",6);
	fash.addVariable("x_axis_steps","1");
	fash.addVariable("x_axis_3d","5");
	 
	fash.addVariable("y_min","0");
	fash.addVariable("y_max",<%=dmax%>);
	fash.addParam("allowScriptAccess", "always" );
	fash.write("flashcontent");

</script>

<div id="flashcontent2" style="margin-top:20px;overflow:scroll;scrollbar-3dlight-color:#46A3FF; scrollbar-arrow-color:#FFFFFF; scrollbar-track-color:#FFFFFF; scrollbar-darkshadow-color:#46A3FF; scrollbar-face-color:#46A3FF; scrollbar-highlight-color:#FFFFFF; scrollbar-shadow-color:#46A3FF"></div>

<script type="text/javascript">

	var fash2 = new SWFObject("open-flash-chart.swf","flashcontent2", "800", "300", "9", "#ffffff");
	fash2.addVariable("variables","true");
	fash2.addVariable("title","理财资金数量变化统计图 单位：(元),{font-size: 18;}");
	fash2.addVariable("y_label_size","15");
	fash2.addVariable("y_ticks","5,10,10");
	 
	fash2.addVariable("bar_3d","90,#567895,本外币储蓄存款,13");
	fash2.addVariable("bar_3d_2","90,#4ffee2,本外币储蓄理财,13");
	fash2.addVariable("bar_3d_3","90,#467500,基金,13");
	fash2.addVariable("bar_3d_4","90,#000000,国债,13");
	fash2.addVariable("bar_3d_5","90,#336666,个贷,13");
	fash2.addVariable("bar_3d_6","90,#6C3365,三方存管,13");
	 
	fash2.addVariable("values",'<%=barsM[0]%>');
	fash2.addVariable("values_2",'<%=barsM[1]%>');
	fash2.addVariable("values_3",'<%=barsM[2]%>');
	fash2.addVariable("values_4",'<%=barsM[3]%>');
	fash2.addVariable("values_5",'<%=barsM[4]%>');
	fash2.addVariable("values_6",'<%=barsM[5]%>');

	 
	fash2.addVariable("x_labels",'<%=xxx%>');
	fash2.addVariable("x_label_style","12,#9933CC,0,1");
	fash2.addVariable("x_ticks",6);
	fash2.addVariable("x_axis_steps","1");
	fash2.addVariable("x_axis_3d","5");
	 
	fash2.addVariable("y_min","0");
	fash2.addVariable("y_max",<%=dmaxM%>);
	fash2.addParam("allowScriptAccess", "always" );
	fash2.write("flashcontent2");

</script>
<%}else{%>
<font color="red">	
<% out.print("出错了！请确认是否已导入了数据！");} %></font>
</body>
</html>