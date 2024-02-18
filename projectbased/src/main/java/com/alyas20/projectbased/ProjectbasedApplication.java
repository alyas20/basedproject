package com.alyas20.projectbased;

import com.alyas20.projectbased.core.security.config.RsaKeyConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class ProjectbasedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectbasedApplication.class, args);
	}

}
