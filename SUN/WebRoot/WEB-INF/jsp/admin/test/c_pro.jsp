<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<h2 class="contentTitle">下拉菜单</h2>

<div class="pageContent" layoutH="56">
	<select class="combox" name="province" ref="w_combox_city" refUrl="news.do?command=city&pid={value}">
		<option value="all">所有省市</option>
		<c:forEach var="p" items="${allPro}">
			<option value="${p.proId}">${p.proName}</option>
		</c:forEach>
			
	</select>
	<select class="combox" name="city" id="w_combox_city">
		<option value="all">所有城市</option>
	</select>
</div>

