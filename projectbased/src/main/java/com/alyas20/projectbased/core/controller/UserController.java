package com.alyas20.projectbased.core.controller;

import com.alyas20.projectbased.core.bean.UserBean;
import com.alyas20.projectbased.core.dto.SignUpDTO;
import com.alyas20.projectbased.core.dto.UserDTO;
import com.alyas20.projectbased.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/email")
    public ResponseEntity<UserDTO.userRespond> getEmail(@RequestParam String userId) {
        UserDTO.userRespond respond = new UserDTO.userRespond(null,null,userService.getEmail(userId));
        return ResponseEntity.ok(respond);
    }
}