<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">编辑文章</h2>
<form action="${base}/admin/news.do?command=edit" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<input name="id" type="hidden" value="${newsId}" />
	<div class="pageContent">
		<div class="pageFormContent" layoutH="97">
		
				<dl>
			<dt>标题：</dt><dd><input name="title"  type="text" size="100" value="${news.title}" /></dd>
		</dl>
		<dl>
			
		</dl>
		<dl>
			<dt>首页显示：</dt><dd>
			<input name="isHome" value="1" type="radio" ${news.isHome eq 1 ?'checked':""}/>
			显示
			<input name="isHome" value="0" type="radio" ${news.isHome eq 0 ?'checked':""}/>
			不显示
			</dd>
		</dl>
		<dl>
			<dt>置顶：</dt><dd>
			<input name="isTop" value="1" type="radio" ${news.isTop eq 1 ?'checked':""}/>
			置顶
			<input name="isTop" value="0" type="radio" ${news.isTop eq 0 ?'checked':""}/>
			不置顶
			</dd>
		</dl>
		<dl>
			<dt>分类：</dt>
			<dd>
                <select class="combox" name="typeId">
						<option value="0">
							=请选择分类=
						</option>
						<c:forEach var="g" items="${allType}" varStatus="t">
							<option value="${g.id}" ${g.id eq news.typeId ?'selected':""}>
								${g.name}
							</option>
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
					upmediaurl="/servlet/UploadFileServlet" upmediaext:"avi">
					${news.content}
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


<div class="page">
	<div class="pageContent">
	<h2 class="contentTitle">修改文章</h2>
		<form method="post" action="news.do?command=edit"
			class="pageForm required-validate"
			onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="94">
				<input name="newsid" type="hidden" value="${newsid}" />
				<table width="90%" border="0">
					<tr height="50px">
						<td width="10%">
							<label>
								标题：
							</label>
						</td>
						<td colspan="3">
							<input name="title" type="text" size="100" value="${news.title}" />
						</td>
					</tr>

					<tr height="40px">
						<td>
							<label>
								分类：
							</label>
						</td>
						<td width="30%">
							<select class="combox" name="newstypeid">
								<option value="0">
									=请选择分类=
								</option>
								<c:forEach var="g" items="${allType}" varStatus="t">
									<option value="${g.id}" ${g.id eq news.typeId ?'selected':""}>
										${g.name}
									</option>
								</c:forEach>
							</select>
							<label>
								添加分类
							</label>
						</td>
						<td width="12%">
							<label>
								首页显示：
							</label>
						</td>
						<td width="49%">
							<input name="status" value="1" type="radio" ${news.status eq 1 ?'checked':""}/>
							启用
							<input name="status" value="2" type="radio" ${news.status eq 2 ?'checked':""}/>
							禁用
						</td>
					</tr>
					<tr height="40px">
						<td width="10%">
							<label>
								置顶：
							</label>
						</td>
						<td colspan="3">
							<input name="top" value="1" type="radio" ${news.isTop eq 1 ?'checked':""}/>
							置顶
							<input name="top" value="0" type="radio" ${news.isTop eq 0 ?'checked':""}/>
							不置顶
						</td>
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
								${news.content}
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