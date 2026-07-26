package com.cognizant.jwt_authentication.controller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwt_authentication.service.JwtService;

@RestController
public class AuthenticationController {

    @Autowired
    JwtService jwtService;

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(

            @RequestHeader("Authorization")

            String authHeader) {

        String username = getUser(authHeader);

        String token = jwtService.generateToken(username);

        Map<String, String> map = new HashMap<>();

        map.put("token", token);

        return map;

    }

    private String getUser(String authHeader) {

        String encoded = authHeader.substring(6);

        byte[] decoded =
                Base64.getDecoder().decode(encoded);

        String credentials =
                new String(decoded, StandardCharsets.UTF_8);

        return credentials.split(":")[0];

    }

}