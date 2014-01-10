<%@ tag pageEncoding="utf-8" import="com.sun.core.common.PagingList"%>

<%@ attribute name="url" type="java.lang.String" required="true"%>
<%@ attribute name="paginglist" type="com.sun.core.common.PagingList"
	required="true"%>
<%
	if (!url.contains("?")) {
		url = url + "?";
	}
%>
<%
	if (paginglist.getPageCount() > 1) {
%>
<div class="page">

	<div class="page_m" style="width: 50px;">


		<%
			if (paginglist.getPageNum() == 1) {
		%>
		上一页
		<%
			} else {
		%>
		<a href="<%=url%>pageNum=${paginglist.pageNum-1}">上一页 </a>
		<%
			}
		%>
	</div>
	<div class="page_m" style="width: 50px;">
		<%
			if (paginglist.getPageNum() == paginglist.getPageCount()) {
		%>
		下一页
		<%
			} else {
		%>
		<a href="<%=url%>pageNum=${paginglist.pageNum+1}"> 下一页 </a>
		<%
			}
		%>
	</div>
	当前<%=paginglist.getPageNum() %>页,共<%=paginglist.getPageCount() %>页
	<div class="clear"></div>
</div>
<%
	}
%>
