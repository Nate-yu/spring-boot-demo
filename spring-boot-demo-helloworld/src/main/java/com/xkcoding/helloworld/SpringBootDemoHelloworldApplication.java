package com.xkcoding.helloworld;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * SpringBoot启动类
 * </p>
 *
 * @package: com.xkcoding.helloworld
 * @description: SpringBoot启动类
 * @author: yangkai.shen
 * @date: Created in 2018/9/28 2:49 PM
 * @copyright: Copyright (c)
 * @version: V1.0
 * @modified: yangkai.shen
 */
@SpringBootApplication
/***
 *  \@RestController = @Controller + @ResponseBody
 *  \@Controller注解将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化
 *  \@ResponseBody注解它的作用是指该类中所有的API接口返回的数据，不管你对应的方法返回Map或是其他Object，它会以
 *  Json字符串的形式返回给客户端，但是String仍会以字符串形式返回
 */
@RestController
public class SpringBootDemoHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoHelloworldApplication.class, args);
	}

	/**
	 * Hello，World
	 * \@RequestParam中的required: 修改自动检测参数非空为false，name: 获取从前台传入的参数
	 * @param who 参数，非必须
	 * @return Hello, ${who}
	 */
	@GetMapping("/hello")
	public String sayHello(@RequestParam(required = false, name = "who") String who) {
	    // StrUtil.isBlank(): 判断字符串who是否为空
		if (StrUtil.isBlank(who)) {
			who = "World";
		}
		// 将字符串who中的值填入"{}"中
		return StrUtil.format("Hello, {}!", who);
	}
}
