package com.pojo;

// Generated Mar 12, 2019 11:57:25 AM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private Integer roleid;
	private String rolename;
	private Set registrations = new HashSet(0);

	public Role() {
	}

	public Role(String rolename, Set registrations) {
		this.rolename = rolename;
		this.registrations = registrations;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(Set registrations) {
		this.registrations = registrations;
	}

}