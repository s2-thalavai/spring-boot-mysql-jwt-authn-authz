package com.sivasankar.spring_boot_mysql_jwt_authn_authz.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vendor {

	@Id
	private Long id;
	private String code;
	private String name;
	private String[] projectId;

	public Vendor() {

	}

}
