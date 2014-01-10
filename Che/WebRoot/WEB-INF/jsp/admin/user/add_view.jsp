<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/user/init.jsp"%>
<h2 class="contentTitle">添加新用户</h2>
<form action="${app}?command=add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
			<input name="pageCount" type="hidden" value="${pageCount}">
			<div class="pageFormContent" layoutH="98">
			
				<p>
					<label>用户名：</label>
					<input name="userName" class="required alphanumeric" minlength="6" maxlength="20"  type="text" size="30"/>
				</p>
				<p>
					<label>真实姓名：</label>
					<input name="realName" class="required" type="text" size="30"/>
				</p>
				<p>
					<label>密码：</label>
					<input name="password" class="required" type="password" size="30" />
				</p>
				<p>
					<label>电话号码：</label>
					<input name="phone" class="required" type="text" size="30" />
				</p>
				
				<p>
					<label>E-mail：</label>
					<input name="email" class="email" type="text" size="30" />
				</p>
				<div class="divider"></div>
				<p>
					<label>用户身份：</label>
					<select name="roleId" class="required combox">
						<c:forEach items="${addGroup}" var="a" varStatus="t">
							<option value="${a.id}" ${t.first?"selected":""}>${a.group_name}</option>
						</c:forEach>
						
					</select>
				</p>
				<p>
					<label>用户状态：</label>
					<input type="radio" value="1" name="status" checked>可用
					<input type="radio" value="0" name="status">禁用
				</p>
			</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	
</div>
</form>