package com.iot.webportal.controller;

import com.iot.webportal.context.LoginContext;
import com.iot.webportal.dto.Device;
import com.iot.webportal.service.DeviceService;
import org.apache.velocity.tools.generic.EscapeTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    DeviceService deviceService;

    @RequestMapping(value = {"/", "/index", "/home"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        Long userId = 0L;
        if (LoginContext.getLoginContext() != null) {
            userId = LoginContext.getLoginContext().getUserId();
        }
        ModelAndView modelAndView = new ModelAndView("index");
        if (userId != null && userId != 0) {
            int pageIndex = 1;
            int pageSize = 20;
            Long count = deviceService.getCount(userId);
            List<Device> deviceList = deviceService.getList(userId, pageIndex, pageSize);
            long pageCount = (count % pageSize == 0) ? count / pageSize : (count / pageSize + 1);
            modelAndView.addObject("deviceList", deviceList);
            modelAndView.addObject("totalCount", count);
            modelAndView.addObject("pageCount", pageCount);
            modelAndView.addObject("pageIndex", pageIndex);
            modelAndView.addObject("esc", new EscapeTool());
        }
        return modelAndView;
    }

}
