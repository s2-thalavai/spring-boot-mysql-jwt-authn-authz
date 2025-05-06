/**
 * 
 */
package com.sivasankar.spring_boot_mysql_jwt_authn_authz.model.response;

import java.util.Arrays;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class VendorResponseDTO {

	private String id;
	private String code;
	private String name;
	private String[] projectId;

	public VendorResponseDTO() {
		super();
	}

	public VendorResponseDTO(String id, String code, String name, String[] projectId) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.projectId = projectId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the projectId
	 */
	public String[] getProjectId() {
		return projectId;
	}

	/**
	 * @param projectId the projectId to set
	 */
	public void setProjectId(String[] projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(projectId);
		result = prime * result + Objects.hash(code, id, name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VendorResponseDTO other = (VendorResponseDTO) obj;
		return Objects.equals(code, other.code) && Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Arrays.equals(projectId, other.projectId);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", code=" + code + ", name=" + name + ", projectId=" + Arrays.toString(projectId)
				+ "]";
	}

}
