package com.alyas20.projectbased.core.controller;

import com.alyas20.projectbased.core.bean.UserBean;
import com.alyas20.projectbased.core.dto.SignUpDTO;
import com.alyas20.projectbased.core.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstTimeController {
    private final UserService userService;

    @Autowired
    public FirstTimeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpDTO.SignUpRespond> signUp(@RequestBody SignUpDTO.SignUpRequest request) {
        UserBean userBean = new UserBean();
        userBean.setUsername(request.username());
        userBean.setUserPassword(request.password());
        userBean.setUserEmail(request.email());
        UserBean resBean = userService.signUpProcess(userBean);
        SignUpDTO.SignUpRespond respond = new SignUpDTO.SignUpRespond(resBean.getUsername(), resBean.getUserId(), resBean.getUserEmail());
        return ResponseEntity.ok(respond);
    }
}
