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
			<h2><span>管理企业文化板块内容</span></h2>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" ><span>添加</span></a></li>
				
				<li><a title="确实要设置排序吗?" target="selectedTodo" rel="sortNum" postType="string" href="${AppBase}?command=sort" class="delete"><span>设置排序</span></a></li>
				
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="50">序号</th>
					<th width="200">标题</th>
					<th width="220"><input type="checkbox" name="ctrl" group="sortNum"  class="checkboxCtrl">
					排序</th>
					<th width="120">发布人</th>
					<th width="120">类型</th>
					<th width="140">更新时间</th>
					<th width="140">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${allCulture}" varStatus="t">
					<tr target="sid_user" rel="${g.id}">
						<td>${t.index+1}</td>
						<td>${g.name}</td>
						<td><input id="box${g.id}" type="checkbox" name="sortNum" group="sortNum"  value="${g.id}:${g.sort}" size="10">
							<input id="sortText${g.id}" type="text" name="sortNum" group="sortNum"  value="${g.sort}" size="15" onchange="typeSortUtil(${g.id},this.value);"></td>
						<td>${g.realname}</td>
						<Td>${g.is_static eq 1?"静态页面":"列表页面"}</Td>
						<td>
						<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.updatetime}"/>
						</td>
						<td>
							<a title="编辑" target="navTab" href="${AppBase}?command=editview&cultureId=${g.id}" class="btnEdit">编辑</a>
							<c:if test="${g.isStatic!= 1}">
							<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&cultureId=${g.id}" class="btnDel">删除</a>
							</c:if>
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