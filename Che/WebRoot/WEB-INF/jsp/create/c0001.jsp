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
		<h1>创建活动</h1>
	</div><!-- /header -->
	<div data-role="content">
		<div class="content-primary">

		<form action="#" method="get">

			<h2>创建活动</h2>

			<div data-role="fieldcontain">
	         <label for="name">创建活动:</label>
	         <input type="text" name="name" id="name" value=""  />
			</div>

			<div data-role="fieldcontain">
			<label for="textarea">活动时间:</label>
			<textarea cols="40" rows="8" name="textarea" id="textarea"></textarea>
			</div>

			<div data-role="fieldcontain">
	         <label for="search">活动地点:</label>
	         <input type="search" name="password" id="search" value=""  />
			</div>

			<div data-role="fieldcontain">
			<fieldset data-role="controlgroup">
				<legend>联合创始人：</legend>
				<input type="checkbox" name="checkbox-1a" id="checkbox-1a" class="custom" />
				<label for="checkbox-1a">Cheetos</label>

				<input type="checkbox" name="checkbox-2a" id="checkbox-2a" class="custom" />
				<label for="checkbox-2a">Doritos</label>

				<input type="checkbox" name="checkbox-3a" id="checkbox-3a" class="custom" />
				<label for="checkbox-3a">Fritos</label>

				<input type="checkbox" name="checkbox-4a" id="checkbox-4a" class="custom" />
				<label for="checkbox-4a">Sun Chips</label>
		    </fieldset>
			</div>

			<div data-role="fieldcontain">
				<label for="name">简介:</label>
	     	   <input type="text" name="name" id="name" value=""  />
			</div>

			

		<div class="ui-body ui-body-b">
		<fieldset class="ui-grid-a">
				<div class="ui-block-a"><button type="submit" data-theme="d">Cancel</button></div>
				<div class="ui-block-b"><button type="submit" data-theme="a">Submit</button></div>
	    </fieldset>
		</div>
	</form>
	</div><!--/content-primary -->		

	</div><!-- /content -->
</div><!-- /page -->
</body>