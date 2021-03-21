<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/common/head.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="right">
	<div class="location">
		<strong>你现在所在的位置是:</strong>
		<span>用户信息修改</span>
	</div>


	<form>
		<div >
			<input name="id" value="${user.id}" type="hidden">
			<div style="margin: 3%">
				<label>userName</label>
				<input type="text" name="userName" value="${user.userName}">
			</div>
			<div style="margin: 3%">
				<label>gender</label>
				<input type="text" name="gender" value="${user.gender}">
			</div>
			<div style="margin: 3%">
				<label>birthday</label>
				<input type="text" name="birthday" value="${user.birthday}">
			</div>
			<div style="margin: 3%">
				<label>phone</label>
				<input type="text" name="phone" value="${user.phone}">
			</div>
			<div style="margin: 3%">
				<label>address</label>
				<input type="text" name="address" value="${user.address}">
			</div>
			<div style="margin: 3%">
				<input type="submit" value="提交">
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
