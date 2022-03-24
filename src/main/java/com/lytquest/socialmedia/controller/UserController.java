package com.lytquest.socialmedia.controller;

import com.lytquest.socialmedia.dto.ApiResponse;
import com.lytquest.socialmedia.entity.User;
import com.lytquest.socialmedia.service.impl.UserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserServiceImpl usi;
    UserController(UserServiceImpl usi){
        this.usi = usi;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        return usi.createUser(user);
    }

    @GetMapping("/all-users")
    public ApiResponse<List<User>> getUsers(){
        return new ApiResponse<>(usi.getUsers().size(), usi.getUsers());
    }

    @GetMapping("/sort-users/{field}")
    public ApiResponse<List<User>> getUsersWithSort(@PathVariable String field){
        return new ApiResponse<>(usi.findUserBySort(field).size(), usi.getUsers());
    }

    @GetMapping("/paginated-users/{offset}/{pageSize}")
    public ApiResponse<Page<User>> getUsersWithPagination(@PathVariable int offset, @PathVariable int pageSize){
        return new ApiResponse<>(usi.findUserByPagination(offset, pageSize).getSize(), usi.findUserByPagination(offset, pageSize));
    }


}
