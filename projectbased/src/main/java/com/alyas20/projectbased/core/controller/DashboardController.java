package com.alyas20.projectbased.core.controller;

import com.alyas20.projectbased.core.dto.DashboardDTO;
import com.alyas20.projectbased.core.security.service.TranslatorService;
import com.alyas20.projectbased.core.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    private final UserService userService;
    private final TranslatorService translatorService;

    @Operation(summary = "Get Main Dashboard", description = "Get dashboard main info such as user class")
    @GetMapping("/main")
    public ResponseEntity<DashboardDTO.dashboardMainResponse> getMainDashboard(@RequestParam String username) {
        DashboardDTO.dashboardMainResponse respond = new DashboardDTO.dashboardMainResponse(translatorService.toLocale("dashboard.already") ,userService.getUserByUserName(username));
        return ResponseEntity.ok().body(respond);
    }
}
