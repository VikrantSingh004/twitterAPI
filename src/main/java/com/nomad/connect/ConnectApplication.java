package com.nomad.connect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.social.twitter.api.Twitter;
//import org.springframework.context.ConfigurableApplicationContext;

@ComponentScan(basePackages="com")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectApplication.class,args);
	}

}
