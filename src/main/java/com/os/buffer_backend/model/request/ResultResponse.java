package com.os.buffer_backend.model.request;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Data
public class ResultResponse {
    public Integer runTime;
    public Integer avgBufferNum;
    public Integer putBuffer1Num;
    public Integer getBuffer1Num;
    public Integer putBuffer2Num;
    public Integer getBuffer2Num;
    public Integer putBuffer3Num;
    public Integer getBuffer3Num;
    public Integer buffer1ContentNum;
    public Integer buffer2ContentNum;
    public Integer buffer3ContentNum;
    public void getResultResponse(Integer runTime,Integer avgBufferNum,Integer putBuffer1Num,Integer getBuffer1Num,Integer putBuffer2Num,Integer getBuffer2Num,Integer putBuffer3Num,Integer getBuffer3Num,Integer buffer1ContentNum,Integer buffer2ContentNum,Integer buffer3ContentNum){
        this.runTime=runTime;
        this.avgBufferNum=avgBufferNum;
        this.putBuffer1Num=putBuffer1Num;
        this.getBuffer1Num=getBuffer1Num;
        this.putBuffer2Num=putBuffer2Num;
        this.getBuffer2Num=getBuffer2Num;
        this.putBuffer3Num=putBuffer3Num;
        this.getBuffer3Num=getBuffer3Num;
        this.buffer1ContentNum=buffer1ContentNum;
        this.buffer2ContentNum=buffer2ContentNum;
        this.buffer3ContentNum=buffer3ContentNum;

    }

}
