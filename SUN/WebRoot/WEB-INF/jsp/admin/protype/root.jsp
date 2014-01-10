<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/protype/init.jsp"%>
<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block; margin-left:5px}
</style>
<form id="pagerForm" method="post" action="${AppBase}">
	<input type="hidden" name="pageNum" value="${allUsers.pageNum}">
	<input type="hidden" name="status" value="300">
	<input type="hidden" name="keywords" value="1" />
	<input type="hidden" name="orderField" value="" />
</form>

<div style="padding:1px">
	<div class="panel" defH="13">
		<h1>当前位置：</h1>
		<div>
			内容 > 内容发布管理 > 管理内容
		</div>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>管理内容</span></a></li>
					<li><a href="javascript:;"><span>首页显示</span></a></li>
					<li><a href="javascript:;"><span>静态页面</span></a></li>
					<li><a href="javascript:;"><span>文章审核</span></a></li>
					<li><a href="javascript:;"><span>回收站</span></a></li>
				</ul>
			</div>
		</div>
		<div class="tabsContent">
			<!-- tabs1 start -->
			<div>
	
				<div layoutH="176" style="float:left; display:block; overflow:auto; width:180px; border:solid 1px #CCC; line-height:21px; background:#fff">
				    <ul class="tree treeFolder">
						<li><a href="javascript">站内新闻（分类）</a>
							<ul>
								<c:forEach var="type" items="${allType}">
								<li><a href="${AppBase}?command=list&typeId=${type.id}" target="ajax" rel="jbsxBox">${type.name}</a></li>
								</c:forEach>
							</ul>
						</li>
						
				     </ul>
				</div>
				
				<div id="jbsxBox" style="margin-left:186px;">
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
	              				<li><a class="add" href="${AppBase}?command=addview" target="navTab" rel="add" mask="true"><span>添加新闻</span></a></li>
	                            
	                            <li><a class="delete" href="${AppBase}?command=delete&&newsId={sid_newsId}" target="ajaxTodo" title="确定要删除吗?"><span>删除</span></a></li>
	                            
	                            <li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="newsId" postType="string" href="${AppBase}?command=delete" class="delete"><span>批量删除</span></a></li>
	                            
	                            <li><a class="edit" href="${AppBase}?command=editview&newsId={sid_newsId}" target="dailog" mask="true"><span>修改</span></a></li>
	                        </ul>
	                    </div>
	                    <table class="table" width="850px" layoutH="220">
	                        <thead>
	                            <tr>
	                            	<th width="22"><input type="checkbox" group="newsId" class="checkboxCtrl"></th>
						<th width="50">序号</th>
						<th width="400">标题</th>
						<th width="120">发布人</th>
						<th width="140">更新时间</th>
						<th width="80">状态</th>
						<th width="80">是否置顶</th>
						<th width="140">操作</th>
	                            </tr>
	                        </thead>
	                        <tbody>
					<c:forEach var="g" items="${allNews.list}" varStatus="t">
					<tr target="sid_newsId" rel="${g.id}">
						<td><input name="newsId" value="${g.id}" type="checkbox"></td>
						<td>${t.index+1}</td>
						<td>
						<a href="${AppBase}?command=view&newsId=${g.id}" target="navTab" rel="view">
								${g.title}
						</a>
						</td>
						<td>${g.realname}</td>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${g.UPDATETIME}"/>
						</td>
						<td>
						    <c:choose>
						      <c:when test="${g.state==1}">审核
						      </c:when>
						      <c:otherwise>未审核
						      </c:otherwise>
						    </c:choose>
						</td>
						<td>
						    <c:choose>
						      <c:when test="${g.top==1}">置顶
						      </c:when>
						      <c:otherwise>不置顶
						      </c:otherwise>
						    </c:choose>
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
	                        <div class="pagination" targetType="navTab" rel="" totalCount="${allNews.rowCount}" numPerPage="20" pageNumShown="5" currentPage="${allNews.pageNum}"></div>
	                    </div>
	                </div>
				</div>
			</div>
	
			<!-- tabs1 end -->
			<!-- tabs2 start -->
			<div>首页显示</div>
			<!-- tabs2 end -->
			<!-- tabs3 start -->
			<div>静态网页</div>
			<!-- tabs3 end -->
			<!-- tabs4 start -->
			<div>基线调查</div>
			<!-- tabs4 end -->
			<!-- tabs4 start -->
			<div>基线调查</div>
			<!-- tabs4 end -->
		</div>
		<div class="tabsFooter">
			<div class="tabsFooterContent"></div>
		</div>
	</div>
	
</div>


	

