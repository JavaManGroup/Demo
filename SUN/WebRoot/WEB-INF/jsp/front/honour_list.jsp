<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大连正泰开宇装饰有限公司</title>
<link href="${base}/front/css/public.css" rel="stylesheet" type="text/css" />
<link href="${base}/front/css/art.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">
	<div id="top_bg">
		<div id="top">
				<div style="position:absolute; top:110px; left:820px; z-index: 1;">
			<form action="search.do" method="post">
			<div style="position:absolute; top:3px; left:-80px;">
						<select name="typeId" id="asd">
							<option value="1">新闻搜索</option>
							<option value="2">精品工程</option>
							<option value="3">人才招聘</option>
						</select>
					</div>
		<div class="top_search">
			<input type="text" name="s" id="xxx" />
			<input type="submit" value="搜索" style="display: none;"/>
		</div>
		</form>
</div>
			<div class="top_logo"></div>
			<form action="search.do" method="post">
			<div class="top_font">
				<div style="text-align:right;"><A href="#" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://yasha.v6.jspzg.com.cn');" title=设置本站为浏览器首页(启始页)>设为首页</A><A href="#" onclick="javascript:window.external.AddFavorite('http://yasha.v6.jspzg.com.cn','『大连正泰开宇装饰有限公司』')" title=收藏本站到你的收藏夹"> | 收藏本站</A></div>
				

			</div>
			</form>
		</div>
	</div>
	<div id="nevigation_bg">
		<%@ include file="/commons/banner.jsp" %>
	</div>
  
	<div class="main">
		<div class="main_1">
			<div class="banner_rongyu">
				<div class="banner_box">
					<c:forEach var="t" items="${allType}">
						<div class="banner_button"><a href="honour.do?command=list&typeId=${t.id}">${t.name }</a></div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="main_2">
			<div>
				<div class="title_left">
					<div class="title_right">
						<div class="title_middle">
							<div class="news_title">现在的位置：荣誉业绩 &gt;&gt; ${typeId == 1?"企业荣誉":""}${typeId == 2?"获得奖项":""}${typeId == 3?"工程业绩":""}</div>
							<a href="honour.do"><div class="more"></div></a>
						</div>
					</div>
				</div>
				<div class="news_2">
					<c:forEach var="p" items="${allHonour}">
						
						<div class="art_box">
						
						<div class="art_left">
							<div class="art_right">
								<div class="art_middle">
								<a title="1" href="project.do?command=detail&projectId=${p.id}" >
								<img src="${base}/front/img/art/1.jpg" width="171" height="117" />
								</a>
								</div>
							</div>
						</div>
						<table border="0" cellpadding="0" cellspacing="0"><tr><td width="186" align="center" valign="middle">${fn:substring(p.title, 0, 16)}</td></tr></table>
						
					</div>
					</c:forEach>
					<div class="clear"></div>
				</div>
			</div>
			<div class="page">
				<div class="page_m"><<</div>
				<div class="page_m" style="width:50px;">上一页</div>
				<div class="page_m">1</div>
				<div class="page_m" style="width:50px;">下一页</div>
				<div class="page_m">>></div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<%@include file="common/footer.jsp" %>
</div>
</body>
</html>

