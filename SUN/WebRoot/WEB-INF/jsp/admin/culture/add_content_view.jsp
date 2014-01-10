<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">添加企业文化文章</h2>
<form action="${AppBase}?command=addcontent" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
<input type="hidden" name="url" value="${url}">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="title" class="required" type="text" size="80"/></dd>
		</dl>
		<dl>
		</dl>
		<dl>
		
		<dt>分类：</dt>
			<dd>
				<select class="required combox" name="typeId">
                		<option value="0">=请选择分类=</option>
							<c:forEach var="g" items="${listType}" varStatus="t">
									<option value="${g.id}">${g.name}</option>
							</c:forEach>                		
                </select>
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