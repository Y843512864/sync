/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodo.sync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.dodo.sync.queue.RequestQueue;
import com.dodo.sync.vo.AsyncVo;

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
 *
 */
@RestController
public class OrderController {

    @Autowired
    private RequestQueue queue;

    @GetMapping("/order")
    public DeferredResult<Object> order(String number) throws InterruptedException {
        System.out.println("[ OrderController ] 接到下单请求");
        System.out.println("当前待处理订单数： " + queue.getOrderQueue().size());

        AsyncVo<String, Object> vo = new AsyncVo<>();
        DeferredResult<Object> result = new DeferredResult<>();

        vo.setParams(number);
        vo.setResult(result);

        queue.getOrderQueue().put(vo);
        System.out.println("[ OrderController ] 返回下单结果");
        return result;
    }

}
