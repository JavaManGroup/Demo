<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/root/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<title>大连正泰开宇网站管理系统

</title>

<link href="${base}/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="${base}/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="${base}/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" />

<script src="${base}/js/speedup.js" type="text/javascript"></script>
<script src="${base}/js/util.js" type="text/javascript"></script>
<script src="${base}/js/jquery-1.4.4.js" type="text/javascript"></script>
<script src="${base}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${base}/js/jquery.validate.js" type="text/javascript"></script>
<script src="${base}/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${base}/xheditor/xheditor-1.1.9-zh-cn.min.js" type="text/javascript"></script>
<script src="${base}/uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="${base}/uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>


<script src="${base}/js/dwz.core.js" type="text/javascript"></script>
<script src="${base}/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${base}/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${base}/js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="${base}/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.drag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.tree.js" type="text/javascript"></script>
<script src="${base}/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${base}/js/dwz.ui.js" type="text/javascript"></script>
<script src="${base}/js/dwz.theme.js" type="text/javascript"></script>
<script src="${base}/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${base}/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${base}/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${base}/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${base}/js/dwz.tab.js" type="text/javascript"></script>
<script src="${base}/js/dwz.resize.js" type="text/javascript"></script>
<script src="${base}/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${base}/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${base}/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${base}/js/dwz.stable.js" type="text/javascript"></script>
<script src="${base}/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${base}/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${base}/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${base}/js/dwz.database.js" type="text/javascript"></script>
<script src="${base}/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${base}/js/dwz.effects.js" type="text/javascript"></script>
<script src="${base}/js/dwz.panel.js" type="text/javascript"></script>
<script src="${base}/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${base}/js/dwz.history.js" type="text/javascript"></script>
<script src="${base}/js/dwz.combox.js" type="text/javascript"></script>
<script src="${base}/js/dwz.regional.zh.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->

<script type="text/javascript">
$(function(){
	DWZ.init("dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"${base}/themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
	
});
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="http://j-ui.com">标志</a>
				<ul class="nav">
					<li><a href="user.do?command=setView" target="dialog" width="600">设置密码</a></li>
					<li><a href="login.do">退出</a></li>
				</ul>
				<ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<!--<li theme="red"><div>红色</div></li>-->
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul>
			</div>

			<!-- navMenu -->
			
		</div>
			<!-- left start -->
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div id="ssss">收缩</div></div>
				<div class="accordion" fillSpace="sidebar">
						
					<div class="accordionHeader">
						<h2><span>Folder</span>网站内容管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree treeFolder collapse">
							<!-- 新闻中心 -->
							
							<li><a href="${base}/admin/news.do?pageNum=1" target="navTab" rel="news" flesh="ture">新闻中心</a>
								<ul>
									<li><a class="add" href="${base}/admin/news.do?command=addview" target="navTab" rel="add" >添加新闻</a></li>
									<li><a href="${base}/admin/news.do?pageNum=1" target="navTab" rel="page1">管理全部新闻</a></li>
									<li><a class="add" href="${base}/admin/type.do?command=addview" target="navTab" rel="add" >添加新闻分类</a></li>
									<li><a href="${base}/admin/type.do?pageNum=1" 				target="navTab" rel="type" flesh="ture">管理新闻分类</a></li>
								</ul>
							</li>
							<!-- 精品工程 -->					
							<li><a href="${base}/admin/project.do?pageNum=1" 	target="navTab" rel="news" flesh="ture">精品工程 </a>
								<ul>
									<li><a class="add" href="${base}/admin/project.do?command=addview" target="navTab" rel="add" >添加精品工程</a></li>
									<li><a class="add" href="${base}/admin/protype.do?command=addview" target="navTab" rel="add" >添加工程分类</a></li>
									
									<li><a href="${base}/admin/project.do?pageNum=1" target="navTab" rel="page1">全部精品工程</a></li>
									<li><a href="${base}/admin/protype.do?pageNum=1" target="navTab" rel="page1">管理精品工程分类</a></li>
									
								</ul>
							</li>
							<!-- 荣誉业绩 -->
							<li><a href="${base}/admin/honour.do?pageNum=1" 	target="navTab" rel="news" flesh="ture">荣誉业绩 </a>
								<ul>
									<li><a href="${base}/admin/honour.do?typeId=1&pageNum=1" target="navTab" rel="honour" >企业荣誉</a></li>
									<li><a href="${base}/admin/honour.do?typeId=2&pageNum=1" target="navTab" rel="honour" >获得奖项</a></li>
									<li><a href="${base}/admin/honour.do?typeId=3&pageNum=1" target="navTab" rel="honour" >工程业绩</a></li>
								</ul>
							</li>
							<!-- 企业文化 -->
							<li><a href="${base}/admin/culture.do?pageNum=1" 	target="navTab" rel="news" flesh="ture">企业文化</a>
								<ul>
									<c:forEach items="${allCulture}" var="c">
									<li><a href="${base}/admin/culture.do?command=${c.is_static eq 1?"editview":"list"}&cultureId=${c.id}" target="navTab" rel="edit" >${c.name}</a></li>
									</c:forEach>
								</ul>
							</li>
							<!-- 人才招聘 -->
							<li><a href="${base}/admin/zhaopin.do?pageNum=1" 	target="navTab" rel="news" flesh="ture">人才招聘</a>
								<ul>
									<li><a class="add" href="${base}/admin/zhaopin.do?command=addview" target="navTab" rel="add" >添加招聘信息</a></li>
								</ul>
							</li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>网站管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="${ctx}/admin/contact.do?command=editview" target="navTab" rel="main">管理公司联系方式</a></li>
							<li><a href="${ctx}/admin/about.do?command=editview" target="navTab" rel="user" flesh="true">修改关于我们</a></li>
							<li><a href="${ctx}/admin/sys.do?command=flash" target="navTab" rel="user" flesh="true">更新FLASH</a></li>
						</ul>
					</div>
					<div class="accordionHeader">
						<h2><span>Folder</span>友情链接管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="${ctx}/admin/link.do" target="navTab" rel="main">友情链接列表</a></li>
						</ul>
					</div>										
					<div class="accordionHeader">
						<h2><span>Folder</span>用户管理</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="${base}/admin/user.do?command=list"  target="navTab" rel="user" flesh="true">系统用户</a></li>
							<li><a href="${base}/admin/group.do" target="navTab" rel="user" flesh="true">用户组</a></li>
						</ul>
					</div>
				</div>

			</div>
		</div>
		<!-- left end -->
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">系统主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
							<p><span>大连正泰开宇网站管理系统</span></p>
							<p>官方:<a href="http://www.521team.com" target="_blank">http://www.521team.com</a></p>
						</div>
						<div class="pageFormContent" layoutH="80" style="margin-right:230px">
<h2>用户信息:</h2>
<br/>
<p>用户：${loginUser.realname}</p>

<div class="divider"></div>
<h2>快捷方式:</h2>
<br/>
<p><a href="${base}/admin/news.do?pageNum=1" target="navTab" rel="news" flesh="ture">管理新闻</a></p>
<p><a class="add" href="/admin/news.do?command=addview" target="navTab" rel="add" mask="true"><span>添加新闻</span></a></p>
<p><a class="add" href="/admin/project.do?command=addview" target="navTab" rel="add" mask="true"><span>添加精品工程</span></a></p>
<p><a href="/admin/project.do?pageNum=1" target="navTab" rel="news" flesh="ture">管理精品工程 </a></p>
<p><a href="/admin/zhaopin.do?pageNum=1" target="navTab" rel="news" flesh="ture">管理人才招聘</a></p>
<p><a class="add" href="/admin/zhaopin.do?command=addview" target="navTab" rel="add">添加招聘信息</a></p>

<div class="divider"></div>
<h2>系统信息:</h2>
<pre style="margin:5px;line-height:1.4em">
企业网站程序版本：SunDev V1.0.1 Release 20111014 [查看最新版本]
操作系统：WINNT 
服务器软件：Tomcat/6.0.16
MySQL 版本：5.0.27-community-nt
上传文件：2M
</pre>

<div class="divider"></div>
<h2>技术支持:</h2>
<pre style="margin:5px;line-height:1.4em;">
版权所有：国信致远JAVAWEB开发团队
总 策 划：李浩
开发与支持团队：李浩、杨昌钊、丁开迪
UI 设计：寻明华
</pre>
						</div>
						
					</div>
					
				</div>
			</div>
		</div>

	</div>

	<div id="footer">Copyright &copy; 2011 <a href="demo_page2.html" target="dialog">国信致远JAVAWEB开发团队</a></div>

</body>
</html>