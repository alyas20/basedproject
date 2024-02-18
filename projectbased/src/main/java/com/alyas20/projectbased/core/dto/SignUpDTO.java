package com.alyas20.projectbased.core.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class SignUpDTO {
    public record SignUpRequest(String username,String password, String email){
    }
    public record SignUpRespond(String username, Long id, String email){
    }
}
