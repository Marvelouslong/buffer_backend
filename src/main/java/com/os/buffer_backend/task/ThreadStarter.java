package com.os.buffer_backend.task;

import com.os.buffer_backend.model.domain.Param;
import com.os.buffer_backend.service.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadStarter {

    @Autowired
    private ParamService paramService;
    @Autowired
    private Buffer1Service buffer1Service;
    @Autowired
    private Buffer2Service buffer2Service;
    @Autowired
    private Buffer3Service buffer3Service;
    @Autowired
    private ResultService resultService;

//    @Autowired
//    private ParamService ps;

//    @PostConstruct // 在bean初始化后执行
    public void startThreads() {
        paramService.register(4,3,3,3,2,2,3,3,20,20,20);
        Param param = paramService.readParmById();
        //paramService.selectBuffer1ByData();
        if (param != null) {
            Common common = new Common(param);
            for (int i = 0; i <param.getPutbuffer1num(); i++) {
                new Thread(new PutBuffer(common,paramService,resultService)).start();
            }
            for (int i = 0; i <param.getMovebuffer2num(); i++) {
                new Thread(new MoveOperation(paramService,common,buffer1Service,buffer2Service,buffer3Service,resultService),"buffer2" + i).start();
            }
            for (int i = 0; i <param.getMovebuffer3num(); i++) {
                new Thread(new MoveOperation(paramService,common,buffer1Service,buffer2Service,buffer3Service,resultService),"buffer3" + i).start();
            }
            for(int i=0;i<param.getGetbuffer2num();i++) {
                System.out.println("buffer2Num: "+param.getGetbuffer2num());
                new Thread(new GetBuffer(paramService,common,buffer1Service,buffer2Service,buffer3Service),"buffer2"+i).start();
            }
            for(int i=0;i<param.getGetbuffer3num();i++) {
                System.out.println("buffer3Num: "+param.getGetbuffer3num());
                new Thread(new GetBuffer(paramService,common,buffer1Service,buffer2Service,buffer3Service),"buffer3"+i).start();
            }
        }

    }
}