<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/file/init.jsp"%>
<h2 class="contentTitle">编辑页面</h2>
<form action="demo/common/ajaxDone.html?navTabId=masterList&callbackType=closeCurrent" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>部门名称：</dt>
			<dd>
				<a href="http://www.baidu.com" target="callbackframe">www.baidu.com</a>
				</dd>
		</dl>
		<dl>
			<dt>部门编号：</dt>
			<dd>
				<input class="readonly" name="master.dwz_devLookup.orgNum" value="1001" readonly="readonly" type="text"/>
			</dd>
		</dl>
		<dl>
			<dt>枚举：</dt>
			<dd>
				<select class="combox">
					<option value="Yes">是</option>
					<option value="No">否</option>
				</select>
			</dd>
		</dl>
		<dl>
			<dt>附件：</dt>
			<dd>
				<input name="master.devAtt_attachment.id" value="" type="hidden">
				<input class="readonly" name="master.dwz_devAtt_attachment.fileName" value="" readonly="readonly" type="text"/>
				<a class="btnAttach" href="${AppBase}?command=uploadview" lookupGroup="master" lookupName="devAtt_attachment" width="560" height="300" title="附件">附件</a>
			</dd>
		</dl>
		<dl class="nowrap">
			<dt>大数据：</dt>
			<dd>
				<textarea class="editor" name="master.devBig" rows="4" cols="95"></textarea>
			</dd>
		</dl>
		<dl>
			<dt>部门名称：</dt>
			<dd>
				<input name="master.devLooup2.id" value="2" type="hidden">
				<input name="master.dwz_devLooup2.orgName" value="人事部" type="text"/>
				<a class="btnLook" href="dwzOrgLookup.html" lookupGroup="master" lookupName="devLooup2">查找带回</a>		
			</dd>
		</dl>


		<div class="divider"></div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>从表</span></a></li>
						<li><a href="javascript:void(0)"><span>从表2</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 150px;">
				<div>
					<table class="list nowrap" itemDetail="master.items" addButton="新建" width="100%">
						<thead>
							<tr>
								<th type="text" name="itemString" size="12" fieldClass="required">从字符串</th>
								<th type="text" name="itemInt" size="12" fieldClass="digits">从整数</th>
								<th type="text" name="itemFloat" size="12" fieldClass="number">从浮点</th>
								<th type="date" name="itemDate" size="12">从日期</th>
								<th type="date" format="yyyy-MM-dd HH:mm:ss" name="itemDataTime" size="16">从日期时间</th>
								<th type="lookup" name="orgName" lookupName="itemLookup" lookupUrl="dwzOrgLookup.html" suggestUrl="db_lookupSuggest.html" suggestFields="orgName" size="12">部门名称</th>
								<th type="enum" name="itemEnum" enumName="yesNo" enumUrl="db_select.html" size="12">从枚举</th>
								<th type="attach" name="fileName" lookupName="itemAtt_attachment" url="db_attachmentLookup.html" size="12">从附件</th>
								<th type="del" width="60">操作</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>								
				<div>
					<table class="list nowrap" itemdetail="master.item2s" width="100%">
						<thead>
							<tr>
								<th type="text" name="itemString" size="12">从字符串2</th>
								<th type="text" name="testStr" size="12">测试</th>
								<th type="del" width="60">操作</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>				
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>