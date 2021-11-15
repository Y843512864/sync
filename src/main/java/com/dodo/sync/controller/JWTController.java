package com.dodo.sync.controller;


import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.http.HttpStatus;

import com.dodo.sync.common.annotation.PassToken;
import com.dodo.sync.common.annotation.UserLoginToken;
import com.dodo.sync.utils.RedisUtil;
import com.dodo.sync.vo.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.JWT;

@Slf4j
@RestController
@RequestMapping("/jwt")
public class JWTController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("login")
    @PassToken(required = true)
    public Object getRedis(User u) {
        String name = u.getUsername();
//        String passwd="123456";
        String token = JWT.create().withAudience(name).sign(Algorithm.HMAC256(u.getPassword()));//生成token
        redisUtil.hset("tokens", name, token);//存入redis
        return redisUtil.hget("tokens", name);
    }

    @GetMapping("getMsg")
    @UserLoginToken(required = true)
    public Object getRedis() {
        return "Success!!!!!";
    }
    
    @GetMapping("getStatus")
    public Object getStatus(HttpServletResponse response) {
        response.setStatus(204); 
        return "";
    }
    
    



}
