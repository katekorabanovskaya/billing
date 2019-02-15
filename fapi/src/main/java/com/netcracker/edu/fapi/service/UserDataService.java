package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.UserViewModel;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserDataService {
    List<UserViewModel> getAllUsers();

    UserViewModel getUser(Long id);

    UserViewModel getUserByLogin(String login);

    UserViewModel saveUser(UserViewModel user);

    void deleteUser(Long id);

    UserDetails loadUserByUsername(String login) throws UsernameNotFoundException;

}
