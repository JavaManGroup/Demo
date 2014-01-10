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
			<h2><span>管理列表页文章</span></h2>
			</div>
		</form>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${AppBase}?command=addcontentview&url=${url}" target="navTab" rel="add" ><span>添加</span></a></li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="50">序号</th>
					<th width="400">标题</th>
					<th width="120">发布人</th>
					<th width="140">更新时间</th>
					<th width="140">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${allCulture}" varStatus="t">
					<tr target="sid_user" rel="${g.id}">
						<td>${t.index+1}</td>
						<td>${g.title}</td>
						<td>${g.realname}</td>
						<td>
						<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.updatetime}"/>
						</td>
						<td>
							<a title="编辑" target="navTab" href="${AppBase}?command=editcontentview&contentId=${g.id}&url=${url}" class="btnEdit">编辑</a>
							<c:if test="${g.static!= 1}">
							<a title="删除" target="ajaxTodo" href="${AppBase}?command=deletecontent&&contentId=${g.id}&url=${url}" class="btnDel">删除</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>