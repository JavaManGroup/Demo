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
                   	<form action="${AppBase}?page=false" method="post" onsubmit="return navTabSearch(this);">
                       <table class="searchContent">
                           <tr>
                               <td width="220px">
                    		                标题：<input type="text" name="title" />
                               </td>
                               <td width="100px">
                                   	<select name="isTop"  class="combox" >
                                   		<option value="999">是否置顶</option>
                                   		<option value="1">置顶</option>
                                   		<option value="0">不置顶</option>
                                   	</select>
                               </td>
                               <td width="100px">
                                   	<select name="isHome"  class="combox" >
                                   		<option value="999">是否首页显示</option>
                                   		<option value="1">显示</option>
                                   		<option value="0">不显示</option>
                                   	</select>
                               </td>
                               <td width="100px">
                                   	<select name="typeId"  class="combox" >
                                   		<option value="0">全部</option>
                                   		<c:forEach var="t" items="${allType}">
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
            				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" mask="true"><span>添加新闻</span></a></li>
                          
                          <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="newsId" postType="string" href="${AppBase}?command=delete" class="delete"><span>批量删除</span></a></li>
                          
                      </ul>
                  </div>
                  <table class="table" width="100%" layoutH="118">
                      <thead>
                          <tr>
                          	<th width="30"><input type="checkbox" group="newsId" class="checkboxCtrl"></th>
								<th width="50">序号</th>
								<th width="400">标题</th>
								<th width="120">发布人</th>
								<th width="120">分类</th>
								<th width="140">更新时间</th>
				<!-- 			<th width="80">是否置顶</th> -->	
								<th width="80">首页显示</th>
								<th width="140">操作</th>
                          </tr>
                      </thead>
                      <tbody>
		<c:forEach var="g" items="${allNews.list}" varStatus="t">
		<tr target="sid_newsId" rel="${g.id}">
			<td><input name="newsId" value="${g.id}" type="checkbox"></td>
			<td>${t.index+1}</td>
			<td>
			<a href="/news.do?command=detail&newsId=${g.id}" target="navTab" rel="external" external="true">
					${g.title}
			</a>
			</td>
			<td>${g.realname}</td>
			<td>${g.name}</td>
			<td>
				<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.UPDATETIME}"/>
			</td>
<!-- 		<td>
				${g.is_top eq 1 ?"置顶":"不置顶" }
			</td> -->	
			<td>
				<a id="isHomeId${g.id}" name="${g.is_home}" title="${AppBase}?command=setIsHome&&status=${g.is_home}&&newsId=${g.id}&&pageNum=${pageNum}" href="#" onclick="newsAjaxTodo(this.title,this.id,this.name,${g.id})" >${g.is_home eq 1 ?"首页显示":"不显示" }</a>
			</td>
			<td>
				<a title="删除" target="ajaxTodo" href="${AppBase}?command=delete&&newsId=${g.id}" class="btnDel">删除</a>
				<a title="编辑" target="navTab" href="${AppBase}?command=editview&newsId=${g.id}" class="btnEdit">编辑</a>									
			</td>
		</tr>
		</c:forEach>
                      </tbody>
                  </table>
                  <div class="panelBar">
                      <div class="pages">
                         	<span>共${allNews.rowCount}条</span>
                      </div>
                      <div class="pagination" targetType="navTab" rel="" totalCount="${allNews.rowCount}" numPerPage="${allNews.pageSize}" pageNumShown="5" currentPage="${allNews.pageNum}"></div>
                  </div>
              </div>
