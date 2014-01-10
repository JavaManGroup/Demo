<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/commons/root/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Event Page</title>
<link href="${base}/front/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript" src="${base}/front/js/util.js"></script>
<script type="text/javascript" language="javascript" src="${base}/front/js/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function() 
{
	var curr_tab=$("#tabs ul li");
	curr_tab.click(function(){
		var index = curr_tab.index(this);
		//alert(index);
		curr_tab.removeClass("li_active")
		$("#tabs ul li:eq("+index+")").addClass("li_active");
		$("#tab-"+index+"").show();
			$.ajax( {
					url : 'index.do?command=tablist', // 后台处理程序
					data: {tab:index,pageNum:1},
					type : 'POST', // 数据发送方式
					dataType : 'json', // 接受数据格式
					success : ContentList,
					error:ContentList
				// 回传函数(这里是函数名)
				});
		});
	/*
	 * $.post(url,data:aa,dd:cc,)
	 * */
});
</script>
</head>

<body>
<div class="topbar">
	<div class="fill">
    	<div class="navigation">
        	<a href="#" class="home"><span></span></a>
          	<a href="#">发布</a>
            <a href="#">好友活动</a>
            <a href="#">活动墙</a>
            <a href="#">设置</a>
            <a href="#">徽章</a>
            <div id="logged_in_user">
            <div class="user_name">Shi Yan -</div><a href="#">登出</a>
            </div>
        </div>
    </div>
</div>
<div id="main">
	<!--标题行-->
    <div class="subject margin10 padding10">
    <div class="tit_image"></div><div class="sub_title">查看所有活动</div>
    </div>
  	<!--左边-->
    <div class="left">
    <!--选项卡-->
    <div class="tab" id="tabs">
    	<ul class="clear">
    	  	<li class="li_active">全部活动</li>
        	<li>我发布的</li>
            <li>我参加的</li>
          
        </ul>
    </div>
	    <!--活动列表 tab-1-->
	    <div class="content margin10" id="contentList" >
	        	<!--一条活动-->
	    				<div class="piece">
	            	<img src="/sun/front/images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">DinnerDinnerDinnerDinnerDinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	            <div class="piece">
	            	<img src="images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">Dinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	            <div class="piece">
	            	<img src="images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">Dinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	            <div class="piece">
	            	<img src="images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">Dinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	            <div class="piece">
	            	<img src="images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">Dinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	            <div class="piece">
	            	<img src="images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">Dinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	            <div class="piece">
	            	<img src="images/need.png" alt="Pic"/>
	                <div class="piece_right">
	                    <div class="piece_title"><a href="#" target="_blank">Dinner</a></div>
	                    <div class="piece_time">明天 22:00</div>
	                    <div class="piece_parti">5 人参加</div>
	                </div>
	                <a href="#" class="piece_rite">确认参加</a>
	            </div>
	    </div>
	    
	    <!--活动列表-  end->
	    <!--活动列表 tab-1-->
	    
	    <!--活动列表-  end->
    </div>        
    <!--右边-->
    
</div>
<div class="right margin10">
    	<div class="user_head_div">
    	<img src="images/default_user_avatar-huge.png" class="user_head">
        <div class="user_head_right margin10">
        	<div class="user_head_id">Shi Yan</div>
            <div class="user_head_create">发布:50</div>
            <div class="user_head_create">参与:100</div>
        </div>
        </div>
        <div class="user_bage">
        	<div class="title">徽章</div>
            <div class="user_bages">
            	<div class="user_bage_one">One</div>
               	<div class="user_bage_one">One</div>
            	<div class="user_bage_one">One</div>  
            	<div class="user_bage_one">One</div>  
            	<div class="user_bage_one">One</div>  
            	<div class="user_bage_one">One</div>                                                
            </div>
        </div>
    </div>
<div class="footer">
Footer
</div>
</body>
</html>

