package com.lytquest.socialmedia.service;

import com.lytquest.socialmedia.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public List<User> getUsers();
    public List<User> findUserBySort(String field);
    public Page<User> findUserByPagination(int offset, int pageSize);
}
