<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/project/init.jsp"%>
<h2 class="contentTitle">添加图片</h2>
<form action="demo/common/ajaxDone.html?navTabId=masterList&callbackType=closeCurrent" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		
		<dl class="nowrap">
			<dt>工程名称：</dt>
			<dd>
				${project.title }
			</dd>
		</dl>
		<div class="divider"></div>
		<dl class="nowrap">
			<dt>分类：</dt>
			<dd>
				酒店会所
			</dd>
		</dl>
		
		
		<div class="divider"></div>
		<h3 class="contentTitle">批量上传图片</h3>
	<div style="float:left; margin:10px">
	<div id="fileQueue" class="fileQueue"></div>
	<input id="testFileInput" type="file" name="image" 
		uploader="${base}/uploadify/scripts/uploadify.swf"
		cancelImg="${base}/uploadify/cancel.png" 
		script="${base}/servlet/Upload?projectId=${projectId}" 
		scriptData="{PHPSESSID:'xxx', ajax:1}"
		fileQueue="fileQueue"
		onAllComplete="uploadifyAllComplete" 
		fileExt="*.jpg;*.jpeg;*.gif;*.png;"
		fileDesc="*.jpg;*.jpeg;*.gif;*.png;"/>
	</div>
		
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>
<table class="list nowrap itemDetail" addButton="新建从表1条目" width="100%">
<thead>
<tr>
	<th type="text" name="items.itemString" size="12" fieldClass="required">从字符串</th>
	<th type="text" name="items.itemInt" size="12" fieldClass="digits">从整数</th>
	<th type="text" name="items.itemFloat" size="12" fieldClass="number">从浮点</th>
	<th type="date" name="items.itemDate" size="12">从日期</th>
	<th type="date" format="yyyy-MM-dd HH:mm:ss" name="items.itemDataTime" size="16">从日期时间</th>
	<th type="lookup" name="dwz.items.org.orgName" lookupGroup="items.org" lookupUrl="demo/database/dwzOrgLookup.html" suggestUrl="demo/database/db_lookupSuggest.html" suggestFields="orgName" size="12">部门名称</th>
	<th type="enum" name="items.itemEnum" enumUrl="demo/database/db_select.html" size="12">从枚举</th>
	<th type="attach" name="dwz.items.attachment.fileName" lookupGroup="items.attachment" lookupUrl="demo/database/db_attachmentLookup.html" size="12">从附件</th>
	<th type="del" width="60">操作</th>
</tr>
</thead>
<tbody></tbody>
</table>