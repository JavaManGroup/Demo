<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/group/init.jsp"%>
<form id="pagerForm" method="post" action="${AppBase}?command=list">
	<input type="hidden" name="pageNum" value="${allGroup.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="page">
	<div class="pageHeader">
	<br/>
		<h1>用户组管理</h1>
		<br/>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li class="line">
					line
				</li>
				<li>
					<a class="add" href="${AppBase}?command=adddialog"
						target="dialog" rel="add" mask="true"><span>添加</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="delete"
						href="${AppBase}?command=delete&&groupId={sid_group}"
						target="ajaxTodo" title="确定要删除吗?"><span>删除</span>
					</a>
				</li>
				<li class="line">
					line
				</li>
				<li>
					<a class="edit"
						href="${AppBase}?command=editview&groupId={sid_group}"
						target="navTab"><span>修改</span>
					</a>
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
					<tr target="sid_group" rel="${g.id}">
						<td>
							${t.index+1}
						</td>
						<td>
							${g.group_name}
						</td>
						<td>
							${g.group_des}
						</td>
						<td>
							<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&groupId=${g.id}" class="btnDel">删除</a>
							<a title="编辑" target="navTab" href="${AppBase}?command=editview&groupId=${g.id}" class="btnEdit">编辑</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>