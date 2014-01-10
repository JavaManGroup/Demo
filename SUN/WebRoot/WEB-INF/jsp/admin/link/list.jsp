<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<form id="pagerForm" method="post" action="${AppBase}">
	<input type="hidden" name="pageNum" value="${pageLink.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"	action="${AppBase}?command=search" method="post">
			<div class="searchBar">
			<br/>
			<h2><span>管理友情链接</span></h2>
			<br/>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" ><span>添加</span></a></li>

				<li><a class="delete" href="${AppBase}?command=delete&&linkId={sid_newsid}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="50">序号</th>
					<th width="80">网站名称</th>
					<th width="300">网站链接地址</th>
					<th width="150">状 态</th>
					<th width="150">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${pageLink.list}" varStatus="t">
					<tr target="sid_user" rel="${g.id}">
						<td>${t.index+1}</td>
						<td>${g.name}</td>
						<td>${g.url}</td>
						<td>${g.status eq 1?"审核":"未审核"}</td>
						<td>
							<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&linkId=${g.id}" class="btnDel">删除</a>
							<a title="编辑" target="navTab" href="${AppBase}?command=editview&linkId=${g.id}" class="btnEdit">编辑</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>共${pageLink.rowCount}条 </span>
			</div>

			<div class="pagination" targetType="navTab"
				totalCount="${pageLink.rowCount}" numPerPage="20" pageNumShown="10"
				currentPage="${pageLink.pageNum}"></div>
		</div>
	</div>
</div>