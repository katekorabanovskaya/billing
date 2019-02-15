package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserDataController {

    private UserDataService userService;

    @Autowired
    public UserDataController(UserDataService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<List<UserViewModel>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserViewModel> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping()
    public ResponseEntity<UserViewModel> saveUser(@Valid @RequestBody UserViewModel user) {
        if (user != null) {
            return ResponseEntity.ok(userService.saveUser(user));
        }
        return null;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUser(id);
    }
}
