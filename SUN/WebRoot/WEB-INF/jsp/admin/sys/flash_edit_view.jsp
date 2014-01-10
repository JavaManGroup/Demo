<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="${app}?command=edit" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" layoutH="56">
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			
			<dl>
			<dt>上传flash：</dt>
			<dd>
				<input name="attachment.id" value="" type="hidden">
				<input id="file" name="dwz.attachment.attachmentPath" value="" type="hidden">
				<input class="readonly" name="dwz.attachment.fileName" value="" readonly="readonly" type="text" />
				<a class="btnAttach" href="${AppBase}?command=upload" lookupGroup="attachment" width="560" height="200" title="附件">附件</a>
			</dd>
		</dl>
		
				<div class="divider"></div>
				<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
				<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
			<br/>
<div>

			<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="930px" height="207px">

	

	          <param name="movie" value="${fpath}" />

	

	          <param name="quality" value="high" />

	

	          <embed src="${fpath}" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="930px" height="207px"></embed>

	        </object>

	       </div>

			</div>
			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>