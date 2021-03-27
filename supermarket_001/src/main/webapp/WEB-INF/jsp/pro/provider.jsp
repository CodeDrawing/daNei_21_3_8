<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>供应商管理页面</span>
    </div>
    <div class="search">
        <form method="post" action="${pageContext.request.contextPath }/pro/selectProvider">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>供应商名：</span>
            <input name="queryname" class="input-text"	type="text" value="${queryUserName }">

            <input type="hidden" name="pageIndex" value="1"/>
            <input	value="查 询" type="submit" id="searchbutton">
            <a href="${pageContext.request.contextPath}/pro/addProviderpage" >添加供应商</a>
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%">供应商编码</th>
            <th width="10%">供应商名称</th>
            <th width="10%">供应商负责人</th>
            <th width="30%">供应商产品</th>
            <th width="10%">供应商电话</th>
            <th width="10%">供应商地址</th>
            <th width="20%">操作</th>
        </tr>
        <c:forEach var="provider" items="${providerList }" varStatus="status">
            <tr>
                <td>
                    <span>${provider.proCode }</span>
                </td>
                <td>
                    <span>${provider.proName }</span>
                </td>
                <td>
                    <span>${provider.proContact }</span>
                </td>
                <td>
							<span>
								${provider.proDesc}
							</span>
                </td>
                <td>
                    <span>${provider.proPhone}</span>
                </td>
                <td>
                    <span>${provider.proAddress}</span>
                </td>
                <td>
                    <span><a class="viewUser" href="/pro/checkProvider?providerid=${provider.id }" providerid=${provider.id } providername=${provider.proName }><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyUser" href="/pro/updateProviderPage?providerid=${provider.id }" providerid=${provider.id } providername=${provider.proName }><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteUser" href="/pro/deleteProvider?providerid=${provider.id }" providerid=${provider.id } providername=${provider.proName }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <c:import url="../rollpage.jsp">
        <c:param name="totalCount" value="${totalCount}"/>
        <c:param name="currentPageNo" value="${currentPageNo}"/>
        <c:param name="totalPageCount" value="${totalPageCount}"/>
    </c:import>
</div>
</section>

<%@include file="/WEB-INF/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
