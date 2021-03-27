<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户信息修改</span>
    </div>


    <form class="layui-form" action="${pageContext.request.contextPath}/bill/updateBill" name="" method="post">
        <div style="width:30%">
            <input name="id" value="${bill.id}" type="hidden">
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">账单号</label>
                <div class="layui-input-block">
                    <input type="text" disabled name="billCode" class="layui-input" value="${bill.billCode}">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">商品名</label>
                <div class="layui-input-block">
                    <input type="text" name="productName"  class="layui-input"value="${bill.productName}">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">商品描述</label>
                <div class="layui-input-block">
                    <input type="text" name="productDesc" class="layui-input" value="${bill.productDesc}">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">单位</label>
                <div class="layui-input-block">
                    <input type="text" name="productUnit" class="layui-input" value="${bill.productUnit}">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">商品数量</label>
                <div class="layui-input-block">
                    <input type="text" name="productCount" class="layui-input" value="${bill.productCount}">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">商品总数</label>
                <div class="layui-input-block">
                    <input type="text" name="totalPrice" class="layui-input" value="${bill.totalPrice}">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">是否支付</label>
                <div class="layui-input-block">
                    <input type="text" name="isPayment" class="layui-input" value="${bill.isPayment}">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
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

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
