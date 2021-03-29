<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>密码修改</span>
    </div>

    <form class="layui-form"  name="form1" >
        <div style="width:30%">
            <input name="id" value="${user.id}" type="hidden">
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">原密码</label>
                <div class="layui-input-block">
                    <input type="password" id="originalPassword" name="originalPassword" class="layui-input">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">新密码</label>
                <div class="layui-input-block">
                    <input type="password" id="userPassword" name="userPassword" class="layui-input">
                </div>
            </div>
            <div style="margin: 3%" class="layui-form-item">
                <label class="layui-form-label">确认新密码</label>
                <div class="layui-input-block">
                    <input type="password" id="confirmPassword" name="confirmPassword" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn"   type="button"   onclick="submit1();"   lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>
    </form>

</div>
<script>
        function submit1() {
            var originalPassword=$("#originalPassword").val();
            var userPassword=$("#userPassword").val();
            var confirmPassword=$("#confirmPassword").val();
            $.ajax({
                type: "post",
                dataType: "json",
                async: false,
                url: "http://172.20.10.5/user/updatePassword",
                data: {"originalPassword":originalPassword,"userPassword":userPassword,"confirmPassword":confirmPassword},
                success: function (data) {
                    if (data.result == 3015) {
                        window.alert("原密码不正确！")
                    } else if (data.result == 3012) {
                        window.alert("两次密码不正确！")
                    } else if (data.result == 2012) {
                        window.alert("修改成功！即将跳转到首页....")
                        window.location.href = "/user/index"
                    }
                }
            });
            return false;
        }

</script>


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
