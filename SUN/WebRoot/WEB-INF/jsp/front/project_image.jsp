<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>大连正泰开宇装饰有限公司</title>
<link href="${base}/front/css/public.css" rel="stylesheet" type="text/css" />
<link href="${base}/front/css/art.css" rel="stylesheet" type="text/css" />
<link href="${base}/front/css/js.css" type="text/css" rel="stylesheet">	
<SCRIPT src="${base}/front/js/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="${base}/front/js/base.js" type=text/javascript></SCRIPT>

</head>

<body>
<div id="container">
	<div id="top_bg">
		<div id="top">
			<div class="top_logo"></div>
			<div class="top_font">
				<div><A href="#" onclick="this.style.behavior='url(#default#homepage)';this.setHomePage('http://yasha.v6.jspzg.com.cn');" title=设置本站为浏览器首页(启始页)>设为首页</A><A href="#" onclick="javascript:window.external.AddFavorite('http://yasha.v6.jspzg.com.cn','『大连正泰开宇装饰有限公司』')" title=收藏本站到你的收藏夹"> | 收藏本站</A></div>
			</div>
		</div>
	</div>
	<div id="nevigation_bg">
		<%@ include file="/commons/banner.jsp" %>
	</div>
	<div class="main">
		<div class="main_1">
			<div class="banner">
				<div class="banner_box">
					<c:forEach var="t" items="${allType}">
						<div class="banner_button"><a href="project.do?command=list&typeId=${t.id}">${t.name }</a></div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="main_2">
			<div>
				<div class="title_left">
					<div class="title_right">
						<div class="title_middle">
							<div class="news_title">现在的位置：精品工程 &gt;&gt; ${project.name} &gt;&gt; ${project.title}</div>
							<div class="more" style="display: none;"></div>
						</div>
					</div>
				</div>
				<!--[if IE 7]>
				<script type="text/javascript">
				$(document).ready(function() 
				{
					$("#news_2").css("width","757px");
					
				});		
				</script>
				<![endif]-->
				<div id="news_2" class="news_2" style="width: 752px"> 
					<div class="news_3_title">${project.title} </div>
					<div class="clear"></div>
					<div>
					
						<div id=preview>
						
	<div class=jqzoom id=spec-n1><IMG height=350 src="${base}${project.image_path}" jqimg="${base}${project.image_path}" width=350>
	</div>
	<div id=spec-n5>
		<div class=control id=spec-left>
			<img src="${base}/front/images/left.gif" />
		</div>
		<div id=spec-list>
			<ul class=list-h>
				<c:forEach var="i" items="${allImage}">
					<li><img src="/uploads/${i.image_url}"> </li>
				</c:forEach>
				
			</ul>
		</div>
		<div class=control id=spec-right>
			<img src="${base}/front/images/right.gif" />
		</div>
		
    </div>
</div>
<SCRIPT type=text/javascript>
	$(function(){			
	   $(".jqzoom").jqueryzoom({
			xzoom:300,
			yzoom:300,
			offset:10,
			position:"right",
			preload:1,
			lens:1
		});
		$("#spec-list").jdMarquee({
			deriction:"left",
			width:550,
			height:56,
			step:2,
			speed:4,
			delay:10,
			control:true,
			_front:"#spec-right",
			_back:"#spec-left"
		});
		$("#spec-list img").bind("mouseover",function(){
			var src=$(this).attr("src");
			$("#spec-n1 img").eq(0).attr({
				src:src.replace("\/n5\/","\/n1\/"),
				jqimg:src.replace("\/n5\/","\/n0\/")
			});
			$(this).css({
				"border":"2px solid #ff6600",
				"padding":"1px"
			});
		}).bind("mouseout",function(){
			$(this).css({
				"border":"1px solid #ccc",
				"padding":"2px"
			});
		});				
	})
	</SCRIPT>

<SCRIPT src="${base}/front/js/lib.js" type=text/javascript></SCRIPT>
<SCRIPT src="${base}/front/js/163css.js" type=text/javascript></SCRIPT>
					</div>
				</div>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<%@include file="common/footer.jsp" %>
</div>
</body>
</html>

