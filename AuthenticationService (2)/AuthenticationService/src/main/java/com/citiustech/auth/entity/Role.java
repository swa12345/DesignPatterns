package com.citiustech.auth.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int roleId;
	
	@Column(name = "code")
	private String code;

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", code=" + code + "]";
	}

	public Role() {
		super();
	}

	public Role(int roleId, String code) {
		super();
		this.roleId = roleId;
		this.code = code;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
