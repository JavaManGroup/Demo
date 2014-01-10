<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/type/init.jsp"%>

<div class="page">
	<div class="pageHeader">
			<div class="searchBar">
				<br>
					<h1>管理本站新闻分类</h1>
				<br/>
			</div>
	</div>
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" ><span>添加新闻分类</span></a></li>
				
				<li><a class="delete" href="${AppBase}?command=delete&&newsid={sid_newsid}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>

				<li><a title="确实要设置排序吗?" target="selectedTodo" rel="sortNum" postType="string" href="${AppBase}?command=sort" class="delete"><span>设置排序</span></a></li>

				<li><a class="edit" href="${AppBase}?command=editview&newsid={sid_newsid}" target="navTab"><span>修改</span></a></li>
			</ul>
		</div>
		<table class="table" width="100%" layoutH="138">
			<thead>
				<tr>
					<th>
						序号
					</th>
					<th>
						名称
					</th>
					<th >
						<input type="checkbox" name="ctrl" group="sortNum"  class="checkboxCtrl">
						排序
					</th>
					<th >
						修改时间
					</th>
					<th>
						创建用户
					</th>
					<th>
						是否为静态页
					</th>
					<th>
						主页显示
					</th>
					<th>
						操作
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="g" items="${allType}" varStatus="t">
					<tr target="sid_user" rel="${g.id}">
						<td>
							${t.index+1}
						</td>
						<td>
							${g.name}
						</td>
						<td>
							<input id="box${g.id}" type="checkbox" name="sortNum" group="sortNum"  value="${g.id}:${g.sort}" size="10">
							<input id="sortText${g.id}" type="text" name="sortNum" group="sortNum"  value="${g.sort}" size="15" onchange="typeSortUtil(${g.id},this.value);">
						</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.UPDATETIME}"/>
						</td>
						<td>
							${g.realname}
						</td>
						<td>
							${g.is_static==1?'普通分类':'静态页面'}
						</td>
						<td>
							${g.is_banner eq "1" ?"主页显示":"不显示"}
						</td>
						<td>
							<a title="编辑" target="navTab" href="${AppBase}?command=editview&typeId=${g.id}" class="btnEdit">编辑</a>	
							<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&typeId=${g.id}" class="btnDel">删除</a>														
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</div>