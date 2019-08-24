package com.sample.sentinel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 热点参数限流
 * 
 * wiki : https://github.com/alibaba/Sentinel/wiki/%E7%83%AD%E7%82%B9%E5%8F%82%E6%95%B0%E9%99%90%E6%B5%81
 *
 * 启动时  VM arguments 加参数：
 * -Dproject.name=xxx -Dcsp.sentinel.dashboard.server=consoleIp:port
 * 
 *  -Dproject.name=parameter-flow-control -Dcsp.sentinel.dashboard.server=localhost:8080
 * 可以在对应的 sentinel 的 dashboard 中查看效果
 *
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.run(args);
	}
}