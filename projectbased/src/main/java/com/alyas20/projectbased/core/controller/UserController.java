package com.alyas20.projectbased.core.controller;

import com.alyas20.projectbased.core.dto.UserDTO;
import com.alyas20.projectbased.core.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @Operation(summary = "Delete user", description = "Delete user")
    @GetMapping("/email")
    public ResponseEntity<UserDTO.userRespond> getEmail(@RequestParam String userId) {
        UserDTO.userRespond respond = new UserDTO.userRespond(null,null,userService.getEmail(userId));
        return ResponseEntity.ok(respond);
    }
}
