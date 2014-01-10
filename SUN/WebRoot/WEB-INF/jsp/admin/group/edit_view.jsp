<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${base}/admin/group.do?command=edit"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
				<input type="hidden" name="groupId" value="${group.id}">

				<p>
					<label>
						名称：
					</label>
					<input name="groupName" value="${group.groupName}" class="required"
						minlength="2" maxlength="20" type="text" size="30" />
				</p>
				<br />
				<br />
				<br />
				<br />
				<br />
				<p>
					<label>
						描述：
					</label>
					<input name="groupDes" value="${group.groupDes}" class="required"
						type="text" size="30" />
				</p>

			</div>
			<div class="formBar">
				<ul>
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>