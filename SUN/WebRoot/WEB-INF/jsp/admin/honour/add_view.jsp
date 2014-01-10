<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="init.jsp"%>
<h2 class="contentTitle">添加精品工程</h2>
<form action="${AppBase}?command=add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="97">
		<dl>
			<dt>标题：</dt><dd><input name="name" class="required" type="text" size="80"/></dd>
		</dl>
		<dl>
		</dl>
		<dl>
			<dt>分类：</dt>
			<dd>
				<select name="typeId" class="combox required">
					<option value="">请选择</option>
					<option value="1">企业荣誉</option>
					<option value="2">获得奖项</option>
					<option value="3">工程业绩</option>
				</select>
			</dd>
		</dl>
		


		<div class="divider"></div>
		
		<h3 class="contentTitle">主从结构</h3>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>添加获奖照片</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 300px;">
				<div>
					<table class="list nowrap itemDetail" addButton="新建从表1条目" width="100%">
						<thead>
							<tr>
								<th type="text" name="items.itemSort" size="12" fieldClass="required">序号</th>
								<th type="text" name="items.itemName" size="12" fieldClass="required">奖状名称</th>
								<th type="text" name="items.itemDes" size="12" fieldClass="required">描述</th>
								<th type="attach" name="dwz.items.attachment.fileName" lookupGroup="items.attachment" lookupUrl="honour.do?command=upload" size="12">从附件</th>
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