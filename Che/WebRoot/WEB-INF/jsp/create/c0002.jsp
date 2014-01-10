<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>My Page</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.js"></script>
	<script type="text/javascript" src="http://www.ycombo.com/combo/lyd/LYD.core.js"></script>
	<script type="text/javascript" src="http://www.ycombo.com/combo/lyd/LYD.ajax.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$.mobile.loading('show');
			LYD.openLink({
				url:"/che/mac/party/IF00001",
				params : {uuid:'10001'},
				success:function(msg){
					$("#listView").html("");
					for(var i = 0 ;i<msg.index_num ;i++){
						var part = "<li onclick=\"part("+msg.partys[i].P_ID+");\"><a>"+
							"<h3>【"+msg.partys[i].P_ID+"】"+msg.partys[i].P_TITLE+"</h3>"+
							"<p>Broken Bells</p>"+
							"</a></li>";
						$("#listView").append(part);
					}
					$('#listView').listview('refresh');
					$.mobile.loading('hide');
				}
			});
		});
		function part(id){
			 window.location.href = "/che/party/"+id+"?uuid=${uuid}";
		}
	</script>
	
	
</head> 
<body> 
<div data-role="page">
	<div data-role="header">
		<h1>选择好友</h1>
	</div><!-- /header -->
	<div data-role="content">
		<div class="content-primary">
			<ul data-role="listview">
				<li><a href="#">
					<img src="http://www.ycombo.com/che/uploads/1.jpg" />
					<h3>李浩</h3>
					<p>城市： 大连</p>
					<p>选择</p>
				</a></li>
				<li><a href="#">
					<img src="http://www.ycombo.com/che/uploads/1.jpg" />
					<h3>李浩</h3>
					<p>城市： 大连</p>
					<p>选择</p>
				</a></li>
				<li><a href="#">
					<img src="http://www.ycombo.com/che/uploads/1.jpg" />
					<h3>李浩</h3>
					<p>城市： 大连</p>
					<p>选择</p>
				</a></li>
			</ul>
		</div><!--/content-primary -->		

	</div><!-- /content -->
</div><!-- /page -->
</body>