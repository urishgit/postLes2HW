package telran.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import telran.forum.dto.UserProfileDto;
import telran.forum.dto.UserRegisterDto;
import telran.forum.service.UserAccountService;

@RestController
@RequestMapping("/account")
public class UserAccountController {

	
	@Autowired
	UserAccountService service;
	
	
	@PostMapping("/account/newuser")
	public UserProfileDto addUser( @RequestBody UserRegisterDto dto,@RequestParam String auth)
	{
		return service.addUser(dto, auth);
	}
	
	
}
