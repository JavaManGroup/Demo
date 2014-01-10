<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/file/init.jsp"%>
<form id="pagerForm" method="post" action="${AppBase}?command=list">
	<input type="hidden" name="pageNum" value="${groups.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"
			action="${AppBase}?command=user" method="post">
			<div class="searchBar">
				<table class="searchContent">
					<tr>
						<td>
							姓名：
							<input type="text" name="realName" />
						</td>
						<td>
							用户类型：
						</td>
						<td>
							<select class="combox" name="userRole">
								<option value="0">
									用户类型
								</option>
								<option value="1">
									管理员
								</option>
								<option value="2">
									编辑
								</option>
							</select>
						</td>
					</tr>
				</table>
				<div class="subBar">
					<ul>
						<li>
							<div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">
										检索
									</button>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
			<li><a class="add" href="${AppBase}?command=addview" target="navTab"><span>添加</span></a></li>
				<li class="line">
					line
				</li>
				<li>
					<a class="add" href="${AppBase}?command=adddialog" target="dialog"
						rel="add" mask="true"><span>添加</span> </a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="delete" href="${AppBase}?command=delete&&uid={sid_user}"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span> </a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="edit" href="${AppBase}?command=editview&uid={sid_user}"
						target="navTab"><span>修改</span> </a>
				</li>
				<li class="line">
					line
				</li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="50">
						序号
					</th>
					<th width="80">
						用户组名称
					</th>
					<th width="300">
						描述
					</th>
					<th width="150">
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${allGroup.list}" varStatus="t">
					<tr target="sid_user" rel="${g.id}">
						<td>
							${t.index+1}
						</td>
						<td>
							${g.role_name}
						</td>
						<td>
							${g.role_name}
						</td>
						<td>
							<a href="${AppBase}?command=editview&uid=${g.id}" target="navTab">
								<img title="修改"
									src="${base}/themes/default/images/icon/tico_edit.gif"
									value="修改">修改</img> </a>
							<a href="${AppBase}?command=delete&&uid=${g.id}"> <img
									title="删除"
									src="${base}/themes/default/images/icon/tico_delete.gif" />删除</img>
							</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>共${allGroup.rowCount}条 </span>
			</div>

			<div class="pagination" targetType="navTab"
				totalCount="${allGroup.rowCount}" numPerPage="20" pageNumShown="10"
				currentPage="${users.pageNum}"></div>
		</div>
	</div>
</div>