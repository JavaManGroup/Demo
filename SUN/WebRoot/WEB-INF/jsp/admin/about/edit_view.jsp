<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>



<div class="page">
	<div class="pageContent">
	<h2 class="contentTitle">修改关于我们</h2>
		<form method="post" action="about.do?command=edit"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="94">
				<input name="aboutid" type="hidden" value="${about.id}" />
				<table width="90%" border="0">
					<tr height="50px">
						<td width="10%">
							<label>
								标题：
							</label>
						</td>
						<td colspan="3">
							<input name="title" type="text" class="required" size="100" value="${about.title}" />
						</td>
					</tr>

					</tr>
					<tr height="40px">
						<td width="10%">
					</tr>
					<tr height="40px">
						<td>
							<label>
								内容：
							</label>
						</td>
						<td colspan="3">
							<textarea class="editor" name="content" rows="20" cols="96"
								uplinkurl="/sun/servlet/UploadFileServlet"
								uplinkext="zip,rar,txt"
								upimgurl="/sun/servlet/UploadFileServlet"
								upimgext="jpg,jpeg,gif,png"
								upflashurl="/sun/servlet/UploadFileServlet" upflashext="swf"
								upmediaurl="/sun/servlet/UploadFileServlet"upmediaext:"avi">
								${about.content}
							</textarea>
						</td>
					</tr>

				</table>


			</div>
			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
					<li>
						<div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">
									保存
								</button>
							</div>
						</div>
					</li>
					<li>
						<div class="button">
							<div class="buttonContent">
								<button type="Button" onclick="navTab.closeCurrentTab()">
									取消
								</button>
							</div>
						</div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>