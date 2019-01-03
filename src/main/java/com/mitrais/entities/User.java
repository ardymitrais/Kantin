package com.mitrais.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	
	@Column(name="user_name")
	@NotEmpty(message = "Nama tidak boleh kosong")
	private String userName;
	
	@Column(name="user_password")
	@NotEmpty(message = "Password tidak boleh kosong")
	private String userPassword;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(	name="user_role", 
				joinColumns= {@JoinColumn(name="user_id")},
				inverseJoinColumns= {@JoinColumn(name="role_id")}
				)
	private Set<Roles> roles;
	
	public User(User user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.userPassword = user.getUserPassword();
		this.roles = user.getRoles();
	}
}
