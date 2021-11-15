/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodo.sync.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <blockquote>
 *
 * <pre>
 *
 * 模拟下单处理，实现高吞吐量异步处理请求
 *
 * 1、 Controller层接口只接收请求，不进行处理，而是把请求信息放入到对应该接口的请求队列中
 * 2、 该接口对应的任务类监听对应接口的请求队列，从队列中顺序取出请求信息并进行处理
 *
 * 优点：接口几乎在收到请求的同时就已经返回，处理程序在后台异步进行处理，大大提高吞吐量
 *
 *
 * </pre>
 *
 * </blockquote>
 *
 * @author dedong.yin
 */
@RestController
public class JqueryJsonRtnController {

    @CrossOrigin
    @GetMapping("/getJson")
    public Object order(HttpServletRequest request,
                        HttpServletResponse response, HttpSession session) {
        List<Emp> employees = new ArrayList<Emp>();
        Emp e = new Emp("Bill", "Gates", 28);
        employees.add(e);
        e = new Emp("George", "Bush", 54);
        employees.add(e);
        e = new Emp("Thomas", "Carter", 43);
        employees.add(e);
        Map<String, Object> data = new HashMap();
        data.put("employees", employees);
        return data;
    }

    @CrossOrigin
    @GetMapping("/login")
    public Object login(String userName, String pwd) {
        if (userName == null) {
            return "参数名要userName：xxxx";
        }
        return createMap(userName, null);
    }

    @CrossOrigin
    @PostMapping("/login")
    public Object login2() {
        return "不好意思，我不支持post";
    }


    @CrossOrigin
    @PostMapping("/getJson")
    public Object order2() {
        return "让你用get你不用，你叉叉,你非用post是吧。";
    }

    @CrossOrigin
    @PostMapping("/error")
    public Object error() {
        return "让你用get你不用，你叉叉,你非用post是吧。";
    }

    private Map createMap(String userName, String pwd) {
        Map<String, Object> data = new HashMap();
        if (userName != null && userName.equals("admin")) {
            data.put("userName", "admin");
            data.put("pwd", "admin");
        }
        return data;
    }

    class Emp {

        public Emp(String firstName, String lastName, Integer gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.gender = gender;
        }

        private String firstName;
        private String lastName;
        private Integer gender;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public Integer getGender() {
            return gender;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

    }

}
