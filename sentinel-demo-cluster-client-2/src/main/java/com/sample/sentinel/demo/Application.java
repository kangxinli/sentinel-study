package com.sample.sentinel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动时  VM arguments 加参数：
 * 
 * -Dproject.name=xxx -Dcsp.sentinel.dashboard.server=consoleIp:port
 * 
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