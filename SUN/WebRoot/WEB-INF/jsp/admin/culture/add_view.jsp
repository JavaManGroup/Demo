<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">添加企业文化</h2>
<form action="${AppBase}?command=add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="name" class="required" type="text"/></dd>
		</dl>
		<dl>
		</dl>
		<dl>
			<dt>副标题：</dt><dd><input name="title" class="required" type="text" size="80"/></dd>
		</dl>
		<dl>
		</dl>
		<dl>
			<dt>页面类型：</dt><dd>
			<input type="radio" name="isStatic"  value="1" checked/>静态页面
			<input type="radio" name="isStatic"  value="2"/>列表页面
			</dd>
		</dl>
		<dl>
		</dl>
		<dl>
			<dt>排序：</dt><dd>
			
				
				<div style="float: left;width: 400px"><input type="text" name="sort"  value="${maxCultureSort}" readonly="readonly" />  <font color="#0000FF" style="line-height:1.4em;text-indent: 2em;">注释：排序初始为最大值  可通过列表页进行设置</font></div>
			</dd>
		</dl>
		


		<div class="divider"></div>
		 <textarea class="editor" name="content" rows="20" cols="96"
					uplinkurl="${base}/servlet/UploadFileServlet" uplinkext="zip,rar,txt" 
					upimgurl="${base}/servlet/UploadFileServlet" upimgext="jpg,jpeg,gif,png" 
					upflashurl="${base}/servlet/UploadFileServlet" upflashext="swf"
					upmediaurl="${base}/servlet/UploadFileServlet" upmediaext:"avi">
					</textarea>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>