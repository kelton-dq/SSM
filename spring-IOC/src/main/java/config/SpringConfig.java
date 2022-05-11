/**
 * Copyright (C), 2020-2022, XDU
 * FileName: SpringConfig
 * Author: Dingq
 * Date: 2022/5/10 14:38
 * Description:
 */
package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"service","dao"})
public class SpringConfig {

}