package com.vshuok.es.common.plugin.web.controller;

import java.io.Serializable;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vshuok.es.common.entity.BaseEntity;
import com.vshuok.es.common.entity.search.Searchable;
import com.vshuok.es.common.plugin.entity.Movable;
import com.vshuok.es.common.plugin.serivce.BaseMovableService;
import com.vshuok.es.common.utils.MessageUtils;
import com.vshuok.es.common.web.bind.annotation.PageableDefaults;
import com.vshuok.es.common.web.controller.BaseCRUDController;
import com.vshuok.es.common.web.validate.AjaxResponse;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public abstract class BaseMovableController<M extends BaseEntity & Movable, ID extends Serializable>
		extends BaseCRUDController<M, ID> {

	protected BaseMovableService<M, ID> getMovableService() {
		return (BaseMovableService<M, ID>) baseService;
	}

	@RequestMapping(method = RequestMethod.GET)
	@PageableDefaults(value = 10, sort = "weight=desc")
	@Override
	public String list(Searchable searchable, Model model) {
		return super.list(searchable, model);
	}

	@RequestMapping(value = "{fromId}/{toId}/up")
	@ResponseBody
	public AjaxResponse up(@PathVariable("fromId") ID fromId,
			@PathVariable("toId") ID toId) {

		if (this.permissionList != null) {
			this.permissionList.assertHasEditPermission();
		}

		AjaxResponse ajaxResponse = new AjaxResponse("移动位置成功");
		try {
			getMovableService().up(fromId, toId);
		} catch (IllegalStateException e) {
			ajaxResponse.setSuccess(Boolean.FALSE);
			ajaxResponse.setMessage(MessageUtils.message("move.not.enough"));
		}
		return ajaxResponse;
	}

	@RequestMapping(value = "{fromId}/{toId}/down")
	@ResponseBody
	public AjaxResponse down(@PathVariable("fromId") ID fromId,
			@PathVariable("toId") ID toId) {

		if (this.permissionList != null) {
			this.permissionList.assertHasEditPermission();
		}

		AjaxResponse ajaxResponse = new AjaxResponse("移动位置成功");
		try {
			getMovableService().down(fromId, toId);
		} catch (IllegalStateException e) {
			ajaxResponse.setSuccess(Boolean.FALSE);
			ajaxResponse.setMessage(MessageUtils.message("move.not.enough"));
		}
		return ajaxResponse;
	}

	@RequestMapping(value = "reweight")
	@ResponseBody
	public AjaxResponse reweight() {

		if (this.permissionList != null) {
			this.permissionList.assertHasEditPermission();
		}

		AjaxResponse ajaxResponse = new AjaxResponse("优化权重成功！");
		try {
			getMovableService().reweight();
		} catch (IllegalStateException e) {
			ajaxResponse.setSuccess(Boolean.FALSE);
			ajaxResponse.setMessage("优化权重失败了！");
		}
		return ajaxResponse;
	}
}