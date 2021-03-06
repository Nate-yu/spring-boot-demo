package com.xkcoding.template.freemarker.controller;

import cn.hutool.core.util.ObjectUtil;
import com.xkcoding.template.freemarker.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 主页
 * </p>
 *
 * @package: com.xkcoding.template.freemarker.controller
 * @description: 主页
 * @author: yangkai.shen
 * @date: Created in 2018/10/9 3:07 PM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Controller
@Slf4j
public class IndexController {

    /**
     *
     * @param request 封装 HTTP 请求消息
     * @return
     */
	@GetMapping(value = {"", "/"})
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		// 获取请求的消息保存在user对象中
		User user = (User) request.getSession().getAttribute("user");
		if (ObjectUtil.isNull(user)) {
			mv.setViewName("redirect:/user/login");
		} else {
			mv.setViewName("page/index");
			mv.addObject(user);
		}

		return mv;
	}
}
