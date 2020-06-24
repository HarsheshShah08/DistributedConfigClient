package com.eureka.app.controller;

import org.bouncycastle.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.app.config.ConfigClientAppConfiguration;

@RestController
@RefreshScope
public class AccessDynamicProfiles {
	
	@Autowired
	ConfigClientAppConfiguration configClientAppConfiguration;
	
	@Value("${first.sub.property}")
	private String secondProperty;
	
	@RequestMapping
	public String printConfig() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(configClientAppConfiguration.getProperty());
		stringBuilder.append(" || ");
		stringBuilder.append(secondProperty);
		
		return stringBuilder.toString();
	}
}
