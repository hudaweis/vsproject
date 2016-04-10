package com.vshuok.es.sys.user.web.controller;

import com.vshuok.es.common.web.controller.BaseCRUDController;

import com.vshuok.es.sys.user.entity.UserStatus;
import com.vshuok.es.sys.user.entity.UserStatusHistory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: Hu dawei
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/user/statusHistory")
public class UserStatusHistoryController extends BaseCRUDController<UserStatusHistory, Long> {

    public UserStatusHistoryController() {
        setListAlsoSetCommonData(true);
        setResourceIdentity("sys:userStatusHistory");
    }


    @Override
    protected void setCommonData(Model model) {
        model.addAttribute("statusList", UserStatus.values());
    }

}
