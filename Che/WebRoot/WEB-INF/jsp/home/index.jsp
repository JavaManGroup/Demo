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
		<h1>派对浏览</h1>
	</div><!-- /header -->
	<div data-role="content">	
		<ul id="listView" data-role="listview">
		</ul>
	</div><!-- /content -->
</div><!-- /page -->
</body>