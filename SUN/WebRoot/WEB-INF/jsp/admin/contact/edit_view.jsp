<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${app}?command=edit" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<input name="id" type="hidden" value="${contact.id}"/>
			<table width="100%" border="0">
              <tr height="40px">
                <td>地址：</td>
                <td><input name="address" type="text" size="30"class="required" value="${contact.address}" /></td>
                 <td>电话号码：</td>
                <td><input type="text" name="phone" size="30" class="required"value="${contact.phone}"/></td>
                <td>邮编：</td>
                <td><input type="text" name="postcode" size="30"class="required" value="${contact.postcode}"/></td>
              </tr>
              <tr height="40px">
               
                <td>传真：</td>
                <td><input type="text" name="fax" size="30" class="required"value="${contact.fax}"/></td>
                <td>E-mail：</td>
                <td><input type="text" name="email" size="30" class="required"value="${contact.email}"/></td>
              </tr>
              
            
            </table>
		
				<div class="divider"></div>

			</div>
			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>