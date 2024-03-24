package com.alyas20.projectbased.core.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SignUpDTO {
    public record SignUpRequest(String username,String password, String email,String locale){
    }
    public record SignUpRespond(String message, String username, Long id, String email){
    }
}
