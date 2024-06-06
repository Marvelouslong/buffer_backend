package com.os.buffer_backend.task;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.model.domain.Buffer3;
import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.service.impl.ParamServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UseThread {
    private Buffer1 buffer1;
    private Buffer2 buffer2;
    private Buffer3 buffer3;
    @Autowired
    private ParamService paramService;

    @PostConstruct
    public void init() {
        Param params = paramService.getParams(1);
        System.out.println(params.getMovebuffer3num());
        start(params);
        // 主线程继续执行其他任务
    }
    public void start(Param param){
        // 创建一个实现了Runnable接口的对象
        MoveOperation myRunnable = new MoveOperation(buffer1,buffer2,buffer3,param);
        for(int i=0;i<param.getMovebuffer2num();i++) {
            // 创建一个线程对象并启动它
            Thread moveThread = new Thread(myRunnable,"buffer2" + i);
            moveThread.start();
        }
        for(int i=0;i<param.getMovebuffer3num();i++) {
            Thread moveThread = new Thread(myRunnable);
            moveThread.start();
        }
    }
}
