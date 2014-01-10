<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="/commons/admin/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/admin/event/init.jsp"%>
<div class="pageContent">
	<form method="post" action="${AppBase}?command=add"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input id="pageNum" name="pageNum" type="hidden" value="${pageNum}">
		<div class="pageFormContent" layoutH="56">
			<table width="90%" border="0">
              <tr>
                <td width="10%"><label>标题：</label></td>
                <td colspan="3">
                <input name="title"  type="text" size="98"/></td>
              </tr>

              
              <tr>
                <td><label>开始时间：</label></td>
                <td width="30%">
                	<input type="text" name="starttime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="true"/>
					<a class="inputDateButton" href="javascript:;">选择</a>
                </td>
                <td width="12%"><label>结束时间：</label></td>
                <td width="48%">
                	<input type="text" name="endtime" class="date" format="yyyy-MM-dd HH:mm:ss" readonly="true"/>
					<a class="inputDateButton" href="javascript:;">选择</a></td>
              </tr>
              <tr>
                <td><label>发布者：</label></td>
                <td width="30%">
                	<select name="userId">
                		<option>请选择</option>
                		<c:forEach var="u" items="${eventUser}">
                		<option value="${u.id }">${u.nick }</option>
                		</c:forEach>
                	</select>
                </td>
                <td width="12%"><label>地点：</label></td>
                <td width="48%">
                	<input name="place" type="text"/></td>
              </tr>
              <tr>
                <td><label>封面图片：</label></td>
                <td width="30%">
                	<input class="readonly" name="image" value="" readonly="readonly" type="text"/>
				<a class="btnAttach" href="db_attachmentLookup.html" lookupGroup="master" lookupName="devAtt_attachment" width="560" height="300" title="附件">附件
                </td>
                <td width="12%"><label>最大参加人数</label></td>
                <td width="48%">
                	<input name="max" type="text"/></td>
              </tr>
              <tr>
                <td><label>是否公开：</label></td>
                <td width="30%">
                	<input name="privilege" value="1" type="radio" />
                		  公开
                    <input name="privilege" value="2" type="radio" />
            			   私有
                </td>
                <td width="12%"><label>是否显示参加者名单</label></td>
                <td width="48%">
                	<input name="opened" value="1" type="radio" />
                		  显示
                    <input name="opened" value="2" type="radio" />
            			   隐藏</td>
              </tr>
              <tr>
                <td><label>内容：</label></td>
                <td colspan="3">
                <textarea class="editor" name="description" rows="6" cols="100" tools="Cut,Copy,Paste,Pastetext,|,Source,About">custom(自定义)
                </textarea></td>
                </tr>
            
            </table>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
				<li>
					<div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">
								保存
							</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>
