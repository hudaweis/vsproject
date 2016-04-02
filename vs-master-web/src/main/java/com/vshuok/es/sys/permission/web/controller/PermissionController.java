package com.vshuok.es.sys.permission.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vshuok.es.common.Constants;
import com.vshuok.es.common.entity.enums.AvailableEnum;
import com.vshuok.es.common.web.controller.BaseCRUDController;
import com.vshuok.es.sys.permission.entity.Permission;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/permission/permission")
public class PermissionController extends BaseCRUDController<Permission, Long> {

	   public PermissionController() {
	        setResourceIdentity("sys:permission");
	    }

	    @Override
	    protected void setCommonData(Model model) {
	        super.setCommonData(model);
	        model.addAttribute("availableList", AvailableEnum.values());
	    }

	    @RequestMapping(value = "/changeStatus/{newStatus}")
	    public String changeStatus(
	            HttpServletRequest request,
	            @PathVariable("newStatus") Boolean newStatus,
	            @RequestParam("ids") Long[] ids
	    ) {

	        this.permissionList.assertHasUpdatePermission();

	        for (Long id : ids) {
	            Permission permission = baseService.findOne(id);
	            permission.setShow(newStatus);
	            baseService.update(permission);
	        }


	        return "redirect:" + request.getAttribute(Constants.BACK_URL);
	    }
}
