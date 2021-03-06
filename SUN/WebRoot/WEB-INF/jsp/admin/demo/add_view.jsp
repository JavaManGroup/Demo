<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">编辑页面</h2>
<form action="${AppBase}?command=add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>字符串：</dt><dd><input name="master.devString" value="test" type="text"/></dd>
		</dl>
		<dl>
			<dt>整数：</dt><dd><input name="master.devInt" class="digits" value="10" alt="请输入整数" type="text"/></dd>
		</dl>
		<dl>
			<dt>浮点：</dt><dd><input name="master.devFloat" class="number" value="10.2" alt="请输浮点数" type="text"/></dd>
		</dl>
		<dl>
			<dt>日期：</dt>
			<dd>
				<input name="master.devDate" class="date readonly" readonly="readonly" value="2011-03-21" type="text"/>
				<a href="javascript:void(0)" class="inputDateButton">选择</a>
			</dd>
		</dl>
		<dl>
			<dt>日期时间：</dt>
			<dd>
				<input name="master.devDateTime" class="date readonly" readonly="readonly" format="yyyy-MM-dd HH:mm:ss" value="2011-03-21 22:19:07" type="text">
				<a href="javascript:void(0)" class="inputDateButton">选择</a>
			</dd>
		</dl>
		<dl>
			<dt>部门名称：</dt>
			<dd>
				<input name="master.devLookup.id" value="1" type="hidden"/>
				<input class="required" name="master.dwz_devLookup.orgName" value="技术部" type="text" suggestFields="orgNum,orgName" suggestUrl="db_lookupSuggest.html" lookupGroup="master" lookupName="devLookup"/>
				<a class="btnLook" href="dwzOrgLookup.html" lookupGroup="master" lookupName="devLookup">查找带回</a>		
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
				<a class="btnAttach" href="db_attachmentLookup.html" lookupGroup="master" lookupName="devAtt_attachment" width="560" height="300" title="附件">附件</a>
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