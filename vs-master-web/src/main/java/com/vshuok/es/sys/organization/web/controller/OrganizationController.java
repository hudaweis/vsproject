package com.vshuok.es.sys.organization.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vshuok.es.common.Constants;
import com.vshuok.es.common.plugin.web.controller.BaseTreeableController;
import com.vshuok.es.sys.organization.entity.Organization;
import com.vshuok.es.sys.organization.entity.OrganizationType;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Controller
@RequestMapping(value="/admin/sys/organization/organization")
public class OrganizationController extends
		BaseTreeableController<Organization, Long> {

	public OrganizationController(){
		setResourceIdentity("sys:organization");
	}
	
	@Override
    protected void setCommonData(Model model) {
        super.setCommonData(model);
        model.addAttribute("types", OrganizationType.values());
    }
	

    @RequestMapping(value = "/changeStatus/{newStatus}")
    public String changeStatus(
            HttpServletRequest request,
            @PathVariable("newStatus") Boolean newStatus,
            @RequestParam("ids") Long[] ids,
            RedirectAttributes redirectAttributes
    ) {

        this.permissionList.assertHasUpdatePermission();

        for (Long id : ids) {
            Organization organization = baseService.findOne(id);
            organization.setShow(newStatus);
            baseService.update(organization);
        }

		redirectAttributes.addFlashAttribute(Constants.MESSAGE, "操作成功！");

        return "redirect:" + request.getAttribute(Constants.BACK_URL);
    }

}