package com.zhiyou100.mapper;

import java.util.List;

import com.zhiyou100.model.User;

public interface UserMapper {

	public List<User> getAllUser();

	public User getUserById(int id);

	public int add(User user);

	public int deleteUserById(int id);

	public int UpdateUserById(User user);
}
