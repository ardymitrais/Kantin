package com.mitrais.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mitrais.entities.Roles;
import com.mitrais.entities.User;

public class MyUserDetails extends User implements UserDetails{
	
	private final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
	private static final long serialVersionUID = 1L;
	
	public MyUserDetails(final User user) {
		super(user);
		initAuthorities(user);
	}
	
	private void initAuthorities(User user) {
		if (user.getRoles() == null) {
            return;
        }
		Set<Roles> myRoles = user.getRoles();
		for (Roles role: myRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
	}
	
	@Override
	public String getPassword() {
		return super.getUserPassword();
	}

	@Override
	public String getUsername() {
		return super.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
