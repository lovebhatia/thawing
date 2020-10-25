package com.example.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Service.UserCrackService;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/crack")
public class UserRestController {




	
	/*
	@Autowired
	UserRepository userService2;

	@Autowired
	UserCrackService userCrackService1;
	@RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return (List<User>) userService2.findAll();
    }

	  @RequestMapping(value="/user",method = RequestMethod.POST)
	  public User createOrSaveUser(@RequestBody User user) {
		System.out.println("user"+user.getUsername()+"--"+user.getPassword()+"--"+user.getUsername());
	  //User userExists=userService2.findUserByMobile(user.getMobile());
	  //System.out.println(userExists);
	  //if (userExists!=null)
	  //	return null;
	  //else {
	  	return userCrackService1.saveUser(user);
	  }
	 // return "User Created";
	//}


	  @PostMapping(value="/checkUser") public User GetUser(@RequestBody User user)
	  { return userCrackService1.findUserByEmail(user.getEmail()); }

*/
}
