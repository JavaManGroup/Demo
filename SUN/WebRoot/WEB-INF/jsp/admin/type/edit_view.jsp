<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/type/init.jsp"%>
<h2 class="contentTitle">编辑文章</h2>
<form action="${AppBase}?command=edit" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<input name="id" type="hidden" value="${typeId}">
		<dl>
			<dt>名称：</dt><dd><input name="name"  type="text" value="${type.name}"/></dd>
		</dl>
		<dl>
			<dt>模式：</dt><dd><input name="isStatic" value="1" type="radio" ${type.isStatic eq 1 ?"checked":""}/>普通分类
							<input name="isStatic" value="2" type="radio" ${type.isStatic eq 2 ?"checked":""}/>静态页面
							</dd>
		</dl>
		<dl>
			<dt>排序：</dt><dd><input name="sort"  type="text" value="${type.sort}" readonly="readonly"/></dd>
		</dl>
		<dl>
			<dt>首页显示：</dt><dd><input name="isBanner" value="1" type="radio" ${type.isStatic eq 1 ?"checked":""} />显示
							<input name="isBanner" value="2" type="radio" ${type.isStatic eq 2 ?"checked":""}/>不显示
							</dd>
		</dl>
		
				<div class="divider"></div>
		<dl class="nowrap">
			<dt>描述：
			<br/>
			<br/>
			<font color="#0000FF" style="line-height:1.4em;text-indent: 2em;">在此填写的描述内容当类型模式为静态网站时将做为网站的页面内容</font></dt>
			<dd>
				 <textarea class="editor" name="introduction" rows="20" cols="96"
					uplinkurl="/servlet/UploadFileServlet" uplinkext="zip,rar,txt" 
					upimgurl="/servlet/UploadFileServlet" upimgext="jpg,jpeg,gif,png" 
					upflashurl="/servlet/UploadFileServlet" upflashext="swf"
					upmediaurl="/sservlet/UploadFileServlet" upmediaext="avi">
					${type.introduction }
					</textarea>
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