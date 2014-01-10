function updateChange(value){
	var path =$("#file").val();
	$("img").attr("src",path);
}
function flashWrite(id, flashUri, vWidth, vHeight, winMode) {
	var _obj_ = "";

	_obj_ = '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="'
			+ vWidth
			+ '" height="'
			+ vHeight
			+ '" id="'
			+ id
			+ '" align="middle">';
	_obj_ += '<param name="movie" value="' + flashUri + '" />';
	_obj_ += '<param name="quality" value="high" />';
	_obj_ += '<param name="wmode" value="' + winMode + '" />    ';
	_obj_ += '<param name="bgcolor" value="#ffffff" />        ';
	_obj_ += '<embed src="'
			+ flashUri
			+ '" quality="high" wmode="'
			+ winMode
			+ '" bgcolor="#ffffff" width="'
			+ vWidth
			+ '" height="'
			+ vHeight
			+ '" id="'
			+ id
			+ '" align="middle" allowscriptaccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" /></embed>    ';
	_obj_ += '</object>';
	document.writeln(_obj_);
}
function flashWrite_var(id, flashUri, vWidth, vHeight, winMode, m_def, s_def,
		ss_def) {

	var urlval = flashUri + "?m_def=" + m_def + "&s_def=" + s_def + "&ss_def="
			+ ss_def;

	var _obj_ = "";

	_obj_ = '<object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" width="'
			+ vWidth
			+ '" height="'
			+ vHeight
			+ '" id="'
			+ id
			+ '" align="middle">';
	_obj_ += '<param name="movie" value="' + urlval + '" />';
	_obj_ += '<param name="quality" value="high" />';
	_obj_ += '<param name="wmode" value="' + winMode + '" />    ';
	_obj_ += '<param name="bgcolor" value="#ffffff" />        ';
	_obj_ += '<embed src="'
			+ flashUri
			+ '" quality="high" wmode="'
			+ winMode
			+ '" bgcolor="#ffffff" width="'
			+ vWidth
			+ '" height="'
			+ vHeight
			+ '" id="'
			+ id
			+ '" align="middle" allowscriptaccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" /></embed>    ';
	_obj_ += '</object>';
	//alert( _obj_ );
	document.writeln(_obj_);
}
function typeSortUtil(id, value){
	if(isInteger(value)&&value > 0){
		var v = $('#box'+id).attr("value");
		$('#box'+id).attr("value",id+":"+value);
	}else{
		$('#sortText'+id).attr("value","请输入大于0的数字");
		$('#box'+id).attr("value",id+":"+0);
		$('#sortText'+id).select();
	}
	
}

function isInteger(val) {
	return (new RegExp(/^\d+$/).test(val));
}

function newsAjaxTodo(url, id,status,newsId){
	$.ajax({
		type:'POST',
		url:url,
		dataType:"json",
		cache: false,
		success: function (){
		
			if(status==1){
				var newurl = "/admin/news.do?command=setIsHome&&status=0&&newsId="+newsId+"&&pageNum=1";
				$('#'+id).attr("title",newurl);
				$('#'+id).attr("name",0);
				$('#'+id).html("不显示");
			}
				
			if(status==0){
				var newurl = "/admin/news.do?command=setIsHome&&status=1&&newsId="+newsId+"&&pageNum=1";
				$('#'+id).attr("title",newurl);
				$('#'+id).attr("name",1);
				$('#'+id).html("首页显示");
			}
				
		},
		error: DWZ.ajaxError
	});
}
function projectAjaxTodo(url, id,status,projectId){
	$.ajax({
		type:'POST',
		url:url,
		dataType:"json",
		cache: false,
		success: function (){
			if(status==1){
				var newurl = "/admin/project.do?command=setIsTop&&status=0&&projectId="+projectId+"&&pageNum=1";
				$('#'+id).attr("title",newurl);
				$('#'+id).attr("name",0);
				$('#'+id).html("不推荐");
			}
				
			if(status==0){
				var newurl = "/admin/project.do?command=setIsTop&&status=1&&projectId="+projectId+"&&pageNum=1";
				$('#'+id).attr("title",newurl);
				$('#'+id).attr("name",1);
				$('#'+id).html("精品推荐");
			}
				
		},
		error: DWZ.ajaxError
	});
}


//后台添加用户是AJAX验证用户名是否存在  开始
function hasUserName(name) {
	$.ajax( {
		url : '/os/root/user.do?command=isHasUser&name=' + name, // 
		type : 'GET', // 数据发送方式
		dataType : 'json', // 接受数据格式
		timeout : 100000,
		success : function(json) { // 回传函数实体，参数为XMLhttpRequest.responseText
			$('#recalled').html(" ");
			var has = json.HasUser;
			if (has == '0') {
				$('#recalled').html("可以使用");
			} else {
				$('#name').select();
				$('#recalled').html("已存在");
			}
		},
		error : function(json) { // 回传函数实体，参数为XMLhttpRequest.responseText
			alert("服务器连接错误");
		}
	});
}
//后台添加用户是AJAX验证用户名是否存在  结束