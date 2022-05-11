/**
 * Copyright (C), 2020-2022, XDU
 * FileName: Configuration
 * Author: Dingq
 * Date: 2022/5/11 15:47
 * Description:
 */
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"pojo"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Config {

}