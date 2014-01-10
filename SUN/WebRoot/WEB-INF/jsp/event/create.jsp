<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/root/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<link href="${base}/front/css/main.css" rel="stylesheet" type="text/css">
<link href="${base}/front/css/new_event.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/front/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="${base}/front/js/jquery.ui.datepicker.js"></script>
<script type="text/javascript" src="${base}/front/js/jquery.ui.widget.js"></script>
<script type="text/javascript" src="${base}/front/js/jquery.ui.core.js"></script>
<script type="text/javascript" src="${base}/front/js/jquery.ui.datepicker-zh-CN.js"></script>
<!--<script type="text/javascript" src="js/jquery.js"></script>-->
<script type="text/javascript">
$(document).ready(function() 
{

	$("#create_date").datepicker(
	{
		altField: "#create_date",
		altFormat: "DD, d MM, yy",
		inline: true
	});	
	
	$("#add_end_date").click(function(){	
		$("#create_end_date").show();
		$("#table_field").add("#create_rite").css("min-height","400px");
		$("#add_end_date").hide();
	});	
	
	$("#create_date_end").datepicker(
	{
		altField: "#create_date_end",
		altFormat: "DD, d MM, yy",
		inline: true
	});	
	
});		
</script>
</head>

<body>
<%@ include file="/commons/event/topbar.jsp" %>
<!--Body Start-->
<div id="main">
	<!--标题行-->
    <div class="subject margin10 padding10">
    <div class="tit_image"></div><div class="sub_title">发布新活动</div>
    </div>
    <div class="create_table margin10" id="table_field">
    	<table class="margin10 float_left">
          <tr>
            <td class="create_date_pre">时间</td>
            <td class="create_date_nex"><input type="text" id="create_date" class="event_date"/>
            <select name="start_time_min" id="start_time_min">
                <option value="0">0:00</option>
                <option value="30">0:30</option>
                <option value="60">1:00</option>
                <option value="90">1:30</option>
                <option value="120">2:00</option>
                <option value="150">2:30</option>
                <option value="180">3:00</option>
                <option value="210">3:30</option>
                <option value="240">4:00</option>
                <option value="270">4:30</option>
                <option value="300">5:00</option>
                <option value="330">5:30</option>
                <option value="360">6:00</option>
                <option value="390">6:30</option>
                <option value="420">7:00</option>
                <option value="450">7:30</option>
                <option value="480">8:00</option>
                <option value="510">8:30</option>
                <option value="540">9:00</option>
                <option value="570">9:30</option>
                <option value="600">10:00</option>
                <option value="630">10:30</option>
                <option value="660">11:00</option>
                <option value="690">11:30</option>
                <option value="720">12:00</option>
                <option value="750">12:30</option>
                <option value="780">13:00</option>
                <option value="810">13:30</option>
                <option value="840">14:00</option>
                <option value="870">14:30</option>
                <option value="900">15:00</option>
                <option value="930">15:30</option>
                <option value="960">16:00</option>
                <option value="990">16:30</option>
                <option value="1020">17:00</option>
                <option value="1050">17:30</option>
                <option value="1080">18:00</option>
                <option value="1110">18:30</option>
                <option value="1140">19:00</option>
                <option value="1170" selected="selected">19:30</option>
                <option value="1200">20:00</option>
                <option value="1230">20:30</option>
                <option value="1260">21:00</option>
                <option value="1290">21:30</option>
                <option value="1320">22:00</option>
                <option value="1350">22:30</option>
                <option value="1380">23:00</option>
                <option value="1410">23:30</option>
</select>
            <span><a href="#" id="add_end_date">添加结束时间</a></span>
            </td>
          </tr>
          <tr class="end_date" id="create_end_date">
            <td class="create_date_pre">结束时间</td>
            <td class="create_date_nex"><input type="text" id="create_date_end" class="event_date"/>
            <select name="start_time_min" id="start_time_min">
                <option value="0">0:00</option>
                <option value="30">0:30</option>
                <option value="60">1:00</option>
                <option value="90">1:30</option>
                <option value="120">2:00</option>
                <option value="150">2:30</option>
                <option value="180">3:00</option>
                <option value="210">3:30</option>
                <option value="240">4:00</option>
                <option value="270">4:30</option>
                <option value="300">5:00</option>
                <option value="330">5:30</option>
                <option value="360">6:00</option>
                <option value="390">6:30</option>
                <option value="420">7:00</option>
                <option value="450">7:30</option>
                <option value="480">8:00</option>
                <option value="510">8:30</option>
                <option value="540">9:00</option>
                <option value="570">9:30</option>
                <option value="600">10:00</option>
                <option value="630">10:30</option>
                <option value="660">11:00</option>
                <option value="690">11:30</option>
                <option value="720">12:00</option>
                <option value="750">12:30</option>
                <option value="780">13:00</option>
                <option value="810">13:30</option>
                <option value="840">14:00</option>
                <option value="870">14:30</option>
                <option value="900">15:00</option>
                <option value="930">15:30</option>
                <option value="960">16:00</option>
                <option value="990">16:30</option>
                <option value="1020">17:00</option>
                <option value="1050">17:30</option>
                <option value="1080">18:00</option>
                <option value="1110">18:30</option>
                <option value="1140">19:00</option>
                <option value="1170" selected="selected">19:30</option>
                <option value="1200">20:00</option>
                <option value="1230">20:30</option>
                <option value="1260">21:00</option>
                <option value="1290">21:30</option>
                <option value="1320">22:00</option>
                <option value="1350">22:30</option>
                <option value="1380">23:00</option>
                <option value="1410">23:30</option>
</select>
            </td>
          </tr>
          <tr>
            <td class="create_date_pre">你有什么计划呢?</td>
            <td class="create_date_nex"><input type="text" id="create_plan" class="event_plan"></td>
          </tr>
          <tr>
            <td class="create_date_pre">什么地方?</td>
            <td class="create_date_nex "><input type="text" id="create_place" class="event_place event_plan"></td>
          </tr>
          <tr>
            <td class="create_date_pre set_line_height">更多信息?</td>
            <td class="create_date_nex"><textarea id="create_info" class="event_info" rows="2" class="event_info"></textarea></td>
          </tr>
          <tr>
            <td class="create_date_pre">邀请了谁?</td>
            <td class="create_date_nex"><input type="text" id="create_invite" class="event_place event_plan"></td>
          </tr>
          <tr>
            <td class="create_date"></td>
            <td class="create_date_nex">
            <input type="checkbox" id="event_radio1"><label for="event_radio1"><span class="event_private">任何人可以查看和回复(公开)</span></label>
            </td>
          </tr>
          <tr>
            <td class="create_date"></td>
            <td class="create_date_nex">            	
            	<input type="checkbox" id="event_radio2"><label for="event_radio2"><span class="event_private">是否显示参加用户</span></label>
            </td>
          </tr>
          <tr>
	          <td class="create_date"></td>
          	<td class="create_date_nex">
            <input type="button" id="create_btn" value="走你" class="event_btn ">
            </td>
          </tr>
    </table>
    	<div class="create_right" id="create_rite"">
        	<div class="create_cover margin10">
        		<div class="title ">封面图片</div>
                <a href="#">
                <div class="cover"></div>
                <div class="cover_plus"></div>
                <div class="cover_add">添加封面图片</div>
                </a>
            </div>
        </div>
    </div>
</div>
<%@ include file="/commons/event/footer.jsp" %>
</body>
</html>