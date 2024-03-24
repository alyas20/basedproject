package com.alyas20.projectbased.core.controller;

import com.alyas20.projectbased.core.security.bean.UserBean;
import com.alyas20.projectbased.core.dto.SignUpDTO;
import com.alyas20.projectbased.core.security.service.TranslatorService;
import com.alyas20.projectbased.core.service.UserService;
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
    private final TranslatorService translatorService;

    @Autowired
    public FirstTimeController(UserService userService, TranslatorService translatorService) {
        this.userService = userService;
        this.translatorService = translatorService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpDTO.SignUpRespond> signUp(@RequestBody SignUpDTO.SignUpRequest request) {
        UserBean userBean = new UserBean();
        userBean.setUsername(request.username());
        userBean.setUserPassword(request.password());
        userBean.setUserEmail(request.email());
        userBean.setLocaleString(request.locale());
        UserBean resBean = userService.signUpProcess(userBean);
        SignUpDTO.SignUpRespond respond = new SignUpDTO.SignUpRespond(translatorService.toLocale("signup.completed"),resBean.getUsername(),
                resBean.getUserId(), resBean.getUserEmail());
        return ResponseEntity.ok().body(respond);
    }
}
