package com.zhiyou100.controller;

import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhiyou100.mapper.UserMapper;
import com.zhiyou100.model.User;
import com.zhiyou100.util.resultObject;

/**
 * 
 * @author 王鸡 演示前后端分离开发, 后端Restful风格的代码 以及使用postman测试接口
 */
@RestController // 该类中的所有方法 都返回json数据,每个方法不用再去写@ResponseBody
public class UserController {

	@Autowired
	private UserMapper mapper;

	// 查询全部
	// 路径get /user/get 参数无 返回一个ResultfulObj"{"code":"200/400/500...","msg":"失败/成功"}
	@RequestMapping("user/get")
	public resultObject getAll() {
		List<User> users = mapper.getAllUser();
		System.out.println("getAll返回的是:" + users);
		if (users == null || users.size() == 0) {
			return new resultObject(201, "咩有数据", null);
		}
		return new resultObject(200, "咩有数据", users);

	}

	// 查询一个
	// get /user/get{id} 参数 int id
	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	public resultObject getUserById(@PathVariable int id) {
		System.out.println("getUserById:  id:" + id);
		User user = mapper.getUserById(id);
		// 判断对象是否存在
		System.out.println("getUserById  user:" + user);
		return new resultObject(200, "成功", user);
	}

	// 添加用户
	// post /user/add 参数 user
	// 参数以form表单发送
	// ajax默认形式:表单序列化
	// 发送json数据 :
	// 表单序列化
	// 这次演示 前端发送json数据
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public resultObject addUser(@RequestBody User user) {
		System.out.println("addUser:  user:" + user);
		int row = 0;
		try {
			row = mapper.add(user);
			int a = 1 / 0;

		} catch (Exception e) {
			row = -1;
			System.out.println("添加异常");
		}

		if (row > 0) {
			return new resultObject(200, "成功", null);
		}

		// 判断对象是否存在
		System.out.println("getUserById  user:" + row);
		return new resultObject(400, "失败", null);
	}

	// 删除
	// get /user/get{id} 参数 int id
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
	public resultObject deleteById(@PathVariable int id) {
		System.out.println("getUserById:  id:" + id);
		int row = mapper.deleteUserById(id);
		// 判断对象是否存在
		System.out.println("getUserById  user:" + row);
		if (row > 0) {
			return new resultObject(200, "成功", row);
		} else {
			return new resultObject(201, "没有该用户", row);
		}

	}
	// 删除
		// get /user/get{id} 参数 int id
		@RequestMapping(value = "/user/Update", method = RequestMethod.PUT)
		public resultObject UpdateById(@RequestBody User user) {
			System.out.println("UpdateById:  user:" + user);
			int row = mapper.UpdateUserById(user);
			// 判断对象是否存在
			System.out.println("getUserById  user:" + row);
			if (row > 0) {
				return new resultObject(200, "成功", row);
			} else {
				return new resultObject(201, "没有该用户", row);
			}

		}
}
