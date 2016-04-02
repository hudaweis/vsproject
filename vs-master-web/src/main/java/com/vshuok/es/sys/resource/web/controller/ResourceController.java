package com.vshuok.es.sys.resource.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vshuok.es.common.Constants;
import com.vshuok.es.common.plugin.web.controller.BaseTreeableController;
import com.vshuok.es.sys.resource.entity.Resource;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/resource")
public class ResourceController extends BaseTreeableController<Resource, Long> {

	public ResourceController() {
		setResourceIdentity("sys:resource");
	}

	@RequestMapping(value = "/changeStatus/{newStatus}")
	public String changeStatus(HttpServletRequest request,
			@PathVariable("newStatus") Boolean newStatus,
			@RequestParam("ids") Long[] ids,
			RedirectAttributes redirectAttributes) {

		this.permissionList.assertHasUpdatePermission();

		for (Long id : ids) {
			Resource resource = baseService.findOne(id);
			resource.setShow(newStatus);
			baseService.update(resource);
		}

		redirectAttributes.addFlashAttribute(Constants.MESSAGE, "操作成功！");

		return "redirect:" + request.getAttribute(Constants.BACK_URL);
	}
}
