<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<c:set var="app" value="/admin/honour.do"/>
<form id="pagerForm" method="POST" action="${AppBase}?page=ture">
	<input type="hidden" name="pageNum" value="${all.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>
              <div class="pageHeader" style="border:1px #B8D0D6 solid">
                   <div class="subBar">
                   <br/>
                	   <h1>管理企业荣誉</h1>
                   <br/>
                   </div>
              </div>
              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" mask="true"><span>添加荣誉业绩</span></a></li>
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
								<th width="50">序号</th>
								<th width="400">名称</th>
								<th width="120">发布人</th>
								<th width="120">更新时间</th>
								<th width="140">奖状数量</th>
								<th width="140">操作</th>
                          </tr>
                      </thead>
                      <tbody>
                      	<c:forEach var="g" items="${all.list}" varStatus="t">
                      		<tr target="sid_honourId" rel="${g.id}">
                      		<td>
										${t.index+1}
								</td>	
								<td>
										${g.name}
								</td>
								<td>${g.realname}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.updatetime}"/>
								</td>
								<td>
									${g.count } 个
								</td>
								<td>
									<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&honourId=${g.id}" class="btnDel">删除</a>
									<a title="编辑" target="navTab" href="${AppBase}?command=editview&honourId=${g.id}" class="btnEdit">编辑</a>
								</td>
							</tr>
							</c:forEach>
                      </tbody>
                  </table>
                  <div class="panelBar">
                      <div class="pages">
                         	<span>共${all.rowCount}条</span>
                      </div>
                      <div class="pagination" targetType="navTab" rel="" totalCount="${all.rowCount}" numPerPage="20" pageNumShown="5" currentPage="${all.pageNum}"></div>
                  </div>
              </div>
