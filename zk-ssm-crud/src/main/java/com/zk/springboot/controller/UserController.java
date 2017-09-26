package com.zk.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zk.springboot.mapper.UserMapper;
import com.zk.springboot.pojo.User;
import com.zk.springboot.pojo.UserExample;
import com.zk.springboot.service.impl.UserServiceImpl;

@RequestMapping("user")
@Controller
public class UserController {

	@Autowired
	private UserMapper usermapper;

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}

	/**
	 * 根据条件查询
	 * 
	 * @return
	 */
	@GetMapping("/select/all")
	public String selectByuUserExample(User user, Model model) {

		UserExample userExample = new UserExample();

		if (user.getName() != null) {

			UserExample.Criteria criteria = userExample.createCriteria();

			criteria.andNameEqualTo(user.getName());

		}

		List<User> userList = usermapper.selectByExample(userExample);

		model.addAttribute("userList", userList);

		return "show";

	}

	/**
	 * 查询所有
	 * 
	 * @return
	 */
	/*
	 * @GetMapping("/select/all") public String selectAll(Model model){
	 * 
	 * List<User> userList = userService.selectByExample(new UserExample());
	 * 
	 * model.addAttribute("userList",userList);
	 * 
	 * return "show";
	 * 
	 * }
	 */

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("select")
	public String selectById(Integer id, Model model) {

		User userByid = userService.selectByPrimaryKey(id);

		model.addAttribute("user", userByid);

		return "update";

	}
	
	/**
	 * 根据ID修改
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping("updateUser")
	public String updateById(User user){
		
		userService.updateByPrimaryKey(user);
		
		return "ok";
		
	}

	/**
	 * 根据ID删除
	 * 
	 * @param id
	 */
	@GetMapping("delete")
	public String deleteById(Integer id) {

		usermapper.deleteByPrimaryKey(id);

		return "ok";
	}

}
