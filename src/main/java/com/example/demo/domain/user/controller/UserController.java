package com.example.demo.domain.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.user.dto.UserDto;
import com.example.demo.domain.user.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;
	
	@GetMapping("/user")
	public List<UserDto> selectAllUser() {
		List<UserDto> allUserInfo = userService.selectAllUser();
		System.out.println(allUserInfo);
		return allUserInfo;
	}
	
	@GetMapping("/user/{id}")
	public UserDto selectById(@PathVariable String id) {
		UserDto userDto = userService.selectById(id);
		System.out.println(id);
		System.out.println(userDto);
		return userDto;
	}
	
	@PostMapping(value = "/user/new")
	public List<UserDto> insertUser(@RequestBody UserDto userDto) {
		userService.insertUser(userDto);
		return userService.selectAllUser();
	}
	
	@PutMapping(value = "/user/{id}")
	public List<UserDto> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
		userService.updateUser(id, userDto);
		return userService.selectAllUser();
	}
	
	@DeleteMapping(value = "/user/{id}")
	public List<UserDto> deleteUser (@PathVariable String id) {
		userService.deleteUser(id);
		System.out.println(id);
		return userService.selectAllUser();
	}
}
