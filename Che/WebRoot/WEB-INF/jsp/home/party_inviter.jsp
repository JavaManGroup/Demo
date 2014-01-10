<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html> 
<html> 
<head> 
	<title>派对主页</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.css" />
	<link rel="stylesheet" href="/che/jquery/demos/docs/_assets/css/jqm-docs.css"/>
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
	
	<script src="/che/jquery/demos/docs/_assets/js/jqm-docs.js"></script>
	<script src="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.js"></script>
	<script type="text/javascript" src="http://www.ycombo.com/combo/lyd/LYD.core.js"></script>
	<script type="text/javascript" src="http://www.ycombo.com/combo/lyd/LYD.ajax.js"></script>
	<script type="text/javascript">
		var party_id = "${partyId}";
		$(document).ready(function () {
			$.mobile.loading('show');
			LYD.openLink({
				url:"/che/mac/user/IF00009",
				params : {party_id:'${partyId}',uuid:"${10001}"},
				success:function(msg){
					$("#listView").html("");
					for(var i = 0 ;i<msg.total ;i++){
						var user = ""+
						"<li><a>"+
						"	<img src=\""+msg.users[i].PIC+"\" />"+
						"	<h3>"+msg.users[i].NICK+"</h3>"+
						"	<p>简介:"+msg.users[i].DES+"</p>"+
						"	<p>地点:"+msg.users[i].LOCAL+"</p>"+
						"<label for=\"flip-1\">Flip switch:</label>"+
						"<select name=\"flip-1\" id=\"flip-1\" data-role=\"slider\">"+
						"	<option value=\"off\">Off</option>"+
						"	<option value=\"on\">On</option>"+
						"</select>" +
						"	</a><a href=\"#purchase\" data-rel=\"popup\" data-position-to=\"window\" data-transition=\"pop\">Purchase album</a>"+
						"</li>";
						
						$("#listView").append(user);
					}
					$('#listView').listview('refresh');
					$.mobile.loading('hide');
				}
			});
		});
		function home(){
			window.location.href = "/che";
		}
	</script>
	
	
</head> 
<body> 

<body> 

<div data-role="page" class="type-interior">

	<div data-role="header">
		<h1>派对邀请好友</h1>
		<a onclick="home();" data-icon="home" data-iconpos="notext" data-direction="reverse">Home</a>
	</div><!-- /header -->
	
	<div data-role="content">
		<ul>
			<li><a>
		<div style="height: 100px">
			<div style="float: left;">
				<img src="http://www.ycombo.com/che/uploads/1.jpg"  width="80px" height="80px" />
			</div>
			<div style="float: left;">
				<h3>李浩</h3>
				<p>简介：大连  地点：大连</p>
			</div>
			<div style="float: right;">
				<div data-role="fieldcontain">
			        <select name="flip-5" id="flip-5" data-role="slider" data-theme="c" data-track-theme="a">
			                <option value="no">不选择</option>
			                <option value="yes">选择</option>
			        </select>
				</div>
			</div>
		</div></a>
			</li>
		<li>
		<div style="height: 100px">
			<div style="float: left;">
				<img src="http://www.ycombo.com/che/uploads/1.jpg"  width="80px" height="80px"  />
			</div>
			<div style="float: left;">
				<h3>李浩</h3>
				<p>简介：大连  地点：大连</p>
			</div>
			<div style="float: right;">
				<div data-role="fieldcontain">
			        <select name="flip-5" id="flip-5" data-role="slider" data-theme="c" data-track-theme="a">
			                <option value="no">不选择</option>
			                <option value="yes">选择</option>
			        </select>
				</div>
			</div>
		</div>
		</li>
		<li>
		<div style="height: 100px">
			<div style="float: left;">
				<img src="http://www.ycombo.com/che/uploads/1.jpg"  width="80px" height="80px"  />
			</div>
			<div style="float: left;">
				<h3>李浩</h3>
				<p>简介：大连  地点：大连</p>
			</div>
			<div style="float: right;">
				<div data-role="fieldcontain">
			        <select name="flip-5" id="flip-5" data-role="slider" data-theme="c" data-track-theme="a">
			                <option value="no">不选择</option>
			                <option value="yes">选择</option>
			        </select>
				</div>
			</div>
		</div>
		</li>
		</ul>
		<ul id="listView" data-role="listview" data-split-icon="gear" data-split-theme="d">
		</ul>
	</div>
	
</div><!-- /page -->
</body>