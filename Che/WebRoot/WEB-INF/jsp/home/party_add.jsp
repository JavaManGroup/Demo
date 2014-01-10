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
		var msg = $(".msg").val();
		$(document).ready(function () {
			
			
		});
		function clickMsg(){
			$(".msg").val("");
		}
		function blurMsg(){
			if($(".msg").val()=="")
				$(".msg").val("添加申请信息，，，，");
			else
				msg = $(".msg").val();
		}
		function action_add(){
			$.mobile.loading('show');
			
			LYD.openLink({
				url:"/che/mac/party/IF00024",
				params : {p_id:'${partyId}',uuid:"${uuid}",m_msg:msg},
				success:function(msg){
					$("#listView").html("");
					$.mobile.loading('hide');
				}
			});
		}
	</script>
	
	
</head> 
<body> 

<body> 

<div data-role="page" class="type-interior">

	<div data-role="header">
		<h1>派对主页</h1>
		<a href="/" data-icon="home" data-iconpos="notext" data-direction="reverse">Home</a>
	</div><!-- /header -->
	
	<div data-role="content">
		<div class="ui-body ui-body-c">

				<div data-role="fieldcontain">
		         <label for="name-c">申请加入:</label>
		         <input onclick="clickMsg();" onblur="blurMsg();" class="msg" type="text" name="name" id="name-c" value="添加申请信息，，，，"  />
				</div>
				
		</div><!-- /body-c -->
		<div class="ui-grid-a">
			<div class="ui-block-a"><button onclick="action_add();" type="button" data-theme="c">加入</button></div>
			<div class="ui-block-b"><button type="button" data-theme="c">邀请者</button></div>	   
		</div>
	</div>
	
</div><!-- /page -->
</body>