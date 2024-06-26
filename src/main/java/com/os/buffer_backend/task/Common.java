package com.os.buffer_backend.task;

import java.util.ArrayList;
import com.os.buffer_backend.model.domain.Param;
import org.springframework.stereotype.Component;

@Component
public class Common {
    public static int putBuffer1Num = 3;
    public static int moveBuffer2Num = 1;
    public static int moveBuffer3Num = 1;
    public static int getBuffer2Num = 2;
    public static int getBuffer3Num = 2;

    public static int Buffer1Size = 4;
    public static int Buffer2Size = 5;
    public static int Buffer3Size = 4;

    public static int putSpeed = 40;
    public static int moveSpeed = 40;
    public static int getSpeed = 40;

    public static int BlockedThreadNum = 0;
    public static int MoveBlockedThreadNum = 0;
    public static int GetBlockedThreadNum = 0;
    public static int p_id = 1;
    public static int buffer1_id = 1;
    public static int buffer2_id = 1;
    public static int buffer3_id = 1;
    public static int rs_id = 1;
    public static boolean flag = true;
    public static boolean pause = false;

    public static int putInBufferNum=0;
    public static int getOutBufferNum=0;

    public static long startTime;
    public static long endTime;


    public static ArrayList<String> buffer1 = new ArrayList<String>(); //buffer1缓冲池
    public static ArrayList<String> buffer2 = new ArrayList<String>();
    public static ArrayList<String> buffer3 = new ArrayList<String>();
    public Common(){

    }

    public Common(Integer p_id,Integer buffer1_id,Integer buffer2_id,Integer buffer3_id,Integer rs_id){
        this.p_id=p_id;
        this.buffer1_id=buffer1_id;
        this.buffer2_id=buffer2_id;
        this.buffer3_id=buffer3_id;
        this.rs_id=rs_id;
    }
    //@Autowired
    public Common(Param param){

        Buffer1Size = param.getBuffer1size();
        Buffer2Size = param.getBuffer2size();
        Buffer3Size = param.getBuffer3size();

        putBuffer1Num = param.getPutbuffer1num();
        moveBuffer2Num = param.getMovebuffer2num();
        moveBuffer3Num = param.getGetbuffer3num();
        getBuffer2Num = param.getGetbuffer2num();
        getBuffer3Num = param.getGetbuffer3num();

        putSpeed = param.getPutspeed();
        moveSpeed = param.getMovespeed();
        getSpeed = param.getGetspeed();
    }
    public static void setParams(Param param) {
        startTime = System.currentTimeMillis();
        Buffer1Size = param.getBuffer1size();
        Buffer2Size = param.getBuffer2size();
        Buffer3Size = param.getBuffer3size();

        putBuffer1Num = param.getPutbuffer1num();
        moveBuffer2Num = param.getMovebuffer2num();
        moveBuffer3Num = param.getGetbuffer3num();
        getBuffer2Num = param.getGetbuffer2num();
        getBuffer3Num = param.getGetbuffer3num();

        putSpeed = param.getPutspeed();
        moveSpeed = param.getMovespeed();
        getSpeed = param.getGetspeed();
    }

    public static char removeRandomChar(ArrayList<Character> charBuffer) {
        char removeChar = charBuffer.remove((int) (Math.random() * charBuffer.size()));
        return removeChar;
    }
    public static void  setCharBuffer(ArrayList<Character> charBuffer, char c) {
        charBuffer.add(c);
    }
}

