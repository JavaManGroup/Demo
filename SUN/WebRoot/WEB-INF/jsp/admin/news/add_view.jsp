<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">添加文章</h2>
<form action="${base}/admin/news.do?command=add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="title"  type="text" size="100" class="required"/></dd>
		</dl>
		<dl>
			
		</dl>
		<dl>
			<dt>首页显示：</dt><dd>
			<input type="radio" name="isHome"  value="1"/>显示
			<input type="radio" name="isHome"  value="0" checked />不显示
			</dd>
		</dl>
		<dl>
			<dt>置顶：</dt><dd>
			<input type="radio" name="isTop"  value="1"/>置顶
			<input type="radio" name="isTop"  value="0" checked />不置顶
			</dd>
		</dl>
		<dl>
			<dt>分类：</dt>
			<dd>
				<select class="required combox" name="typeId">
                		<option value="0">=请选择分类=</option>
							<c:forEach var="g" items="${allType}" varStatus="t">
									<option value="${g.id}">${g.name}</option>
							</c:forEach>                		
                </select>
			</dd>
		</dl>

		<div class="divider"></div>
			<table width="90%" border="0">
              <tr height="40px">
                <td><label>内容：</label></td>
                <td colspan="3">
                <textarea class="editor" name="content" rows="20" cols="96"
					uplinkurl="/servlet/UploadFileServlet" uplinkext="zip,rar,txt" 
					upimgurl="/servlet/UploadFileServlet" upimgext="jpg,jpeg,gif,png" 
					upflashurl="/servlet/UploadFileServlet" upflashext="swf"
					upmediaurl="/servlet/UploadFileServlet" upmediaext="avi">
					</textarea></td>
                </tr>
            
            </table>

			
  </div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
			</ul>
		</div>
	</div>
</form>

