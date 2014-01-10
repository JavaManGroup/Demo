<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">添加精品工程</h2>
<form action="${AppBase}?command=edit" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input type="hidden" name="id" value="${protypeId}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="name" class="required" type="text" value="${type.name}"/></dd>
		</dl>
		<dl>
			<dt>首页显示：</dt><dd>
			<input type="radio" name="isHome"  value="1" ${type.is_home eq 1 ?'checked':""}/>显示
			<input type="radio" name="isHome"  value="0" ${type.is_home eq 0 ?'checked':""} />不显示
			</dd>
		</dl>
		<dl>
			<dt>封面：</dt>
			<dd>
				<input name="attachment.id" value="" type="hidden">
				<input id="file" name="dwz.attachment.attachmentPath" value="" type="hidden">
				<input class="readonly" name="dwz.attachment.fileName" value="${type.image}" readonly="readonly" type="text" />
				<a class="btnAttach" href="${AppBase}?command=upload" lookupGroup="attachment" width="560" height="300" title="附件">附件</a>
			</dd>
		</dl>
		<dl>
			<dt>排序：</dt><dd>
			<input name="sort" class="required" type="text" value="${type.sort}"/>
			</dd>
		</dl>


		<div class="divider"></div>
		<img alt="" src="${type.image}" width="350px" height="280px">
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>