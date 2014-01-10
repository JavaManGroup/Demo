package com.sun.app.process.admin.type;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.app.process.AjaxDwzResultProcess;
import com.sun.dao.SysNewsTypeMapper;
import com.sun.vo.SysNewsType;
import com.sun.vo.SysNewsTypeExample;

public class SortProcess extends AjaxDwzResultProcess {

	@Autowired
	private SysNewsTypeMapper mapper;

	@Override
	public HashMap<String, Object> execute(HttpServletRequest request,
			HttpServletResponse response, HashMap<String, Object> model)
			throws Exception {
		// 设置排序

		String Sort = request.getParameter("sortNum");
		String[] arraySort = Sort.split(",");
		Integer r = 0;
		//验证用户输入信息是否正确
		for (int j = 0; j < arraySort.length; j++) {
			String[] v = arraySort[j].split(":");
			if (Integer.valueOf(v[1]) == 0) {
				model.putAll(ForwardJson(300, "请检查您输入的序号是否正确", appName,
						"type.do"));
				return model;
			}
		}
		for (int i = 0; i < arraySort.length; i++) {
			String[] value = arraySort[i].split(":");
			SysNewsTypeExample example = new SysNewsTypeExample();
			example.createCriteria().andIdEqualTo(Integer.valueOf(value[0]));
			SysNewsType type = new SysNewsType();
			type.setSort(Integer.valueOf(value[1]));
			r = r + mapper.updateByExampleSelective(type, example);
		}
		if (r > 0) {
			model.putAll(ForwardJson(200, "操作成功", appName, "type.do"));
		} else {
			model.putAll(ForwardJson(300, "操作失败", appName, "type.do"));
		}
		return model;
	}

}
