<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/project/init.jsp"%>
<h2 class="contentTitle">添加精品工程</h2>
<form action="${AppBase}?command=add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="title" class="required" type="text" /></dd>
		</dl>
		<dl style="display: none">
			<dt>首页显示：</dt><dd>
			<input type="hidden" name="isHome"  value="1" checked/>显示
			</dd>
		</dl>
		<dl>
			<dt>精品推荐：</dt>
			<dd>
				<input type="radio" name="status" value="1" />推荐
				<input type="radio" name="status" value="0" checked />不推荐
			</dd>
		</dl>
		<dl>
			<dt>分类：</dt>
			<dd>
				<select name="typeId" class="required combox">
					<option value="0" selected>请选择</option>
					<c:forEach var="t" items="${alltype}">
						<option value="${t.id }">${t.name}</option>
					</c:forEach>
				</select>
				
				<a class="add" href="/admin/protype.do?command=addview" target="navTab" rel="add" mask="true">添加工程分类</a>
			</dd>
		</dl>
		<dl>
			<dt>封面：</dt>
			<dd>
				<input name="attachment.id" value="" type="hidden">
				<input id="file" name="dwz.attachment.attachmentPath" value="" type="hidden">
				<input class="readonly" name="dwz.attachment.fileName" value="" readonly="readonly" type="text" />
				<a class="btnAttach" href="${AppBase}?command=upload" lookupGroup="attachment" width="560" height="300" title="附件">附件</a>
			</dd>
		</dl>
		


		<div class="divider"></div>
		<img alt="" src="${base}/themes/default/images/fengmian.jpg" width="350px" height="280px">
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>