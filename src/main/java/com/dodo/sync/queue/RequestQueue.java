/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodo.sync.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import com.dodo.sync.vo.AsyncVo;

/**
 * 存放所有异步处理接口请求队列的对象,一个接口对应一个队列
 *
 * @author dedong.yin
 *
 */
@Component
public class RequestQueue {

    /**
     * 处理下订单接口的队列，设置缓冲容量为50
     */
    private BlockingQueue<AsyncVo<String, Object>> orderQueue = new LinkedBlockingQueue<>(50);

    public BlockingQueue<AsyncVo<String, Object>> getOrderQueue() {
        return orderQueue;
    }

}
