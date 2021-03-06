<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>

<div class="pageContent">
	<form method="post" action="${base}/admin/user.do?command=add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<input id="pageNum" name="pageNum" type="hidden" value="${pageNum }">
			<div class="pageFormContent" layoutH="56">
			
				<p>
					<label>用户名：</label>
					<!--  
					<input id="name" name="userName" class="required alphanumeric" minlength="6" maxlength="20"  type="text" size="30" onblur="javascript:hasUserName(document.getElementById('name').value)" />
					<span id="recalled"></span>
					-->
					<input id="name" name="userName" class="required alphanumeric" minlength="6" maxlength="20"  type="text" size="30"/>
					<span id="recalled"></span>
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
					<input type="text" name="phone" class="required" size="30" />
				</p>
				
				<p>
					<label>E-mail：</label>
					<input type="text" name="email" class="email" size="30" />
				</p>
				<div class="divider"></div>
				<p>
					<label>用户身份：</label>
					<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
					<input type="text" class="textInput required" name="dwz_orgLookup.orgName" value="" readonly="readonly"/>
					<a class="btnLook" href="dwzOrgLookup.html" lookupGroup="" lookupName="orgLookup" maxable="false" resizable="false"><hi:text key="查找带回"/></a>		
				</p>
				<p>
					<label>用户状态：</label>
					<input type="radio" value="" name="status">可用
					<input type="radio" value="" name="status">禁用
				</p>
			</div>
			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				</ul>
			</div>
	</form>
</div>
