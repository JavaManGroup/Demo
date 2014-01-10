<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>消息</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.css" />
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.js"></script>
	<script type="text/javascript" src="http://www.ycombo.com/combo/lyd/LYD.core.js"></script>
	<script type="text/javascript" src="http://www.ycombo.com/combo/lyd/LYD.ajax.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$('#listView').listview('refresh');
			$.mobile.loading('show');
			LYD.openLink({
				url:"/che/mac/party/IF00001",
				params : {uuid:'10001'},
				success:function(msg){
					//$("#listView").html("");
					for(var i = 0 ;i<msg.index_num ;i++){
						var part = "<li onclick=\"part("+msg.partys[i].P_ID+");\"><a>"+
							"<h3>【"+msg.partys[i].P_ID+"】"+msg.partys[i].P_TITLE+"</h3>"+
							"<p>Broken Bells</p>"+
							"</a></li>";
						//$("#listView").append(part);
					}
					$('#listView').listview('refresh');
					$.mobile.loading('hide');
				}
			});
		});
		function part(id){
			 window.location.href = "/che/party/"+id+"?uuid=${uuid}";
		}
		
		function m_friend(){
			window.location.href = "/che/message_friend?uuid=${uuid}";
		}
		function m_party(){
			window.location.href = "/che/message_party?uuid=${uuid}";
		}
		function m_system(){
			window.location.href = "/che/message_system?uuid=${uuid}";
		}
		
		function home(){
			window.location.href = "/che";
		}
	</script>
	
	
</head> 
<body> 
<div data-role="page">
	<div data-role="header">
		<h1>消息</h1>
		<a onclick="home();" data-icon="home" data-iconpos="notext"
				data-direction="reverse">Home</a>
	</div><!-- /header -->
	<div class="ui-grid-b">
			<div class="ui-block-a"><button onclick="m_friend();" type="button" data-theme="a">好友</button></div>
			<div class="ui-block-b"><button onclick="m_party();" type="button" data-theme="c">派对</button></div>	   
			<div class="ui-block-c"><button onclick="m_system();" type="button" data-theme="c">系统</button></div>
		</div>
	<div data-role="content">
		
		<ul id="listView" data-role="listview" data-split-icon="gear" data-split-theme="d">
			<li>
			<div style="height: 100px">
				<div style="float: left;">
					<img src="http://www.ycombo.com/che/uploads/1.jpg"  width="80px" height="80px"  />
				</div>
				<div style="float: left; padding: 10px">
					<h3>李浩</h3>
					<p>邀请你参加： XXXXX派对</p>
					<p>状态： Y YES</p>
					<p>决定时间： 15mins</p>
				</div>
			</div>
			</li>
			<li>
			<div style="height: 100px">
				<div style="float: right;">
					<img src="http://www.ycombo.com/che/uploads/1.jpg"  width="80px" height="80px"  />
				</div>
				<div style="float: left; padding: 10px">
					<h3>我</h3>
					<p>邀请  XXX  参加：  XXXXX派对</p>
					<p>状态： YES</p>
					<p>决定时间： 15mins</p>
				</div>
			</div>
			</li>
		</ul>
	</div><!-- /content -->
</div><!-- /page -->
</body>