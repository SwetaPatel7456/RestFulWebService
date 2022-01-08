 package com.RestWeb.Controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RestWeb.DaoServices.UserDaoServices;
import com.RestWeb.Entity.User;
import com.RestWeb.Entity.UserNotFoundexception;

@RestController
public class UserController {
    
	@Autowired
	private UserDaoServices userDaoServices;
	
	@RequestMapping(method = RequestMethod.GET,path = "/getUsers")
	public ResponseEntity<List<User>> getUser() {
		List<User> list = this.userDaoServices.getAllUsers();
		if(list.size()>0) {
			return ResponseEntity .status(HttpStatus.OK).build();
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	//^^^^^HATEOAS**** it is used to add links to response what we are returning
	@RequestMapping(method = RequestMethod.GET,path = "/getUsers/{id}")
	//public User getUser(@PathVariable("id") Integer id) {
	public EntityModel<User> getUser(@PathVariable("id") Integer id) {
		User u= this.userDaoServices.getUser(id);
		if (u==null)
			throw new UserNotFoundexception("id -" + id);
			//this error handling provided by the combination of spring boot and spring web mvc framework ''''''Spring boot 
			// does is it auto-configured some default exception handling for us
		
		EntityModel<User> model = EntityModel.of(u);
		
		
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getUser());
		model.add(linkToUsers.withRel("all-users"));
		return model;
		//return u;
		
		
	}
	@RequestMapping(method = RequestMethod.DELETE,path = "/getUsers/{id}")
	public User  deleteUser(@PathVariable("id") Integer id) {
		User u = this.userDaoServices.deleteUser( id);
		if (u==null)
			throw new UserNotFoundexception("id - " + id);
			//this error handling provided by the combination of spring boot and spring web mvc framework ''''''Spring boot 
			// does is it auto-configured some default exception handling for us
		
	    return u;
		
		
	}
	@RequestMapping(method = RequestMethod.POST,path = "/getUsers")
	public void  updateUser(@RequestBody User user) {
		this.userDaoServices.updateUser(user);
		
	}
	@RequestMapping(method = RequestMethod.POST,path = "/create")
		public User  createUser(@Valid @RequestBody User user) {
			return this.userDaoServices.createUser(user);
	}
}
