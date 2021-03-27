<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>添加订单</span>
    </div>

    <label style="color:red">${msg}</label>
    <form action="${pageContext.request.contextPath}/bill/addBill" name="" method="post" id="form" class="layui-form">
        <div>
            <div class="layui-form-item">
                <label class="layui-form-label">订单账号</label>
                <div class="layui-input-inline">
                    <input type="text" name="billCode" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品名</label>
                <div class="layui-input-inline">
                    <input type="text" name="productName" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品描述</label>
                <div class="layui-input-inline">
                    <input type="text" name="productDesc" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品单位</label>
                <div class="layui-input-inline">
                    <input type="text" name="productUnit" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">商品数量</label>
                <div class="layui-input-inline">
                    <input type="text" name="productCount" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">总数量</label>
                <div class="layui-input-inline">
                    <input type="text" name="totalPrice" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">是否支付</label>
                <div class="layui-input-inline">
                    <input type="text" name="isPayment" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>


    </form>

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
<script>
    layui.use('form',function(){
        var form = layui.form;

        //刷新界面 所有元素

        form.render();

    });
</script>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
