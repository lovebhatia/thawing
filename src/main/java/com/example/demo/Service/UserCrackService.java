package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import javax.transaction.Transactional;

//@Service("userService")
public class UserCrackService  {
	
	/*@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getUsername(), user.getPassword(), authorities);

        return userDetails;
	}


	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getActive(), true, true, true, authorities);
	}



	public User findUserByMobile(String userName) {
		return userRepository.findUserByMobile(userName);
	}



		private RoleRepository roleRepository;
	  	private BCryptPasswordEncoder bCryptPasswordEncoder;

	  @Autowired
	  public UserCrackService(UserRepository userRepository, RoleRepository
	  roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	  this.userRepository = userRepository;
	  this.roleRepository = roleRepository;
	  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	  }
	  public User findUserByEmail(String userName) {
	  	return
	  userRepository.findByUsername(userName);
	  }

	  public User saveUser(User user) {
	  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	  user.setActive(true);
	  Role userRole = roleRepository.findByRole("ADMIN");
	  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	  return userRepository.save(user); }
*/
}
