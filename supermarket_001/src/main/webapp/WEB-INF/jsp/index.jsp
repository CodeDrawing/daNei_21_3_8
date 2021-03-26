<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<div class="layui-container">
	数据统计
	<div class="layui-row">
		<div class="layui-col-xs5"style="margin-right: 30px" >
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
				<legend>销售量最高</legend>
				<div id="main" style="width: 400px;height:300px"></div>
<%--				111--%>
			</fieldset>

		</div>
<%--		<div class="layui-col-xs2">--%>

<%--		</div>--%>
		<div class="layui-col-xs5" style="margin-left: 50px" >
			<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
				<legend>供应商分布</legend>
				<div id="main1" style="width: 400px;height:300px"></div>
<%--				222--%>
			</fieldset>
		</div>
	</div>
</div>



<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	// var myChart = echarts.init(document.getElementById('main'));
	// var myChart = echarts.init(document.getElementById('main1'));

	// 指定图表的配置项和数据
	// myChart.setOption({
	// 	series : [
	// 		{
	// 			name: '访问来源',
	// 			type: 'pie',
	// 			radius: '55%',
	// 			data:[
	// 				{value:235, name:'视频广告'},
	// 				{value:274, name:'联盟广告'},
	// 				{value:310, name:'邮件营销'},
	// 				{value:335, name:'直接访问'},
	// 				{value:400, name:'搜索引擎'}
	// 			]
	// 		}
	// 	]
	// });

	<%--$.get('${pageContext.request.contextPath }/user/getDate').done(function (data){--%>
	<%--	myChart.setOption({--%>
	<%--		series : [--%>
	<%--			{--%>
	<%--				name: '访问来源',--%>
	<%--				type: 'pie',--%>
	<%--				radius: '55%',--%>
	<%--				data:data.data--%>
	<%--			}--%>
	<%--		]--%>
	<%--	});--%>

	<%--});--%>
	<%--// 使用刚指定的配置项和数据显示图表。--%>
	<%--myChart.setOption(option);--%>

	var myChart = echarts.init(document.getElementById('main'));
	$.get('${pageContext.request.contextPath }/user/getDate', function (data) {
		myChart.setOption({
			series : [
				{
					name: '销售量最多商品',
					type: 'pie',    // 设置图表类型为饼图
					radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
					data:data.topFive
				}
			]
		})
	}, 'json')
	var myChart1 = echarts.init(document.getElementById('main1'));
	$.get('${pageContext.request.contextPath }/user/getDate', function (data) {
		myChart1.setOption({
			series : [
				{
					name: '供应商地区分布',
					type: 'pie',    // 设置图表类型为饼图
					radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
					data:data.provinceCount
				}
			]
		})
	}, 'json')

</script>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
