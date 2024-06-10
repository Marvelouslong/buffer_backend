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
import com.os.buffer_backend.model.request.ResultResponse;
import java.lang.Integer;

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
    public ResponseEntity<String> pause(@RequestBody String pause){
        if(pause.equals("true=")){
            common.pause=true;
        }else{
            common.pause=false;
        }
        return ResponseEntity.ok("ok");
    }
    @GetMapping("/total")
    protected ResponseEntity<ResultResponse> backtototal() {
        ResultResponse resultResponse=new ResultResponse();

        common.endTime = System.currentTimeMillis();
        System.out.println("操作执行时间end: " + common.endTime + " 毫秒");
        long timeCost = common.endTime - common.startTime;
        Integer runTimeSeconds = (int) (timeCost / 1000); // 需要秒数
        if (timeCost <= Integer.MAX_VALUE) {
            System.out.println("操作执行时间end-start: " + runTimeSeconds + " 秒");
            resultResponse.setRunTime(runTimeSeconds);
        } else {
            // 处理超出 Integer 范围的情况，可能需要使用其他方法或数据结构来存储时间
        }
        //Map<String,Object> responseData=new HashMap<>();
        Result result=resultService.getBufferResult(common.rs_id);
        resultResponse.setPutBuffer1Num(result.getPutbuffer1num());
        resultResponse.setGetBuffer1Num(result.getGetbuffer1num());
        resultResponse.setPutBuffer2Num(result.getPutbuffer2num());
        resultResponse.setGetBuffer2Num(result.getGetbuffer2num());
        resultResponse.setPutBuffer3Num(result.getPutbuffer3num());
        resultResponse.setGetBuffer3Num(result.getGetbuffer3num());
        Integer buffer1id=common.buffer1_id;
        Integer buffer2id=common.buffer2_id;
        Integer buffer3id=common.buffer3_id;
        List<Integer> bufferNums = resultService.getBufferResultNum(buffer1id, buffer2id, buffer3id);
        resultResponse.setBuffer1ContentNum(bufferNums.get(0));
        resultResponse.setBuffer2ContentNum(bufferNums.get(1));
        resultResponse.setBuffer3ContentNum(bufferNums.get(2));
        System.out.println("bufferNum:   "+bufferNums);
        Integer averageNum=(bufferNums.get(0)+bufferNums.get(1)+bufferNums.get(2))/3;
        resultResponse.setAvgBufferNum(averageNum);
        resultResponse.getResultResponse(runTimeSeconds,averageNum,result.getPutbuffer1num(),result.getGetbuffer1num(),result.getPutbuffer2num(),result.getGetbuffer2num(),result.getPutbuffer3num(),result.getGetbuffer3num(),bufferNums.get(0),bufferNums.get(1),bufferNums.get(2));
        System.out.println("resultResponse::"+resultResponse);
        resultService.upTimeandAverage(runTimeSeconds,averageNum,common.rs_id);
        return ResponseEntity.ok(resultResponse);
        //todo时间传回去，平均值也传回去，

    }
}
