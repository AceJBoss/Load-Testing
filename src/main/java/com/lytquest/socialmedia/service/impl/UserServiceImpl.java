package com.lytquest.socialmedia.service.impl;

import com.lytquest.socialmedia.entity.User;
import com.lytquest.socialmedia.repository.UserRepository;
import com.lytquest.socialmedia.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserServiceImpl implements UserService {

    long start = 0, end = 0;
    private UserRepository userRepository;
    UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

//    @PostConstruct
//    public void initDB(){
//       List<User> userList =  IntStream.rangeClosed(1, 50000)
//                .mapToObj(i->new User("User" + i, "user"+i+"@gmail.com"))
//                .collect(Collectors.toList());
//        start = System.currentTimeMillis();
//        userRepository.saveAll(userList);
//        end = System.currentTimeMillis();
//
//        long diff = end - start;
//
//        System.out.println("Total time taken " + diff);
//    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUserBySort(String field) {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC,field));
    }

    @Override
    public Page<User> findUserByPagination(int offset, int pageSize) {
        Page<User> paginatedUser = userRepository.findAll(PageRequest.of(offset, pageSize));
        return paginatedUser;
    }


}
