package com.vshuok.es.sys.user.web.controller;

import com.vshuok.es.common.web.controller.BaseCRUDController;
import com.vshuok.es.sys.user.entity.UserLastOnline;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Controller
@RequestMapping(value = "/admin/sys/user/lastOnline")
public class UserLastOnlineController extends BaseCRUDController<UserLastOnline, Long> {

    public UserLastOnlineController() {
        setResourceIdentity("sys:userLastOnline");
    }
}
