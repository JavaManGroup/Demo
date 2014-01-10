<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<c:set var="app" value="/admin/project.do"/>
<form id="pagerForm" method="post" action="${AppBase}">
	<input type="hidden" name="pageNum" value="${allproject.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>
              <div class="pageHeader" style="border:1px #B8D0D6 solid">
                   <div class="subBar">
                     	<h1>管理精品工程分类</h1>
                   </div>
              </div>
              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" mask="true"><span>添加工程分类</span></a></li>
                          
                          <li><a class="delete" href="${AppBase}?command=delete&&protypeId={sid_protypeId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                          
                          <li><a class="edit" href="${AppBase}?command=editview&protypeId={sid_protypeId}" target="dailog" mask="true"><span>修改</span></a></li>
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
								<th width="50">序号</th>
								<th width="400">名称</th>
								<th width="120">发布人</th>
								<th width="140">工程数量</th>
								<th width="80">首页显示</th>
								<th width="140">操作</th>
                          </tr>
                      </thead>
                      <tbody>
                      	<c:forEach var="g" items="${allProtype}" varStatus="t">
                      		<tr target="sid_protypeId" rel="${g.id}">
								<td>${t.index+1}</td>
								<td>
								<a href="${AppBase}?command=view&protypeId=${g.id}" target="navTab" rel="view">
										${g.name}
								</a>
								</td>
								<td>李浩</td>
								<td>${g.count }
								</td>
								<td>
									${g.is_home eq 1 ?"首页显示":"不显示" }
								</td>
								<td>
									<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&protypeId=${g.id}" class="btnDel">删除</a>
									<a title="编辑" target="navTab" href="${AppBase}?command=editview&protypeId=${g.id}" class="btnEdit">编辑</a>
								</td>
							</tr>
							</c:forEach>
                      </tbody>
                  </table>
              </div>
