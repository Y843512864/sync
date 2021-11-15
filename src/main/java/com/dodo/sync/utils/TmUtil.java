/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodo.sync.utils;

/**
 *
 * @author dedong.yin
 */
public class TmUtil {
        
    public static void tmCost(String methodName, Long st, Long ed) {
        String rst = "-------------------method %s cost:%d------------------------------";
        System.out.println(String.format(rst, methodName, (ed - st)));
    }
}
