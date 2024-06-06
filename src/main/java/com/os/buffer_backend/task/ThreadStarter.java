package com.os.buffer_backend.task;

import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.ParamService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadStarter {

    @Autowired
    private ParamService paramService;

    @PostConstruct // 在bean初始化后执行
    public void startThreads() {

        paramService.register(4,3,3,3,2,2,3,3,20,20,20);
        Param param = paramService.readParmById();

        //paramService.selectBuffer1ByData();
        if (param != null) {
            for (int i = 0; i <param.getPutbuffer1num(); i++) {
                Common common = new Common(param);
                new Thread(new PutBuffer(common,paramService)).start();
            }

        }
    }
}
