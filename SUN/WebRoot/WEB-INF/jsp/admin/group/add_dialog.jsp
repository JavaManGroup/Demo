<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${base}/admin/group.do?command=add" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
			<input id="pageNum" name="pageNum" type="hidden" value="${pageNum}">
			<div class="pageFormContent" layoutH="56">

				<p>
					<label>名称：</label>
					<input name="groupName" class="required" minlength="2" maxlength="20"  type="text" size="30" />
				</p>
				<p>
					<label>描述：</label>
					<input name="groupDes" class="required" type="text" size="30"/>
				</p>
	
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
</div>