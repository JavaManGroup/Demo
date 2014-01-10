<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<form id="pagerForm" method="post" action="${AppBase}?command=list">
	<input type="hidden" name="pageNum" value="${demo.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>

<div class="page">
	<div class="pageHeader">
		<form onsubmit="return navTabSearch(this);"	action="${AppBase}?command=search" method="post">
			<div class="searchBar">
			<h2><span>系统用户管理</span></h2>
			<table class="searchContent">
				<tr>
					<td><span>姓名：</span><input type="text" name="realName" /></td>
					<td>用户类型：</td>
					<td>
						<select class="combox" name="userRole">
							<option value="0">用户类型</option>
							<option value="1">管理员</option>
							<option value="2">编辑</option>
						</select>
					</td>
					<td><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div>	</td>
				</tr>
			</table>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" ><span>添加</span></a></li>
				<li class="line">line</li>
				<li><a class="delete" href="${AppBase}?command=delete&&demoId={sid_newsid}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="edit" href="${AppBase}?command=editview&demoId={sid_newsid}" target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="50">序号</th>
					<th width="80">用户组名称</th>
					<th width="300">描述	</th>
					<th width="150">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${allDemo.list}" varStatus="t">
					<tr target="sid_user" rel="${g.id}">
						<td>${t.index+1}</td>
						<td>${g.role_name}</td>
						<td>${g.role_name}</td>
						<td>
							<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&demoId=${demo.id}" class="btnDel">删除</a>
							<a title="编辑" target="navTab" href="${AppBase}?command=editview&demoId=${demo.id}" class="btnEdit">编辑</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="panelBar">
			<div class="pages">
				<span>共${allDemo.rowCount}条 </span>
			</div>

			<div class="pagination" targetType="navTab"
				totalCount="${allDemo.rowCount}" numPerPage="20" pageNumShown="10"
				currentPage="${demo.pageNum}"></div>
		</div>
	</div>
</div>