package com.xkcoding.properties.property;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目配置
 * </p>
 *
 * @package: com.xkcoding.properties.property
 * @description: 项目配置
 * @author: yangkai.shen
 * @date: Created in 2018/9/29 10:50 AM
 * @copyright: Copyright (c) 2018
 * @version: V1.0
 * @modified: yangkai.shen
 */
@Data
/**\@Component注解: 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>*/
@Component
public class ApplicationProperty {
    /**将配置文件的属性读出来*/
	@Value("${application.name}")
	private String name;
	@Value("${application.version}")
	private String version;
}
