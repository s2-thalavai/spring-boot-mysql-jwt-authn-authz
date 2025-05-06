/**
 * 
 */
package com.sivasankar.spring_boot_mysql_jwt_authn_authz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 */
@RestController
@RequestMapping("/vendors")
@Tag(name = "vendor-controller", description = "vendor APIs")
public class VendorController {

	@Value("${organization}")
	private String organization;

	@Value("${spring.security.user.password}")
	private String someProperty;

	/**
	 * 
	 */
	public VendorController() {

	}

	@GetMapping("/")
	public String getStudent() {
		return "organization=" + organization;
	}

	@GetMapping("/getDecryptedValue")
	public String sendDecryptedValue() {
		return "Decrypted value: " + someProperty;
	}
}
