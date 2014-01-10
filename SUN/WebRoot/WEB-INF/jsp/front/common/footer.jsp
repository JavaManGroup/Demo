<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/taglibs.jsp" %>
		<div id="banner_bg">
		<div class="banner_text">
			<p><a href="index.html">返回首页</a> | <a href="about.do">关于我们</a> | <a href="zhaopin.do">人才招聘</a> | <a href="contact.do">联系我们</a></p>
			<p>友情链接：
			<c:forEach items="${links}" var="l"><a href="${l.url}" target="new">${l.name}   </a> </c:forEach>
			</p>
		</div>
	</div>
	<p style="text-align:center;">大连正泰开宇装饰有限公司 版权所有. ZHETAI KAIYU DECORATION CO.LTD All rights reserved. 技术支持：国信致远计算机团队</p>