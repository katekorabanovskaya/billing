package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("userService")
public class UserDataServiceImpl implements UserDataService, UserDetailsService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    public UserDataServiceImpl(BCryptPasswordEncoder bcryptEncoder) {
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public List<UserViewModel> getAllUsers() {
        RestTemplate template = new RestTemplate();
        UserViewModel[] users = template.getForObject(
                backendServerUrl + "api/users",
                UserViewModel[].class
        );
        return users == null ? Collections.emptyList() : Arrays.asList(users);
    }

    @Override
    public UserViewModel saveUser(UserViewModel user) {
        //TODO: encode
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return new RestTemplate().postForEntity(
                backendServerUrl + "api/users",
                user,
                UserViewModel.class
        ).getBody();
    }

    @Override
    public UserViewModel getUser(Long id) {
        return new RestTemplate().getForEntity(
                backendServerUrl + "api/users/" + id,
                UserViewModel.class
        ).getBody();
    }

    @Override
    public UserViewModel getUserByLogin(String login) {
        return new RestTemplate().getForEntity(
                backendServerUrl + "api/users/login/" + login,
                UserViewModel.class
        ).getBody();
    }

    @Override
    public void deleteUser(Long id) {
        RestTemplate template = new RestTemplate();
        template.delete(
                backendServerUrl + "api/users/" + id
        );
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserViewModel user = getUserByLogin(login);
        if(user == null){
            throw new UsernameNotFoundException("Invalid login or password.");
        }
        return new User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserViewModel user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        //TODO:
//        user.getRoles().forEach(role -> {
//            //authorities.add(new SimpleGrantedAuthority(role.getName()));
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
//        });
//        return authorities;
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }
}
