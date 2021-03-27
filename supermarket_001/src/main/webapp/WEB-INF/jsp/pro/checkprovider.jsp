<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<h1>${msg}</h1>
<table class="providerTable" cellpadding="0" cellspacing="0">
        <c:forEach var="provider" items="${providerlist }" varStatus="status">
            <input type="hidden" name="id" value="${provider.id}">
            <tr><td align="right">供应商号：</td><td align="left">${provider.proCode}</td></tr>
            <tr><td align="right">供应商名：</td><td align="left">${provider.proName}</td></tr>
            <tr><td align="right">供应商商品及合作关系：</td><td align="left">${provider.proDesc}</td></tr>
            <tr><td align="right">供应商：</td><td align="left">${provider.proContact}</td></tr>
            <tr><td align="right">联系号码：</td><td align="left">${provider.proPhone}</td></tr>
            <tr><td align="right">地址：</td><td align="left">${provider.proAddress}</td></tr>
            <tr><td align="right">传真：</td><td align="left">${provider.proFax}</td></tr>
        </c:forEach>
</table>
<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
