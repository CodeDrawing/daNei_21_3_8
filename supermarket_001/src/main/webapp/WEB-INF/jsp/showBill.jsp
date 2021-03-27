<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>账单管理</span>
    </div>
<%--    <div class="search">--%>
        <a href="${pageContext.request.contextPath }/bill/toAddBill" class="layui-btn">添加订单</a>




    <table class="layui-hide" id="demo" lay-filter="test"></table>


    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <script>
            layui.use( 'table', function () {
                var table = layui.table;
                table.render({
                    elem: '#demo'
                    , url: '/bill/getAllBill/'
                    , page: true
                    , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                    , cols: [[
                        , {field: 'id', title: 'ID', sort: true}
                        , {field: 'billCode', title: '账单号', sort: true}
                        , {field: 'productName', title: '产品名称', sort: true}
                        , {field: 'productDesc', title: '产品描述', sort: true}
                        , {field: 'productUnit', title: '单位', sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                        , {field: 'productCount', title: '商品数量', sort: true}
                        , {field: 'totalPrice', title: '商品总额', sort: true}
                        , {field: 'isPayment', title: '是否支付', sort: true}
                        , {fixed: 'right', width: 165, align: 'center', toolbar: '#barDemo',title:'操作'}
                    ]]
                });//监听行工具事件
                table.on('tool(test)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                    var data = obj.data //获得当前行数据
                        ,layEvent = obj.event; //获得 lay-event 对应的值
                   if(layEvent === 'del'){
                        layer.confirm('真的删除行么', function(index){
                             //删除对应行（tr）的DOM结构

                            $.ajax({
                                url:"/bill/deleteBillById/"+data.id,
                                type:"post",
                                success:function(data){
                                    layer.msg("删除成功！")
                                    window.location.href="/bill/showBill"
                                },
                                error:function(data){
                                    layer.msg('服务器错误，请重试！')
                                },

                            })
                            layer.close(index);
                            //向服务端发送删除指令
                        });
                    } else if(layEvent === 'edit'){
                        layer.msg('跳转中..');
                        window.location.href="/bill/toUpdateBill/"+data.id
                    }
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
