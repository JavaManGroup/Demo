<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大连正泰开宇装饰有限公司</title>
<link href="front/css/public.css" rel="stylesheet" type="text/css" />
<link href="front/css/index.css" rel="stylesheet" type="text/css" />
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
				<div style="text-align:right;">
				<A href="#" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://yasha.v6.jspzg.com.cn');" title=设置本站为浏览器首页(启始页)>设为首页</A><A href="#" onclick="javascript:window.external.AddFavorite('http://yasha.v6.jspzg.com.cn','『大连正泰开宇装饰有限公司』')" title=收藏本站到你的收藏夹"> | 收藏本站</A></div>
			</div>
			</form>

		</div>
	</div>
	<div id="nevigation_bg">
		<%@ include file="/commons/banner.jsp" %>
	</div>
	 
	<div class="main">
		<div class="main_1">
			<div class="border1_left">
				<div class="border1_right">
					<div class="border1_middle">
						<div class="title">${homeType1.name}</div>
						<a href="project.do?command=list&typeId=${homeType1.id}"><div class="more"></div></a>
						<div class="border5_left">
							<div class="border5_right">
								<div class="border5_middle">
									<table border="0" align="center" cellpadding="0" cellspacing="0">
										<tr align="center" valign="middle">
											<td height="166"><img src="${base}${homeType1.image}" height="161"/></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="text">
						<c:forEach var="p" items="${homeProject1}" end="5">
							<p><a href="project.do?command=detail&projectId=${p.id}">${fn:substring(p.title, 0, 16)}</a></p>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="border1_left">
				<div class="border1_right">
					<div class="border1_middle">
						<div class="title_2">${homeType2.name}</div>
						<a href="project.do?command=list&typeId=${homeType2.id}"><div class="more"></div></a>
						<div class="border5_left">
							<div class="border5_right">
								<div class="border5_middle">
									<table border="0" align="center" cellpadding="0" cellspacing="0">
										<tr align="center" valign="middle">
											<td height="166"><img src="${base}${homeType2.image}" height="162"/></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="text">
						<c:forEach var="p" items="${homeProject2}" end="5">
							<p><a href="project.do?command=detail&projectId=${p.id}">${fn:substring(p.title, 0, 16)}</a></p>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="border1_left">
				<div class="border1_right">
					<div class="border1_middle">
						<div class="title_3">${homeType3.name}</div>
						<a href="project.do?command=list&typeId=${homeType3.id}"><div class="more"></div></a>
						<div class="border5_left">
							<div class="border5_right">
								<div class="border5_middle">
									<table border="0" align="center" cellpadding="0" cellspacing="0">
										<tr align="center" valign="middle">
											<td height="166"><img src="${base}${homeType3.image}" height="162" /></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="text">
						<c:forEach var="p" items="${homeProject3}" end="5">
							<p><a href="project.do?command=detail&projectId=${p.id}">${fn:substring(p.title, 0, 16)}</a></p>
						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main_2">
			<div class="border2_left">
				<div class="border2_right">
					<div class="border2_middle">
						<div class="title_4">精品推荐</div>
						<a href="project.do" ><div class="more"></div></a>
						<div class="border5_left">
							<div class="border5_right">
								<div class="border5_middle">
									<table border="0" align="center" cellpadding="0" cellspacing="0">
										<tr align="center" valign="middle">
											<td height="166"><img src="front/img/index/4.jpg" /></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="text" style="margin-top:1px;">
							<c:forEach var="p" items="${topProject}" end="5">
								<p><a href="project.do?command=detail&projectId=${p.id}">${fn:substring(p.title, 0, 16)}</a></p>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<div class="border3_left">
				<div class="border3_right">
					<div class="border3_middle">
						<div class="title_5">新闻</div>
						<a href="news.do">
						<div class="more"></div></a>
						<div class="border6_left">
							<div class="border6_right">
								<div class="border6_middle">
									<table border="0" align="center" cellpadding="0" cellspacing="0">
										<tr align="center" valign="middle">
											<td height="66"><img src="front/img/index/5.jpg" /></td>
										</tr>
									</table>
								</div>
							</div>
						</div>
						<div class="text" style="margin-top:-2px; width:248px;">
							<c:forEach var="p" items="${topNews}" end="5">
								<p><a href="news.do?command=detail&newsId=${p.id}" >${fn:substring(p.title, 0, 16)}</a></p>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main_3">
			<div class="border4_left">
				<div class="border4_right">
					<div class="border4_middle">
						<div class="title_d">联系方式</div>
						<div class="more" style="background:none;"></div>
						<div class="clear"></div>
						<div class="phone" style="margin-left:4px;">
							<div class="phone_text">
								<p>联系电话：</p>
								<p>${contact.phone}</p>
							</div>
						</div>
						<div class="text" style="margin-top:-2px; width:163px;">
							<p>大连正泰开宇装饰有限公司</p>
							<p>地址：${contact.address}</p>
							<p>E-mail：${contact.email}</p>
							<p>电话：${contact.phone}</p>
							<p>传真：${contact.fax}</p>
							<p>邮编：${contact.postcode}</p>
						</div>
					</div>
				</div>
			</div>
			<div style="margin-top:6px;"><img src="front/img/index/6.jpg" width="180" height="105" /></div>
			<div style="margin-top:8px;"><img src="front/img/index/7.jpg" width="180" height="105" /></div>
			<div style="margin-top:8px;"><img src="front/img/index/8.jpg" width="180" height="105" /></div>
		</div>
		<div class="clear"></div>
	</div>
	<%@include file="common/footer.jsp" %>
</div>
</body>
</html>
