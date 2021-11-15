/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dodo.sync.listener;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dodo.sync.task.OrderTask;

/**
 * 队列监听器，初始化启动所有监听任务
 *
 * @author dedong.yin
 *
 */
@Component
public class QueueListener {

    @Autowired
    private OrderTask orderTask;

    /**
     * 初始化时启动监听请求队列
     */
    @PostConstruct
    public void init() {
        orderTask.start();
    }

    /**
     * 销毁容器时停止监听任务
     */
    @PreDestroy
    public void destory() {
        orderTask.setRunning(false);
    }

}
