<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div class="page">
	<div class="pageHeader">
		<h2 class="contentTitle">查看文章：${news.title}</h2>
		作者：${news.realname}&nbsp;
_&nbsp;文章分类：${news.name}
_&nbsp;发布时间：<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${news.POSTTIME}"/>
_&nbsp;修改时间：<fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${news.UPDATETIME}"/>
_&nbsp;点击量：${news.VIEWCOUNT}
_&nbsp;<c:choose>
		<c:when test="${news.STATE==1}">状态：启用
		</c:when>
		<c:otherwise>状态：禁用
		</c:otherwise>
		</c:choose>
_&nbsp;<c:choose>
		  <c:when test="${news.TOP==1}">是否置顶：置顶
		  </c:when>
		  <c:otherwise>是否置顶：不置顶
		  </c:otherwise>
		</c:choose>
	</div>
	<div class="pageContent" layoutH="67" >
			${news.content}
	</div>
</div>