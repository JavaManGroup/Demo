<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/event/init.jsp"%>
<form id="pagerForm" method="post" action="${AppBase}?command=list">
	<input type="hidden" name="pageNum" value="${allEvent.pageNum }" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>我的客户：</label>
				<input type="text" name="keywords" value=""/>
			</li>
			<li>
			<select class="combox" name="province">
				<option value="">所有省市</option>
				<option value="北京">北京</option>
				<option value="上海">上海</option>
				<option value="天津">天津</option>
				<option value="重庆">重庆</option>
				<option value="广东">广东</option>
			</select>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></li>
				<li><a class="button" href="demo_page6.html" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${AppBase}?command=addview" target="navTab"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html" class="delete"><span>批量删除默认方式</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="demo/common/ajaxDone.html" class="delete"><span>批量删除逗号分隔</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="请选择一个用户"><span>修改</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>序号</th>
				<th>主题</th>
				<th>发布者</th>
				<th>参与人数</th>
				<th>地点</th>
				<th>是否公开</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="e" items="${allEvent.list}" varStatus="t">
			<tr target="sid_user" rel="1">
				<td><input name="ids" value="xxx" type="checkbox"></td>
				<td>${t.index+1}</td>
				<td>${e.title}</td>
				<td>${e.nick}</td>
				<td>${e.count}</td>
				<td>${e.place}</td>
				<td>${e.privilege == 1 ?'公开':"私有"}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${e.starttime}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${e.endtime}"/></td>
				<td>
					<a title="删除" target="ajaxTodo" href="demo/common/ajaxDone.html?id=xxx" class="btnDel">删除</a>
					<a title="编辑" target="navTab" href="demo_page4.html?id=xxx" class="btnEdit">编辑</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span> 共 ${allEvent.rowCount}条</span>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="${allEvent.rowCount}" numPerPage="20" pageNumShown="10" currentPage="${allEvent.pageNum}"></div>

	</div>
</div>
