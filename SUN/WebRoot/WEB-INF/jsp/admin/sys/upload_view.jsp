<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<c:if test="${method == 'POST'}">
{
	"id":"1000",
	"fileName":"${fileName}",
	"attachmentPath":"${attachmentPath}",
	"attachmentSize":"1024"
}
</c:if>
<c:if test="${method == 'GET'}">
<h2 class="contentTitle">请选择需要上传的附件</h2>

<form action="${base}/admin/sys.do?command=upload" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this, $.bringBack)">

<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>附件：</dt><dd><input type="file" name="file" class="required" size="30" /></dd>
		</dl>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">上传</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>
</c:if>