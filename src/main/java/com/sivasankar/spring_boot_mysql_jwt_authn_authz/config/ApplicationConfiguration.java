package com.sivasankar.spring_boot_mysql_jwt_authn_authz.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties
public class ApplicationConfiguration {

	@Bean
	@ConfigurationProperties("jasypt.encryptor")
	SimpleStringPBEConfig jasypConfig() {
		return new SimpleStringPBEConfig();
	}

	@Bean
	StringEncryptor jasyptEncryptor() {
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
		encryptor.setConfig(jasypConfig());
		return encryptor;
	}

}