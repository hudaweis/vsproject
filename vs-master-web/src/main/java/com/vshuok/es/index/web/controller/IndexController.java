package com.vshuok.es.index.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vshuok.es.maintain.push.service.PushApi;
import com.vshuok.es.personal.calendar.service.CalendarService;
import com.vshuok.es.personal.message.service.MessageService;
import com.vshuok.es.sys.resource.entity.tmp.Menu;
import com.vshuok.es.sys.resource.service.ResourceService;
import com.vshuok.es.sys.user.entity.User;
import com.vshuok.es.sys.user.web.bind.annotation.CurrentUser;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Controller("adminIndexController")
@RequestMapping("/admin")
public class IndexController {

	   @Autowired
	    private ResourceService resourceService;

	    @Autowired
	    private PushApi pushApi;

	    @Autowired
	    private MessageService messageService;

	    @Autowired
	    private CalendarService calendarService;


	    @RequestMapping(value = {"/{index:index;?.*}"}) 
	    public String index(@CurrentUser User user, Model model) {

	        List<Menu> menus = resourceService.findMenus(user);
	        model.addAttribute("menus", menus);

	        pushApi.offline(user.getId());

	        return "admin/index/index";
	    }


	    @RequestMapping(value = "/welcome")
	    public String welcome(@CurrentUser User loginUser, Model model) {

	        //未读消息
	        Long messageUnreadCount = messageService.countUnread(loginUser.getId());
	        model.addAttribute("messageUnreadCount", messageUnreadCount);

	        //最近3天的日历
	        model.addAttribute("calendarCount", calendarService.countRecentlyCalendar(loginUser.getId(), 2));

	        return "admin/index/welcome";
	    }


}
