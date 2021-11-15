/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodo.sync.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NdmsMockInterfaceController {
    @CrossOrigin
    @RequestMapping("/esb-dcs/standardRequest")
    public Object ndmsMockReturn() {
        return new ArrayList();
    }
}
