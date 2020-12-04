package com.example.demo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInterfacesDemo implements InitializingBean, DisposableBean {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringInterfacesDemo.class, args);
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy method");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Properties have been set.");
		
	}
	

}
