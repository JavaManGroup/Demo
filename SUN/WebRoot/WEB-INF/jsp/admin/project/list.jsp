<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/project/init.jsp"%>
<c:set var="app" value="/admin/project.do"/>
<form id="pagerForm" method="POST" action="${AppBase}?page=ture">
	<input type="hidden" name="pageNum" value="${allproject.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>
              <div class="pageHeader" style="border:1px #B8D0D6 solid">
                   <div class="subBar">
                   	<form action="${AppBase}?page=false" method="post" onsubmit="return navTabSearch(this);">
                       <table class="searchContent">
                           <tr>
                               <td width="220px">
                    		                标题：<input type="text" name="title" />
                               </td>
                               <td width="100px">
                                   	<select name="status"  class="combox" >
                                   		<option value="999">精品推荐</option>
                                   		<option value="1">推荐</option>
                                   		<option value="0">不推荐</option>
                                   	</select>
                               </td>
                               <td width="100px">
                                   	<select name="typeId"  class="combox" >
                                   		<option value="0">全部</option>
                                   		<c:forEach var="t" items="${allProtype}">
                                   		<option value="${t.id}">${t.name}</option>
                                   		</c:forEach>
                                   	</select>
                               </td>
                               <td>
                               </td>
                               <td><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></td>
                           </tr>
                       </table>
                       </form>
                   </div>
              </div>
              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" mask="true"><span>添加精品工程</span></a></li>
                          
                          <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="projectId" postType="string" href="${AppBase}?command=delete" class="delete"><span>删除</span></a></li>
                         
                          <li><a title="确实要精品推荐这些记录吗?" target="selectedTodo" rel="projectId" postType="string" href="${AppBase}?command=set&field=delstatus" class="delete"><span>设置精品推荐</span></a></li>
                          
                          <li><a title="确实要精品推荐这些记录吗?" target="selectedTodo" rel="projectId" postType="string" href="${AppBase}?command=set&field=addstatus" class="delete"><span>取消精品推荐</span></a></li>
                          
                          <li><a class="edit" href="${AppBase}?command=editview&projectId={sid_projectId}" target="dailog" mask="true"><span>修改</span></a></li>
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
                          	<th width="35"><input type="checkbox" group="projectId" class="checkboxCtrl"></th>
								<th width="50">序号</th>
								<th width="400">名称</th>
								<th width="100">分类</th>
								<th width="120">发布人</th>
								<th width="140">更新时间</th>
								<th width="140">图片数量</th>
								<th width="80">精品推荐</th>
						<!-- 		<th width="80">首页显示</th> -->
								<th width="140">操作</th>
                          </tr>
                      </thead>
                      <tbody>
                      	<c:forEach var="g" items="${allproject.list}" varStatus="t">
                      		<tr target="sid_projectId" rel="${g.id}">
								<td><input name="projectId" value="${g.id}" type="checkbox"></td>
								<td>${t.index+1}</td>
								<td>
								<a href="${base}/project.do?command=detail&projectId=${g.id}" target="navTab" rel="external" external="true">
										${g.title}
								</a>
								</td>
								<td>${g.name}</td>
								<td>${g.author }</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.updatetime}"/>
								</td>
								<td>
									${g.count } 个|   <a title="编辑" target="navTab" href="${AppBase}?command=images&projectId=${g.id}" >管理图片</a>														
								</td>
								<td>
									<a id="isTopId${g.id}" name="${g.status}" title="${AppBase}?command=setIsTop&&status=${g.status}&&projectId=${g.id}" href="#" onclick="projectAjaxTodo(this.title,this.id,this.name,${g.id})" >${g.status eq 1 ?"精品推荐":"不推荐" }</a>
									
								</td>
								<!-- <td>
									${g.is_home eq 1 ?"首页显示":"不显示" }
								</td> -->
								<td>
									<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&projectId=${g.id}" class="btnDel">删除</a>
									<a title="编辑" target="navTab" href="${AppBase}?command=editview&projectId=${g.id}" class="btnEdit">编辑</a>
								</td>
							</tr>
							</c:forEach>
                      </tbody>
                  </table>
                  <div class="panelBar">
                      <div class="pages">
                         	<span>共${allproject.rowCount}条</span>
                      </div>
                      <div class="pagination" targetType="navTab" rel="" totalCount="${allproject.rowCount}" numPerPage="${allproject.pageSize}" pageNumShown="5" currentPage="${allproject.pageNum}"></div>
                  </div>
              </div>
