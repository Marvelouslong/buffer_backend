package com.os.buffer_backend.controller;

import com.os.buffer_backend.model.domain.Buffer1;
import com.os.buffer_backend.model.domain.Buffer2;
import com.os.buffer_backend.model.domain.Buffer3;
import com.os.buffer_backend.model.domain.Result;
import com.os.buffer_backend.model.request.InfiniteList;
import com.os.buffer_backend.model.request.ParamRequest;
import com.os.buffer_backend.model.request.Work;
import com.os.buffer_backend.service.ParamService;
import com.os.buffer_backend.service.ResultService;
import com.os.buffer_backend.service.Buffer1Service;
import com.os.buffer_backend.service.Buffer2Service;
import com.os.buffer_backend.service.Buffer3Service;
import com.os.buffer_backend.task.Common;
import com.os.buffer_backend.task.ThreadStarter;
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
        List<Result> result=resultService.putResultHistory();
        Map<String, Object> responseData = new HashMap<>();
        responseData.put("buffer1", buffer1);
        responseData.put("buffer2", buffer2);
        responseData.put("buffer3", buffer3);
        responseData.put("res",result);
        return ResponseEntity.ok(responseData);
    }
    @GetMapping("/getBuffer")
    public ResponseEntity<Work> getBuffer(@RequestParam String bufferValue){
        Work work=new Work();

        if (bufferValue.equals("Buffer1")){
            work=buffer1Service.getdata(common.buffer1_id,common.rs_id);
            work.setBufferValue("Buffer1");
        }
        else if (bufferValue.equals("Buffer2")){
            work=buffer2Service.getdata(common.buffer2_id,common.rs_id);
            work.setBufferValue("Buffer2");
        } else if (bufferValue.equals("Buffer3")) {
            work=buffer3Service.getdata(common.buffer3_id,common.rs_id);
            work.setBufferValue("Buffer3");
        }else {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(work);
    }
    @GetMapping("/threadblock")
    public ResponseEntity<InfiniteList> threadblock(){
        Integer putthreadblocknum=common.BlockedThreadNum;
        Integer movethreadblocknum=common.MoveBlockedThreadNum;
        Integer getthreadblocknum=common.GetBlockedThreadNum;
        InfiniteList infiniteList=new InfiniteList();
        infiniteList.setPutthreadblocknum(putthreadblocknum);
        infiniteList.setMovethreadblocknum(movethreadblocknum);
        infiniteList.setGetthreadblocknum(getthreadblocknum);
        return ResponseEntity.ok(infiniteList);
    }
    @PostMapping("/pause")
    public ResponseEntity<String> pause(@RequestParam boolean pause){
        common.pause=pause;
        return ResponseEntity.ok("ok");
    }
}
