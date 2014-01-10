<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/project/init.jsp"%>
<c:set var="app" value="/admin/project.do"/>
              <div class="pageHeader" style="border:1px #B8D0D6 solid">
                   <div class="subBar">
                       <table class="searchContent">
                           <tr>
                               <td class="dateRange" width="300px">
                                 		  添加时间:
                                   <input type="text" value="" readonly="readonly" class="date" name="dateStart">
                                   <span class="limit">-</span>
                                   <input type="text" value="" readonly="readonly" class="date" name="dateEnd">
                               </td>
                               <td width="100px">
                                   	<select name="status"  class="combox" >
                                   		<option value="0">全部</option>
                                   		<option value="1">审核</option>
                                   		<option value="2">未审核</option>
                                   	</select>
                               </td>
                               <td>
                      				  标题：<input type="text" name="title" />
                               </td>
                               <td><div class="buttonActive"><div class="buttonContent"><button type="submit">检索</button></div></div></td>
                           </tr>
                       </table>
                   </div>
              </div>
              
              <div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
             		<div class="panelBar">
                      <ul class="toolBar">
            				<li><a class="add" href="${AppBase}?command=addimageview&projectId=${projectId}" target="navTab" rel="add" mask="true"><span>批量添加图片</span></a></li>
                          
                          <li><a class="delete" href="${AppBase}?command=delete&&projectId={sid_projectId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
                          
                          <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="projectId" postType="string" href="${AppBase}?command=delete" class="delete"><span>批量删除</span></a></li>
                          
                          <li><a class="edit" href="${AppBase}?command=editview&projectId={sid_projectId}" target="dailog" mask="true"><span>修改</span></a></li>
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
                          	<th width="22"><input type="checkbox" group="projectId" class="checkboxCtrl"></th>
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
								<td><input name="projectId" value="${g.id}" type="checkbox"></td>
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
									<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&projectId=${g.id}" class="btnDel">删除</a>
									<a title="编辑" target="navTab" href="${AppBase}?command=editview&projectId=${g.id}" class="btnEdit">编辑</a>
								</td>
							</tr>
							</c:forEach>
                      </tbody>
                  </table>
              </div>
