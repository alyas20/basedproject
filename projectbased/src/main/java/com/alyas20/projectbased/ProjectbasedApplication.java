package com.alyas20.projectbased;

import com.alyas20.projectbased.core.security.config.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class ProjectbasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectbasedApplication.class, args);
	}

}
