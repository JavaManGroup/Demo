<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="org.apache.struts2.components.Include"%>
<%@ include file="/commons/root/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link href="${base}/front/css/main.css" rel="stylesheet" type="text/css">
<link href="${base}/front/css/event_content.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="javascript" src="${base}/front/js/jquery.js"></script>
<script type="text/javascript">
            $(document).ready(function() 
			{
				$("#new_comment").click(function() 
				{
					$("#new_comment").attr("rows","3");
				});	
				$("#new_comment").blur(function()
				{
					if($("#new_comment").val()=='')
					{
					$("#new_comment").attr("rows","1");
					}
				});		
			});
</script>			
</head>

<body>
<%@ include file="/commons/event/topbar.jsp" %>
<div id="main">
	<!--标题行-->
    <div class="subject margin10 padding10">
    <div class="tit_image"></div><div class="sub_title">查看详细</div>
    </div>
    
    <!--活动列表-->
    <div class="content margin10">
    	<!--左边-->
    	<div class="left">
        <!--一条活动-->
        <div class="piece_event">
			<div class="margin10 event_title event_state">JESSICA FLORI'S COMMING HOME TO LONG ISLAND PARTY!</div>
            <span class="piece_time">|状态:未过期</span>
            <div class="event_left">
            	<table class="event_table">
                <tr style="border:1px;">
            	<td class="event_time_pre ">时间:</td><td class="event_time_nex">明天 22:00</td>
                </tr>
                <tr>
            	<td class="event_time_pre">地点:</td><td class="event_time_nex">三期食堂 22:00</td>
                </tr>
                <tr>
            	<td class="event_time_pre">发起人:</td><td class="event_time_nex">明天 22:00</td>
                </tr>
                <tr>
            	<td class="event_time_pre">详细:</td><td class="event_time_nex event_description">明天巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧巴拉巴拉巴拉巴拉巴拉巴拉吧</td>
                </tr>
                <!--
                <div class="event_time_pre margin10">地点:<span class="event_time_nex">三期食堂</span></div>
                <div class="event_time_pre margin10">发起人:<span class="event_time_nex">Shi Yan</span></div             	-->
                </table>
            </div>
            <div class="event_right">    
            <a href="#"><div class="shorcut"><span class="event_img event_img_favor"></span>收藏</div></a>        	
            <a href="#"><div class="shorcut"><span class="event_img event_img_tag"></span>标签</div></a>            <a href="#"><div class="shorcut"><span class="event_img event_img_edit"></span>编辑</div></a>                                
            <a href="#"><div class="shorcut"><span class="event_img event_img_del"></span>删除</div></a>
            </div>
        </div>
        <div class="comment margin_left10 clear">
        <span class="event_time_pre">评论:</span>
        <div class="new_comment">
          <textarea class="event_time_nex event_description" id="new_comment" rows="1"></textarea><br>
          <div class="comment_add_btn">
	          <input type="button" value="走你" name="submit_comment" class="submit_comment_btn"/>
          </div>
        </div>        
        </div>
        <div class="comments event_time_pre clear">
        	<!--<div class="title">评论内容</div>-->
            <div class="piece_comment">            	
            	<div class="piece_head"><img src="${base}/front/images/head.png" class="piece_head"/></div>
                <div class="piece_right">
            	<span class="piece_id">HL_Cfan</span>
                <div class="piece_content">这是评论啦这是评论啦这是评论啦这是评论啦这是评论啦这是评论啦这是评论啦这是评论啦这是评论啦</div>   
                <span class="piece_date">20/09/2011</span>   
                </div>          
            </div>
        </div>
        </div>
        <div class="right">
        <div class="dicision margin10">
        	<a href="#">参加</a>
            <a href="#">不参加</a>
            <a href="#">不确定</a>
        </div>
        <div class="event_cover margin10">
        	<img src="${base}/front/images/job.jpg"/>
        </div>  
        <div class="event_join margin10">
        	<div class="event_join_title">可能参加的人<a href="#" class="event_join_all">查看全部>></a></div>
            <div class="event_join_list">
            	<ul>
                	<li><img src="${base}/front/images/head.png" ><div class="event_join_list_name">Sarah</div></li>
                    <li><img src="${base}/front/images/head.png" ><div class="event_join_list_name">Sarah</div></li>
                    <li><img src="${base}/front/images/head.png" ><div class="event_join_list_name">Sarah</div></li>
                </ul>
            </div>
        </div>      
        </div>
     </div>
</div>            
<%@ include file="/commons/event/footer.jsp" %>
</body>
</html>
