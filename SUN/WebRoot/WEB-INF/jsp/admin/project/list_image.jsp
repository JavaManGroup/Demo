<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/project/init.jsp"%>
<c:set var="app" value="/admin/project.do"/>
              <div class="pageHeader" style="border:1px #B8D0D6 solid">
              <br/>
              		<h1>管理精品工程图片</h1>
              		<br/>
              </div>
              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}?command=addimageview&projectId=${projectId}" target="navTab" rel="add" mask="true"><span>批量添加图片</span></a></li>
                          
                          <li><a class="delete" href="${AppBase}?command=deleteimages&&imageId={sid_imageId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                          
                          <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="imageId" postType="string" href="${AppBase}?command=deleteimages" class="delete"><span>批量删除</span></a></li>
                          
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
                          	<th width="22"><input type="checkbox" group="imageId" class="checkboxCtrl"></th>
								<th width="50">序号</th>
								<th width="400">名称</th>
								<th width="120">发布人</th>
								<th width="80">状态</th>
								<th width="80">首页显示</th>
								<th width="140">操作</th>
                          </tr>
                      </thead>
                      <tbody>
                      	<c:forEach var="g" items="${images}" varStatus="t">
                      		<tr target="sid_projectId" rel="${g.id}">
								<td><input name="imageId" value="${g.id}" type="checkbox"></td>
								<td>${t.index+1}</td>
								<td>
								<a href="${AppBase}?command=view&projectId=${g.id}" target="navTab" rel="view">
										${g.title }
								</a>
								</td>
								<td>李浩</td>
								<td>
									${g.status eq 1 ?"精品推荐":"不推荐" }
								</td>
								<td>
									<img alt="" src="${base}/uploads/${g.image_url}" height="100%" width="50px" />
								</td>
								<td>
									<a title="删除" target="ajaxTodo" href="${AppBase}?command=deleteimages&&imageId=${g.id}" class="btnDel">删除</a>
								</td>
							</tr>
							</c:forEach>
                      </tbody>
                  </table>
              </div>
