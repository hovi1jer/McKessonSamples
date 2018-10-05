package com.mckesson.restApi.user;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mckesson.restApi.validator.EmailConstraint;

/**
 * @author jhovis
 * 
 * Class that represents a user for the user REST API 
 *
 */
public class User {

	@Id
	private int id;
	@NotNull
	@Size(min = 1)
	private String name;
	@NotNull
	@NotBlank
	@EmailConstraint
	private String email;
	@JsonIgnore
	private Date lastModified; // internal tracking value so don't return in the api

	/**
	 * Get Id
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Set Id
	 * 
	 * @param id
	 * 			the id to set  
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Get Name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Name
	 * 
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get email address
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email address 
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get last modified date
	 * 
	 * @return the lastModified
	 */
	public Date getLastModified() {
		return lastModified;
	}

	/**
	 * Set last modified date 
	 * 
	 * @param lastModified
	 *            the lastModified to set
	 */
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
}