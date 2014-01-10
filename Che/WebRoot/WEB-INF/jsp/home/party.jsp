<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>派对主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.css" />
<link rel="stylesheet"
	href="/che/jquery/demos/docs/_assets/css/jqm-docs.css" />
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>

<script src="/che/jquery/demos/docs/_assets/js/jqm-docs.js"></script>
<script
	src="http://code.jquery.com/mobile/1.2.0-rc.2/jquery.mobile-1.2.0-rc.2.min.js"></script>
<script type="text/javascript"
	src="http://www.ycombo.com/combo/lyd/LYD.core.js"></script>
<script type="text/javascript"
	src="http://www.ycombo.com/combo/lyd/LYD.ajax.js"></script>
<script type="text/javascript">
		var party_id = "${partyId}";
		var p_status = "N";
		$(document).ready(function () {
			$.mobile.loading('show');
			LYD.openLink({
				url:"/che/mac/party/IF00002",
				params : {party_id:${partyId},uuid:${uuid}},
				success:function(msg){
					if(msg.party.C_ID != 0){
						$(".c_title").val(msg.party.C_TITLE);
					}else{
						$(".c_title").val("没有所属活动");
					}
					
					$(".p_title").val(msg.party.P_TITLE);
					$(".p_time").val(msg.party.P_CTIME);
					$(".p_local").val(msg.party.P_LOCAL);
					$("#p_des").html(msg.party.P_INFO);
					
					p_status = msg.party.P_STATUS;
					
					for(var i = 0 ;i< msg.creat_num ;i++){
						if(i==2)
							break;
						$("#p"+i).attr("src",msg.party.creaters[i].USER_PIC);
					}					
					
					$.mobile.loading('hide');
				}
			});
		});
		function add(){
			//是否加入
			if(p_status=="N"){
				window.location.href = "/che/party_add/${partyId}";	
			}else{
				alert("已加入");
			}
			
		}
		function invate(){
			window.location.href = "/che/party_invite/${partyId}";
		}
		function home(){
			window.location.href = "/che";
		}
		
	</script>


</head>
<body>
<body>

	<div data-role="page" class="type-interior">

		<div data-role="header">
			<h1>派对主页</h1>
			<a onclick="home();" data-icon="home" data-iconpos="notext"
				data-direction="reverse">Home</a>
		</div>
		<!-- /header -->

		<div data-role="content">
			<div class="ui-grid-b">
				<div class="ui-block-a">
					<div class="ui-bar ui-bar-e" style="height: 120px">
						<img id="p1" src="http://www.ycombo.com/che/uploads/1.jpg" />
					</div>
				</div>
				<div class="ui-block-b">
					<div class="ui-bar ui-bar-e" style="height: 120px">
						<img id="p2" src="http://www.ycombo.com/che/uploads/2.jpg" />
					</div>
				</div>
				<div class="ui-block-c">
					<div class="ui-bar ui-bar-e" style="height: 120px">
						<img id="p3" src="http://www.ycombo.com/che/uploads/3.jpg" />
					</div>
				</div>
			</div>
			<div class="ui-grid-a">
				<div class="ui-block-a">
					<button type="button" data-theme="c">创建者</button>
				</div>
				<div class="ui-block-b">
					<button type="button" data-theme="c">参与者</button>
				</div>
			</div>
			<div class="ui-body ui-body-c">
				<div data-role="fieldcontain">
					<label for="name-c">派对名称:</label> <input class="p_title"
						type="text" name="name" id="name-c" value="loading......" />
				</div>
				<div data-role="fieldcontain">
					<label for="name-c">所属活动:</label> <input class="c_title"
						type="text" name="name" id="name-c" value="loading......" />
				</div>

				<div data-role="fieldcontain">
					<label for="name-c">派对时间:</label> <input class="p_time" type="text"
						name="name" id="name-c" value="loading......" />
				</div>

				<div data-role="fieldcontain">
					<label for="name-c">地点:</label> <input class="p_local" type="text"
						name="name" id="name-c" value="loading......" />
				</div>

				<label for="name-c">活动简介:</label>
				<div class="ui-body ui-body-d ui-corner-all" id="p_des">
					loading......</div>
			</div>
			<!-- /body-c -->
			<div class="ui-grid-a">
				<div onclick="add();" class="ui-block-a">
					<a data-role="button" data-theme="c" data-icon="arrow-l">加入</a>
					</button>
				</div>
				<div onclick="invate();" class="ui-block-b">
					<a data-role="button" data-theme="c" data-icon="arrow-l">邀请</a>
					</button>
				</div>
			</div>
		</div>

	</div>
	<!-- /page -->
</body>