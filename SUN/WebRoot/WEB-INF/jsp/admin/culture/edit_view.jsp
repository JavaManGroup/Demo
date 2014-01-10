<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">编辑页面</h2>
<form action="${AppBase}?command=edit" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input name="id" type="hidden" value="${culture.id}"/>
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="name" class="required" type="text" value="${culture.name}"/></dd>
		</dl>
		<dl>
		</dl>
		<dl>
			<dt>副标题：</dt><dd><input name="title" class="required" size="80" type="text" value="${culture.title}"/></dd>
		</dl>
		<dl>
		</dl>
		<dl>
			<dt>页面类型：</dt><dd>
			<input type="radio" name="isStatic"  value="1" ${culture.is_static eq 1 ?'checked':""}/>静态页面
			<input type="radio" name="isStatic"  value="2" ${culture.is_static eq 2 ?'checked':""}/>列表页面
			</dd>
		</dl>
		<c:if test="${culture.is_static eq 2}">
		<dl>
		</dl>
		<dl>
			<a href="/admin/culture.do?command=list&cultureId=${culture.id}" target="navTab" rel="edit">管理文章</a>
		</dl>
		</c:if>

		<div class="divider"></div>
		 <textarea class="editor" name="content" rows="20" cols="96"
					uplinkurl="${base}/servlet/UploadFileServlet" uplinkext="zip,rar,txt" 
					upimgurl="${base}/servlet/UploadFileServlet" upimgext="jpg,jpeg,gif,png" 
					upflashurl="${base}/servlet/UploadFileServlet" upflashext="swf"
					upmediaurl="${base}/servlet/UploadFileServlet" upmediaext:"avi">
					${culture.content}
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
