package com.os.buffer_backend.controller;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.model.domain.Buffer3;
import com.os.buffer_backend.model.domain.Result;
import com.os.buffer_backend.model.request.ParamRequest;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.service.ResultService;
import com.os.buffer_backend.service.Buffer1Service;
import com.os.buffer_backend.service.Buffer2Service;
import com.os.buffer_backend.service.Buffer3Service;
import com.os.buffer_backend.service.impl.ParamServiceImpl;
import com.os.buffer_backend.task.Common;
import com.os.buffer_backend.task.ThreadStarter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buffer")
@CrossOrigin(origins = {"http://127.0.0.1:5173"})
@Slf4j
public class buffercontroller {
    @Autowired
    private ParamService paramService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private ThreadStarter threadStarter;
    @Autowired
    private Buffer1Service buffer1Service;
    @Autowired
    private Buffer2Service buffer2Service;
    @Autowired
    private Buffer3Service buffer3Service;
    Common common;
    @PostMapping("/start")
    public ResponseEntity<String> startBuffer(@RequestBody ParamRequest paramRequest) {
        if (paramRequest == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("未传参数");
        }
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
    @GetMapping("/result")
    public Result returnResult(){
        Result result=resultService.getBufferResult(common.rs_id);
        System.out.println("result:"+result);
        return result;
    }
    @PostMapping("/begin")
    public ResponseEntity<String> begin() {
        threadStarter.startThreads();
        return ResponseEntity.ok("Threads started successfully!!!!");
    }

    @GetMapping("/getHistory")
    public ResponseEntity<Map<String, Object>> GetHistory(){
        List<Buffer1> buffer1=buffer1Service.putBuffer1History();
        List<Buffer2> buffer2=buffer2Service.putBuffer2History();
        List<Buffer3> buffer3=buffer3Service.putBuffer3History();
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("buffer1", buffer1);
        System.out.println(buffer1);
        responseData.put("buffer2", buffer2);
        responseData.put("buffer3", buffer3);
        return ResponseEntity.ok(responseData);
    }
}
