package com.vshuok.es.sys.organization.web.controller;

import com.vshuok.es.common.Constants;
import com.vshuok.es.common.plugin.web.controller.BaseTreeableController;
import com.vshuok.es.sys.organization.entity.Job;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/organization/job")
public class JobController extends BaseTreeableController<Job, Long> {

    public JobController() {
        setResourceIdentity("sys:job");
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
            Job job = baseService.findOne(id);
            job.setShow(newStatus);
            baseService.update(job);
        }
        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "操作成功！");

        return "redirect:" + request.getAttribute(Constants.BACK_URL);
    }

}
