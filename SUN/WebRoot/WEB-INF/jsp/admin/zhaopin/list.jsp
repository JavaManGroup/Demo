<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<form id="pagerForm" method="post" action="${AppBase}">
	<input type="hidden" name="pageNum" value="${allNews.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>
              <div class="pageHeader" style="border:1px #B8D0D6 solid">
                   <div class="subBar">
                       <h1>管理人才招聘</h1>
                   </div>
              </div>
              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" mask="true"><span>添加招聘</span></a></li>
                          
                          <li><a class="delete" href="${AppBase}?command=delete&&zhaopinId={sid_zhaopinId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                          
                          <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="zhaopinId" postType="string" href="${AppBase}?command=delete" class="delete"><span>批量删除</span></a></li>
                          
                          <li><a class="edit" href="${AppBase}?command=editview&zhaopinId={sid_zhaopinId}" target="navTab"  mask="true"><span>修改</span></a></li>
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
                          	<th width="30"><input type="checkbox" group="zhaopinId" class="checkboxCtrl"></th>
								<th width="50">序号</th>
								<th width="400">标题</th>
								<th width="120">发布人</th>
								<th width="140">更新时间</th>
								<th width="140">操作</th>
                          </tr>
                      </thead>
                      <tbody>
		<c:forEach var="g" items="${list.list}" varStatus="t">
		<tr target="sid_zhaopinId" rel="${g.id}">
			<td><input name="zhaopinId" value="${g.id}" type="checkbox"></td>
			<td>${t.index+1}</td>
			<td>
			<a href="/zhaopin.do?command=detail&zhaopinId=${g.id}" target="navTab" rel="external" external="true">
					${g.title}
			</a>
			</td>
			<td>${g.realname}</td>
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.UPDATETIME}"/>
			</td>
			<td>
				<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&zhaopinId=${g.id}" class="btnDel">删除</a>
				<a title="编辑" target="navTab" href="${AppBase}?command=editview&zhaopinId=${g.id}" class="btnEdit">编辑</a>									
			</td>
		</tr>
		</c:forEach>
                      </tbody>
                  </table>
                  <div class="panelBar">
                      <div class="pages">
                         	<span>共${list.rowCount}条</span>
                      </div>
                      <div class="pagination" targetType="navTab" rel="" totalCount="${list.rowCount}" numPerPage="20" pageNumShown="5" currentPage="${list.pageNum}"></div>
                  </div>
              </div>
