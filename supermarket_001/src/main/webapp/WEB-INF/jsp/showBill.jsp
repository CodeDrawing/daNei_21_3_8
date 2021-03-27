<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>账单管理</span>
    </div>

    <table class="layui-hide" id="test"></table>


    <script>
        layui.use('table', function(){
            var table = layui.table;

            table.render({
                elem: '#test'
                ,url:'/bill/getAllBill/'
                ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                ,cols: [[
                    ,{field:'billCode', width:140, title: '账单号'}
                    ,{field:'productName', width:80, title: '产品名称', sort: true}
                    ,{field:'productDesc', width:80, title: '产品描述'}
                    ,{field:'productUnit', title: '单位', width: 50,sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                    ,{field:'productCount', title: '商品数量', sort: true}
                    ,{field:'totalPrice', title: '商品总额', }
                    ,{field:'isPayment', title: '是否支付'}
                ]]
            });
        });
    </script>

</div>


<%--<!--点击删除按钮后弹出的页面-->--%>
<%--<div class="zhezhao"></div>--%>
<%--<div class="remove" id="removeUse">--%>
<%--    <div class="removerChid">--%>
<%--        <h2>提示</h2>--%>
<%--        <div class="removeMain">--%>
<%--            <p>你确定要删除该用户吗？</p>--%>
<%--            <a href="${pageContext.request.contextPath }/user/deleteUser/${user.id}" id="yes">确定</a>--%>
<%--            <a href="#" id="no">取消</a>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
