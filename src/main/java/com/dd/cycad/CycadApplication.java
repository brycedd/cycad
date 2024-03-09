package com.dd.cycad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@MapperScan(basePackages={"com.dd.cycad.mapper"}) //mybatis 开启mapper接口扫描
public class CycadApplication {

	public static void main(String[] args) {
		SpringApplication.run(CycadApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

}
