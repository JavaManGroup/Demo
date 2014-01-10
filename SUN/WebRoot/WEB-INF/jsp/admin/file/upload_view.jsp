<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/file/init.jsp"%>

<h2 class="contentTitle">请选择需要上传的附件</h2>
<form name=saveForm action="/sun/admin/upload.do?command=upload" method="post" enctype="multipart/form-data" onsubmit="return iframeCallback(this, $.bringBack)">


<!--  
<form name=saveForm action="/sun/admin/upload.do?command=add" target="callbackframe" method="post" enctype="multipart/form-data" onsubmit="return validateCallback(this, $.bringBack)">

<form name=saveForm action="http://www.baidu.com" target="callbackframe" method="get" enctype="multipart/form-data" onsubmit="return iframeCallback(this, $.bringBack)">


<form name="saveForm" action="db_attachmentBrightBack.html" method="post" enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this, $.bringBack)">
-->
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>附件：</dt><dd><input type="file" name="file" class="required" size="30" /></dd>
		</dl>
		<dl>
			<dt>附件：</dt><dd><a href="http://www.baidu.com" target="callbackframe">www.baidu.com</a></dd>
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