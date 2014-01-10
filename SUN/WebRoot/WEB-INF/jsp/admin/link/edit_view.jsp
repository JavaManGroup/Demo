<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">编辑页面</h2>
<form action="${AppBase}?command=edit" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="id" value="${linkId}"> 
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>网站名称：</dt><dd><input name="name" class="required" type="text" value="${link.name} "/></dd>
		</dl>
		<dl>
			<dt>状态：</dt><dd>
			<input type="radio" name="status"  value="1"  ${link.status eq 1?"checked":"" }/>审核
			<input type="radio" name="status"  value="2"  ${link.status eq 1?"":"checked"}/>未审核
			</dd>
		</dl>
		<dl>
			<dt>网址：</dt><dd><input name="url" class="required" type="text" value="${link.url}" /></dd>
		</dl>
		<dl>
			<dt>排序：</dt><dd>
			<input name="sort" class="required" type="text" value="${link.sort}" readonly="readonly"/>
			</dd>
		</dl>


		<div class="divider"></div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>
