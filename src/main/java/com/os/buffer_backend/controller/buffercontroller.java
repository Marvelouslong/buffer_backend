package com.os.buffer_backend.controller;

import com.os.buffer_backend.model.request.ParamRequest;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.service.impl.ParamServiceImpl;
import com.os.buffer_backend.task.ThreadStarter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buffer")
@CrossOrigin(origins = {"http://127.0.0.1:5173"})
@Slf4j
public class buffercontroller {
    @PostMapping("/start")
    public ResponseEntity<String> startBuffer(@RequestBody ParamRequest paramRequest) {
        if (paramRequest == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("未传参数");
        }
        ParamService paramService=new ParamServiceImpl();
        Integer buffer1size=paramRequest.getBuffer1size();
        Integer buffer2size=paramRequest.getBuffer2size();
        Integer buffer3size=paramRequest.getBuffer3size();
        Integer putbuffer1num=paramRequest.getPutbuffer1num();
        Integer movebuffer2num=paramRequest.getMovebuffer2num();
        Integer movebuffer3num=paramRequest.getMovebuffer3num();
        Integer getbuffer2num=paramRequest.getGetbuffer2num();
        Integer getbuffer3num=paramRequest.getGetbuffer3num();
        Integer putspeed=paramRequest.getPutspeed();
        Integer movespeed=paramRequest.getMovespeed();
        Integer getspeed=paramRequest.getGetspeed();
        if ((buffer1size ==0)&&(buffer2size==0)&&(buffer3size==0)&&(putbuffer1num==0)&&(movebuffer2num==0)&&(movebuffer3num==0)
                &&(getbuffer2num==0)&&(getbuffer3num==0)&&(putspeed==0)&&(movespeed==0)&&(getspeed==0)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("参数为0");
        }
        paramService.register(buffer1size,buffer2size,buffer3size,putbuffer1num,movebuffer2num,movebuffer3num,getbuffer2num,getbuffer3num,putspeed,movespeed,getspeed);
        return ResponseEntity.ok("success");
    }
    @PostMapping("/begin")
    public void begin() {
        ThreadStarter threadStarter=new ThreadStarter();
        threadStarter.startThreads();
    }
}
