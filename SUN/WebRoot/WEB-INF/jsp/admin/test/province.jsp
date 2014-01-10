<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<h2 class="contentTitle">下拉菜单</h2>

<div class="pageContent" layoutH="56">
	<select class="combox" name="province" ref="w_combox_city" refUrl="demo/combox/city_{value}.html">
		<option value="all">所有省市</option>
		<option value="bj">北京</option>
		<option value="sh">上海</option>
	</select>
	<select class="combox" name="city" id="w_combox_city" ref="w_combox_area" refUrl="demo/combox/area_{value}.html">
		<option value="all">所有城市</option>
	</select>
	<select class="combox" name="area" id="w_combox_area">
		<option value="all">所有区县</option>
	</select>
</div>

