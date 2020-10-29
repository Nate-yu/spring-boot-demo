package com.xkcoding.template.freemarker.controller;

import com.xkcoding.template.freemarker.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 用户页面
 * </p>
 *
 * @package: com.xkcoding.template.freemarker.controller
 * @description: 用户页面
 * @author: yangkai.shen
 * @date: Created in 2018/10/9 3:11 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     *
     * 登录
     * @param user
     * @param request
     * @return
     */
	@PostMapping("/login")
	public ModelAndView login(User user, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

        // 添加对象使用的参数名称生成模型
		mv.addObject(user);
        // 此为ModelAndView的设置视图名称，由通过一个ViewResolverDispatcherServlet会得到解决
		mv.setViewName("redirect:/");

		// 获取请求信息，存入对象
		request.getSession().setAttribute("user", user);
		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("page/login");
	}
}
