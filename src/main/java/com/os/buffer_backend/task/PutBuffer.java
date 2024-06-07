package com.os.buffer_backend.task;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.service.ResultService;
import com.os.buffer_backend.util.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class PutBuffer implements Runnable{
    private Common common;
    private boolean flag = true;
    @Autowired
    private ParamService paramService;
    @Autowired
    ResultService resultService;


    public PutBuffer() {
    }

    public PutBuffer(Common common,ParamService paramService,ResultService resultService) {

        this.common = common;
        this.paramService=paramService;
        this.resultService=resultService;
    }
    @Override
    public void run() {
        while (Common.flag){// Common.flag是一个全局控制变量，用于停止所有线程
            //同步代码段
            synchronized (Common.buffer1) {// 确保对缓冲区的同步访问
                while (Common.buffer1.size()==Common.Buffer1Size) {// 如果缓冲区已满，则等待
                    try {
                        Common.BlockedThreadNum++;// 增加阻塞线程数
                        Common.buffer1.wait();// 等待，直到其他线程通知（notify或notifyAll）
                        Common.BlockedThreadNum--;//// 减少阻塞线程数（可选）
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String randomChar = RandomData.generateRandomString();// 生成随机字符
                System.out.println(randomChar);
                Common.buffer1.add(randomChar);// 将字符添加到缓冲区
                Common.putInBufferNum++;// 增加已经放入缓冲区的字符数
                if (!Common.buffer1.isEmpty()) { // 确保缓冲区中有数据
                    System.out.println("buffer1缓冲区：    "+Common.buffer1);
                    String data= randomChar;
                    int id=Common.buffer1_id;
                    paramService.updateBuffer1Values(data,id);
                    int id11=Common.rs_id;
                    paramService.updateResult1(id11);
                    try {
                    // 模拟线程休眠，这里使用了Common.putSpeed来调整休眠时间
                    Thread.sleep((long) (Math.random() * 100 * (50-Common.putSpeed)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Common.buffer1.notify();
            }
            }
            // 通知可能在等待的线程（如果有的话）
            while (Common.pause) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
